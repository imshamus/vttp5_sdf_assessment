package vttp.batch5.sdf.task01;

import java.util.List;

public class FilterInfo {
    
    private int highestTotal;    
    private int secondHighest;        
    private int thirdHighest;   
    private int fourthHighest;
    private int fifthHighest;

    private boolean holidayHighest;
    private String seasonHighest;
    private String monthHighest;
    private String dayHighest;
    private String weatherHighest;

    private boolean holidaySecond;
    private String seasonSecond;
    private String monthSecond;
    private String daySecond;
    private String weatherSecond;

    private boolean holidayThird;
    private String seasonThird;
    private String monthThird;
    private String dayThird;
    private String weatherThird;

    private boolean holidayFourth;
    private String seasonFourth;
    private String monthFourth;
    private String dayFourth;
    private String weatherFourth;

    private boolean holidayFifth;
    private String seasonFifth;
    private String monthFifth;
    private String dayFifth;
    private String weatherFifth;

    // Constructor
    public FilterInfo() 
    {
        this.highestTotal = 0;
        this.secondHighest = 0;
        this.thirdHighest = 0;
        this.fourthHighest = 0;
        this.fifthHighest = 0;

        this.holidaySecond = false;
        this.seasonSecond = "";
        this.monthSecond = "";
        this.daySecond = "";
        this.weatherSecond = "";
        
        this.holidayThird = false;
        this.seasonThird = "";
        this.monthThird = "";
        this.dayThird = "";
        this.weatherThird = "";

        this.holidayFourth = false;
        this.seasonFourth = "";
        this.monthFourth = "";
        this.dayFourth = "";
        this.weatherFourth = "";
        
        this.holidayFifth = false;
        this.seasonFifth = "";
        this.monthFifth = "";
        this.dayFifth = "";
        this.weatherFifth = "";
    }

    // Methods
    // Compute stats
    public void appStats(List<DataRecord> mr)
    {
        for (int i = 0 ; i < mr.size(); i ++)
        {
            DataRecord record = mr.get(i);
            int total = record.getTotal();

            if (total > highestTotal)
            {
                highestTotal = total;

                holidayHighest = record.isHoliday();
                seasonHighest = record.getSeason();
                monthHighest = record.getMonth();
                dayHighest = record.getDay();
                weatherHighest = record.getWeather();
            }

            if (total < highestTotal && total > secondHighest)
            {
                secondHighest = total;

                holidaySecond = record.isHoliday();
                seasonSecond = record.getSeason();
                monthSecond = record.getMonth();
                daySecond = record.getDay();
                weatherSecond = record.getWeather();
            }

            if (total < secondHighest && total > thirdHighest)
            {
                thirdHighest = total;

                holidayThird = record.isHoliday();
                seasonThird = record.getSeason();
                monthThird = record.getMonth();
                dayThird = record.getDay();
                weatherThird = record.getWeather();
            }

            if (total < thirdHighest && total > fourthHighest)
            {
                fourthHighest = total;

                holidayFourth = record.isHoliday();
                seasonFourth = record.getSeason();
                monthFourth = record.getMonth();
                dayFourth = record.getDay();
                weatherFourth = record.getWeather();
            }

            if (total < fourthHighest && total > fifthHighest)
            {
                fifthHighest = total;

                holidayFifth = record.isHoliday();
                seasonFifth = record.getSeason();
                monthFifth = record.getMonth();
                dayFifth = record.getDay();
                weatherFifth = record.getWeather();
            }

        }
        
        
    }

    // Getters
    public int getHighestTotal() {
        return highestTotal;
    }

    public int getSecondHighest() {
        return secondHighest;
    }

    public int getThirdHighest() {
        return thirdHighest;
    }

    public int getFourthHighest() {
        return fourthHighest;
    }

    public int getFifthHighest() {
        return fifthHighest;
    }

    public boolean isHolidayHighest() {
        return holidayHighest;
    }

    public String getSeasonHighest() {
        return seasonHighest;
    }

    public String getMonthHighest() {
        return monthHighest;
    }

    public String getDayHighest() {
        return dayHighest;
    }

    public String getWeatherHighest() {
        return weatherHighest;
    }

    public boolean isHolidaySecond() {
        return holidaySecond;
    }

    public String getSeasonSecond() {
        return seasonSecond;
    }

    public String getMonthSecond() {
        return monthSecond;
    }

    public String getDaySecond() {
        return daySecond;
    }

    public String getWeatherSecond() {
        return weatherSecond;
    }

    public boolean isHolidayThird() {
        return holidayThird;
    }

    public String getSeasonThird() {
        return seasonThird;
    }

    public String getMonthThird() {
        return monthThird;
    }

    public String getDayThird() {
        return dayThird;
    }

    public String getWeatherThird() {
        return weatherThird;
    }

    public boolean isHolidayFourth() {
        return holidayFourth;
    }

    public String getSeasonFourth() {
        return seasonFourth;
    }

    public String getMonthFourth() {
        return monthFourth;
    }

    public String getDayFourth() {
        return dayFourth;
    }

    public String getWeatherFourth() {
        return weatherFourth;
    }

    public boolean isHolidayFifth() {
        return holidayFifth;
    }

    public String getSeasonFifth() {
        return seasonFifth;
    }

    public String getMonthFifth() {
        return monthFifth;
    }

    public String getDayFifth() {
        return dayFifth;
    }

    public String getWeatherFifth() {
        return weatherFifth;
    }

    
}
