package com.example.harikakonagala.customoverflowmenudemo;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton customMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        customMenu = (ImageButton) findViewById(R.id.custom_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        customMenu.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        customMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast mToast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
        switch(v.getId()){
            case R.id.custom_menu:
                DialogFragment newFragment = MenuDialogFragment.newInstance();
                newFragment.show(getSupportFragmentManager(), "");
                break;
        }
    }
}
