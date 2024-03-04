abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0                    // переменные для отслеживания количества проданных пицц каждого вида
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var totalCheckPhotos = 0
    var totalDiscounts = 0.0
    var totalDrinksSold = 0                      // переменные для статистики по пиццерии
    var totalDrinksRevenue = 0.0
    var totalSaucesSold = 0
    var totalSaucesRevenue = 0.0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()              // абстрактные методы для продажи каждого вида пиццы
    abstract fun tyroleanPizzaSale()

    fun showPercentageStatistics() {             // метод для отображения статистики в процентах   
        val totalPizzasSold =
            neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount

        val percentageCheckPhotos = calculatePercentage(totalCheckPhotos, totalPizzasSold)  // расчет процентов по показанным чекам проданным кофе и соусам
        val percentageDrinksSold = calculatePercentage(totalDrinksSold, totalPizzasSold)
        val percentageSaucesSold = calculatePercentage(totalSaucesSold, totalPizzasSold)

        val percentageNoCheck = 100.0 - percentageCheckPhotos                 // расчет процентов по непоказанным чекам не проданным кофе и соусам
        val percentageNoCoffee = 100.0 - percentageDrinksSold
        val percentageNoSauces = 100.0 - percentageSaucesSold

        println("Процент людей, показывающих фотографию чека: $percentageCheckPhotos%")
        println("Процент людей, покупающих кофе: $percentageDrinksSold%")                 // вывод статистики в процентах
        println("Процент людей, покупающих соусы: $percentageSaucesSold%")
        println("Процент людей, НЕ показывающих фотографию чека: $percentageNoCheck%")
        println("Процент людей, НЕ покупающих кофе: $percentageNoCoffee%")
        println("Процент людей, НЕ покупающих соусы: $percentageNoSauces%")

        if (totalCheckPhotos > 0 || totalDrinksSold > 0 || totalSaucesSold > 0) { //вывод доп информации при наличии в городе

            if (totalDrinksSold > 0) {                                       //для общей статистики
                println("Количество проданных кофе: $totalDrinksSold")
                println("Общая сумма выручки за кофе: $totalDrinksRevenue")
            }

            if (totalSaucesSold > 0) {
                println("Количество проданных соусов: $totalSaucesSold")
                println("Общая сумма выручки за соусы: $totalSaucesRevenue")
            }

            if (totalCheckPhotos > 0) {
                println("Количество показанных чеков: $totalCheckPhotos")
                println("Общая сумма скидок(*в руб*): $totalDiscounts")
            }
        }
    }

    fun showStatistics() {

        val totalRevenue = calculateTotalRevenue()
        println("Общая выручка: $totalRevenue")

        showPercentageStatistics()
        println("Продано сицилийской пиццы: $sicilianPizzaCount")  // статистика по каждому виду пиццы
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")


    }

    private fun calculatePercentage(part: Int, total: Int): Double {
        return if (total != 0) {
            (part.toDouble() / total.toDouble()) * 100.0     //функция для расчета %
        } else {
            0.0
        }
    }

    private fun calculateTotalRevenue(): Double {  //общая статистика
        return neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice +
                totalDrinksRevenue +
                totalSaucesRevenue -
                totalDiscounts
    }
}


