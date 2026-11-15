package com.example.bai1

class LienHe_ItemInfo(
    var icon: Int,
    var name: String,
    var sdt: String,
    var email: String,
    var diachi: String
)

var LienHeList = mutableListOf<LienHe_ItemInfo>(
    LienHe_ItemInfo(R.drawable.img_1, "Nguyen Van A", "0987654321", "a@gmail.com", "Ha Noi"),
    LienHe_ItemInfo(R.drawable.img_2, "Nguyen Van B", "0987654321", "b@gmail.com", "Ha Noi"),
    LienHe_ItemInfo(R.drawable.img_3, "Nguyen Van C", "0987654321", "c@gmail.com", "Ha Noi"),
    )

