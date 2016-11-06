/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.agent.Robot;
import model.agent.Supervisor;
import model.agent.Truck;

/**
 *
 * @author dougl
 */
public class Factory {
    
   //Contém a lista dos robôs disponíveis na fábrica
   private List<Robot> lstRobots = new ArrayList<>();
   
   //Supervisor responsável pelo controle da produção
   private Supervisor supervisor = new Supervisor();
   
   //Contém a lista de caminhões disponíveis
   private List<Truck> lstTrucks = new ArrayList<>();
   
   //Meta de pallets por dia (Ver se é isso mesmo)
   private int dailyGoal = 0;

   //Quantida de produção por hora
   private int hourlyProduction = 0;
   
    public List<Robot> getLstRobots() {
        return lstRobots;
    }

    public void setLstRobots(List<Robot> lstRobots) {
        this.lstRobots = lstRobots;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public List<Truck> getLstTrucks() {
        return lstTrucks;
    }

    public void setLstTrucks(List<Truck> lstTrucks) {
        this.lstTrucks = lstTrucks;
    }

    public int getDailyGoal() {
        return dailyGoal;
    }

    public void setDailyGoal(int dailyGoal) {
        this.dailyGoal = dailyGoal;
    }

    public int getHourlyProduction() {
        return hourlyProduction;
    }

    public void setHourlyProduction(int hourlyProduction) {
        this.hourlyProduction = hourlyProduction;
    }
}
