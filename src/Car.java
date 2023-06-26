public class Car {
    //defines the 4 main variables that can be changed via the settings menu
    Double MPG;
    Double fuelTank;
    Double prices;
    Double maxCap;


    public Car(Double MPG, Double fuelTank, Double prices, Double maxCap){
        this.MPG = MPG;
        this.fuelTank = fuelTank;
        this.prices = prices;
        this.maxCap = maxCap;
    }
    public Double getMPG() {
        return MPG;
    }

    public void setMPG(Double MPG) {
        this.MPG = MPG;
    }

    public Double getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(Double fuelTank) {
        this.fuelTank = fuelTank;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public Double getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(Double maxCap) {
        this.maxCap = maxCap;
    }
}
