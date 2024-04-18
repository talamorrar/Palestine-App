package com.example.trail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Jeneen extends AppCompatActivity {
    public Button btnJenin2;
    public ListView listInfo;
    public ArrayAdapter<String> info;
    public TextView txtResult;
    public Button btnQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jeneen);

       btnJenin2=findViewById(R.id.btnJenin2);
       listInfo=findViewById(R.id.listInfo);
        txtResult=findViewById(R.id.textView2);
        btnJenin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arr={"Area","population","Villages and Surroundings","Location and Geography"};
                ArrayAdapter<String> adapter=new ArrayAdapter<>(Jeneen.this,
                        android.R.layout.simple_list_item_1,arr);
                listInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        String selectedItem = (String) adapterView.getItemAtPosition(position);
                        if(selectedItem=="Area"){
                            txtResult.setText("37.3 km²");
                        } else if (selectedItem=="population") {
                            txtResult.setText("40,000");
                        }
                        else if (selectedItem=="Villages and Surroundings") {
                            txtResult.setText("Qabatiya, Burqin, and Arraba");
                        }
                        else if (selectedItem=="Location and Geography") {
                            txtResult.setText("Jenin is situated in the northern part of the palestine");
                        }
                        Toast.makeText(Jeneen.this, "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
                    }
                });
                listInfo.setAdapter(adapter);
                btnQuiz = findViewById(R.id.btnQuiz);
                btnQuiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Jeneen.this, JinenQuiz.class);
                        startActivity(intent);
                    }
                });
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }


    public void fill() {
        info.add("Area : 37.3 km²");
        info.add("population : 40,000");
        info.add("Villages and Surroundings :  Qabatiya, Burqin, and Arraba");
        info.add("Location and Geography: Jenin is situated in the northern part of the palestine");
    }
}