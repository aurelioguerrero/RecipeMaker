fun main(args: Array<String>) {
    val misRecetas = mutableListOf<String?>()
    val listaIngredientes=  listOf("Agua","Leche","Carne","Verduras","Frutas","Cereal","Huevos","Aceite")
    val menuPrincipal = """:: Bienvenido a Recipe Maker ::
        
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        
    """.trimIndent()
    terminar@ while(true){
        try{
            println(menuPrincipal)
            var respuesta:Int? = readLine().toString().toInt() ?: 0
            when(respuesta) {
                3 -> {
                    println("Gracias por usar el Recipe Maker :)")
                    break@terminar
                }
                1 -> {
                    println("Ingrese el nombre de la receta: ")
                    var nombreReceta: String? = readLine().toString() ?: "Receta sin nombre"
                    var receta: String = ""
                    var respuestaIngrediente: Int? = 0
                    while (respuestaIngrediente != 9) {
                        try {
                            makeRecipe(nombreReceta)
                            respuestaIngrediente = readLine().toString().toInt() ?: 0
                            if (respuestaIngrediente in 1..9) {
                                if (respuestaIngrediente == 9) {
                                    receta = "$nombreReceta: ${receta.substring(0, receta.length - 2)}."
                                    misRecetas.add(receta)
                                    println("La receta ha sido guardada :)")
                                } else {
                                    receta += listaIngredientes[respuestaIngrediente - 1]
                                }
                                receta += ", "
                            } else {
                                println("La opción $respuestaIngrediente no es válida")
                            }
                        }catch (e:NumberFormatException){
                            println("¡Por favor ingrese un valor numérico válido!")
                        }
                    }
                    continue@terminar
                }
                2 -> {
                    viewRecipe(misRecetas)
                }
                else -> {
                    println("¡El valor ingresado no es válido!")
                    continue@terminar
                }
            }
        }catch (e:NumberFormatException){
            println("¡Por favor ingrese un valor numérico válido!")
        }
    }
}

fun makeRecipe(nombreReceta: String?): Unit{
    val menuIngredientes = """Seleccione los ingredientes de $nombreReceta: 

        1. Agua
        2. Leche
        3. Carne
        4. Verduras
        5. Frutas
        6. Cereal
        7. Huevos
        8. Aceite
        9. --Para salir y guardar--""".trimIndent()
    println(menuIngredientes)
}

fun viewRecipe(recetas: MutableList<String?>): Unit{
    println(":: Mis recetas ::")
    for (i in 0..recetas.size - 1) {
        println("${i + 1}. ${recetas[i]}")
    }
    println()
}