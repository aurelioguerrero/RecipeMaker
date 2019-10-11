fun main(args: Array<String>) {
    val misRecetas = mutableListOf<String>()
    val menuPrincipal = """:: Bienvenido a Recipe Maker
        
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        
    """.trimIndent()

    try{
        terminar@ while(true){
            println(menuPrincipal)
            var respuesta:Int? = readLine().toString().toInt() ?: 0
            println("Usted seleccionó: $respuesta")
            when(respuesta){
                3 -> {println("Gracias por usar el Recipe Maker :)")
                    break@terminar}
                1 -> {
                    println("Ingrese el nombre de la receta: ")
                    var receta:String? = readLine().toString() ?: "Receta"+misRecetas.lastIndex.toString()
                    println("Nombre de la receta: $receta")
                    continue@terminar
                }
                2 -> {}
            }
        }
    }catch (e:NumberFormatException){
        println("¡Por favor ingrese un valor numérico válido!")
    }
}