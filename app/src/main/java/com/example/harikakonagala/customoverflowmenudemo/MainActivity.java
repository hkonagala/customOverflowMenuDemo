package com.example.harikakonagala.customoverflowmenudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton left, right, bookmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        final MenuItem overflowItem = menu.findItem(R.id.action_overflow_menu);
        LinearLayout rootLayout = (LinearLayout) overflowItem.getActionView();

        left = (ImageButton) rootLayout.findViewById(R.id.image_button_back);
        bookmark = (ImageButton) rootLayout.findViewById(R.id.image_button_bookmark);
        right = (ImageButton) rootLayout.findViewById(R.id.image_button_forward);

        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(overflowItem);
            }
        });

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        bookmark.setOnClickListener(this);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_overflow_menu:
                updateOverFlowMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateOverFlowMenu() {
        //set onclick listeners for buttons
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.image_button_back:
                Toast.makeText(getApplicationContext(), "Go Back", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_button_forward:
                Toast.makeText(getApplicationContext(), "Go Forward", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_button_bookmark:
                Toast.makeText(getApplicationContext(), "Bookmark Option", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
