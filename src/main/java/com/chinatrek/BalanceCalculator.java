package com.chinatrek;

/**
 * Калькулятор баллов для игры China Trek
 */
public class BalanceCalculator {
    
    private static final int MOVE_COST = 20;
    private static final int START_BALANCE = 100;
    
    /**
     * Рассчитывает баллы за попытку ответа на вопрос
     * @param attemptNumber номер попытки (1, 2, 3...)
     * @return количество баллов (10, 5 или 0)
     */
    public int calculatePointsForAttempt(int attemptNumber) {
        if (attemptNumber == 1) {
            return 10;
        } else if (attemptNumber == 2) {
            return 5;
        } else {
            return 0;
        }
    }
    
    /**
     * Проверяет, можно ли переместиться на следующую локацию
     * @param currentBalance текущий баланс
     * @return true если можно переместиться
     */
    public boolean canMove(int currentBalance) {
        return currentBalance >= MOVE_COST;
    }
    
    /**
     * Списывает баллы за перемещение
     * @param currentBalance текущий баланс
     * @return новый баланс
     */
    public int applyMove(int currentBalance) {
        if (!canMove(currentBalance)) {
            throw new IllegalStateException("Недостаточно баллов для перемещения! Нужно " + MOVE_COST);
        }
        return currentBalance - MOVE_COST;
    }
    
    /**
     * Добавляет баллы за правильный ответ
     * @param currentBalance текущий баланс
     * @param points заработанные баллы
     * @return новый баланс
     */
    public int addPoints(int currentBalance, int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Баллы не могут быть отрицательными");
        }
        return currentBalance + points;
    }
}
