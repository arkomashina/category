package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        withResources();

    }

    static void throwException() throws Exception {
        try {
            throw new IOException();
        } catch (IOException ex) {
            System.err.println("IOException");
            throw new IOException();
        } catch (Exception ex) {
            System.err.println("Exception");
            throw new IOException();
        } finally {
            System.err.println("Finally");
            throw new Exception();
        }
    }

    public static void withResources()  {

        try(Scanner scanner = new Scanner(System.in)){
            scanner.nextLine();
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("finally");
        }

    }
}