package commands.tools

import commands.Var

class SetMapForArguments {
    fun set() : Map<String, String>{
        return mapOf<String, String>(
            Var.name to Var.str,
            Var.age to Var.integer,
            Var.agl to Var.double,
            Var.area to Var.integer,
            Var.birthday to Var.str,
            Var.coordinateX to Var.long,
            Var.coordinateY to Var.float,
            Var.climate to "HUMIDCONTINENTAL MEDITERRANIAN STEPPE",
            Var.government to "OLIGARCHY JUNTA ETHNOCRACY",
            Var.id to Var.long,
            Var.population to Var.long,
            Var.meters to Var.long
        )
    }
}