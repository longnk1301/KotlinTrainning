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

    companion object {
        fun newInstance(): RageComicListFragment {
            return RageComicListFragment()
        }
    }

    internal inner class RageComicAdapter(context: Context): RecyclerView.Adapter<ViewHolder>() {

        private val layoutInflater: LayoutInflater

        init {
            layoutInflater = LayoutInflater.from(context)
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            val comic =
                Comic(imageResIds[p1], names[p1], desctiptions[p1], urls[p1])
            p0.setData(comic)
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            val recyclerItemRageComicBinding = RecyclerItemRageComicBinding.inflate(layoutInflater, p0, false)

            return ViewHolder(recyclerItemRageComicBinding.root, recyclerItemRageComicBinding)
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

    //Add fragment vào trong activity thông qua code
    /*onAttach(): có thể truy cập các resource mà bạn cần thông qua Context mà fragment đính kèm.
    * với đoạn code ở dưới bạn chắc chắn có một Context hợp lệ
    * ta tạo danh sách Rage Comic bằng RecycleView
    *
    * Sau khi xong đoạn dưới thì qua MainActivity và sửa onCreate()
    * */
    override fun onAttach(context: Context?) {
        super.onAttach(context)

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
}