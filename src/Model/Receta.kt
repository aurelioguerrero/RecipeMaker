package Model

class Receta(private var nombre: String){
    private var ingredientes: MutableList<Ingrediente> = mutableListOf<Ingrediente>()
    private var instrucciones: String = "Combinar los ingredientes y cocinar"
        get() {
            return field
        }
        set(value) {
            field = value
        }

    fun getNombre(): String{
        return this.nombre
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun addIngrediente(ingrediente: Ingrediente){
        this.ingredientes.add(ingrediente)
    }

    fun addIngredientes(ingredientes: List<Ingrediente>){
        this.ingredientes.addAll(ingredientes)
    }

    fun getIngredientes(): String{
        var lista: String = ""

        for(ingrediente in this.ingredientes){

            lista += "- ${ingrediente.Cantidad} ${ingrediente.getUM()} de ${ingrediente.getAlimento().nombre} (${ingrediente.getAlimento().grupoAlimenticio})\n"
        }

        return lista
    }
}