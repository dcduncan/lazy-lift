package main

import io.javalin.Javalin;

fun main(args: Array<String>) {
    val app: Javalin = Javalin.create().start(7000)
    app.get("/") { ctx -> ctx.result("Hello World") }
    app.get("/api/routines") { ctx -> ctx.result(arrayListOf("Legs", "Arms", "Abs").toString())}
}