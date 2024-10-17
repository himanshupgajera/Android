package com.example.practical2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LifecycleFragment extends Fragment {

    private static final String TAG = "LifecycleFragment";
    private TextView fragmentLifecycleTextView;
    private StringBuilder lifecycleStatusBuilder;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach called");
        appendLifecycleStatus("onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");
        appendLifecycleStatus("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView called");
        appendLifecycleStatus("onCreateView");

        View view = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        fragmentLifecycleTextView = view.findViewById(R.id.fragmentLifecycleTextView);
        fragmentLifecycleTextView.setText(lifecycleStatusBuilder.toString());

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated called");
        appendLifecycleStatus("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
        appendLifecycleStatus("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
        appendLifecycleStatus("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
        appendLifecycleStatus("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
        appendLifecycleStatus("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView called");
        appendLifecycleStatus("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
        appendLifecycleStatus("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach called");
        appendLifecycleStatus("onDetach");
    }

    // Helper method to update lifecycle status
    private void appendLifecycleStatus(String status) {
        if (lifecycleStatusBuilder == null) {
            lifecycleStatusBuilder = new StringBuilder();
        }
        lifecycleStatusBuilder.append(status).append("\n");
    }
}
