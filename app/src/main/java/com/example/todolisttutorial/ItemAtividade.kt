package com.example.todolisttutorial

import java.time.LocalTime
import java.util.*

class ItemAtividade(
    var name: String,
    var desc: String,
    var resp: String,
    var dueTime: LocalTime?,
    var id: UUID = UUID.randomUUID()
)