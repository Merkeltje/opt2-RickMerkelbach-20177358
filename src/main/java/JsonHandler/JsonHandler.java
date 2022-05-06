package JsonHandler;

import com.google.gson.*;

import Gebruiker.gebruiker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;


public class JsonHandler {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static JsonArray haalJsonArrayOp(String fileName) {
        // Zoek de gegeven /storage/:fileName file
        String file = (new File("").getAbsolutePath() + "/src/main.main/resources/storage/" + fileName);

        if (!new File(file).exists()) {
            return null;
        }

        // Lees de file met een FileReader object en gson
        try {
            Reader reader = new FileReader(file);
            return gson.fromJson(reader, JsonArray.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static ArrayList<gebruiker> Haalgebruikersop() {
        JsonArray gebruikersJson = haalJsonArrayOp("gebruiker.json");
        ArrayList<gebruiker> gebruikers = new ArrayList<>();

        if (gebruikersJson == null) {
            return gebruikers;
        }

        for (int i = 0; i < gebruikersJson.size(); i++) {
            JsonObject jsonObject = (JsonObject) gebruikersJson.get(i);

            JsonElement NaamElement = jsonObject.get("Naam");
            JsonElement EmailElement = jsonObject.get("Email");
            JsonElement wwElement = jsonObject.get("wachtwoord");
            JsonElement RolElement = jsonObject.get("Rol");

            int nummer = -1;
            String Naam = null;
            String Email = null;
            String Wachtwoord = null;
            String Rol = null;
            if (NaamElement != null) {
                Naam = NaamElement.getAsString();
            }

            if (EmailElement != null) {
                Email = EmailElement.getAsString();
            }

            if (wwElement != null) {
                Wachtwoord = wwElement.getAsString();
            }

            if (RolElement != null) {
                Rol = RolElement.getAsString();
            }

            if (nummer == -1) {
                gebruiker gebruiker1 = new gebruiker(Naam, Email, Wachtwoord, Rol);
                gebruikers.add(gebruiker1);
            }
        }
        return gebruikers;
    }

    public static gebruiker Haalgebruikerop(String Email) {
        ArrayList<gebruiker> opgehaaldegebruikers = Haalgebruikersop();
        for (gebruiker gebruiker : opgehaaldegebruikers) {
            if (gebruiker.getEmail().equals(Email)){
                return gebruiker;
            }
        }
        return null;
    }

        public static JsonObject Jemoeder(int joumama) {

            JsonArray pietje = haalJsonArrayOp("gebruiker.json");

            JsonObject gebruiker = (JsonObject) pietje.get(joumama);
            System.out.println(gebruiker.get("Naam"));
            return gebruiker;
        }

}