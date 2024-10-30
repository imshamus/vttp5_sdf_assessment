package vttp.batch5.sdf.task01;

public class DataRecord {

    private boolean holiday;
    private String season;
    private String month;
    private String day;
    private String weather;
    private int casual;
    private int registered;
    private int total;

    // Constructor
    public DataRecord(boolean holiday, String season, String month, String day, String weather, int casual,
            int registered, int total) {
        this.holiday = holiday;
        this.season = season;
        this.month = month;
        this.day = day;
        this.weather = weather;
        this.casual = casual;
        this.registered = registered;
        this.total = total;
    }

    // Getters Setters
    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public int getTotal() {
        return total;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getCasual() {
        return casual;
    }

    public void setCasual(int casual) {
        this.casual = casual;
    }

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }
    
}
