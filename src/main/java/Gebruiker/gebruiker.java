package Gebruiker;

import JsonHandler.JsonHandler;
import Taak.taak;
import main.main;

import java.util.ArrayList;
import java.util.Scanner;

public class gebruiker {
    private String Naam;
    private String Email;
    private String Wachtwoord;
    private String Rol;

    public gebruiker (String Naam, String Email, String Wachtwoord, String Rol){
        this.Naam = Naam;
        this.Email = Email;
        this.Wachtwoord = Wachtwoord;
        this.Rol = Rol;
    }

    public String getNaam() {
        return Naam;
    }

    public String getEmail() {
        return Email;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public String getRol() {
        return Rol;
    }

    public static void Login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inloggen-->");
        System.out.print("E-mail: ");
        String Email = scanner.nextLine();

        gebruiker gebruiker = JsonHandler.Haalgebruikerop(Email);

        if (gebruiker == null){
            System.out.println("Geen gebruiker gevonden");
            gebruiker.Login();
        }
        else {
            System.out.print("Wachtwoord: ");
            String wachtwoordinvoer = scanner.nextLine();

            if (gebruiker.getWachtwoord().equals(wachtwoordinvoer)){
                System.out.println("ingelogd als: " + gebruiker.getNaam());

            }
            else {
                System.out.println("Wachtwoord of Email is verkeerd probeer opnieuw.");
                gebruiker.Login();
            }
        }

    }

    @Override
    public String toString() {
        return Naam + " " + Email + " " + Wachtwoord + " " + Rol;
    }
}
