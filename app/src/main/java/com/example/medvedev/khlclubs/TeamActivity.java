package com.example.medvedev.khlclubs;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class TeamActivity extends SingleFragmentActivity {

    private static final String EXTRA_TEAM_ID =
            "com.example.medvedev.khlclubs.team_id";

    @Override
    protected Fragment createFragment() {
        UUID teamId = (UUID) getIntent().getSerializableExtra(EXTRA_TEAM_ID);
        return TeamFragment.newInstance(teamId);
    }

    public static Intent newIntent(Context packageContext, UUID teamId) {
        Intent intent = new Intent(packageContext, TeamActivity.class);
        intent.putExtra(EXTRA_TEAM_ID, teamId);
        return intent;
    }
}
