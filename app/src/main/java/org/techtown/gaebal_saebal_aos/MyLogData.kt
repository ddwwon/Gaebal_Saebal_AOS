package org.techtown.gaebal_saebal_aos

// title: 폴더 명, content: 폴더 내 글의 제목
//data class MyLogData(
//    val title: String,
//    val content1: String,
//    val content2: String,
//    val content3: String,
//    val content4: String,
//    val content5: String
//)

data class MyLogData(val type: Int, val category: String, val content1: String?, val content2: String?, val content3: String?, val content4: String?, val content5: String?) {
    companion object {
        const val MY_LOG_ITEM1 = 1
        const val MY_LOG_ITEM2 = 2
        const val MY_LOG_ITEM3 = 3
        const val MY_LOG_ITEM4 = 4
        const val MY_LOG_ITEM5 = 5
    }
}
