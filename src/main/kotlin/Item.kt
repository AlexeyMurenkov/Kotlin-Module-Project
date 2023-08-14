sealed class Item (open val name: String){
    data class Note (override val name: String, val text: String) : Item(name)
    data class Archive (override val name: String) : Item(name) {
        val notes = mutableListOf<Note>()
    }
}
