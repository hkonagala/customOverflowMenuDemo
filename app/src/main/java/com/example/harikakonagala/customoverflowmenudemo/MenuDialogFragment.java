package com.example.harikakonagala.customoverflowmenudemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by phani on 8/31/17.
 */

public class MenuDialogFragment extends DialogFragment implements View.OnClickListener {

    ImageButton left, right, bookmark;

    static MenuDialogFragment newInstance() {
        return new MenuDialogFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View subView = inflater.inflate(R.layout.activity_custom_menu, null);

        left = (ImageButton) subView.findViewById(R.id.image_button_back);
        right = (ImageButton) subView.findViewById(R.id.image_button_forward);
        bookmark = (ImageButton) subView.findViewById(R.id.image_button_bookmark);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        bookmark.setOnClickListener(this);

        Window window = getDialog().getWindow();
        window.setGravity(Gravity.END | Gravity.TOP);
        WindowManager.LayoutParams p = getDialog().getWindow().getAttributes();
        p.width = 70;
        p.y = 100;
        window.setAttributes(p);
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        return subView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        Toast mToast = Toast.makeText(getActivity().getApplicationContext(), "", Toast.LENGTH_SHORT);
        switch (v.getId()){
            case R.id.image_button_back:
                mToast.setText("Back");
                mToast.show();
                break;
            case R.id.image_button_forward:
                mToast.setText("Forward");
                mToast.show();
                break;
            case R.id.image_button_bookmark:
                mToast.setText("Bookmark");
                mToast.show();
                break;
        }
    }
}
