package tk.moiseev.alfabetika

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import java.util.*

class MainActivity
  (


  )
    : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    fun <T:Comparable<T>>shuffle(items:MutableList<T>):List<T>{
        val rg : Random = Random()
        for (i in 0..items.size - 1) {
            val randomPosition = rg.nextInt(items.size)
            val tmp : T = items[i]
            items[i] = items[randomPosition]
            items[randomPosition] = tmp
        }
        return items
    }

    private var newDrawItems: MutableList<Int> = (1..31).toMutableList()

    override fun onLongClick(v: View?): Boolean {
// перемешивание букв
        var drawItems: MutableList<Int> = (1..31).toMutableList()
        val res: Resources = this.getResources()
        for (item in drawItems)
        {
            val id = res.getIdentifier("l"+item.toString(),"drawable",this.packageName)
            newDrawItems[item-1] = id
        }



        newDrawItems = shuffle(newDrawItems).toMutableList()
        val button1: ImageButton = this.findViewById(R.id.imageButton1)
        button1.setImageResource(newDrawItems[1])
        val button2: ImageButton = this.findViewById(R.id.imageButton2)
        button2.setImageResource(newDrawItems[3])
        val button3: ImageButton = this.findViewById(R.id.imageButton3)
        button3.setImageResource(newDrawItems[5])
        val button4: ImageButton = this.findViewById(R.id.imageButton4)
        button4.setImageResource(newDrawItems[7])
        val button5: ImageButton = this.findViewById(R.id.imageButton5)
        button5.setImageResource(newDrawItems[9])
        val button6: ImageButton = this.findViewById(R.id.imageButton6)
        button6.setImageResource(newDrawItems[11])
        val button7: ImageButton = this.findViewById(R.id.imageButton7)
        button7.setImageResource(newDrawItems[13])
        val button8: ImageButton = this.findViewById(R.id.imageButton8)
        button8.setImageResource(newDrawItems[15])
        val button9: ImageButton = this.findViewById(R.id.imageButton9)
        button9.setImageResource(newDrawItems[17])


        return true
    }

    override fun onClick(v: View?) {
        Log.d("click", "Hello")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: ImageButton = this.findViewById(R.id.imageButton1)
        button1.setOnClickListener(this)
        button1.setOnLongClickListener(this)

        val button2: ImageButton = this.findViewById(R.id.imageButton2)
        button2.setOnClickListener(this)
        button2.setOnLongClickListener(this)

        val button3: ImageButton = this.findViewById(R.id.imageButton3)
        button3.setOnClickListener(this)
        button3.setOnLongClickListener(this)

        val button4: ImageButton = this.findViewById(R.id.imageButton4)
        button4.setOnClickListener(this)
        button4.setOnLongClickListener(this)

        val button5: ImageButton = this.findViewById(R.id.imageButton5)
        button5.setOnClickListener(this)
        button5.setOnLongClickListener(this)

        val button6: ImageButton = this.findViewById(R.id.imageButton6)
        button6.setOnClickListener(this)
        button6.setOnLongClickListener(this)

        val button7: ImageButton = this.findViewById(R.id.imageButton7)
        button7.setOnClickListener(this)
        button7.setOnLongClickListener(this)

        val button8: ImageButton = this.findViewById(R.id.imageButton8)
        button8.setOnClickListener(this)
        button8.setOnLongClickListener(this)

        val button9: ImageButton = this.findViewById(R.id.imageButton9)
        button9.setOnClickListener(this)
        button9.setOnLongClickListener(this)


    }



}
