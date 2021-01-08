package com.example.gartenundhausapp;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.gartenundhausapp.ui.main.SectionsPagerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    protected LinearLayout tab1, tab2, tab3;
    protected TabWidget mytabs;
    protected TabHost tabhost;
    public TextView tvtab1Row, tvtab1Beet;
    protected ImageButton ibRow1FarLeft, ibRow1Left, ibRow1Right, ibRow1FarRight, ibRow2FarLft, ibRow2Left, ibRow2Right, ibRow2FarRight;
    //protected TabLayout.Tab tab_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        TextView tvtab1Row = findViewById(R.id.tvtab1Row);
        TextView tvtab1Beet = findViewById(R.id.tvtab1Beet);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        ImageButton ibRow1FarLeft = findViewById(R.id.ibRow1FarLeft);
        ImageButton ibRow1Left = findViewById(R.id.ibRow1Left);
        ImageButton ibRow1Right = findViewById(R.id.ibRow1Right);
        ImageButton ibRow1FarRight = findViewById(R.id.ibRow1FarRight);
        ImageButton ibRow2FarLeft = findViewById(R.id.ibRow2FarLeft);
        ImageButton ibRow2Left = findViewById(R.id.ibRow2Left);
        ImageButton ibRow2Right = findViewById(R.id.ibRow2Right);
        ImageButton ibRow2FarRight = findViewById(R.id.ibRow2FarRight);

        LinearLayout tab1 = findViewById(R.id.tab1);
        LinearLayout tab2 = findViewById(R.id.tab2);
        LinearLayout tab3 = findViewById(R.id.tab3);

        TabHost tabhost = findViewById(R.id.tabhost);

        //tabhost.setCurrentTab(1);


        //mytabs.setEnabled(true);

       tabhost.setup();
        TabHost.TabSpec spec = tabhost.newTabSpec("one");
        spec.setContent(R.id.tab1);
        spec.setIndicator("GIEẞEN");
        tabhost.addTab(spec);

        spec = tabhost.newTabSpec("two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("DACH LUEFTEN (?)");
        tabhost.addTab(spec);

        spec = tabhost.newTabSpec("three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("???");
        tabhost.addTab(spec);

        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
               //int x = tabhost.getCurrentTab();
               String a = tabhost.getCurrentTabTag();

                if(tabhost.getCurrentTabTag() == "one"){
                    tab2.setVisibility(View.GONE); //set all other tabs invisible
                    tab3.setVisibility(View.GONE);
                    tab1.setVisibility(View.VISIBLE); //set current Tab visible

                } else if(tabhost.getCurrentTabTag() == "two"){
                    tab1.setVisibility(View.GONE); //set all other tabs invisible
                    tab3.setVisibility(View.GONE);
                    tab2.setVisibility(View.VISIBLE); //set current Tab visible

                } else if(tabhost.getCurrentTabTag() == "three"){
                    tab1.setVisibility(View.GONE); //set all other tabs invisible
                    tab2.setVisibility(View.GONE);
                    tab3.setVisibility(View.VISIBLE); //set current Tab visible

                } else {
                    tab1.setVisibility(View.GONE); //set all other tabs invisible
                    tab3.setVisibility(View.GONE);
                    tab2.setVisibility(View.VISIBLE); //set current Tab visible

                }
            }
        });

        /*

        Funktion die (in Gießen):
        1a. Den Gießplan ausliest und ausführt
        1b. Den Gießplan anzeigt
        2a. Sensoren ausliest (?)
        2b. Sensorendaten aus der Datenbank ausliest
        2c. Die Buttonbilder ändert / dem User die Möglich keit gibt zusätzlich zu gießen

        Funktion die (in Dachluefter):
        1a. Sensoren ausliest (?)
        1b. Sensorendaten aus der Datenbank ausliest
        1c. Sensorendaten anzeigt
        1d. Dem User die Möglich keit gibt zusätzlich zu lueften

         */

        ibRow1FarLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gießen("1","1", tvtab1Row, tvtab1Beet);
            }
        });

        ibRow1Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gießen("1","2", tvtab1Row, tvtab1Beet);
            }
        });

        ibRow1Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gießen("1","3", tvtab1Row, tvtab1Beet);
            }
        });

        ibRow1FarRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gießen("1","4", tvtab1Row, tvtab1Beet);
            }
        });

        ibRow2FarLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gießen("2","1", tvtab1Row, tvtab1Beet);
            }
        });

        ibRow2Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gießen("2","2", tvtab1Row, tvtab1Beet);
            }
        });

        ibRow2Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gießen("2","3", tvtab1Row, tvtab1Beet);
            }
        });

        ibRow2FarRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gießen("2","4", tvtab1Row, tvtab1Beet);
            }
        });


    }

    public void gießen(String row, String beet, TextView tvtab1Row, TextView tvtab1Beet){
        tvtab1Row.setText(row);
        tvtab1Beet.setText(beet);
    }
}