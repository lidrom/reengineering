class HumanBMI {
    private static final double UNDERWEIGHT_THRESHOLD = 18.5;
    private static final double NORMAL_THRESHOLD = 25.0;
    private static final double OVERWEIGHT_THRESHOLD = 30.0;

    private double weight; // Weight in kilograms
    private double height; // Height in meters
    private double bmi;     // Body Mass Index

    /**
     * Constructor for HumanBMI class.
     *
     * @param weight weight in kilograms
     * @param height height in meters
     * @throws IllegalArgumentException if weight or height are invalid
     */
    public HumanBMI(double weight, double height) {
        setHeight(height);
        setWeight(weight);
    }

    /**
     * Returns the person's weight.
     *
     * @return weight in kilograms
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the person's weight.
     *
     * @param weight weight in kilograms
     * @throws IllegalArgumentException if weight is not positive
     */
    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        this.weight = weight;
        calculateBmi();
    }

    /**
     * Returns the person's height.
     *
     * @return height in meters
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the person's height.
     *
     * @param height height in meters
     * @throws IllegalArgumentException if height is not positive
     */
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive.");
        }
        this.height = height;
        calculateBmi();
    }

    /**
     * Returns the Body Mass Index (BMI).
     *
     * @return BMI value
     */
    public double getBmi() {
        return bmi;
    }

    /**
     * Calculates the Body Mass Index.
     */
    private void calculateBmi() {
        bmi = weight / (height * height);
    }

    /**
     * Returns the BMI category.
     *
     * @return BMI category as a string
     */
    public String getResult() {
        if (bmi < UNDERWEIGHT_THRESHOLD) {
            return "Underweight";
        } else if (bmi >= UNDERWEIGHT_THRESHOLD && bmi < NORMAL_THRESHOLD) {
            return "Normal weight";
        } else if (bmi >= NORMAL_THRESHOLD && bmi < OVERWEIGHT_THRESHOLD) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
};
public class Main {
    public static void main(String[] args) {
        HumanBMI person = new HumanBMI(90, 1.70);
        System.out.println("BMI: " + person.getBmi());
        System.out.println("Result: " + person.getResult());
    }
};