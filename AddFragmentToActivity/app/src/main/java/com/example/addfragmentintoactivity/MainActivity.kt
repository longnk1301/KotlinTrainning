package com.example.addfragmentintoactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.addfragmentintoactivity.data.Comic
import com.example.addfragmentintoactivity.ui.RageComicDetailsFragment
import com.example.addfragmentintoactivity.ui.RageComicListFragment

/*
    Fragment: là 1 Android Component, là 1 phần UI hoặc hành vi người dùng. Fragment không độc lập
    nó được gán với 1 Activity đơn lẻ, nhiều chức năng tương tự Activity.

    Ex: Me(Activity: i need working, learning, ...) use Bot1(Fragment: Work), Bot2(Fragment: Leaning)

    Ưu điểm:
        - Module hoá: Với các Activity phức tạp thì code sẽ được implement ở các Fragment. Mỗi Fragment là 1 module độc
        lập, giúp code dễ tổ chức và quản lý hơn
        - Tái sử dụng: Viết code implement các tương tác với người dùng hoặc các phần UI vào fragment vào fragmnet
        dể có thể chia sẻ chúng với Activity khác
        - Hỗ trợ đa màn hình
*/

/*Note: Làm từ dưới lên, ví dụ có 1 listItem thì hãy tạo Detail, code xml trước sau đó code logic*/

class MainActivity : AppCompatActivity(), RageComicListFragment.OnRageComicSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add Fragment

        /*
        * Để ý nhé,  nếu bạn sử dụng thư viện support v4 thì thay vì gọi Fragment Manager,
        * bạn gọi hàm supportFragmentManager (Hai class này có vai trò tương đương nhau)
        */

        //kiểm tra trạng thái Fragment trước khi add
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction() //tạo 1 transaction(giao dịch)

                /*
                * add():
                *   -   view ID của 1 container của framelayout trong android của activity.
                *       mình đang đặt id trong file activity_main là root_layout các bạn qua xem nhá.
                *   -   Instance fragment được thêm vào. Ở đây là íntance của RageComicListFragment.
                *   -   dùng 1 string làm id cho fragment này
                */
                .add(R.id.root_layout, RageComicListFragment.newInstance(), "rageComicList")
                .commit() //để FragmentManger thêm vào Activity
        }
    }

    //implement OnRageComicSelected
    override fun onRageComicSelected(comic: Comic) {
//        Toast.makeText(this, "you selected" + comic.name + "!", Toast.LENGTH_SHORT).show()

        val detailsFragment = RageComicDetailsFragment.newInstance(comic)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, detailsFragment, "rageComicDetails") //thay thế fragment hiện tại
            .addToBackStack(null) //addToBackStack - đẻ add 1 instance của fragment vào stack
            .commit()
    }
}
