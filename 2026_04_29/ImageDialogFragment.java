package edu.zsk.a2026_04_29;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ImageDialogFragment extends DialogFragment {

    public static ImageDialogFragment newInstance(int resId) {
        ImageDialogFragment fragment = new ImageDialogFragment();
        Bundle args = new Bundle();
        args.putInt("id", resId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImageView iv = new ImageView(getContext());
        if (getArguments() != null) {
            iv.setImageResource(getArguments().getInt("id"));
        }
        iv.setAdjustViewBounds(true);

        iv.setOnClickListener(v -> dismiss());

        return iv;
    }
}