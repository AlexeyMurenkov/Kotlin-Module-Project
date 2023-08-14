object ArchivesCollection : Menu<Item.Archive>(
    "архива",
    { name -> Item.Archive(name) },
    { archive -> NotesCollection.go(archive) }
) {
    val archives = mutableListOf<Item.Archive>()

    fun go() = super.go("Список архивов:", archives)
}
