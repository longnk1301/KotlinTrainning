package com.example.addfragmentintoactivity.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.addfragmentintoactivity.R

class RageComicDetailsFragment : Fragment() {

    //Cung cấp hàm khởi tạo instance cho fragment. Ở đây chính là một dạng factory method
    /*
        Tại sao lại sử dụng factory method thay vì hàm contructor để tạo fragment?
        Trong hướng dẫn này, mình sử dụng factory method để khởi tạo fragment thay
        vì sử dụng constructor. Nhiều bạn sẽ thắc mắc tại sao lại vậy đúng không?

        Thứ nhất: Do bạn không định nghĩa bất kỳ constructor nào, trình biên dịch tự động
            tạo ra một constructor mặc định, không có đối số đủ để tạo được i
            Đây là tất cả những gì bạn cần có cho một fragment.

        Thứ hai: Khi ứng dụng chuyển sang chạy nền(background) thì Android sẽ destroy Activities
            cùng tất cả các fragment liên quan. Khi Activity được visibile trở lại,
            FragmentManager sẽ tạo lại các fragment bằng cách sử dụng constructor rỗng mặc định.
            Nếu nó không tìm thấy thì sẽ bị exception.
            Do đó, cách code thông minh nhất không nên tạo class với constructor có tham số.
            Nếu có tạo constructor có tham số thì bắt buộc bạn phải viết thêm hàm constructor không tham số.
            Cách đơn giản nhất là dùng factory method như mình làm ở trên.*/
    companion object {
        fun newInstance(): RageComicDetailsFragment {
            return RageComicDetailsFragment()
        }
    }

    //Cuối cùng là override lại hàm onCreateView để có thể nhồi file layout xml vào fragment class
    //Activity  sử dụng setContentView() để nhồi xml layout thì fragments thực hiện trong hàm onCreateView()
    //Tham số thứ 3 của inflate xác định liệu có thêm fragment vào container hay không? (false là không thêm)
    //Container  là view cha và nó sẽ chứa các view của fragment.
    //Bạn nên đặt giá trị là false vì nên để việc thêm fragment vào containner cho FragmentManager đảm nhiệm
    //Mỗi Activity sẽ có một FragmentManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_rage_comic_details, container, false)
    }
}