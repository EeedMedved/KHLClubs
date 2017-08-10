package com.example.medvedev.khlclubs;

import java.util.UUID;

/**
 * Created by medvedev on 28.07.2017.
 */

public class SportTeam {
    private UUID mUUID;
    private String mName;
    private String mCity;
    private int mEstimateYear;

    public SportTeam() {
        this(UUID.randomUUID());
    }

    public SportTeam(UUID uuid) {
        mUUID = uuid;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public int getEstimateYear() {
        return mEstimateYear;
    }

    public void setEstimateYear(int estimateYear) {
        mEstimateYear = estimateYear;
    }

    public UUID getID() {
        return mUUID;
    }
}
