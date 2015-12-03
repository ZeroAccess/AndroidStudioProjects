package randstad.youtubeplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by robertsg on 2/19/2015.
 */
public class StandAloneActivity extends Activity implements View.OnClickListener {

    private Button btnPlay;
    private Button btnPlayList;

    public static final String GOOGLE_API_KEY = "AIzaSyABAvNlMWOKpucvxwqzVxEu94QuHm06XHE";
    public static final String YOUTUBE_VIDEO_ID = "6KJkvDLJXVE";
    public static final String YOUTUBE_PLAYLIST_ID = "RD6KJkvDLJXVE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standalone);

        btnPlay = (Button) findViewById(R.id.btnStart);
        btnPlayList = (Button) findViewById(R.id.btnPlaylist);

        btnPlay.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent = null;
        if(v == btnPlay){
            //Play a single video
            intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
        }else if (v == btnPlayList){
            //Play the playlist
            intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY,YOUTUBE_PLAYLIST_ID);
        }

        if(intent != null){
            startActivity(intent);
        }
    }
}
