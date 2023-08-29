package io;

public class StdWriter implements IWriter{
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
