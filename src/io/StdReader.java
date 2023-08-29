package io;

import java.util.Scanner;

public class StdReader implements IReader{
    Scanner scanner = new Scanner(System.in);
    boolean hasNextLine = true;

    @Override
    public String readLine() {
        String s = scanner.nextLine();
        if(s.equals("exit")){
            hasNextLine = false;
        }
        return s;
    }

    @Override
    public boolean hasNextLine() {
        return hasNextLine;
    }
}
