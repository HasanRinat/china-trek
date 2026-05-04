package com.chinatrek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Location {
    AIRPORT(0, "✈️ Аэропорт", "Прилёт в Пекин", true),
    TAXI(1, "🚕 Такси", "Поездка по городу", false),
    HOTEL(2, "🏨 Гостиница", "Заселение", false),
    TEMPLE(3, "🏯 Запретный город", "Императорский дворец", false),
    MOUNTAINS(4, "⛰️ Горы Хуаншань", "Величественные пейзажи", false),
    ZOO(5, "🐼 Зоопарк", "Панды и не только", false),
    FOOD(6, "🥟 Уличная еда", "Пекинская утка", false),
    EXHIBITION(7, "🎨 Выставка", "Каллиграфия", false),
    SOUVENIRS(8, "🎁 Сувениры", "Чай и шёлк", false),
    AIRPORT_BACK(9, "✈️ Аэропорт", "Возвращение домой", false),
    FINISH(10, "🏁 Финиш", "Путешествие завершено!", false);

    private final int index;
    private final String displayName;
    private final String description;
    private final boolean startingPoint;
}
