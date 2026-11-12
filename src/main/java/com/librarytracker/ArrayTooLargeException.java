package com.librarytracker;


// Unchecked custom exception: extends RuntimeException, so no "throws" clause is needed.
public class ArrayTooLargeException extends RuntimeException {

    public ArrayTooLargeException(int size) {
        super("Array has " + size + " elements; the maximum allowed is 5.");
    }
}
