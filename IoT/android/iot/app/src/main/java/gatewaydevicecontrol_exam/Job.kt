package gatewaydevicecontrol_exam

class Job {
    var date:String = ""
    var id:String = ""
    var ledstate:String = ""

    constructor(date: String, id: String, ledstate: String) {
        this.date = date
        this.id = id
        this.ledstate = ledstate
    }


    override fun toString(): String {
        return "Job(date=$date, id='$id', ledstate='$ledstate')"
    }
}