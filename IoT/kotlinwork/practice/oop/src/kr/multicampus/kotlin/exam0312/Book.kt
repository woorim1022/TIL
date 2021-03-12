package kr.multicampus.kotlin.exam0312

class Book(title:String,var year:String):Content(title){
    override fun totalPrice() {
        if(year in "1975".."1990"){
            price = 5000
        }
        else if(year in "1991".."2000"){
            price = 3500
        }
        else if(year in "2001".."2020"){
            price = 1000
        }
        else{
            price = 500
        }
    }

}
