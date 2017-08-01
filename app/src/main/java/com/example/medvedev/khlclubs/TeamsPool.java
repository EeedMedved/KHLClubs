package com.example.medvedev.khlclubs;

import android.content.Context;
import android.speech.SpeechRecognizer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by medvedev on 28.07.2017.
 */

public class TeamsPool {
    private static TeamsPool sTeamsPool;

    private List<SportTeam> mSportTeams;

    private TeamsPool(Context context) {
        mSportTeams = new ArrayList<>();

        SportTeam sportTeam = new SportTeam();
        sportTeam.setCity("Ufa");
        sportTeam.setName("Salavat Yulaev");
        sportTeam.setEstimateYear(1961);
        mSportTeams.add(sportTeam);

        sportTeam = new SportTeam();
        sportTeam.setCity("Omsk");
        sportTeam.setName("Avanguard");
        sportTeam.setEstimateYear(1950);
        mSportTeams.add(sportTeam);

        sportTeam = new SportTeam();
        sportTeam.setCity("Magnitogorsk");
        sportTeam.setName("Metallurg");
        sportTeam.setEstimateYear(1955);
        mSportTeams.add(sportTeam);

        sportTeam = new SportTeam();
        sportTeam.setCity("Chelyabinsk");
        sportTeam.setName("Traktor");
        sportTeam.setEstimateYear(1947);
        mSportTeams.add(sportTeam);

        sportTeam = new SportTeam();
        sportTeam.setCity("Novosibirsk");
        sportTeam.setName("Sibir");
        sportTeam.setEstimateYear(1962);
        mSportTeams.add(sportTeam);
    }

    public static TeamsPool get(Context context) {
        if (sTeamsPool == null) {
            sTeamsPool = new TeamsPool(context);
        }

        return sTeamsPool;
    }

    public List<SportTeam> getTeams() { return mSportTeams; }

    public SportTeam getTeam(UUID id) {
        for (SportTeam sportTeam : mSportTeams) {
            if (sportTeam.getID().equals(id)) {
                return sportTeam;
            }
        }

        return null;
    }
}
