
import com.google.gson.Gson
import pl.webwizards.akai.Util.convertToOunces
import pl.webwizards.akai.models.Category
import pl.webwizards.akai.models.Material
import java.io.File


fun main(args: Array<String>) {
    val gson = Gson()
    val categoriesJson = File("./src/main/resources/kategorie.json")
    val materialsJson = File("./src/main/resources/zbiór_wejściowy.json")
    val categories = gson.fromJson(categoriesJson.readText(), Array<Category>::class.java).asList()
    val materials = gson.fromJson(materialsJson.readText(), Array<Material>::class.java).asList()
    val categoryMap = categories.associateBy { it.typ }

    val materialsWithValuePerUnit = materials.mapNotNull { material ->
        val category = categoryMap[material.typ]
        if (category != null) {
            val purityCategory = categories.find { it.typ == material.typ && it.czystosc == material.czystosc }
            if (purityCategory != null) {
                val massInOunces = convertToOunces(material.masa)
                if (massInOunces > 0) {
                    val valuePerUnit = purityCategory.wartoscZaUncje * massInOunces
                    Pair(material, valuePerUnit)
                } else {
                    null
                }
            } else {
                null
            }
        } else {
            null
        }
    }
    val top = materialsWithValuePerUnit
        .sortedByDescending { it.second }
        .take(5)

    if (top.isNotEmpty()) {
        top.forEach { (material, valuePerUnit) ->
            val formattedValue = String.format("$%,.2f", valuePerUnit)
            println("${material.typ} wartosc: $formattedValue; o czystości: ${material.czystosc}; właściciel: ${material.wlasciciel}")
        }
    }
}