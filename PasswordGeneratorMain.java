package PasswordGenerator;

import java.util.Scanner;

public class PasswordGeneratorMain {
    public static final Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        Generator generator=new Generator(scanner);
        generator.mainLoop();
        scanner.close();
    }
}
