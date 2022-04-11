package com.example.barberappsecproject.model.remote.response

import com.google.gson.annotations.SerializedName

data class getTimeSlotResponse(
    val message: String,
    val slots: List<Slot>,
    val status: Int
)

data class Slot(
    val date: String,
    val day: String,
    val slots: List<TimeSlot>
)

data class TimeSlot(val time:String, val isAvailable:Boolean)

//data class Slots(
//    val `08:00-08:15`: Boolean,
//    val `08:15-08:30`: Boolean,
//    val `08:30-08:45`: Boolean,
//    val `08:45-09:00`: Boolean,
//    val `09:00-09:15`: Boolean,
//    val `09:15-09:30`: Boolean,
//    val `09:30-09:45`: Boolean,
//    val `09:45-10:00`: Boolean,
//    val `10:00-10:15`: Boolean,
//    val `10:15-10:30`: Boolean,
//    val `10:30-10:45`: Boolean,
//    val `10:45-10:00`: Boolean,
//    val `11:00-11:15`: Boolean,
//    val `11:15-11:30`: Boolean,
//    val `11:30-11:45`: Boolean,
//    val `11:45-12:00`: Boolean,
//    val `12:00-12:15`: Boolean,
//    val `12:15-12:30`: Boolean,
//    val `12:30-12:45`: Boolean,
//    val `12:45-13:00`: Boolean,
//    val `13:00-13:15`: Boolean,
//    val `13:15-13:30`: Boolean,
//    val `13:30-13:45`: Boolean,
//    val `13:45-14:00`: Boolean,
//    val `14:00-14:15`: Boolean,
//    val `14:15-14:30`: Boolean,
//    val `14:30-14:45`: Boolean,
//    val `14:45-15:00`: Boolean,
//    val `15:00-15:15`: Boolean,
//    val `15:15-15:30`: Boolean,
//    val `15:30-15:45`: Boolean,
//    val `15:45-16:00`: Boolean,
//    val `16:00-16:15`: Boolean,
//    val `16:15-16:30`: Boolean,
//    val `16:30-16:45`: Boolean,
//    val `16:45-17:00`: Boolean,
//    val `17:00-17:15`: Boolean,
//    val `17:15-17:30`: Boolean,
//    val `17:30-17:45`: Boolean,
//    val `17:45-18:00`: Boolean,
//    val `18:00-18:15`: Boolean,
//    val `18:15-18:30`: Boolean,
//    val `18:30-18:45`: Boolean,
//    val `18:45-19:00`: Boolean,
//    val `19:00-19:15`: Boolean,
//    val `19:15-19:30`: Boolean,
//    val `19:30-19:45`: Boolean,
//    val `19:45-20:00`: Boolean,
//    val `20:00-20:15`: Boolean,
//    val `20:15-20:30`: Boolean,
//    val `20:30-20:45`: Boolean,
//    val `20:45-21:00`: Boolean,
//    val `21:00-21:15`: Boolean,
//    val `21:15-21:30`: Boolean,
//    val `21:30-21:45`: Boolean,
//    val `21:45-22:00`: Boolean
//)

//how can we change this into Slots(val time:String. val isAvailable:Boolean)