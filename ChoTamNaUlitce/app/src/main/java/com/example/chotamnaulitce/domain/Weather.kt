package com.example.chotamnaulitce.domain

data class Weather(
    val city: City = getDefaultCity(),
    val temperatureActual: Int = 0,
    val temperatureFeels: Int = 0
)

data class City(
    val name: String,
    val latitude: Double,
    val longtitude: Double
)

fun getRusCities(): List<Weather>{
    return listOf(
        Weather(City("Москва", 55.45, 37.36), 1, 2),
        Weather(City("Санкт-Петербург", 59.93, 30.34), 3, 4),
        Weather(City("Новосибирск", 55.01, 82.94), 5, 6),
        Weather(City("Екатеринбург", 56.84, 60.61), 7, 8),
        Weather(City("Нижний Новгород", 56.3, 43.94), 9, 10),
        Weather(City("Казань", 55.83, 49.07), 11, 12),
        Weather(City("Челябинск", 55.16, 61.44), 13, 14),
        Weather(City("Омск", 54.99, 73.32), 15, 16),
        Weather(City("Ростов-на-Дону", 47.24, 39.7), 17, 18),
        Weather(City("Уфа", 54.74, 55.97), 19, 20),
        Weather(City("Подлипки", 55.93, 37.82), 21, 22)
    )
}

fun getWorldCities(): List<Weather>{
    return listOf(
        Weather(City("Лондон", 51.51, -0.13), 1, 2),
        Weather(City("Токио", 35.7, 139.69), 3, 4),
        Weather(City("Париж", 48.85, 2.35), 5, 6),
        Weather(City("Берлин", 52.52, 13.4), 7, 8),
        Weather(City("Рим", 41.9, 12.5), 9, 10),
        Weather(City("Минск", 53.9, 27.56), 11, 12),
        Weather(City("Стамбул", 41.01, 28.98), 13, 14),
        Weather(City("Вашингтон", 38.91, -77.04), 15, 16),
        Weather(City("Киев", 50.45, 30.52), 17, 18),
        Weather(City("Пекин", 39.9, 116.41), 19, 20),
        Weather(City("Бангладеш", 23.77, 90.38), 21, 22)
    )
}

fun getDefaultCity() = City("Москва", 55.45, 37.36)