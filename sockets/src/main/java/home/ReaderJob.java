package home;

import java.io.BufferedReader;

/**
 * ReaderJob
 */
public class ReaderJob implements Runnable {
    BufferedReader reader;

    public ReaderJob(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
        String request;
        while ((request = reader.readLine()) != null) {
            System.out.println(request);
        }
        reader.close();
        } catch (Exception e) {
            System.out.println("Problem with reading:" + e.getMessage());
        }
    }

}
