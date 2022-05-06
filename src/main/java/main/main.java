package main;

import Taak.taak;
import Gebruiker.gebruiker;
import JsonHandler.JsonHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){
        gebruiker.Login();
        Menu();
    }

    public static void Menu(){
        int keuze;
        ArrayList<taak> taken = new ArrayList<>();

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("(1) Taken maken");
            System.out.println("(2) Taken ophalen");
            System.out.println("(0) Exit.");
            System.out.print("Uw keuze:");
            keuze = scanner.nextInt();

            switch (keuze) {
                case 1 -> taak.TaakMaken();
                case 2 -> taak.Takenophalen();
                case 0 -> {
                    System.out.println("exit");
                    System.exit(0);
                }
            }
        }
    }
}

