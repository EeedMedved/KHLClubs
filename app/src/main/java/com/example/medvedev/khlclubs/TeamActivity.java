package com.example.medvedev.khlclubs;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TeamActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TeamFragment();
    }
}
