package com.example.bai1

import android.text.Selection

data class ItemInfo(
    var icon: Int,
    var name: String,
    var selection: Boolean
)
var MyList = mutableListOf<ItemInfo>(
    ItemInfo(R.drawable.img_1, "Vu kIm ThiEn 1", true),
    ItemInfo(R.drawable.img_2, "vU kiM tHien 2", false),
    ItemInfo(R.drawable.img_3, "VU KIm ThIen 3", false),
)
