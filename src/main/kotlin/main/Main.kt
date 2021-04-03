package main

import io.javalin.Javalin;

fun main(args: Array<String>) {
    val port = System.getenv("PORT") ?: "8080"
    val app = Javalin.create { config ->
        config
            .addStaticFiles("/static/build")
            .addSinglePageRoot("/", "/static/build/index.html")
    }.start(port.toInt())

    app.get("/api/routines") { ctx -> ctx.result(arrayListOf("Legs", "Arms", "Abs").toString())}
}