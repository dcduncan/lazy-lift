package main

val EXERCISES = setOf(
    Exercise(
        "Bench Press",
        BodyPart.CHEST,
        setOf(Equipment.BENCH, Equipment.BARBELL),
        setOf(BodyPart.TRICEPS, BodyPart.SHOULDERS)
    ),
    Exercise(
        "Dumbbell Bench Press",
        BodyPart.CHEST,
        setOf(Equipment.BENCH, Equipment.DUMBBELLS),
        setOf(BodyPart.TRICEPS, BodyPart.SHOULDERS)
    ),
    Exercise(
        "Tricep Extension",
        BodyPart.TRICEPS,
        setOf(Equipment.DUMBBELLS)
    ), Exercise(
        "Squats",
        BodyPart.LEGS,
        setOf(Equipment.BAR, Equipment.RACK)
    ), Exercise(
        "Dumbbell Squats",
        BodyPart.LEGS,
        setOf(Equipment.DUMBBELLS)
    ), Exercise(
        "Sit Ups",
        BodyPart.ABS
    )
)