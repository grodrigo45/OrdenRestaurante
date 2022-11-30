package com.example.ordenrestaurante.chefFoodPanel;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ordenrestaurante.R;
import com.example.ordenrestaurante.chef_postDish;


public class ChefProfileFragment extends Fragment {

    Button postDish;
    ConstraintLayout backimg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chef_profile, null);
        getActivity().setTitle("Post Dish");

        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.bg2), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img2), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img4), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img5), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img6), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img7), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img8), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.bg3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img9), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img10), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11), 3000);

        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);

        backimg = v.findViewById(R.id.back1);
        backimg.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();

        postDish = (Button) v.findViewById(R.id.post_dish);

        postDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), chef_postDish.class));
            }
        });

        return v;
    }

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public ChefProfileFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ChefProfileFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ChefProfileFragment newInstance(String param1, String param2) {
//        ChefProfileFragment fragment = new ChefProfileFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_chef_profile, container, false);
//    }
}