/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.agent.Robot;
import model.agent.Supervisor;
import model.agent.Truck;

/**
 *
 * @author dougl
 */
public class Factory {

    //Classe que contém as configurações para a simulação
    private Configuration oConfig = new Configuration();
    
   //Contém a lista dos robôs disponíveis na fábrica
   private List<Robot> lstRobots = new ArrayList<>();
   
   //Supervisor responsável pelo controle da produção
   private Supervisor supervisor = null;
   
   //Contém a lista de caminhões disponíveis
   private List<Truck> lstTrucks = new ArrayList<>();
   
   ///Lista de pallets cheios
   private List<Pallet> lstPallet = new ArrayList<>();
   
   //Meta de pallets por dia (Ver se é isso mesmo)
   private int dailyGoal = 0;

   //Quantida de produção por hora
   private int hourlyProduction = 0;
   
   //Número de pallets acumulado
   private int numPalletsAccumulated = 0;
   
   //Total acumulado de produção do dia
   private int totalDailyProduction = 0;
   
   //Supervisor responsável pelo controle da fábrica
   private Supervisor oSupervisor = null;
   
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
    
    //Verifica o nível de produção para ver se precisa chamar algum robô
    public boolean VerifyNeedRobot(){
        return lstRobots.size() > 0;
    }
    
    //Verifica se precisa de caminhões
    public boolean VerifyNeedTrucks(){
        return lstTrucks.isEmpty();
    }
    
    //Adiciona um novo caminhão
    public void AddTruck(){
        lstTrucks.add((new Truck()));
    }
    
    //Inicia a produção da fábrica
    public void Start(){
        oSupervisor = new Supervisor(this);
        new Thread(){

            @Override
            public void run() {
                try {
                    sleep(10000);
                    lstPallet.add(new Pallet(oConfig.getMaxPallets(), Size.large));//ver de onde vem o tamanho???
                } catch (InterruptedException ex) {
                    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }.start();
    }
}
