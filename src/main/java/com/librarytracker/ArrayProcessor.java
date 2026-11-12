package com.librarytracker;

public class ArrayProcessor {
    private static final int MAX_SIZE = 5;

    public void process(String label, int[] numbers) {
        System.out.println(label);
        int[] buffer = new int[MAX_SIZE]; // fixed size of 5

        try {
            // No size check: at i = 5 the JVM throws ArrayIndexOutOfBoundsException.
            for (int i = 0; i < numbers.length; i++) {
                buffer[i] = numbers[i];
            }
            System.out.println("  All " + numbers.length + " elements stored.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Caught automatically because this catch block matches the exception type.
            throw new ArrayTooLargeException(numbers.length);
        } catch (Exception e) {
            // Default catch: any other exception. It must come last.
            System.out.println("  Unexpected error: " + e.getMessage());
        } finally {
            // Runs on every path.
            System.out.println("  Finished processing.\n");
        }
    }

    public void demonstrate() {
        ArrayProcessor processor = new ArrayProcessor();
        processor.process("Valid array (5 elements)", new int[]{1, 2, 3, 4, 5});
        processor.process("Oversized array (6 elements)", new int[]{1, 2, 3, 4, 5, 6});
    }

}


