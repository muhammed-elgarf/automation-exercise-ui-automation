package utilities;

import java.io.File;

public class FileUtils {

    public static boolean isInvoiceDownloaded() {

        File downloadsFolder =
                new File(System.getProperty("user.home")
                        + "\\Downloads");

        // Wait up to 10 seconds for the file
        for (int i = 0; i < 10; i++) {

            File[] files = downloadsFolder.listFiles();

            if (files != null) {

                for (File file : files) {

                    if (file.getName().startsWith("invoice")
                            && file.getName().endsWith(".txt")) {

                        return true;
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return false;
    }
}