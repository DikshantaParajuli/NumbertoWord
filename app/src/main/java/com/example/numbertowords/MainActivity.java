package com.example.numbertowords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtaa;
    private TextView txtbb;
    private Button btnConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        setAction();
    }
    private void initiate(){
        txtaa=findViewById(R.id.txta);
        txtbb=findViewById(R.id.txtb);
        btnConvert=findViewById(R.id.btnConvert);
    }
    private void setAction(){
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input = Integer.parseInt(txtaa.getText().toString());
                Model model = new Model();
                if (input < 20) {

                    txtbb.setText(model.getOnes()[input]);
                } else if (input < 100) {
                    int tensIndex = input / 10;
                    int onesIndex = input % 10;

                    if (onesIndex != 0) {
                        txtbb.setText(model.getTens()[tensIndex] + " " + model.getOnes()[onesIndex]);
                    } else {
                        txtbb.setText(model.getTens()[tensIndex]);
                    }
                } else {
                    int hundredsIndex = input / 100;
                    int remainder = input % 100;
                    int tensIndex = remainder / 10;
                    int onesIndex = remainder % 10;

                    if (onesIndex != 0) {
                        txtbb.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex] + " " + model.getOnes()[onesIndex]);
                    } else {
                        txtbb.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex]);
                    }
                }
            }});
    }
}

