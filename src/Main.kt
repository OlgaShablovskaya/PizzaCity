import kotlin.system.exitProcess
fun main() {
    val pizzaPeter = PizzaPeter(
        175.0,
        241.5,
        167.5,
        215.0
    )
    val pizzaMoscow = PizzaMoscow(
        215.0,
        250.5,
        180.5,
        215.0
    )
    val  pizzaKrasnodar = PizzaKrasnodar(
        150.0,
        240.5,
        160.5,
        215.0
    )
    var currentPizzaCity: PizzaCity
    while (true) {
        println("Добрый день! Выберите город")
        println("1. Москва\n 2. Санкт-Петербург\n 3.Краснодар\n 0. Выход из программы")
        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaKrasnodar // добавляю Краснодар
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }
        println("выберите пиццу:")
        println("1. Неаполитанская пицца\n 2.Римская пицца\n 3.Сициллийская пицца\n 4.Тирольская пицца\n\n 0. Показать статистику")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity) {
    when (currentPizzaCity) {
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> currentPizzaCity.drinkSale()
        is Sauce -> currentPizzaCity.choiceOfSauce()
    }
}
