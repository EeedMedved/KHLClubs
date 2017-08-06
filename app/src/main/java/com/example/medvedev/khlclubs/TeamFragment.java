package com.example.medvedev.khlclubs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by medvedev on 28.07.2017.
 */

public class TeamFragment extends Fragment {

    private static final String ARG_TEAM_ID = "team_id";

    private SportTeam mSportTeam;
    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mSportTeam = new SportTeam();

        UUID teamId = (UUID) getArguments().getSerializable(ARG_TEAM_ID);
        mSportTeam = TeamsPool.get(getActivity()).getTeam(teamId);
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

    public static TeamFragment newInstance(UUID teamId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TEAM_ID, teamId);

        TeamFragment fragment = new TeamFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
