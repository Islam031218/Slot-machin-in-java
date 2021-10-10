package com.template;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Records extends AppCompatActivity implements View.OnClickListener {
    TextView recordText1,record1,recordText2,record2,recordText3,record3,empty;
    Button btn;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        getShared();
        findViewById(R.id.bnt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("Range")
    private void getShared() {
        record1 = findViewById(R.id.firstRecord);
        record2 = findViewById(R.id.secondRecord);
        record3 = findViewById(R.id.thirdRecord);
        recordText1 = findViewById(R.id.firstText);
        recordText2 = findViewById(R.id.secondText);
        recordText3 = findViewById(R.id.thirdText);
        empty = findViewById(R.id.empty);

        sharedPreferences = getSharedPreferences("record", MODE_PRIVATE);
        if (sharedPreferences.getString(Utils.keyThirdRecord, null) != null) {
            record1.setAlpha(1000);
            recordText1.setAlpha(1000);
            record2.setAlpha(1000);
            recordText2.setAlpha(1000);
            recordText3.setAlpha(1000);
            record3.setAlpha(1000);
            record1.setText(sharedPreferences.getString(Utils.keyFirstRecord,null));
            record2.setText(sharedPreferences.getString(Utils.keySecondRecord, null));
            record3.setText(sharedPreferences.getString(Utils.keyThirdRecord, null));
        } else if (sharedPreferences.getString(Utils.keySecondRecord, null) != null) {
            record1.setAlpha(1000);
            recordText1.setAlpha(1000);
            record2.setAlpha(1000);
            recordText2.setAlpha(1000);
            record2.setText(sharedPreferences.getString(Utils.keySecondRecord, null));
            record1.setText(sharedPreferences.getString(Utils.keyFirstRecord, null));
        } else if (sharedPreferences.getString(Utils.keyFirstRecord, null) != null)
        {
            Log.i(Utils.tag,(sharedPreferences.getString(Utils.keyFirstRecord, null))+"  log");
            empty.setAlpha(0);
            record1.setAlpha(1000);
            recordText1.setAlpha(1000);
            record1.setText(sharedPreferences.getString(Utils.keyFirstRecord, null));

        } else {
            empty.setAlpha(1000f);
            record1.setAlpha(0);
            record2.setAlpha(0);
            record3.setAlpha(0);
            recordText1.setAlpha(0);
            recordText2.setAlpha(0);
            recordText3.setAlpha(0);
        }
    }

    @Override
    public void onClick(View v) {

    }
}