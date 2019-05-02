package com.saliim.tekatekisilang.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.saliim.tekatekisilang.API
import com.saliim.tekatekisilang.R
import com.saliim.tekatekisilang.adapter.TtsAdapterMendatar
import com.saliim.tekatekisilang.adapter.TtsAdapterMenurun
import com.saliim.tekatekisilang.model.GetTts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_jawab.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var dataMenurun: java.util.ArrayList<GetTts>? = null
    var dataMendatar: java.util.ArrayList<GetTts>? = null
    var ttsCounter: Int = 0

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Teka-Teki Silang"

        recyclerMenurun.addOnItemTouchListener(
            RecyclerItemClickListener(
                this@MainActivity,
                RecyclerItemClickListener.OnItemClickListener { view, position ->

                    val mDialogView =
                        LayoutInflater.from(this).inflate(R.layout.custom_jawab, null)

                    val mBuilder = AlertDialog.Builder(this@MainActivity)
                        .setView(mDialogView)
                        .setTitle(dataMenurun!![position].noSoal + " " + dataMenurun!![position].jenis)

                    mDialogView.txt_tanya.text = dataMenurun!![position].tanya

                    val mAlertDialog = mBuilder.show()

                    mDialogView.btn_submit.setOnClickListener {
                        mAlertDialog.dismiss()

                        val quiz = dataMenurun!![position].jawab.toCharArray()
                        val coord = arrayOf(dataMenurun!![position].kolom, dataMenurun!![position].baris)

                        val jawab = dataMenurun!![position].jawab
                        val isian = mDialogView.et_jawab.text.toString()

                        val isianS = isian == isian.toUpperCase()

                        if (isian == jawab) {

                            quiz.forEachIndexed { index, c ->
                                val board = findViewById<Button>(
                                    resources.getIdentifier(
                                        "c${coord[0]}${coord[1] + index}",
                                        "id",
                                        packageName
                                    )
                                )
//                                Log.d("board", "c${coord[0] + index}${coord[1]}")


                                board.text = c.toString()
                            }

                            ttsCounter -= 1
                            dataMenurun!!.removeAt(position)
                            recyclerMenurun.adapter!!.notifyDataSetChanged()

                            Log.d("tts", ttsCounter.toString())

                            if (ttsCounter == 0) handleWin()


                            Toast.makeText(this@MainActivity, "anda benar", Toast.LENGTH_LONG).show()

                        } else if (isianS) {
                            Toast.makeText(this@MainActivity, "jangan gunakan huruf besar", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this@MainActivity, "anda salah", Toast.LENGTH_LONG).show()
                        }

                    }

                })
        )


        recyclerMendatar.addOnItemTouchListener(
            RecyclerItemClickListener(
                this@MainActivity,
                RecyclerItemClickListener.OnItemClickListener { view, position ->

                    val mDialogView =
                        LayoutInflater.from(this).inflate(R.layout.custom_jawab, null)

                    val mBuilder = AlertDialog.Builder(this@MainActivity)
                        .setView(mDialogView)
                        .setTitle(dataMendatar!![position].noSoal + " " + dataMendatar!![position].jenis)

                    mDialogView.txt_tanya.text = dataMendatar!![position].tanya

                    val mAlertDialog = mBuilder.show()

                    mDialogView.btn_submit.setOnClickListener {
                        mAlertDialog.dismiss()

                        val quiz = dataMendatar!![position].jawab.toCharArray()
                        val coord = arrayOf(dataMendatar!![position].kolom, dataMendatar!![position].baris)


                        val jawab = dataMendatar!![position].jawab
                        val isian = mDialogView.et_jawab.text.toString()

                        val isianS = isian == isian.toUpperCase()

                        if (isian == jawab) {

                            quiz.forEachIndexed { index, c ->
                                val board = findViewById<Button>(
                                    resources.getIdentifier(
                                        "c${coord[0] + index}${coord[1]}",
                                        "id",
                                        packageName
                                    )
                                )
                                Log.d("board", "c${coord[0] + index}${coord[1]}")


                                board.text = c.toString()
                            }

                            ttsCounter -= 1
                            dataMendatar!!.removeAt(position)
                            recyclerMendatar.adapter!!.notifyDataSetChanged()

                            Log.d("tts", ttsCounter.toString())

                            if (ttsCounter == 0) handleWin()


                            Toast.makeText(this@MainActivity, "anda benar", Toast.LENGTH_LONG).show()

                        } else if (isianS) {
                            Toast.makeText(this@MainActivity, "jangan gunakan huruf besar", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this@MainActivity, "anda salah", Toast.LENGTH_LONG).show()
                        }

                    }

                })
        )

        getDataMendatar()

        getDataMenurun()



    }

    private fun handleWin() {
//        Toast.makeText(this@MainActivity, "anda menang", Toast.LENGTH_SHORT).show()

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Finish")
        builder.setMessage("want to play again?")
        builder.setPositiveButton("yes"){dialog, which ->

            var intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)

        }
        builder.setNegativeButton("no"){dialog, which ->
            finish()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()


    }



    private fun getDataMenurun() {
        API.getTJMenurun().enqueue(object : Callback<ArrayList<GetTts>>{
            override fun onResponse(call: Call<ArrayList<GetTts>>, response: Response<ArrayList<GetTts>>) {
                if (response.code() == 200){
                    dataMenurun = response.body()
                    Log.d("dataIndex", ""+dataMenurun)


                    if (dataMenurun == null){

                        txt_null_data.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, "tidak ada", Toast.LENGTH_LONG).show()

                    } else {
                        ttsCounter += dataMenurun!!.size
                        txt_null_data.visibility = View.INVISIBLE
                        recyclerMenurun?.setHasFixedSize(true)
                        recyclerMenurun?.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerMenurun?.adapter = TtsAdapterMenurun(dataMenurun)
//                        Toast.makeText(this@MainActivity, "berhasil", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "gagal", Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<ArrayList<GetTts>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "gagal2", Toast.LENGTH_LONG).show()

            }
        })
    }

    private fun getDataMendatar() {
        API.getTJMendatar().enqueue(object : Callback<ArrayList<GetTts>>{
            override fun onResponse(call: Call<ArrayList<GetTts>>, response: Response<ArrayList<GetTts>>) {
                if (response.code() == 200){
                    dataMendatar = response.body()
                    Log.d("dataIndex", ""+dataMendatar)


                    if (dataMendatar == null){

                        txt_null_data.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, "tidak ada", Toast.LENGTH_LONG).show()

                    } else {
                        ttsCounter += dataMendatar!!.size
                        txt_null_data.visibility = View.INVISIBLE
                        recyclerMendatar?.setHasFixedSize(true)
                        recyclerMendatar?.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerMendatar?.adapter = TtsAdapterMendatar(dataMendatar)
//                        Toast.makeText(this@MainActivity, "berhasil", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "gagal", Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<ArrayList<GetTts>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "gagal2", Toast.LENGTH_LONG).show()

            }
        })
    }
}
