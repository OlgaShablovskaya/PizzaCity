class PizzaKrasnodar(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Sauce, Drink, CheckPhoto {

    private var checkPhotoCalled = false // проверка вызова метода

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку неаполитанской пиццы в Краснодаре")
        performAdditionalActions()
    }

    override fun romanPizzaSale() {
        romanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку римской пиццы в Краснодаре")
        performAdditionalActions()
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку сицилийской пиццы в Краснодаре")
        performAdditionalActions()
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++ // подсчет для пицц
        println("Спасибо за покупку тирольской пиццы в Краснодаре")
        performAdditionalActions()
    }

    private fun performAdditionalActions() { //вызов методов
        drinkSale()
        choiceOfSauce()
        checkAndShowPhoto()
    }

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1.Да\n 2.Нет")
        val choice = readln()
        if (choice == "1") {
            println("С вас 200 рублей за кофе")
            totalDrinksSold++    //количество проданных кофе
            totalDrinksRevenue += 200.0 // общая сумма выручки за кофе
        }
    }

    override fun showCheckPhoto() {
        if (!checkPhotoCalled) {
            println("У вас есть фотография чека?")
            println("1. Да\n 2. Нет")
            val choice = readln()
            if (choice == "1") {
                val discount = 50.0
                println("Вам будет скидка $discount рублей с покупки")
                totalDiscounts += discount //Общая сумма скидок(*в руб*)
                totalCheckPhotos++ // количество показанных чеков
                checkPhotoCalled = true // проверка вызова метода
            }
        } else {
            checkPhotoCalled = false // сбрасываем флаг чтобы можно было спросить еще раз
        }
    }

    override fun choiceOfSauce() {
        println("Вы будете соус?")
        println("1. Да мексиканский\n2. Да сырный\n 3. Нет")
        val choice = readln()
        if (choice == "1" || choice == "2") {
            println("С вас 30 рублей за соус")
            totalSaucesSold++ // количество проданных соусов
            totalSaucesRevenue += 30.0 //общая сумма выручки за соусы
        }
    }

    private fun checkAndShowPhoto() { // проверка вызова метода
        showCheckPhoto()
    }
}

