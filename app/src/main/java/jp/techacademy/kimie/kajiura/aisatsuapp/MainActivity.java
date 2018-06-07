package jp.techacademy.kimie.kajiura.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 =(Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        showTimePickerDialog();
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    TextView textView = (TextView) findViewById(R.id.textView);
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI_PARTS" ,String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if ((hourOfDay >= 2 && hourOfDay <= 9) && minute >= 00 ) {
                            textView.setText("「おはよう」");
                        }else if ((hourOfDay >= 10 && hourOfDay <= 17) && minute >=00) {
                            textView.setText("「こんにちは」");
                        }else if (((hourOfDay >=18 && hourOfDay <=23) || (hourOfDay >=00 && hourOfDay <=1)) && minute >= 00){
                            textView.setText("「こんばんは」");
                        }
                    }
                },
                12,
                00,
                true);
        timePickerDialog.show();
    }
}
