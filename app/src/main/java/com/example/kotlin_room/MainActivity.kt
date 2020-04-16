package com.example.kotlin_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MhsDatabase(this)

        GlobalScope.launch {
            db.mhsDao().insertAll(MhsEntity(0, "Budi", "malang"))
            val data = db.mhsDao().getAll()

            data?.forEach {
                Log.d("DATABASE", it.toString())
            }
        }

        tambah.setOnClickListener {

            var nama = input_nama.text.toString()
            var alamat = input_alamat.text.toString()

            txt_result.setText("nama = $nama \nalamat = $alamat")

            GlobalScope.launch {
                db.mhsDao().insertAll(MhsEntity(0, "$nama", "$alamat"))
                val data = db.mhsDao().getAll()

                data?.forEach {
                    Log.d("DATABASE", it.toString())
                }
            }

        }

    }

    fun Btn_tambah(view: View) {

    }
}
