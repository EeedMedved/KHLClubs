package com.example.medvedev.khlclubs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.speech.SpeechRecognizer;
import android.telephony.SubscriptionManager;

import com.example.medvedev.khlclubs.database.TeamBaseHelper;
import com.example.medvedev.khlclubs.database.TeamCursorWrapper;
import com.example.medvedev.khlclubs.database.TeamDbSchema;
import com.example.medvedev.khlclubs.database.TeamDbSchema.TeamTable;

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

    //private List<SportTeam> mSportTeams;
    private SQLiteDatabase mDatabase;
    private Context mContext;

    private TeamsPool(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new TeamBaseHelper(mContext).getWritableDatabase();
    }


    public static TeamsPool get(Context context) {
        if (sTeamsPool == null) {
            sTeamsPool = new TeamsPool(context);
        }

        return sTeamsPool;
    }

    public List<SportTeam> getTeams() {
        List<SportTeam> teams = new ArrayList<>();

        TeamCursorWrapper cursor = queryTeams(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                teams.add(cursor.getTeam());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return teams;
    }

    public SportTeam getTeam(UUID id) {
        TeamCursorWrapper cursorWrapper = queryTeams(TeamTable.Cols.UUID + " = ?",
                new String[] {id.toString()});
        SportTeam sportTeam;

        try {
            if (cursorWrapper.getCount() == 0) {
                return null;
            }
            cursorWrapper.moveToFirst();
            return cursorWrapper.getTeam();
        } finally {
            cursorWrapper.close();
        }
    }

    public void addTeam(SportTeam sportTeam) {
        ContentValues values = getContentValues(sportTeam);
        mDatabase.insert(TeamTable.Name, null, values);
    }

    private static ContentValues getContentValues(SportTeam sportTeam) {
        ContentValues values = new ContentValues();
        values.put(TeamTable.Cols.UUID, sportTeam.getID().toString());
        values.put(TeamTable.Cols.NAME, sportTeam.getName());
        values.put(TeamTable.Cols.CITY, sportTeam.getCity());
        values.put(TeamTable.Cols.ESTIMATED, sportTeam.getEstimateYear());

        return values;
    }

    private TeamCursorWrapper queryTeams(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                TeamTable.Name,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new TeamCursorWrapper(cursor);
    }
}
