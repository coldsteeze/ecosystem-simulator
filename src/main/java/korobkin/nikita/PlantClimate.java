package korobkin.nikita;


public class PlantClimate {
    private final double temperature; // Температура в градусах Цельсия
    private final double humidity; // Влажность в процентах
    private final double waterAvailability; // Доступная вода в литрах/м²

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