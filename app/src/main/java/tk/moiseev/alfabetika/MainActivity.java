package tk.moiseev.alfabetika;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.Build;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    Context context;
    private int mStreamID;
    private int m1,m2,m3,m4,m5,m6,m7,m8,m9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        context = this;
        ImageButton m1ImageButton = (ImageButton) findViewById(R.id.image1);
        m1ImageButton.setOnClickListener(onClickListener);

        ImageButton m2ImageButton = (ImageButton) findViewById(R.id.image2);
        m2ImageButton.setOnClickListener(onClickListener);

        ImageButton m3ImageButton = (ImageButton) findViewById(R.id.image3);
        m3ImageButton.setOnClickListener(onClickListener);

        ImageButton m4ImageButton = (ImageButton) findViewById(R.id.image4);
        m4ImageButton.setOnClickListener(onClickListener);

        ImageButton m5ImageButton = (ImageButton) findViewById(R.id.image5);
        m5ImageButton.setOnClickListener(onClickListener);

        ImageButton m6ImageButton = (ImageButton) findViewById(R.id.image6);
        m6ImageButton.setOnClickListener(onClickListener);

        ImageButton m7ImageButton = (ImageButton) findViewById(R.id.image7);
        m7ImageButton.setOnClickListener(onClickListener);

        ImageButton m8ImageButton = (ImageButton) findViewById(R.id.image8);
        m8ImageButton.setOnClickListener(onClickListener);

        ImageButton m9ImageButton = (ImageButton) findViewById(R.id.image9);
        m9ImageButton.setOnClickListener(onClickListener);


       // mAssetManager = getAssets();
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image1:
                    playSound(m1);
                    break;
                case R.id.image2:
                    playSound(m2);
                    break;
                case R.id.image3:
                    playSound(m3);
                    break;
                case R.id.image4:
                    playSound(m4);
                    break;
                case R.id.image5:
                    playSound(m5);
                    break;
                case R.id.image6:
                    playSound(m6);
                    break;
                case R.id.image7:
                    playSound(m7);
                    break;
                case R.id.image8:
                    playSound(m8);
                    break;
                case R.id.image9:
                    playSound(m9);
                    break;
            }
        }
    };

 /*   private int playSound(int sound) {
        if (sound > 0) {
            mStreamID = mSoundPool.play(sound, 1, 1, 1, 0, 1);
        }
        return mStreamID;
    }
    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }*/

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    @SuppressWarnings("deprecation")
    private void createOldSoundPool() {
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    }

    private int playSound(int sound) {
        if (sound > 0) {
            mStreamID = mSoundPool.play(sound, 1, 1, 1, 0, 1);
        }
        return mStreamID;
    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Для устройств до Android 5
            createOldSoundPool();
        } else {
            // Для новых устройств
            createNewSoundPool();
        }

        mAssetManager = getAssets();

        // получим идентификаторы
        m1 = loadSound("\u0410.ogg");
        m2 = loadSound("\u0411.ogg");
        m3 = loadSound("\u0412.ogg");
        m4 = loadSound("\u0413.ogg");
        m5 = loadSound("\u0414.ogg");
        m6 = loadSound("\u0415.ogg");
        m7 = loadSound("\u0401.ogg");
        m8 = loadSound("\u0416.ogg");
        m9 = loadSound("\u0417.ogg");

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSoundPool.release();
        mSoundPool = null;
    }
}
