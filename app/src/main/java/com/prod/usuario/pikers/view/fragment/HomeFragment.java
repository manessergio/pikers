package com.prod.usuario.pikers.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.prod.usuario.pikers.R;
import com.prod.usuario.pikers.adapter.PictureAdapterRecyclerView;
import com.prod.usuario.pikers.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolBar(getResources().getString(R.string.menu_home), false,view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(),
                                                                R.layout.cardview_picture,getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.fotonostra.com/fotografia/fotos/fotografiarpaisajes5.jpg",
                                "Sergio Manes",
                                " 3 "+getResources().getString(R.string.timecardtext),
                                "5 " + getResources().getString(R.string.likesNumber),false));
        pictures.add(new Picture("https://www.socialhizo.com/images/geografia/el-paisaje/paisajes-rurales.jpg",
                                "Joaco Perez",
                                " 5 "+getResources().getString(R.string.timecardtext),
                                "2 " + getResources().getString(R.string.likesNumber),
                                false));
        pictures.add(new Picture("https://losviajesdedomi.com/wp-content/uploads/2014/02/stavanger-fiordo-noruego-1.jpg",
                                "Mauricio Gonzalez",
                                " 9 "+getResources().getString(R.string.timecardtext),
                                "23 " + getResources().getString(R.string.likesNumber),
                                false));
        return pictures;
    }

    public void showToolBar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
