import java.util.Scanner

object NotesCollection : Menu<Item.Note> (
    "заметки",
    { name -> createNote(name)},
    { note -> showNote(note)}
) {
    fun go(archive: Item) {
        if (archive is Item.Archive) {
            super.go("Список заметок архива '${archive.name}':", archive.notes)
        }
    }

}
fun createNote(name: String) : Item.Note {
    println("Введите текст заметки '$name':")
    val scanner = Scanner(System.`in`)
    val text = scanner.nextLine()
    return Item.Note(name, text)
}

fun showNote(note: Item) {
    if (note is Item.Note) {
        println("Просмотр заметки:")
        println("Наименование заметки: ${note.name}")
        println("Текст заметки: ${note.text}")
    }
}
