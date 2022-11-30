package com.example.ordenrestaurante.chefFoodPanel;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.ordenrestaurante.Models.Chef;
import com.example.ordenrestaurante.Models.UpdateDishModel;
import com.example.ordenrestaurante.PMenu;
import com.example.ordenrestaurante.R;
import com.example.ordenrestaurante.adapter.ChefHomeAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ChefHomeFragment extends Fragment {

    RecyclerView recyclerView;
    private List<UpdateDishModel> updateDishModelList;
    private ChefHomeAdapter adapter;
    DatabaseReference dataa;
    private String State, City, Area;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chef_home, null);
        getActivity().setTitle("Home");
        setHasOptionsMenu(true);

        recyclerView = v.findViewById(R.id.recycle_menu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        updateDishModelList = new ArrayList<>();
        String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        dataa = FirebaseDatabase.getInstance().getReference("Chef").child(userid);
        dataa.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Chef cheff = snapshot.getValue(Chef.class);
                State = cheff.getState();
                City = cheff.getCity();
                Area = cheff.getArea();
                chefDishes();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
//        return inflater.inflate(R.layout.fragment_chef_home, container, false);
    }

    private void chefDishes() {

        String useridd = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("FoodDetails").child(State).child(City).child(Area).child(useridd);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                updateDishModelList.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    UpdateDishModel updateDishModel = snapshot1.getValue(UpdateDishModel.class);
                    updateDishModelList.add(updateDishModel);
                }
                adapter = new ChefHomeAdapter(getContext(), updateDishModelList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.logout, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int idd = item.getItemId();
        if (idd == R.id.LOGOUT) {
            Logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void Logout() {

        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), PMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
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
//    public ChefHomeFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ChefHomeFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ChefHomeFragment newInstance(String param1, String param2) {
//        ChefHomeFragment fragment = new ChefHomeFragment();
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