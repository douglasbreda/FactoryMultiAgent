
package model;

/**
 * Classe de configuração do ambiente
 * @author dougl
 */
public class Configuration {
    
    //Número mínimo de robôs
    private int minRobots = 0;
    
    //Número máximo de robôs
    private int maxRobots = 0;
    
    //Número máximo de Pallets
    private int maxPallets = 0;
    
    //Meta de produção diária
    private int dailyGoal = 0;
    
    //Define a quantidade de robôs disponíveis na fábrica
    private int qtdRobots = 0;
    
    //Define a quantidade de caminhões disponíveis
    private int qtdTrucks = 0;

    public int getMinRobots() {
        return minRobots;
    }

    public void setMinRobots(int minRobots) {
        this.minRobots = minRobots;
    }

    public int getMaxRobots() {
        return maxRobots;
    }

    public void setMaxRobots(int maxRobots) {
        this.maxRobots = maxRobots;
    }

    public int getMaxPallets() {
        return maxPallets;
    }

    public void setMaxPallets(int maxPallets) {
        this.maxPallets = maxPallets;
    }

    public int getDailyGoal() {
        return dailyGoal;
    }

    public void setDailyGoal(int dailyGoal) {
        this.dailyGoal = dailyGoal;
    }

    public int getQtdRobots() {
        return qtdRobots;
    }

    public void setQtdRobots(int qtdRobots) {
        this.qtdRobots = qtdRobots;
    }

    public int getQtdTrucks() {
        return qtdTrucks;
    }

    public void setQtdTrucks(int qtdTrucks) {
        this.qtdTrucks = qtdTrucks;
    }
}
