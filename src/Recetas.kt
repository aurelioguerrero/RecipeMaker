import Model.*

fun main(args: Array<String>) {
    var misRecetas = mutableListOf<Receta>()
    var listaVerduras: List<Alimento> = listOf(
        Alimento("Cebolla","Verduras"),
        Alimento("Tomate","Verduras"),
        Alimento("Zanahoria","Verduras"),
        Alimento("Habichuela","Verduras"),
        Alimento("Pimentón","Verduras"),
        Alimento("Repollo","Verduras"),
        Alimento("Papa","Verduras")
        )
    var listaFrutas: List<Alimento> = listOf(
        Alimento("Banano","Frutas"),
        Alimento("Manzana","Frutas"),
        Alimento("Uva","Frutas"),
        Alimento("Pera","Frutas"),
        Alimento("Kiwi","Frutas"),
        Alimento("Fresa","Frutas"),
        Alimento("Naranja","Frutas")
    )
    var listaLacteos: List<Alimento> = listOf(
        Alimento("Yogurt","Lácteos"),
        Alimento("Queso","Lácteos"),
        Alimento("Leche","Lácteos"),
        Alimento("Mantequilla","Lácteos"),
        Alimento("Margarina","Lácteos"),
        Alimento("Leche Condensada","Lácteos"),
        Alimento("Crema de leche","Lácteos")
    )

    var listaCarnes: List<Alimento> = listOf(
        Alimento("Carne","Carnes, legúmbres y huevos"),
        Alimento("Huevo","Carnes, legúmbres y huevos"),
        Alimento("Pollo","Carnes, legúmbres y huevos"),
        Alimento("Pescado","Carnes, legúmbres y huevos"),
        Alimento("Huevo de codornís","Carnes, legúmbres y huevos"),
        Alimento("Carne molida","Carnes, legúmbres y huevos"),
        Alimento("Pechua de pollo","Carnes, legúmbres y huevos")
    )

    var listaGranos: List<Alimento> = listOf(
        Alimento("Maiz","Granos"),
        Alimento("Arroz","Granos"),
        Alimento("Maní","Granos"),
        Alimento("Frijoles","Granos"),
        Alimento("Lentejas","Granos"),
        Alimento("Café","Granos"),
        Alimento("Blanquillos","Granos")
    )

    var listaAceites: List<Alimento> = listOf(
        Alimento("Aceite vegetal","Aceites"),
        Alimento("Aceite de oliva","Aceites")
    )
    val listaGrupos=  listOf("Agua","Leche","Carne","Verduras","Frutas","Cereal","Aceite")
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
                    print("Ingrese el nombre de la receta: ")
                    var nombreReceta: String = readLine().toString()
                    //var receta: String = ""
                    var receta: Receta = Receta(nombreReceta)
                    var respuestaIngrediente: Int? = 0
                    while (respuestaIngrediente != 8) {
                        try {
                            makeRecipe(receta.getNombre())
                            respuestaIngrediente = readLine().toString().toInt() ?: 0
                            if (respuestaIngrediente in 1..8) {
                                when(respuestaIngrediente){
                                    1 -> {
                                        var ingrediente: Ingrediente = Ingrediente(Alimento("Agua","Agua"),seleccionarUnidad())
                                        ingrediente.Cantidad = ingresarCantidad()
                                        receta.addIngrediente(ingrediente)
                                    }
                                    2 -> {
                                        receta.addIngredientes(makeListaIngredientes(listaLacteos))
                                    }
                                    3 -> {
                                        receta.addIngredientes(makeListaIngredientes(listaCarnes))
                                    }
                                    4 -> {
                                        receta.addIngredientes(makeListaIngredientes(listaVerduras))
                                    }
                                    5 -> {
                                        receta.addIngredientes(makeListaIngredientes(listaFrutas))
                                    }
                                    6 -> {
                                        receta.addIngredientes(makeListaIngredientes(listaGranos))
                                    }
                                    7 -> {
                                        receta.addIngredientes(makeListaIngredientes(listaAceites))
                                    }
                                    8 -> {
                                        misRecetas.add(receta)
                                        println("La receta ha sido guardada :)")
                                    }
                                }
                                /*if (respuestaIngrediente == 9) {
                                    receta = "$nombreReceta: ${receta.substring(0, receta.length - 2)}."
                                    misRecetas.add(receta)
                                    println("La receta ha sido guardada :)")
                                } else {
                                    receta += listaGrupos[respuestaIngrediente - 1]
                                }
                                receta += ", "*/
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
    val menuIngredientes = """Seleccione un grupo alimenticio para $nombreReceta: 

        1. Agua
        2. Leche
        3. Carne
        4. Verduras
        5. Frutas
        6. Cereal
        7. Aceite
        8. --Para salir y guardar--""".trimIndent()
    println(menuIngredientes)
}

fun viewRecipe(recetas: MutableList<Receta>): Unit{
    println(":: Mis recetas ::")
    for (receta in recetas) {
        println("::${receta.getNombre()}::\nIngredientes:\n${receta.getIngredientes()}")
    }
    println()
}

fun makeListaIngredientes(lista: List<Alimento>): MutableList<Ingrediente>{
    var cadena: String = ""
    var index: Int = 1
    var ingredientes: MutableList<Ingrediente> = mutableListOf<Ingrediente>()
    var opcionAlimento: Int? = 0

    while (opcionAlimento != lista.size+1) {
        index = 1
        cadena = ""
        try{
            for (alimento in lista) {
                cadena += "$index. ${alimento.nombre}\n"
                index++
            }
            cadena += "$index. --Para salir--"
            println("Seleccione un ingrediente:\n$cadena")
            opcionAlimento = readLine().toString().toInt() ?: 0

            if (opcionAlimento in 1..index) {
                if(opcionAlimento != index) {
                    var unidad: String = seleccionarUnidad()
                    val ingrediente: Ingrediente = Ingrediente(lista[opcionAlimento - 1], unidad)
                    ingrediente.Cantidad = ingresarCantidad()
                    ingredientes.add(ingrediente)
                }
            }
            else
            {
                println("¡El valor ingresado no es válido!")
            }
        }catch (e:NumberFormatException){
            println("¡Por favor ingrese un valor numérico válido!")
        }
    }
    return ingredientes
}

fun seleccionarUnidad(): String{
    var opcionUnidad: Int = 0
    var cadena: String = ""
    var index: Int = 1
    val listaUnidades: List<String> = listOf("Cucharadas","Onzas","Tazas","Gramos","Litros")

    while (!(opcionUnidad in 1..5)) {
        try {
            cadena = ""
            index = 1
            for (unidad in listaUnidades) {
                cadena += "$index. $unidad\n"
                index++
            }
            println("Seleccione una unidad de medida:\n$cadena")
            opcionUnidad = readLine().toString().toInt() ?: 0
        }catch (e:NumberFormatException){
            println("¡Por favor ingrese un valor numérico válido!")
        }
    }
    return listaUnidades[opcionUnidad.minus(1)]
}

fun ingresarCantidad(): Int{
    print("Ingrese la cantidad: ")
    var cantidad = 0
    var malIngreso: Boolean = true
    while (malIngreso){
        try{
            cantidad = readLine().toString().toInt() ?: 0
            malIngreso = false
        }catch (e:NumberFormatException){
            println("¡Por favor ingrese un valor numérico válido!")
            malIngreso = true
        }
    }
    return cantidad
}