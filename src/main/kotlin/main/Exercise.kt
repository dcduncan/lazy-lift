package main

data class Exercise(
    val name: String,
    val primaryBodyPart: BodyPart,
    val equipment: Set<Equipment> = setOf(),
    val secondaryBodyParts: Set<BodyPart> = setOf()
)
