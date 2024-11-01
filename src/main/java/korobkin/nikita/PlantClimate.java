package korobkin.nikita;

// Класс, предназначенный для задания климатических условий
public class PlantClimate {
    private final double temperature;
    private final double humidity;
    private final double waterAvailability;

    public PlantClimate(double temperature, double humidity, double waterAvailability) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.waterAvailability = waterAvailability;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWaterAvailability() {
        return waterAvailability;
    }

    @Override
    public String toString() {
        return "PlantClimate{" +
                "температура=" + temperature +
                ", влажность=" + humidity +
                ", доступность воды=" + waterAvailability +
                '}';
    }
}