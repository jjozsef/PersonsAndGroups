package com.juhaszjozsef;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        options();
    }

    public static void options() {

        String list = "Options:" +
                "\n1: CREATE a new person" +
                "\n2: READ the tables" +
                "\n3: UPDATE the person properties" +
                "\n4: DELETE a person" +
                "\n5: exit";

        System.out.println(list);

        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();

        if (choise == 1) {
            Feature.create();
            continuation();

        } else if (choise == 2) {
            Feature.read();
            continuation();

        } else if (choise == 3) {
            Feature.update();
            continuation();

        } else if (choise == 4) {
            Feature.delete();
            continuation();

        } else if (choise == 5){
            boolean factoryOpen = Feature.factory.isOpen();
            if (factoryOpen){
                Feature.factory.close();}

        } else {
            System.out.println("Please repeat!");
            options();
        }
    }

    public static void continuation() {

        String yesOrNo = "Continue?" +
                "\n1: YES" +
                "\n2: NO";

        System.out.println(yesOrNo);

        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();

        if (choise == 1){
            options();
        }
        else if (choise == 2){
            boolean factoryOpen = Feature.factory.isOpen();
            if (factoryOpen){
                Feature.factory.close();}
        }
        else {
            System.out.println("Please repeat!");
            continuation();
        }
    }
}