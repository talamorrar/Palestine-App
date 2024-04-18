package com.example.trail;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JinenQuiz extends AppCompatActivity {
    public EditText edtanswer;
    public Button btnDone;
    RadioGroup radioGroup;
    RadioButton radioButtonOption1, radioButtonOption2, radioButtonOption3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jinen_quiz);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonOption1 = findViewById(R.id.rbtn1);
        radioButtonOption2 = findViewById(R.id.rbtn2);
        radioButtonOption3 = findViewById(R.id.rbtn3);
        edtanswer = findViewById(R.id.edtanswer);
        btnDone = findViewById(R.id.btnDone);
        if (edtanswer.getText() != null) {
            btnDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                    if (selectedRadioButtonId != -1) {
                        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                        if (selectedRadioButton.getText().toString().equals("Qabatiya")) {
                            selectedRadioButton.setBackgroundColor(Color.GREEN);
                            selectedRadioButton.setTextColor(Color.GREEN);
                        } else{
                            radioButtonOption2.setBackgroundColor(Color.RED);
                            radioButtonOption3.setBackgroundColor(Color.RED);
                            radioButtonOption1.setBackgroundColor(Color.GREEN);
                        }
                    }else{
                        radioButtonOption2.setBackgroundColor(Color.RED);
                        radioButtonOption3.setBackgroundColor(Color.RED);
                        radioButtonOption1.setBackgroundColor(Color.GREEN);
                    }
                    String area = "37.3";
                    if (edtanswer.getText().toString().trim().equals(area)) {
                        edtanswer.append("   true");
                    } else {
                        edtanswer.append("false");
                    }

                }
            });
        } else {
            edtanswer.setText("false");
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}