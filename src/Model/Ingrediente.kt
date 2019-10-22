package Model

class Ingrediente(private var alimento: Alimento, private var UM: String){
    var Cantidad = 0
        get() = field
        set(value){
            field = value
        }

    fun getAlimento(): Alimento{
        return this.alimento
    }

    fun setAlimento(alimento: Alimento){
        this.alimento = alimento
    }

    fun getUM(): String{
        return this.UM
    }

    fun setUM(um: String){
        this.UM = um
    }
}