package main

import com.google.gson.GsonBuilder
import io.javalin.Javalin;
import io.javalin.plugin.json.FromJsonMapper
import io.javalin.plugin.json.JavalinJson
import io.javalin.plugin.json.ToJsonMapper

fun main(args: Array<String>) {
    val gson = GsonBuilder().create()
    JavalinJson.fromJsonMapper = object : FromJsonMapper {
        override fun <T> map(json: String, targetClass: Class<T>) = gson.fromJson(json, targetClass)
    }

    JavalinJson.toJsonMapper = object : ToJsonMapper {
        override fun map(obj: Any): String = gson.toJson(obj)
    }
    val port = System.getenv("PORT") ?: "7070"
    val app = Javalin.create { config ->
        config
            .addStaticFiles("/static/build")
            .addSinglePageRoot("/", "/static/build/index.html")
    }.start(port.toInt())

    app.get("/api/routines") { ctx -> ctx.result(arrayListOf("Legs", "Arms", "Abs").toString()) }
    app.get("/api/create_routine") { ctx ->
        val bodyParts =
            ctx.req.getParameterValues("body_parts[]")
                .map { BodyPart.valueOf(it.toUpperCase()) }
                .toSet()
        val exercises = EXERCISES.filter {
            bodyParts.contains(it.primaryBodyPart) || bodyParts.intersect(it.secondaryBodyParts).isNotEmpty()
        }.map { it.name }
        ctx.json(exercises)
    }
}