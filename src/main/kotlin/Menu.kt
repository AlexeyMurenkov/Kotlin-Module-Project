import java.util.Scanner

open class Menu<T: Item> (
    val name: String,
    val create: (name: String) -> T,
    val select: (item: Item) -> Unit
) {
    private val scanner = Scanner(System.`in`)

    private fun createdItem() : T {
        println("Создание $name")
        while (true) {
            println("Введите наименование $name:")
            val nameItem = scanner.nextLine()
            if (!nameItem.isBlank()) {
                return create(nameItem)
            }
        }
    }

    fun go(title: String, items: MutableList<T>) {
        while (true) {
            println(title)
            println("0 - Создать")
            for (i in items.indices) {
                println("${i + 1} - ${items[i].name}")
            }
            println("${items.size + 1} - Выход")
            if (!scanner.hasNextInt()) {
                scanner.next()
                println("Неверный выбор. Нужно ввести число - номер пункта меню.")
                continue
            }
            val command = scanner.nextInt()
            scanner.nextLine()
            when (command) {
                0 -> items.add(createdItem())
                in 1..items.size -> select(items[command - 1])
                items.size + 1 -> break
                else -> println("Такого пункта меню еще нет.")
            }
        }
    }
}