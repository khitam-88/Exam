package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtq;
    Button btnnex, btnfin, btnprev;
    RadioButton rd1, rd2, rd3;
    String[][] question = new String[4][4];
    int x = 0,y=0;
    int correct=0 ,incorrect=0 ;
    private Object[] answer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtq = findViewById(R.id.txtq);
        btnfin = findViewById(R.id.btnfin);
        btnnex = findViewById(R.id.btnnex);
        btnprev = findViewById(R.id.btnprev);
        rd1 = findViewById(R.id.rd1);
        rd2 = findViewById(R.id.rd2);
        rd3 = findViewById(R.id.rd3);
        question[0][0] = "Q1.What is a correct syntax to output \"Hello World\" in Java?";
        question[0][1] = "System.out.println(\"Hello World\" );";
        question[0][2] = "print(\"Hello World\" );";
        question[0][3] = "echo(\"Hello World\" );";
        question[1][0] = "Q2.How do you insert COMMENTS in Java code? ";
        question[1][1] = "#This isCOMMENTS ";
        question[1][2] = "//This isCOMMENTS";
        question[1][3] = "/*This isCOMMENTS";
        question[2][0] = "Q3.Which data type is used to create a variable that should store text? ";
        question[2][1] = "String";
        question[2][2] = "string";
        question[2][3] = "myString";
        question[3][0] = "Q4.How do you create a variable with the numeric value 5?";
        question[3][1] = "x=5;";
        question[3][2] = "int x=5;";
        question[3][3] = "float x=5;";
        txtq.setText(question[x][0]);
        rd1.setText(question[x][1]);
        rd2.setText(question[x][2]);
        rd3.setText(question[x][3]);

    }

    public void next(View view) {
        btnfin.setVisibility(view.INVISIBLE);
        if((rd1.isChecked() == false && rd2.isChecked() == false && rd3.isChecked() == false))
            Toast.makeText(MainActivity.this, "please select answer", Toast.LENGTH_LONG).show();

        else {
            if (x == 3){
                Toast.makeText(this, "this is last qustion", Toast.LENGTH_LONG).show();
            btnfin.setVisibility(view.VISIBLE);}
            else {
                x++;
                txtq.setText(question[x][0]);
                rd1.setText(question[x][1]);
                rd2.setText(question[x][2]);
                rd3.setText(question[x][3]);
            }
        }
    }

    public void prev(View view) {

        if (x == 0){
            Toast.makeText(this, "this is first qustion", Toast.LENGTH_LONG).show();
        btnfin.setVisibility(view.INVISIBLE);}
        else
        {
            x--;
            txtq.setText(question[x][0]);
            rd1.setText(question[x][1]);
            rd2.setText(question[x][2]);
            rd3.setText(question[x][3]);

        }
    }

    public void fin(View view) {
      btnfin.setVisibility(view.VISIBLE);
        rd1.setChecked(false);
        rd2.setChecked(false);
        rd3.setChecked(false);
        String[]answer={" System.out.println(\"Hello World\" ); "," //This isCOMMENTS "," String "," int x=5; "};
        String studentanswer=null;
        if(rd1.isChecked())
            studentanswer = rd1.getText().toString();
        else if (rd2.isChecked())
            studentanswer = rd2.getText().toString();
        else if (rd3.isChecked())
            studentanswer = rd3.getText().toString();

        if (studentanswer.equals(answer[x]))
        correct ++;
        else
        incorrect --;

    }
}
