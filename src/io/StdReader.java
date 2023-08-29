package io;

import java.util.Scanner;

public class StdReader implements IReader{
    Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
