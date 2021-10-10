package com.template;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SettingProfil extends AppCompatActivity {
    ImageView settingImage;
    int countClick = 0;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_profil);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        settingImage = (ImageView) findViewById(R.id.settingImage);
        editText = (EditText) findViewById(R.id.nameSetting);

    }

    @SuppressLint({"NonConstantResourceId", "CommitPrefEdits"})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialogBackBtn:
                countClick--;
                if (countClick == -1) {
                    countClick = 9;
                }

                settingImage.setImageResource(Utils.arrayImage[countClick]);

                break;

            case R.id.dialogNextBtn:
                countClick++;
                if (countClick == 9) {
                    countClick = 0;
                }

                settingImage.setImageResource(Utils.arrayImage[countClick]);


                break;

            case R.id.saveBtn:
                Log.i(Utils.tag, "SaveShared");
                String name = editText.getText().toString();
                int id = settingImage.getId();
                if (!name.equals("")){
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                    SharedPreferences.Editor ed = sharedPreferences.edit();
                    ed.putString(Utils.keyNamePlayer, name);
                    ed.putInt(Utils.keyImage,Utils.arrayImage[countClick]);
                    Log.i(Utils.tag,String.valueOf(id));
                    ed.commit();
                    Toast.makeText(this, "Nick saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this,"Please write your nickname",Toast.LENGTH_SHORT).show();
                }




                break;

            case R.id.cancelBtn:
                Log.i(Utils.tag, "cancel");
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}