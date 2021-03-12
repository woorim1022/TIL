package kr.multicampus.kotlin.exam0312


class Video(title:String,var genre:String):Content(title){
    override fun totalPrice() {
        if(genre.equals("new")){
            price = 2000
        }
        else if(genre.equals("comic")){
            price = 1500
        }
        else if(genre.equals("child")){
            price = 1000
        }
        else{
            price = 500
        }
    }
}
