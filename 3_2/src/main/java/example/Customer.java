package example;

import java.util.List;

import static example.Movie.MovieType.NEW_RELEASE;

class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        double totalAmount = calculateTotalAmount(result);
        int frequentRenterPoints = calculateTotalFrequentRenterPoints();

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return result.toString();
    }

    private double calculateTotalAmount(StringBuilder result) {
        double totalAmount = 0;

        for (Rental rental : rentals) {
            double thisAmount = rental.getMovie().getPriceCode().calculateAmount(rental.getDaysRented());
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }

        return totalAmount;
    }

    private int calculateTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;

        for (Rental rental : rentals) {
            frequentRenterPoints++;
            if (rental.getMovie().getPriceCode() == NEW_RELEASE && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        }

        return frequentRenterPoints;
    }
}
