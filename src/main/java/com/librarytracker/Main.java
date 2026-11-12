package com.librarytracker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static void main() {
        ArrayProcessor  arrayProcessor = new ArrayProcessor();

        ExceptionDelegation.demonstrate();
        arrayProcessor.demonstrate();
    }
}
