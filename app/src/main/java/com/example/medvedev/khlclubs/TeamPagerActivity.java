package com.example.medvedev.khlclubs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by sennator on 06.08.17.
 */

public class TeamPagerActivity extends FragmentActivity {

    private static final String EXTRA_TEAM_ID = "com.example.medvedev.khlclubs.team_id";

    private ViewPager mViewPager;
    private List<SportTeam> mTeams;

    public static Intent newIntent(Context packageContext, UUID teamId) {
        Intent intent = new Intent(packageContext, TeamPagerActivity.class);
        intent.putExtra(EXTRA_TEAM_ID, teamId);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_pager);

        UUID teamId = (UUID) getIntent().getSerializableExtra(EXTRA_TEAM_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_team_pager_view_pager);

        mTeams = TeamsPool.get(this).getTeams();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                SportTeam team = mTeams.get(position);
                return TeamFragment.newInstance(team.getID());
            }

            @Override
            public int getCount() {
                return mTeams.size();
            }
        });

        for (int i = 0; i < mTeams.size(); i++) {
            if (mTeams.get(i).getID().equals(teamId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
