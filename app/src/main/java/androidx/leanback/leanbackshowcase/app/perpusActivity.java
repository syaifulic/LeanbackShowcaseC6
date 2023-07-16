package androidx.leanback.leanbackshowcase.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.leanback.leanbackshowcase.R;
import androidx.leanback.leanbackshowcase.cards.presenters.YoutubePlayerFullscreen;

public class perpusActivity extends LeanbackActivity {
    private TextView currentSec;
    private YoutubePlayerView youtubePlayerView;
    private YoutubePlayerView youtubePlayerView2;

    private Button mButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_perpus);

        ImageView home = (ImageView) findViewById(R.id.home3);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(perpusActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // get id from XML
        youtubePlayerView = (YoutubePlayerView) findViewById(R.id.youtubePlayerView);


        // make auto height of youtube. if you want to use 'wrap_content'
//        youtubePlayerView.setAutoPlayerHeight(this);

        // if you want to change white backgrond, #default is black.
        // youtubePlayerView.setWhiteBackgroundColor();

        // Control values : see more # https://developers.google.com/youtube/player_parameters?hl=en
        YTParams params = new YTParams();
        // params.setControls(0);
        params.setAutoplay(0);
        params.setVolume(100);
        params.setPlaybackQuality(PlaybackQuality.small);


        // initialize YoutubePlayerCallBackListener with Params and Full Video URL
        // youtubePlayerView.initializeWithUrl("https://www.youtube.com/watch?v=dxWvtMOGAhw", params, new YoutubePlayerView.YouTubeListener())

        // initialize YoutubePlayerCallBackListener with Params and Full Video URL
        // To Use - avoid UMG block!!!! but you'd better make own your server for your real service.
        // youtubePlayerView.initializeWithCustomURL("p1Zt47V3pPw" or "http://jaedong.net/youtube/p1Zt47V3pPw", params, new YoutubePlayerView.YouTubeListener())

        // Have to use old version user, if you have already set own your handler.
        // youtubePlayerView.setHandlerDisable();

        youtubePlayerView.initializeWithCustomURL("VrkLeQv3R1M", params, new YoutubePlayerView.YouTubeListener() {



            @Override
            public void onReady() {
                // when player is ready.
                JLog.i("onReady()");
            }

            public void sendMessage(View view) {
                Intent intent = new Intent(perpusActivity.this, YoutubePlayerFullscreen.class);
                startActivity(intent);
            }

            @Override
            public void onStateChange(YoutubePlayerView.STATE state) {
                /**
                 * YoutubePlayerView.STATE
                 *
                 * UNSTARTED, ENDED, PLAYING, PAUSED, BUFFERING, CUED, NONE
                 *
                 */

                JLog.i("onStateChange(" + state + ")");
            }

            @Override
            public void onPlaybackQualityChange(String arg) {
                String message = "onPlaybackQualityChange(" + arg + ")";
                Toast.makeText(perpusActivity.this, message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPlaybackRateChange(String arg) {
                String message = "onPlaybackRateChange(" + arg + ")";
                Toast.makeText(perpusActivity.this, message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String arg) {
                String message = "onError(" + arg + ")";
                Toast.makeText(perpusActivity.this, message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onApiChange(String arg) {
                String message = "onApiChange(" + arg + ")";
                Toast.makeText(perpusActivity.this, message, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCurrentSecond(double second) {
                currentSec.setText(String.valueOf(second));
            }

            @Override
            public void onDuration(double duration) {
                String message = "onDuration(" + duration + ")";
                JLog.i(message);
            }

            @Override
            public void logs(String log) {
                // javascript debug log. you don't need to use it.
                JLog.d(log);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // this is optional but you need.
        youtubePlayerView.destroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // pause video when on the background mode.
        youtubePlayerView.pause();
    }
}
