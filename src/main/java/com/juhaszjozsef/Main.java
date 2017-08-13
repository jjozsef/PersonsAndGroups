package com.juhaszjozsef;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        options();
    }

    public static void options() {

        System.out.println("Options:" +
                "\n1: CREATE a new person" +
                "\n2: READ the tables" +
                "\n3: UPDATE the person properties" +
                "\n4: DELETE a person" +
                "\n5: exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                Feature.create();
                continuation();
                break;

            case 2:
                Feature.read();
                continuation();
                break;

            case 3:
                Feature.update();
                continuation();
                break;

            case 4:
                Feature.delete();
                continuation();
                break;

            case 5:
                if (Feature.factory.isOpen())
                    Feature.factory.close();
                break;

            default:
                System.out.println("Please repeat!");
                options();
                break;
        }
    }

    public static void continuation() {

        System.out.println("Continue?" +
                "\n1: Yes" +
                "\n2: No");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                options();
                break;

            case 2:
                if (Feature.factory.isOpen())
                    Feature.factory.close();
                break;

            default:
                System.out.printf("Please repeat!");
                continuation();
                break;
        }
    }
}