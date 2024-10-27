package pl.webwizards.akai

object Util {

   /* fun convertToGrams(mass: String?, unit: String): Double {
        return when (unit) {
            "g" -> mass?.removeSuffix("g")?.toDoubleOrNull() ?: 0.0
            "ct" -> (mass?.removeSuffix("ct")?.toDoubleOrNull() ?: 0.0) * 0.2
            else -> 0.0
        }
    }*/

    fun convertToOunces(mass: String): Double {
        return when {
            mass.endsWith("g") -> {
                val grams = mass.removeSuffix("g").replace(',', '.').toDoubleOrNull() ?: 0.0
                grams / 28.3495
            }
            mass.endsWith("ct") -> {
                val carats = mass.removeSuffix("ct").replace(',', '.').toDoubleOrNull() ?: 0.0
                (carats * 0.2) / 28.3495
            }
            else -> 0.0
        }
    }

}