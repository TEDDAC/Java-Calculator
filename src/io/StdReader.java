package io;

import java.util.Scanner;

public class StdReader implements IReader{

    @Override
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
