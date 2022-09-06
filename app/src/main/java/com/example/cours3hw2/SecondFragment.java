package com.example.cours3hw2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    public static final String KEY = "key2";
    private EditText etSecond;
        private TextView tvSecond;
        private Button btnSecond;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_second, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            etSecond = view.findViewById(R.id.et_second);
            tvSecond = view.findViewById(R.id.tv_second);
            btnSecond = view.findViewById(R.id.btn_second);

            Bundle bundle = getArguments();
            String text = bundle.getString(FirstFragment.KEY);
            etSecond.setText(text);

            btnSecond.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    String text = etSecond.getText().toString();
                    bundle.putString(FirstFragment.KEY, text);
                    Fragment fragment = new ThirdFragment();
                    fragment.setArguments(bundle);


                    requireActivity().getSupportFragmentManager().beginTransaction().
                            replace(R.id.container, fragment).commit();
                }
            });
        }
    }