package com.ariefzuhri.makanbuah.data.dummy

import com.ariefzuhri.makanbuah.data.model.Fruit

object FruitDummyData {

    private val idList = arrayOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
    )

    private val nameList = arrayOf(
        "Apples",
        "Avocado",
        "Bananas",
        "Dragon Fruit",
        "Guava",
        "Mango",
        "Papaya",
        "Pineapple",
        "Strawberries",
        "Watermelon",
    )

    private val photoIdList = arrayOf(
        "img_apples",
        "img_avocado",
        "img_bananas",
        "img_dragonfruit",
        "img_guava",
        "img_mango",
        "img_papaya",
        "img_pineapple",
        "img_strawberries",
        "img_watermelon",
    )

    private val advantagesList = arrayOf(
        "Cholesterol-free;Fat-free;Good source of fiber;Sodium-free",
        "Cholesterol-free;Gluten-free;Low-sodium;High-fiber",
        "Cholesterol-free;Fat-free;Sodium-free;Good source of fiber",
        "Cholesterol-free;Fat-free;Good source of fiber",
        "Cholesterol-free;Sodium-free;High-fiber;Low-fat",
        "Good source of fiber;Low-fat;Sodium-free;Cholesterol-free",
        "Cholesterol-free;Low-sodium;Good source of fiber;Fat-free",
        "Cholesterol-free;Fat-free;Sodium-free",
        "Cholesterol-free;Low-fat;Sodium-free;Gluten-free;Low in saturated fat;Good source of fiber",
        "Cholesterol-free;Low-sodium;Fat-free",
    )

    private val nutritionList = arrayOf(
        "Apples vary significantly in size but, in general, they are a low-calorie, nutrient-dense food, providing fiber and micronutrients such as potassium and vitamin C.",
        "Avocados are high in fat, but it's healthier, monounsaturated fat. They also provide fiber and a variety of vitamins and minerals with very little sugar.",
        "Bananas are a great potassium-loaded food which also contains carbohydrates, vitamin C, and magnesium.",
        "Dragon fruit contains vitamin C, magnesium, and is packed with healthy fiber.",
        "Guava is a tropical fruit and an excellent source of vitamin C, vitamin A, and folate.",
        "Mangoes are a nutrient rich source of carbohydrates, packed with vitamin C. They are low in fat, sodium, and cholesterol, and contain vitamins A, E, and K, as well as potassium, magnesium, and copper.",
        "Papaya is a fat-free, nutrient-rich source of healthy carbohydrates, including fiber. It provides plenty of vitamin C, with 98% of your daily recommended intake, as well as potassium and vitamin A.",
        "Pineapple contains nutrients like vitaminc C, but it is high in sugar and carbs.",
        "Strawberries are a fiber-rich source of complex carbs that is naturally low in calories and fat. Strawberries are an excellent source of vitamin C and a good source of potassium, folate, and magnesium. Strawberries are also high in antioxidants.",
        "Watermelon is low in calories and contains almost no fat. While providing many valuable nutrients—such as vitamins A and C—it is somewhat high in sugar, so people who are monitoring their sugar intake may be best served by eating this fruit in moderation.",
    )

    private val benefitsList = arrayOf(
        "Promotes heart health;Regulates blood sugar;May aid cancer prevention;May reduce asthma symptoms;May support weight loss",
        "May aid in diabetes management;May reduce cardiovascular disease risk;Seed extract may help prevent cancer;May lower metabolic syndrome risk;May promote weight loss",
        "Improves diabetes management;Promotes regularity;Aids weight loss;Lowers blood presure;May assist wound healing",
        "Helps build and heal cells;Reduces inflammation;Improves digestive health;Helps manage blood sugar",
        "Aids cell protection and repair;Promotes skin health;Support weight control;Promotes better heart health;May aid disease prevention",
        "Improve cell function;Aids fluid balance;Protects against cell damage;Provides anti-inflammatory benefits;Boosts vitamin A",
        "Improves skin;Protects vision;Aids digestion;Support heart health;Helps prevent cancer",
        "May reduce inflammation;May help reduce abdominal obesity;Aids in skin repair;Promotes a healthy gut;Fights against cancer cells",
        "Prevents high blood sugar;Eases arthritis symptoms;Promotes wound healing;Promotes heart health;May reduce risk of colon cancer",
        "Fights dehydration;Reduces blood pressure;Reduces risk of infections and cancer;Contributes to weight loss;Helps ease muscle fatigue",
    )

    private val photoCreditList = arrayOf(
        "Shelley Pauls",
        "Alina Karpenko",
        "Syed Hussaini",
        "Helen Thomas",
        "Jethro Carullo",
        "Fedor",
        "Pranjall Kumar",
        "Gabriel Yuji",
        "Raghavendra Mithare",
        "Art Rachen",
    )

    private val readMoreUrlList = arrayOf(
        "https://www.verywellfit.com/apples-nutrition-facts-calories-and-their-health-benefits-4117992",
        "https://www.verywellfit.com/calories-in-an-avocado-3495640",
        "https://www.verywellfit.com/are-bananas-bad-for-weight-loss-3495634",
        "https://www.verywellfit.com/dragon-fruit-calories-carbs-nutrition-facts-4172559",
        "https://www.verywellfit.com/carb-counts-for-guava-2241794",
        "https://www.verywellfit.com/mango-calories-and-nutrition-facts-3982611",
        "https://www.verywellfit.com/papayas-nutrition-facts-calories-and-health-benefits-4114326",
        "https://www.verywellfit.com/pineapple-nutrition-facts-calories-and-health-benefits-4114409",
        "https://www.verywellfit.com/strawberries-carb-counts-and-health-benefits-1087572",
        "https://www.verywellfit.com/nutrition-facts-and-watermelon-carbs-1087575",
    )

    fun get(): List<Fruit> {
        val fruits = mutableListOf<Fruit>()
        for (i in idList.indices) {
            fruits.add(
                Fruit(
                    id = idList[i],
                    name = nameList[i],
                    photoId = photoIdList[i],
                    advantages = advantagesList[i].split(";"),
                    nutrition = nutritionList[i],
                    benefits = benefitsList[i].split(";"),
                    contentSource = "Verrywell Fit",
                    photoCredit = photoCreditList[i],
                    readMoreUrl = readMoreUrlList[i]
                )
            )
        }
        return fruits
    }
}