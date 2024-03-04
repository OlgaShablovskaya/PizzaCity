class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {
    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1.Да\n 2.Нет")
        val choice = readln()
        if (choice == "1") {
            println("С вас 200 рублей за кофе")
            totalDrinksSold++  //количество проданных кофе
            totalDrinksRevenue += 200.0 // общая сумма выручки за кофе
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку  римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку тирольской пиццы в Санкт- Петербурге")
    }
}


