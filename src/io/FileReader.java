package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements IReader {
    Scanner scanner;
    File file;
    boolean hasNextLine = true;

    public FileReader(File file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(file);
    }

    @Override
    public String readLine() {
        if(!scanner.hasNextLine()){
            return "";
        }
        return scanner.nextLine();
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

}
