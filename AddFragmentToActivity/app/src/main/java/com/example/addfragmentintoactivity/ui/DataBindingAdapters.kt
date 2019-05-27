package com.example.addfragmentintoactivity.ui

import android.databinding.BindingAdapter
import android.widget.ImageView


object DataBindingAdapters {

    // gọi tới src ImageView trong layout xml

    /*
    * Một Binding Adapter cho phép chúng ta thực hiện các tác vụ mở rộng mà data binding mặc định không có
    * trong trường hợp này chúng ta muốn lưu resource(là đường dẫn của một resource nhưng được
    * compiler mã hóa thành một số hexa kiểu như ID) cho ImageView.
    * nhưng databinding trong android mặc định không support để hiển thị một image từ 1 ID.
    * để khắc phục điều này cần phải tjao 1 BindingAdapter lấy 1 tham chiếu đến đối tượng mà nó được gọi
    * từ cùng 1 tham số
    * */

    @BindingAdapter("android:src")
    fun setImageResoruce(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}