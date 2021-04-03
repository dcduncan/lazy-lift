package main

import io.javalin.Javalin;

fun main(args: Array<String>) {
    val app = Javalin.create { config ->
        config
            .addStaticFiles("/static/build")
            .addSinglePageRoot("/", "/static/build/index.html")
    }.start(8080)

    app.get("/api/routines") { ctx -> ctx.result(arrayListOf("Legs", "Arms", "Abs").toString())}
}