package org.codemxde;

public class Time {
    private double userInput;
    private int hours;
    private int minutes;

    private int totalHours = 0;
    private int totalMinutes = 0;

    public void setUserInput(double userInput) {
        this.userInput = userInput;
    }

    public void setHours() {
        this.hours = (int) this.userInput;
    }

    public void setMinutes() {
        double userMinutes = (this.userInput - this.hours) * 100;
        this.minutes = (int) Math.floor(userMinutes);
    }

    public void setTotalHours() {
        this.totalHours += this.hours;
    }

    public void setTotalMinutes() {
        this.totalMinutes += this.minutes;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    public int getTotalHours() {
        return this.totalHours;
    }

    public int getTotalMinutes() {
        return this.totalMinutes;
    }

    public void convertMinutesToHours() {
        if (this.totalMinutes > 0) {
            int hours = this.totalMinutes / 60;
            this.totalHours += hours;
            // reset totalMinutes to the remainder minutes post hour conversion
            this.totalMinutes %= 60;
        }
    }

}
