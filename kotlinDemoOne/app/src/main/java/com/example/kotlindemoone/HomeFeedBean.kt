package com.example.kotlindemoone

class HomeFeed {
    val videos: List<Videos> = ArrayList<Videos>()
}

class Videos {

    val id: Int = 0
    val name: String = ""
    val link: String = ""
    val imageUrl: String = ""
    val numberOfViews: Int = 0
    val channel: Channel = Channel()

}

class Channel {
    val name = ""
    val profileImageUrl = ""
    val numberOfSubscribers = 0
}

class CourseLesson {
    val name = ""
    val duration = ""
    val number = -1
    val imageUrl = ""
}