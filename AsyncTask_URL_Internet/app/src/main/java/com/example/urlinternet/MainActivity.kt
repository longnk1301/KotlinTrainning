package com.example.urlinternet

import android.net.Uri
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    val urlGetData: String = "http://192.168.17.30/DemoContactWebService/getData.php"
    val urlInsert: String = "http://192.168.17.30/DemoContactWebService/insertData.php"
    var mangKH: ArrayList<String> = ArrayList()
    var adapterKH : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GetData().execute(urlGetData)
        adapterKH = ArrayAdapter(this, android.R.layout.simple_list_item_1, mangKH)
        lvCourse.adapter = adapterKH

        btnThem.setOnClickListener {
            val ten : String = edtTen.text.toString().trim()
            val hp : String = edtHocPhi.text.toString().trim()
            if(ten.length == 0 || hp.length == 0) {
                Toast.makeText(this@MainActivity, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_LONG).show()
            } else {
                InsertData().execute(urlInsert)
                edtHocPhi.setText("")
                edtTen.setText("")
                GetData().execute(urlGetData)
            }
        }
    }

    inner class GetData : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String?): String {
            return   getContentURL(params[0])
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            var jsonArray: JSONArray = JSONArray(result)

            var ten: String = ""
            var hocphi: String = ""
            mangKH.clear()
            for (khoaHoc in 0..jsonArray.length() - 1) {
                var objectKH: JSONObject = jsonArray.getJSONObject(khoaHoc)

                ten = objectKH.getString("TenKH")
                hocphi = objectKH.getString("HocPhi")
                mangKH.add(ten + " - " + hocphi)
            }
            adapterKH?.notifyDataSetChanged()
        }
    }

    inner class InsertData : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String?): String {
            return postData(params[0])
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.d("GGG", edtTen.text.toString())
            Log.d("GGG", edtHocPhi.text.toString())
            if(result.equals("success")) {
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun postData(link: String?): String {
        val connect: HttpURLConnection
        var url: URL =  URL(link)
        try {
            connect = url.openConnection() as HttpURLConnection
            connect.readTimeout = 10000
            connect.connectTimeout = 15000
            connect.requestMethod = "POST"
            // POST theo tham số
            val builder = Uri.Builder()
                .appendQueryParameter("tenkhoahoc", edtTen.text.toString().trim())
                .appendQueryParameter("hocphiKH", edtHocPhi.text.toString().trim())
            val query = builder.build().getEncodedQuery()
            val os = connect.outputStream
            val writer = BufferedWriter(OutputStreamWriter(os, "UTF-8"))
            writer.write(query)
            writer.flush()
            writer.close()
            os.close()
            connect.connect()
        } catch (e1: IOException) {
            e1.printStackTrace()
            return "Error!"
        }

        try {
            // Đọc nội dung trả về sau khi thực hiện POST
            val response_code = connect.responseCode
            if (response_code == HttpURLConnection.HTTP_OK) {
                val input = connect.inputStream
                val reader = BufferedReader(InputStreamReader(input))
                val result = StringBuilder()
                var line: String
                try {
                    do{
                        line = reader.readLine()
                        if(line != null){
                            result.append(line)
                        }
                    }while (line != null)

                    reader.close()
                }catch (e:Exception){}

                return result.toString()
            } else {
                return "Error!"
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return "Error!"
        } finally {
            connect.disconnect()
        }
    }

    private fun getContentURL (url: String?) : String {
        var content : StringBuilder = StringBuilder()
        val url : URL = URL(url)
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        val inputStream : InputStream = urlConnection.inputStream
        val inputStreamReader : InputStreamReader = InputStreamReader(inputStream)
        val bufferedReader : BufferedReader = BufferedReader(inputStreamReader) as BufferedReader

        var line : String = ""
        Log.d("CCC", content.toString())
        try {
            do {
                line = bufferedReader.readLine()
                if (line != null) {
                    content.append(line)
                }
            }while (line != null)
            bufferedReader.close()
        }catch (e: Exception) {
            Log.d("AAA", e.toString())
        }
        return content.toString()
    }
}
