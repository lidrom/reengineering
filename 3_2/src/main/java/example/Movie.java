package example;

public class Movie {
    private final String title;
    private final MovieType priceCode;

    public enum MovieType {
        REGULAR {
            @Override
            public double calculateAmount(int daysRented) {
                double amount = 2;
                if (daysRented > 2) {
                    amount += (daysRented - 2) * 1.5;
                }
                return amount;
            }
        },
        NEW_RELEASE {
            @Override
            public double calculateAmount(int daysRented) {
                return daysRented * 3;
            }
        },
        CHILDRENS {
            @Override
            public double calculateAmount(int daysRented) {
                double amount = 1.5;
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 1.5;
                }
                return amount;
            }
        },
        HORROR {
            @Override
            public double calculateAmount(int daysRented) {
                double amount = 3;
                if (daysRented > 1) {
                    amount += (daysRented - 1) * 2;
                }
                return amount;
            }
        };

        public abstract double calculateAmount(int daysRented);
    }

    public Movie(String title, MovieType priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}
