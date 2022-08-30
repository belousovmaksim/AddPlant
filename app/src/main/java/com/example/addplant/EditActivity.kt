package com.example.addplant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.addplant.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = 0
    private val imageIdList = listOf(
        R.drawable.armeria1,
        R.drawable.delfinium2,
        R.drawable.gorechevka3,
        R.drawable.gus_lyk4,
        R.drawable.jivokost5,
        R.drawable.kiprey6,
        R.drawable.zveroboy7
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()

    }

    private fun initButton() = with(binding) {
        bNextIm.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
            Log.d("Log", "index: $indexImage")


            bDone.setOnClickListener {
                val plant = Plant(imageId, edTitle.text.toString(), edDiscr.text.toString())
                val editIntent = Intent().apply {
                    putExtra("plant", plant)
                }
                setResult(RESULT_OK, editIntent)
                finish()
            }
        }
    }
}