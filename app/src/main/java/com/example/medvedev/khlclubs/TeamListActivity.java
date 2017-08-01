package com.example.medvedev.khlclubs;

import android.support.v4.app.Fragment;

/**
 * Created by medvedev on 28.07.2017.
 */

public class TeamListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TeamListFragment();
    }
}
