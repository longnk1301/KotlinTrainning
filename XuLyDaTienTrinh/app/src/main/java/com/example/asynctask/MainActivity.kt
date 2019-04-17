package com.example.asynctask

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnXuly.setOnClickListener {
            XuLyTienTrinh().execute()
        }
    }

    //muon goi txtview trong class asyncTask thi phai them inner, nghia la class xulycongviec se la 1 class con cua class mainactivity
    inner class XuLyTienTrinh : AsyncTask<Void, String, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            txtNoidung.text = " Start!! \n"
        }

        override fun doInBackground(vararg params: Void?): String {
            for ( i in 1..5) {
                publishProgress("Success $i \n")
            }
            return "Finish!"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            txtNoidung.append(result)
        }

        override fun onProgressUpdate(vararg values: String?) {
            super.onProgressUpdate(*values)
            txtNoidung.append(values[0])
        }
    }
}
