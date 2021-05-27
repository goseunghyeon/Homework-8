package com.example.myapplication ;



import android.app.TabActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.example.myapplication.R;

@SuppressWarnings("deprecation")
public class SubActivity extends TabActivity {
    //MediaPlayer player;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Button button=(Button)findViewById(R.id.back);
        final MediaPlayer[] player = {MediaPlayer.create(this, R.raw.song1)};
        String[] mid = { "숲을달리는소리", "새소리2", "새소리1", "세소리3", "시냇물소리", "잔잔한시냇물",
        };
        int[] song = { R.raw.song1,R.raw.song2,R.raw.song3,R.raw.song4,R.raw.song5,R.raw.song6};
        ListView list = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mid);
        list.setAdapter(adapter);
        //final MediaPlayer player;
        //player=MediaPlayer.create(this, R.raw.song1);
        //MediaPlayer.c
        TabHost tabHost = getTabHost();

        TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("산");
        tabSpecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabSpecSong);

        TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("바다");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("그외");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        TabSpec tabSpecBack = tabHost.newTabSpec("ALBUM").setIndicator("이전");
        tabSpecBack.setContent(R.id.back);
        tabHost.addTab(tabSpecBack);

        tabHost.setCurrentTab(0);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                // final MediaPlayer player;
                //player=MediaPlayer.create(getApplicationContext(), song[arg2]);
                if(player[0].isPlaying())
                    player[0].stop();
                else {
                    player[0] =MediaPlayer.create(getApplicationContext(), song[arg2]);
                    player[0].start();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
           }
        });


    }
}
