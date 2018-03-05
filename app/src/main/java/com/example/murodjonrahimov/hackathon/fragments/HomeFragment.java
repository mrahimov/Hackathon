package com.example.murodjonrahimov.hackathon.fragments;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.murodjonrahimov.hackathon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


//    private Button recreationalActivitiesButton;
    private Button outOfSchoolProgramsButton, recreationButton;
    private FragmentListener fragmentListener;

    private CardView recreationalCard, opportunitiesCard;
    private ImageView basketballView, opportunitiesView;



    public HomeFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            fragmentListener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);



        recreationButton = rootView.findViewById(R.id.recreational_button);
        outOfSchoolProgramsButton = rootView.findViewById(R.id.jobs_button);

//        recreationalCard = rootView.findViewById(R.id.recreational_button);
//        opportunitiesCard = rootView.findViewById(R.id.jobs_button);
       // basketballView = rootView.findViewById(R.id.basketBallImage);
        //opportunitiesView = rootView.findViewById(R.id.opportunitiesImage);

        recreationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.swapWithRecreationalFragment();
            }
        });

        outOfSchoolProgramsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListener.swapWithOutOfSchoolFragment();

            }
        });
        return rootView;
    }

    public interface FragmentListener {
        void swapWithRecreationalFragment();
        void swapWithOutOfSchoolFragment();
    }


}
