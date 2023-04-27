package commands.tools

import commands.Var

class ArgumentsSetting {
    fun getSettings(): HashMap<String, String> {
        return mapOf(
            Numbers.one to MapWrapper(
                name = Var.name,
                fieldType = FieldType.String,
                min = 1,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.two to MapWrapper(
                name = Var.id,
                fieldType = FieldType.Float,
                min = 0,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.three to MapWrapper(
                name = Var.age,
                fieldType = FieldType.Int,
                min = 0,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.four to MapWrapper(
                name = Var.agl,
                fieldType = FieldType.Double,
                min = 0,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.five to MapWrapper(
                name = Var.area,
                fieldType = FieldType.Int,
                min = 0,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.six to MapWrapper(
                name = Var.climate,
                fieldType = FieldType.String,
                min = 1,
                max = null,
                chooseable = true,
                choose = "HUMIDCONTINENTAL MEDITERRANIAN STEPPE"
            ).toString(),
            Numbers.seven to MapWrapper(
                name = Var.government,
                fieldType = FieldType.String,
                min = 1,
                max = null,
                chooseable = true,
                choose = "OLIGARCHY JUNTA ETHNOCRACY"
            ).toString(),
            Numbers.eight to MapWrapper(
                name = Var.birthday,
                fieldType = FieldType.ZonedDateTime,
                min = 1,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.nine to MapWrapper(
                name = Var.coordinateX,
                fieldType = FieldType.Long,
                min = 0,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.ten to MapWrapper(
                name = Var.coordinateY,
                fieldType = FieldType.Float,
                min = 0,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.eleven to MapWrapper(
                name = Var.population,
                fieldType = FieldType.Long,
                min = 0,
                max = null,
                chooseable = false,
                choose = null
            ).toString(),
            Numbers.twelve to MapWrapper(
                name = Var.meters,
                fieldType = FieldType.Long,
                min = null,
                max = null,
                chooseable = false,
                choose = null
            ).toString()
        ) as HashMap<String, String>
    }
}