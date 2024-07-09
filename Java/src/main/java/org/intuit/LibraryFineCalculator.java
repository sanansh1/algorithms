package org.intuit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryFineCalculator {

    // Constants for fine calculation
    private static final int DAILY_FINE = 1; // $1 per day
    private static final int MONTHLY_FINE = 30; // $30 per month
    private static final int YEARLY_FINE = 365; // $365 per year

    // Method to calculate the fine
    public static double calculateFine(LocalDate dueDate, LocalDate returnDate) {
        if (returnDate.isBefore(dueDate) || returnDate.isEqual(dueDate)) {
            return 0;
        }

        long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);

        long yearsOverdue = daysOverdue / 365;
        daysOverdue %= 365;

        long monthsOverdue = daysOverdue / 30;
        daysOverdue %= 30;

        double fine = (yearsOverdue * YEARLY_FINE) + (monthsOverdue * MONTHLY_FINE) + (daysOverdue * DAILY_FINE);

        return fine;
    }

    public static void main(String[] args) {
        // Example usage
        LocalDate dueDate = LocalDate.of(2023, 5, 1);
        LocalDate returnDate = LocalDate.of(2024, 6, 15);

        double fine = calculateFine(dueDate, returnDate);
        System.out.printf("The total fine is: $%.2f%n", fine);
    }
}
