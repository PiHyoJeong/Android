package org.techtown.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallback{

    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.ListFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.ViewrFragment);
    }

    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImageView(images[position]);
    }
}