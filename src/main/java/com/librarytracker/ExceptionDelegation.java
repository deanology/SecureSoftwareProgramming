package com.librarytracker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDelegation {


    // Level 3: where the problem occurs. It does not handle the exception;
    // "throws" delegates the responsibility to the calling method.
    public static void openFile(String path) throws IOException {
        // FileReader throws FileNotFoundException if the file is missing.
        try (FileReader reader = new FileReader(path)) {
            System.out.println("File opened: " + path);
        }
    }
    // Level 2: also delegates. The exception passes through this method to whoever called it.
    public static void loadSettings(String path) throws IOException {
        System.out.println("Loading settings...");
        openFile(path);
        System.out.println("Settings loaded."); // skipped when openFile() throws
    }

    // Level 1: the exception is finally handled here, two calls above the point where it occurred.
    public static void demonstrate() {
        try {
            loadSettings("missing-settings.txt");
        } catch (FileNotFoundException e) {
            // Specific exception first: the file does not exist.
            System.out.println("Handled: file not found -> " + e.getMessage());
        } catch (IOException e) {
            // General exception last: any other I/O problem.
            System.out.println("Handled: I/O error -> " + e.getMessage());
        } finally {
            // Runs whether or not an exception occurred.
            System.out.println("Delegation demo finished.");
        }
    }
}
