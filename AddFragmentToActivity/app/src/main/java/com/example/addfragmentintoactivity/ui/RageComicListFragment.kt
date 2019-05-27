package com.example.addfragmentintoactivity.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.addfragmentintoactivity.R
import com.example.addfragmentintoactivity.data.Comic
import com.example.addfragmentintoactivity.databinding.RecyclerItemRageComicBinding

class RageComicListFragment : Fragment() {
    private lateinit var imageResIds: IntArray
    private lateinit var names: Array<String>
    private lateinit var desctiptions: Array<String>
    private lateinit var urls: Array<String>

    //Communicating giữa Fragment với Activity
    private lateinit var listener: OnRageComicSelected

    companion object {
        fun newInstance(): RageComicListFragment {
            return RageComicListFragment()
        }
    }

    //Add fragment vào trong activity thông qua code
    /*onAttach(): có thể truy cập các resource mà bạn cần thông qua Context mà fragment đính kèm.
    * với đoạn code ở dưới bạn chắc chắn có một Context hợp lệ
    * ta tạo danh sách Rage Comic bằng RecycleView
    *
    * Sau khi xong đoạn dưới thì qua MainActivity và sửa onCreate()
    * */
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        //Communicating giữa Fragment với Activity
        //phần này sẽ khởi tạo tham chiếu cho listener
        /*Bạn hãy đợi đến khi onAttach()hoàn thành để chắc chắn rằng fragment đã đính kèm.
         Sau đó bạn cần xác định activity nào sẽ implement OnRageComicSelected interface thông qua từ khóa instanceof*/
        /*Nếu không hãy bắn Exception vì bạn không thể proceed.
        Nếu có hãy thiết lập activity như một listener cho RageComicListFragment.*/
        //tiếp theo cần nên OnBindViewHolder trong RageComicAdapter thêm code ở cuối dòng.
        if(context is OnRageComicSelected) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnRageComicSelected.")
        }

        //Get rage face names and descriptions.
        val resources = context!!.resources
        names = resources.getStringArray(R.array.names)
        desctiptions = resources.getStringArray(R.array.descriptions)
        urls = resources.getStringArray(R.array.urls)

        //Get rage face images.
        val typeArray = resources.obtainTypedArray(R.array.images)
        val imageCount = names.size
        imageResIds = IntArray(imageCount)
        for (i in 0..imageCount-1) {
            imageResIds[i] = typeArray.getResourceId(i, 0)
        }
        typeArray.recycle()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_rage_comic_list, container, false)
        val activity = activity
        val recycleriew = view.findViewById<RecyclerView>(R.id.recycler_view) as RecyclerView

        //GridLayoutManagergiúp việc định vị các items trong danh sách Rage Comic.
        recycleriew.layoutManager = GridLayoutManager(activity, 2)
        recycleriew.adapter = activity?.let { RageComicAdapter(it) }
        return view
    }

    internal inner class RageComicAdapter(context: Context): RecyclerView.Adapter<ViewHolder>() {

        private val layoutInflater: LayoutInflater

        init {
            layoutInflater = LayoutInflater.from(context)
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            val recyclerItemRageComicBinding = RecyclerItemRageComicBinding.inflate(layoutInflater, p0, false)

            return ViewHolder(recyclerItemRageComicBinding.root, recyclerItemRageComicBinding)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
            val comic =
                Comic(imageResIds[p1], names[p1], desctiptions[p1], urls[p1])
            viewHolder.setData(comic)

            //Communicating giữa Fragment với Activity
            viewHolder.itemView.setOnClickListener { listener.onRageComicSelected(comic) }
        }

        override fun getItemCount(): Int {
            return names.size
        }
    }

    internal inner class ViewHolder constructor(
        itemView: View,
        val recyclerItemRageComicBinding: RecyclerItemRageComicBinding) : RecyclerView.ViewHolder(itemView) {
        fun setData(comic: Comic) {
            recyclerItemRageComicBinding.comic = comic
        }
    }

    //Communicating giữa Fragment với Activity

    /*Điều này định nghĩa một listener interface để activity có thể bắt sự kiện của các fragment.
     Các activity sẽ implement interface  này và fragment sẽ gọi hàm onRageComicSelected()khi một mục
     được chọn bởi người dùng và chuyển lựa chọn đó đến activity.*/
    interface OnRageComicSelected {
        fun onRageComicSelected(comic: Comic)
    }
}