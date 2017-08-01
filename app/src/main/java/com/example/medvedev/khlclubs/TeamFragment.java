package com.example.medvedev.khlclubs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by medvedev on 28.07.2017.
 */

public class TeamFragment extends Fragment {
    private SportTeam mSportTeam;
    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSportTeam = new SportTeam();
        mSportTeam.setName("Salavat Yulaev");
        mSportTeam.setCity("Ufa");
        mSportTeam.setEstimateYear(1961);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_team, container, false);

        mTextView = (TextView)v.findViewById(R.id.tvw_team_name);
        mTextView.setText(mSportTeam.getName());

        mTextView = (TextView)v.findViewById(R.id.tvw_team_city);
        mTextView.setText(mSportTeam.getCity());

        mTextView = (TextView)v.findViewById(R.id.tvw_estimated_year);
        mTextView.setText(Integer.toString(mSportTeam.getEstimateYear()));

        return v;
    }
}
