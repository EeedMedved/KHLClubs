package com.example.medvedev.khlclubs;

import android.content.Intent;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by medvedev on 28.07.2017.
 */

public class TeamListFragment extends Fragment {
    private RecyclerView mTeamRecyclerView;
    private TeamAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_list, container, false);

        mTeamRecyclerView = (RecyclerView) view.findViewById(R.id.team_recycler_view);
        mTeamRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private class TeamHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private SportTeam mSportTeam;
        private TextView mNameTextView;
        private TextView mCityTextView;
        private TextView mYearTextView;

        public TeamHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            mNameTextView = (TextView)itemView.findViewById(R.id.list_item_team_name);
            mCityTextView = (TextView)itemView.findViewById(R.id.list_item_team_city);
            mYearTextView = (TextView)itemView.findViewById(R.id.list_item_team_estimated);
        }

        public void bindTeam(SportTeam sportTeam) {
            mSportTeam = sportTeam;
            mNameTextView.setText(sportTeam.getName());
            mCityTextView.setText(sportTeam.getCity());
            mYearTextView.setText(Integer.toString(sportTeam.getEstimateYear()));
        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(getActivity(), "Клик", Toast.LENGTH_SHORT).show();

            //Intent intent = new Intent(getActivity(), TeamActivity.class);

            //Intent intent = TeamActivity.newIntent(getActivity(), mSportTeam.getID());
            Intent intent = TeamPagerActivity.newIntent(getActivity(), mSportTeam.getID());
            startActivity(intent);
        }
    }

    private void updateUI() {
        TeamsPool teamsPool = TeamsPool.get(getActivity());
        List<SportTeam> sportTeams = teamsPool.getTeams();

        mAdapter = new TeamAdapter(sportTeams);
        mTeamRecyclerView.setAdapter(mAdapter);
    }

    private class TeamAdapter extends RecyclerView.Adapter<TeamHolder> {
        private List<SportTeam> mSportTeams;

        public TeamAdapter(List<SportTeam> sportTeams) {
            mSportTeams = sportTeams;
        }

        @Override
        public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_team, parent, false);
            return new TeamHolder(view);
        }

        @Override
        public void onBindViewHolder(TeamHolder holder, int position) {
            SportTeam sportTeam = mSportTeams.get(position);
            holder.bindTeam(sportTeam);
        }

        @Override
        public int getItemCount() {
            return mSportTeams.size();
        }
    }
}
