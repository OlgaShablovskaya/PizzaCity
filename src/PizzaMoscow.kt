class PizzaMoscow (
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto {
    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n 2. Нет")
        val choice = readln()
        if (choice == "1") {
            val discount = 50.0
            println("Вам будет скидка $discount рублей с покупки")
            totalDiscounts += discount //Общая сумма скидок(*в руб*)
            totalCheckPhotos++ // количество показанных чеков
        }
    }
    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку  римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку тирольской пиццы в Москве")
    }
}
