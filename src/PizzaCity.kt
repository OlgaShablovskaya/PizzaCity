abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var totalCheckPhotos = 0
    var totalDiscounts = 0.0
    var totalDrinksSold = 0
    var totalDrinksRevenue = 0.0
    var totalSaucesSold = 0
    var totalSaucesRevenue = 0.0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun showPercentageStatistics() {
        val totalPizzasSold =
            neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount

        val percentageCheckPhotos = calculatePercentage(totalCheckPhotos, totalPizzasSold)
        val percentageDrinksSold = calculatePercentage(totalDrinksSold, totalPizzasSold)

        val percentageNoCheck = 100.0 - percentageCheckPhotos
        val percentageNoCoffee = 100.0 - percentageDrinksSold

        println("Процент людей, показывающих фотографию чека: $percentageCheckPhotos%")
        println("Процент людей, покупающих кофе: $percentageDrinksSold%")
        println("Процент людей, НЕ показывающих фотографию чека: $percentageNoCheck%")
        println("Процент людей, НЕ покупающих кофе: $percentageNoCoffee%")

        if (totalCheckPhotos > 0) {

            if (totalDrinksSold > 0) {  // статистика по пиццам и кофе
                println("Процент людей, покупающих кофе с неаполитанской пиццей: ${
                    calculatePercentage(totalDrinksSold, neapolitanPizzaCount)
                }%")
                println("Процент людей, покупающих кофе с римской пиццей: ${
                    calculatePercentage(totalDrinksSold, romanPizzaCount)
                }%")
                println("Процент людей, покупающих кофе с сицилийской пиццей: ${
                    calculatePercentage(totalDrinksSold, sicilianPizzaCount)
                }%")
                println("Процент людей, покупающих кофе с тирольской пиццей: ${
                    calculatePercentage(totalDrinksSold, tyroleanPizzaCount)
                }%")
            }

            if (totalDiscounts > 0) {
                println("Количество показанных чеков: $totalCheckPhotos")
                println("Общая сумма скидок(*в руб*): $totalDiscounts")
            }

            if (totalDrinksSold > 0) {
                println("Количество проданных кофе: $totalDrinksSold")
                println("Общая сумма выручки за кофе: $totalDrinksRevenue")
            }

            if (totalSaucesSold > 0) {
                println("Количество проданных соусов: $totalSaucesSold")
                println("Общая сумма выручки за соусы: $totalSaucesRevenue")
            }
        }
    }

    fun showStatistics() {
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")
        val money =
            neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                    sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice // заработано денег
        println("Всего заработано денег: $money")

        showPercentageStatistics()
    }

    private fun calculatePercentage(part: Int, total: Int): Double {
        return if (total != 0) {
            (part.toDouble() / total.toDouble()) * 100.0
        } else {
            0.0
        }
    }
}
