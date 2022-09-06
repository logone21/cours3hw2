package com.example.cours3hw2;

import android.content.Context;
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

public class FirstFragment extends Fragment {

    private EditText etFirst;
    private TextView tvFirst;
    private Button btnFirst;
    public static  final String KEY = "key1";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //фрагмент просто создаеться
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etFirst = view.findViewById(R.id.et_first);
        tvFirst = view.findViewById(R.id.tv_first);
        btnFirst = view.findViewById(R.id.btn_first);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String text = etFirst.getText().toString();
                bundle.putString(KEY, text);
                Fragment fragment = new SecondFragment();
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, fragment).commit();
            }
        });
    }
}