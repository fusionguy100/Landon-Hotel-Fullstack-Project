package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class ThreadClass extends Thread {

    static ExecutorService messageExecutor = newFixedThreadPool(5);
    private static final List<String> messages = new ArrayList<>();
    private String propertiesFile;

    public ThreadClass(String propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

    @Override
    public void run() {
        messageExecutor.execute(() -> {
            Properties properties = new Properties();
            try {
                InputStream stream = new ClassPathResource(propertiesFile).getInputStream();
                properties.load(stream);
                synchronized (messages) { //added to fix only 1 welcome message appearing

                    messages.add(properties.getProperty("welcome"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Method to retrieve the messages as an array
    public String[] getMessages() {

        try {
            messageExecutor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messages.toArray(new String[0]);
    }

}
