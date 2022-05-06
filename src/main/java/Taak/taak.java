package Taak;

import java.util.ArrayList;
import java.util.Scanner;

public class taak {
    private String TaakNaam;
    private String TaakInhoud;

    public static ArrayList<taak> taken = new ArrayList<>();

    public taak (String TaakNaam, String TaakInhoud){
        this.TaakNaam = TaakNaam;
        this.TaakInhoud = TaakInhoud;
    }

    public String getTaakNaam() {
        return TaakNaam;
    }

    public String getTaakInhoud() {
        return TaakInhoud;
    }

    public void setTaakNaam(String taakNaam) {
        TaakNaam = taakNaam;
    }

    public void setTaakInhoud(String taakInhoud) {
        TaakInhoud = taakInhoud;
    }

    public static void TaakMaken(){
        Scanner scanner = new Scanner(System.in);
        boolean x = false;
        while(!x){
            System.out.println("taaknaam:");
            String taaknaam = scanner.nextLine();
            System.out.println("taakinhoud: ");
            String taakinhoud = scanner.nextLine();
            taken.add(new taak(taaknaam, taakinhoud));
            System.out.println("klaar? j/n");
            String klaar = scanner.nextLine();

            if (klaar.equals("j")){
                x = true;
            }
        }
    }

    public static void Takenophalen(){
        int teller =  1;
        for (taak taak: taken){
            System.out.print("taak " + teller + ": ");
            System.out.println(taak.getTaakNaam() + taak.getTaakInhoud());
            teller++;
        }
    }
}

