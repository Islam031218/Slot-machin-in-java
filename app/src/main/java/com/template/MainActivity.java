package com.template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView count, countWin, namePlayer;
    SharedPreferences sharedPreferences;
    private ArrayList<Model> historyList,assistantList;


    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13,
            img14, img15, playerImage;

    private Weel wheel1, wheel2, wheel3, wheel4, wheel5, wheel6, wheel7, wheel8, wheel9, wheel10, wheel11,
            wheel12, wheel13, wheel14, wheel15;

    private ImageView btn;
    private Button btnPlus, btnMinus;
    private int counter = 1;
    Integer randomCount = 20;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(0);
        setSupportActionBar(toolbar);
        historyList = new ArrayList<Model>();
        assistantList = new ArrayList<Model>();


// All icons
        {
            img1 = (ImageView) findViewById(R.id.icon1);
            img2 = (ImageView) findViewById(R.id.icon2);
            img3 = (ImageView) findViewById(R.id.icon3);
            img4 = (ImageView) findViewById(R.id.icon4);
            img5 = (ImageView) findViewById(R.id.icon5);
            img6 = (ImageView) findViewById(R.id.icon6);
            img7 = (ImageView) findViewById(R.id.icon7);
            img8 = (ImageView) findViewById(R.id.icon8);
            img9 = (ImageView) findViewById(R.id.icon9);
            img10 = (ImageView) findViewById(R.id.icon10);
            img11 = (ImageView) findViewById(R.id.icon11);
            img12 = (ImageView) findViewById(R.id.icon12);
            img13 = (ImageView) findViewById(R.id.icon13);
            img14 = (ImageView) findViewById(R.id.icon14);
            img15 = (ImageView) findViewById(R.id.icon15);
            btn = (ImageView) findViewById(R.id.imageSpin);
            playerImage = (ImageView) findViewById(R.id.imagePlayer);


            count = (TextView) findViewById(R.id.count);
            countWin = (TextView) findViewById(R.id.countWin);
            namePlayer = (TextView) findViewById(R.id.namePlayer);

            btnPlus = (Button) findViewById(R.id.plusButton);
            btnMinus = (Button) findViewById(R.id.minusButton);
        }

        getInIntent();
    }

    // check sharedPreferences(namePlayer and icon) & set namePlayer and setIconPlayer
    private void getInIntent() {

        try {
            sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            if (sharedPreferences.getString(Utils.keyNamePlayer, null) != null) {
                String name = sharedPreferences.getString(Utils.keyNamePlayer, null);
                int id = sharedPreferences.getInt(Utils.keyImage, 0);
                namePlayer.setText(name);
                playerImage.setImageResource(id);
            }else{

            }

            sharedPreferences = getSharedPreferences(Utils.keyLevel, MODE_PRIVATE);

            if (sharedPreferences.getInt(Utils.keyLevel, 0) != 0) {
                randomCount = sharedPreferences.getInt(Utils.keyLevel, 0);
            }

        } catch (Exception e) {
            e.getStackTrace();

        }

    }

    // number of inserts (количество вставок)
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()) {

            case R.id.plusButton:
                counter++;
                count.setText(String.valueOf(counter));
                Log.i(Utils.tag, "TagPlus");
                break;


            case R.id.minusButton:
                if (counter > 1) {
                    counter--;
                    count.setText(String.valueOf(counter));
                    Log.i(Utils.tag, "TagMinus");
                }
                break;

            case R.id.imageSpin:

                setImage();
                break;


        }
    }


    // set images on click spin
    private void setImage() {
        wheel1 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img1.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(0, 300), btn, randomCount);
        wheel1.start();


        wheel2 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img2.setImageResource(img);


                    }

                });

            }
        }, 100, randomLong(0, 500), btn, randomCount);

        wheel2.start();


        wheel3 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img3.setImageResource(img);

                    }
                });
            }
        }, 100, randomLong(150, 400), btn, randomCount);
        wheel3.start();


        wheel4 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img4.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(0, 450), btn, randomCount);
        wheel4.start();


        wheel5 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img5.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(0, 350), btn, randomCount);
        wheel5.start();

        wheel6 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img6.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(0, 250), btn, randomCount);
        wheel6.start();

        wheel7 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img7.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(0, 300), btn, randomCount);
        wheel7.start();

        wheel8 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img8.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(0, 100), btn, randomCount);
        wheel8.start();

        wheel9 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img9.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(0, 200), btn, randomCount);
        wheel9.start();

        wheel10 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img10.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(150, 300), btn, randomCount);
        wheel10.start();

        wheel11 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img11.setImageResource(img);
                    }
                });
            }
        }, 100, randomLong(0, 400), btn, randomCount);
        wheel11.start();

        wheel12 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img12.setImageResource(img);

                    }
                });
            }
        }, 100, randomLong(0, 500), btn, randomCount);
        wheel12.start();

        wheel13 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img13.setImageResource(img);

                    }
                });
            }
        }, 100, randomLong(0, 500), btn, randomCount);
        wheel13.start();

        wheel14 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img14.setImageResource(img);

                    }
                });
            }
        }, 100, randomLong(0, 200), btn, randomCount);
        wheel14.start();

        wheel15 = new Weel(new Weel.WheelListener() {
            @Override
            public void newImage(final int img) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img15.setImageResource(img);


                    }
                });
            }
        }, 100, randomLong(0, 300), btn, randomCount);
        wheel15.start();
        if (btn.getAlpha() > 0) {
            check();
        }

    }


    // menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    // items in menu
    @SuppressLint({"NonConstantResourceId", "Range"})
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.settingProfile:
                startActivity(new Intent(this, SettingProfil.class));
                break;
            case R.id.record:
                startActivity(new Intent(this,Records.class));
                break;
            case R.id.light:
                Log.i(Utils.tag, "level");
                try{
                    sharedPreferences = getSharedPreferences(Utils.keyLevel, MODE_PRIVATE);
                    SharedPreferences.Editor ed = sharedPreferences.edit();
                    ed.putInt(Utils.keyLevel, 5);
                    ed.commit();
                    Log.i(Utils.tag, String.valueOf(sharedPreferences.getInt(Utils.keyLevel, 0) + "ksdnk"));
                    getInIntent();

                } catch (Exception e) {
                    e.getStackTrace();
                    Log.i(Utils.tag, e.getMessage());
                }

                break;
            case R.id.normal:
                try {
                    sharedPreferences = getSharedPreferences(Utils.keyLevel, MODE_PRIVATE);
                    SharedPreferences.Editor ed = sharedPreferences.edit();
                    ed.putInt(Utils.keyLevel, 20);
                    ed.commit();
                    Log.i(Utils.tag, String.valueOf(sharedPreferences.getInt(Utils.keyLevel, 0) + "ksdnk"));
                    getInIntent();

                } catch (Exception e) {
                    e.getStackTrace();
                    Log.i(Utils.tag, e.getMessage());
                }

                break;
            case R.id.hard:
                try {
                    sharedPreferences = getSharedPreferences(Utils.keyLevel, MODE_PRIVATE);
                    SharedPreferences.Editor ed = sharedPreferences.edit();
                    ed.putInt(Utils.keyLevel, 70);
                    ed.commit();
                    Log.i(Utils.tag, String.valueOf(sharedPreferences.getInt(Utils.keyLevel, 0) + "ksdnk"));
                    getInIntent();

                } catch (Exception e) {
                    e.getStackTrace();
                    Log.i(Utils.tag, e.getMessage());
                }

                break;

            case R.id.history:
                startActivity(new Intent(this, History.class));
        }

        return super.onOptionsItemSelected(item);
    }

    // save records in sharedPreferences
    private void check() {

        int count = (int) ((100 + Math.random() * 900) );
        countWin.setText(String.valueOf(count));
        int image = playerImage.getId();
        historyList.add(new Model(String.valueOf(namePlayer.getText()),String.valueOf(count),image));
        saveList(historyList);
        historyList.remove(0);


        sharedPreferences = getSharedPreferences("record", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        if (sharedPreferences.getString(Utils.keyFirstRecord, null) == null){
            Log.i(Utils.tag, "firstEdit");
            edit.putString(Utils.keyFirstRecord, String.valueOf(count));
            Log.i(Utils.tag, String.valueOf(count));
        }
        else if (sharedPreferences.getString(Utils.keySecondRecord, null) == null){
            if (count > Integer.parseInt(sharedPreferences.getString(Utils.keyFirstRecord, null))){
                edit.putString(Utils.keySecondRecord, sharedPreferences.getString(Utils.keyFirstRecord, null));
                edit.putString(Utils.keyFirstRecord, String.valueOf(count));
            }else{
                edit.putString(Utils.keySecondRecord, String.valueOf(count));
            }

        }
        else if (sharedPreferences.getString(Utils.keyThirdRecord, null) == null){
            if(count > Integer.parseInt(sharedPreferences.getString(Utils.keySecondRecord, null))){
                edit.putString(Utils.keyThirdRecord,sharedPreferences.getString(Utils.keySecondRecord, null));
                if (count > Integer.parseInt(sharedPreferences.getString(Utils.keyFirstRecord, null))){
                    edit.putString(Utils.keySecondRecord,sharedPreferences.getString(Utils.keyFirstRecord, null));
                    edit.putString(Utils.keyFirstRecord,String.valueOf(count));
                }else {
                    edit.putString(Utils.keySecondRecord, String.valueOf(count));
                }
            }else{
                edit.putString(Utils.keyThirdRecord, String.valueOf(count));
            }

        }
        else {
            if (count >= Integer.parseInt(sharedPreferences.getString(Utils.keyThirdRecord, null))) {
                if (count >= Integer.parseInt(sharedPreferences.getString(Utils.keySecondRecord, null))) {
                    if (count >= Integer.parseInt(sharedPreferences.getString(Utils.keyFirstRecord, null))) {
                        edit.putString(Utils.keyThirdRecord,sharedPreferences.getString(Utils.keySecondRecord,null));
                        edit.putString(Utils.keySecondRecord,sharedPreferences.getString(Utils.keyFirstRecord,null));
                        edit.putString(Utils.keyFirstRecord, String.valueOf(count));
                    } else {
                        edit.putString(Utils.keyThirdRecord,sharedPreferences.getString(Utils.keySecondRecord,null));
                        edit.putString(Utils.keySecondRecord, String.valueOf(count));
                    }
                } else {
                    edit.putString(Utils.keyThirdRecord, String.valueOf(count));
                }
            }
        }

        edit.apply();
        Log.i(Utils.tag,sharedPreferences.getString(Utils.keyFirstRecord,null)+" putFirst");
    }

    // save history in sharedPreferences
    private void saveList(ArrayList<Model> list) {
        if (getLists()!=null){
            assistantList = getLists();
        }
        assistantList.add(list.get(0));
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(assistantList);
        Log.i("MyTag", json.toString());
        editor.putString("key", json);
        editor.apply();


    }

    // check old historyes
    private ArrayList<Model> getLists() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = prefs.getString("key", null);
        Type type = new TypeToken<ArrayList<Model>>() {}.getType();
        return gson.fromJson(json,type);
    }


}