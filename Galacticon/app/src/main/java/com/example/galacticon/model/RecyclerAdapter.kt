package com.example.galacticon.model

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.galacticon.R
import com.example.galacticon.ui.PhotoActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycleview_item_row.view.*

class RecyclerAdapter(private val photos: ArrayList<Photo>) : RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.PhotoHolder {

        /*
        * Ở đây, bạn inflate các view từ layout và chuyển vào một PhotoHolder.
        * Phương thức parent.inflate (R.layout.recyclerview_item_row, false) sẽ thực hiện
        * chức năng ViewGroup.inflate(..) extension mới để inflate layout.
        * */
        val inflatedView = parent.inflate(R.layout.recycleview_item_row, false)

        return PhotoHolder(inflatedView)
    }

    override fun getItemCount() = photos.size

    //Hàm này sẽ cho biết Item mới đang avaiable trên màn hình và holder cần dữ liệu để hiển thị
    override fun onBindViewHolder(holder: RecyclerAdapter.PhotoHolder, position: Int) {
        val itemPhoto = photos[position]
        holder.binPhoto(itemPhoto)
    }

    //tạo class và kế thừa RecyclerView.ViewHolder sẽ cho phép class này được sử dụng như là ViewHolder
    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        /*
        * Thêm reference đối tượng cho phép ViewHolder trong Android có thể keep được view của bạn.
        * Điều này cho phép holder có thể tiếp cận ImageView và TextView như là một extension property.
        * Kotlin Androd Extensions plugin bổ sung thêm các chức năng và
        * trường ẩn bộ nhớ đệm để view không bị truy vấn thường xuyên.
        * */

        private var view: View = v
        private var photo: Photo? = null


        init {
            v.setOnClickListener(this)
        }

        //Implement các phương thức bắt buộc của Onclicklistener Interface.
            //start Activity khi click vào một item nào đó
        override fun onClick(v: View) {
            Log.d("AAA", "Click")

            //lấy thuộc tính của itemview được click vào
            val context = itemView.context

            //tạo intent để start Activity
            val showPhotoIntent = Intent(context, PhotoActivity::class.java)

            //pass các object ảnh bạn muốn hiển thị ra màn hình
            //Việc chuyển object context vào intent cho phép ứng dụng biết Activity của nó là gì.
            showPhotoIntent.putExtra(PHOTO_KEY, photo)
            context.startActivity(showPhotoIntent)
        }

        //bind các bức ảnh vào PhotoHolder, tức là tạo data cho item là bức ảnh để nó có thể hiển thị ra màn hình
        fun binPhoto(photo: Photo) {
            this.photo = photo
            Picasso.with(view.context).load(photo.url).into(view.itemImage)
            view.itemDate.text = photo.humanDate
            view.itemDescription.text = photo.explanation
        }

        companion object {
            private val PHOTO_KEY = "PHOTO"
        }
    }
}



