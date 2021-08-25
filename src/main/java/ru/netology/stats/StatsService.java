package ru.netology.stats;

public class StatsService {

    public long calculateSum(long[] sales) {
        long sum = 0;
        for (long sale : sales) {
            // аналог sum = sum + purchase;
            sum += sale;
        }
        return sum;
    }

    public long calculateAverage(long[] sales) {
        long sum = calculateSum(sales);
        return sum / sales.length;
    }

    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце maxMonth
            // sale - продажи в рассматриваемом месяце
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return maxMonth + 1;
    }

    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }


    public int numberOfMonthsSalesBelowAverage(long[] sales) {
        long averageSales = calculateAverage(sales);
        int month = 0;
        for (long sale : sales) {
            if (sale < averageSales) {
                month += 1;
            }
        }
        return month;
    }

    public int numberOfMonthsSalesOverAverage(long[] sales) {
        long averageSales = calculateAverage(sales);
        int month = 0;
        for (long sale : sales) {
            if (sale > averageSales) {
                month += 1;
            }
        }
        return month;
    }
}