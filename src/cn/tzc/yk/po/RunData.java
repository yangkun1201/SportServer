package cn.tzc.yk.po;

public class RunData {
    private String id;
    private String password;
    private String sportsType;
    private String startTime;
    private String totalTime;
    private double totalDistance;
    private double calories;
    private double timePerKM;
    private int stepCount;
    private double mCurrentLat;//纬度
    private double mCurrentLon;//经度
    private int score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSportsType() {
        return sportsType;
    }

    public void setSportsType(String sportsType) {
        this.sportsType = sportsType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getTimePerKM() {
        return timePerKM;
    }

    public void setTimePerKM(double timePerKM) {
        this.timePerKM = timePerKM;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public double getmCurrentLat() {
        return mCurrentLat;
    }

    public void setmCurrentLat(double mCurrentLat) {
        this.mCurrentLat = mCurrentLat;
    }

    public double getmCurrentLon() {
        return mCurrentLon;
    }

    public void setmCurrentLon(double mCurrentLon) {
        this.mCurrentLon = mCurrentLon;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "RunData{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", sportsType='" + sportsType + '\'' +
                ", startTime='" + startTime + '\'' +
                ", totalTime='" + totalTime + '\'' +
                ", totalDistance=" + totalDistance +
                ", calories=" + calories +
                ", timePerKM=" + timePerKM +
                ", stepCount=" + stepCount +
                ", mCurrentLat=" + mCurrentLat +
                ", mCurrentLon=" + mCurrentLon +
                ", score=" + score +
                '}';
    }
}