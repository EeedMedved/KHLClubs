package com.example.medvedev.khlclubs;

import android.content.Context;
import android.speech.SpeechRecognizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
        sportTeam.setCity("Уфа");
        sportTeam.setName("Салават Юлаев");
        sportTeam.setEstimateYear(1961);
        mSportTeams.add(sportTeam);

        sportTeam = new SportTeam();
        sportTeam.setCity("Омск");
        sportTeam.setName("Авангард");
        sportTeam.setEstimateYear(1950);
        mSportTeams.add(sportTeam);

        sportTeam = new SportTeam();
        sportTeam.setCity("Магнитогорск");
        sportTeam.setName("Металлург");
        sportTeam.setEstimateYear(1955);
        mSportTeams.add(sportTeam);

        sportTeam = new SportTeam();
        sportTeam.setCity("Челябинск");
        sportTeam.setName("Трактор");
        sportTeam.setEstimateYear(1947);
        mSportTeams.add(sportTeam);

        sportTeam = new SportTeam();
        sportTeam.setCity("Новосибирск");
        sportTeam.setName("Сибирь");
        sportTeam.setEstimateYear(1962);
        mSportTeams.add(sportTeam);

        mSportTeams.add(newTeam("Динамо", "Минск", 1948));
        mSportTeams.add(newTeam("Динамо", "Рига", 2008));
        mSportTeams.add(newTeam("Йокерит", "Хельсинки", 1967));
        mSportTeams.add(newTeam("СКА", "Санкт-Петербург", 1946));
        mSportTeams.add(newTeam("Слован", "Братислава", 1921));
        mSportTeams.add(newTeam("Спартак", "Москва", 1946));
        mSportTeams.add(newTeam("Автомобилист", "Екатеринбург", 2006));
        mSportTeams.add(newTeam("Ак Барс", "Казань", 1956));
        mSportTeams.add(newTeam("Лада", "Тольятти", 1976));
        mSportTeams.add(newTeam("Нефтехимик", "Нижнекамск", 1968));
        mSportTeams.add(newTeam("Югра", "Ханты-Мансийск", 2006));

        Collections.sort(mSportTeams, new Comparator<SportTeam>() {
            @Override
            public int compare(SportTeam t1, SportTeam t2) {
                return t1.getName().compareTo(t2.getName());
            }
        });
    }

    private SportTeam newTeam(String name, String city, int year) {
        SportTeam sportTeam = new SportTeam();

        sportTeam.setName(name);
        sportTeam.setCity(city);
        sportTeam.setEstimateYear(year);
        return sportTeam;
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
