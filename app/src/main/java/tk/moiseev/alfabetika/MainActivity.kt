package tk.moiseev.alfabetika

import android.annotation.TargetApi
import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

import java.io.IOException

class MainActivity : AppCompatActivity() {
    internal var context: Context? = null
    private var mSoundPool: SoundPool? = null
    private var mAssetManager: AssetManager? = null
    private var mStreamID: Int = 0
    private var m1: Int = 0
    private var m2: Int = 0
    private var m3: Int = 0
    private var m4: Int = 0
    private var m5: Int = 0
    private var m6: Int = 0
    private var m7: Int = 0
    private var m8: Int = 0
    private var m9: Int = 0
    internal var onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.image1 -> playSound(m1)
                R.id.image2 -> playSound(m2)
                R.id.image3 -> playSound(m3)
                R.id.image4 -> playSound(m4)
                R.id.image5 -> playSound(m5)
                R.id.image6 -> playSound(m6)
                R.id.image7 -> playSound(m7)
                R.id.image8 -> playSound(m8)
                R.id.image9 -> playSound(m9)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        context = this;
        val m1ImageButton = findViewById(R.id.image1) as ImageButton
        m1ImageButton.setOnClickListener(onClickListener)

        val m2ImageButton = findViewById(R.id.image2) as ImageButton
        m2ImageButton.setOnClickListener(onClickListener)

        val m3ImageButton = findViewById(R.id.image3) as ImageButton
        m3ImageButton.setOnClickListener(onClickListener)

        val m4ImageButton: ImageButton
        m4ImageButton = findViewById(R.id.image4) as ImageButton
        m4ImageButton.setOnClickListener(onClickListener)

        val m5ImageButton = findViewById(R.id.image5) as ImageButton
        m5ImageButton.setOnClickListener(onClickListener)

        val m6ImageButton = findViewById(R.id.image6) as ImageButton
        m6ImageButton.setOnClickListener(onClickListener)

        val m7ImageButton = findViewById(R.id.image7) as ImageButton
        m7ImageButton.setOnClickListener(onClickListener)

        val m8ImageButton = findViewById(R.id.image8) as ImageButton
        m8ImageButton.setOnClickListener(onClickListener)

        val m9ImageButton = findViewById(R.id.image9) as ImageButton
        m9ImageButton.setOnClickListener(onClickListener)


        // mAssetManager = getAssets();
    }

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
    private fun createNewSoundPool() {
        val attributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
        mSoundPool = SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build()
    }

    private fun createOldSoundPool() {
        mSoundPool = SoundPool(3, AudioManager.STREAM_MUSIC, 0)
    }

    private fun playSound(sound: Int): Int {
        if (sound > 0) {
            mStreamID = mSoundPool!!.play(sound, 1f, 1f, 1, 0, 1f)
        }
        return mStreamID
    }

    private fun loadSound(fileName: String): Int {
        val afd: AssetFileDescriptor
        try {
            afd = mAssetManager!!.openFd(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(applicationContext, "Не могу загрузить файл $fileName",
                    Toast.LENGTH_SHORT).show()
            return -1
        }

        return mSoundPool!!.load(afd, 1)
    }

    override fun onResume() {
        super.onResume()

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Для устройств до Android 5
            createOldSoundPool()
        } else {
            // Для новых устройств
            createNewSoundPool()
        }

        mAssetManager = assets

        // получим идентификаторы
        m1 = loadSound("\u0410.ogg")
        m2 = loadSound("\u0411.ogg")
        m3 = loadSound("\u0412.ogg")
        m4 = loadSound("\u0413.ogg")
        m5 = loadSound("\u0414.ogg")
        m6 = loadSound("\u0415.ogg")
        m7 = loadSound("\u0401.ogg")
        m8 = loadSound("\u0416.ogg")
        m9 = loadSound("\u0417.ogg")

    }

    override fun onPause() {
        super.onPause()
        mSoundPool!!.release()
        mSoundPool = null
    }
}
