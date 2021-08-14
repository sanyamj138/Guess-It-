package com.sanyamjain.guessit;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.sanyamjain.guessit.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

private FragmentSecondBinding binding;

    Button button;
    EditText editTextNumber;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentSecondBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextNumber = binding.editTextNumber.findViewById(R.id.editTextNumber);
        button = binding.button.findViewById(R.id.button);
        Random ran = new Random();
        int randomNumber = ran.nextInt(100);
        final int[] count = {1};

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int guessValue = Integer.parseInt(binding.editTextNumber.getText().toString());

                Log.i("Info", "Entered Number: " + guessValue);

                if (guessValue == randomNumber) {
                    Toast.makeText(getContext(), "Congratulations!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "Number found in " + count[0] + " counts " , Toast.LENGTH_SHORT).show();
                    // count++;
                }
                else if (guessValue < randomNumber) {
                    Toast.makeText(getContext(), "Number is Quite More", Toast.LENGTH_SHORT).show();
                    // count++;
                }
                else {
                    Toast.makeText(getContext(), "Number is Quite Less", Toast.LENGTH_SHORT).show();
                    // count++;
                }
                count[0]++;
            }
        });

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "Exiting");
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}