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

    //Classe que cria os agentes
    private AgentFactory oAgentFactory = new AgentFactory();
    
   //Contém a lista dos robôs disponíveis na fábrica
   private List<Robot> lstRobots = new ArrayList<>();
   
   private int iNumRobots = 0;
   
   //Supervisor responsável pelo controle da produção
   private String supervisorName = "";
   
   //Contém a lista de caminhões disponíveis
   private List<Truck> lstTrucks = new ArrayList<>();
   
   private int iNumTruck = 0;
   
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

    public int getiNumRobots() {
        return iNumRobots;
    }

    public void setiNumRobots(int iNumRobots) {
        this.iNumRobots = iNumRobots;
    }

    public int getiNumTruck() {
        return iNumTruck;
    }

    public void setiNumTruck(int iNumTruck) {
        this.iNumTruck = iNumTruck;
    }

    public void setLstRobots(List<Robot> lstRobots) {
        this.lstRobots = lstRobots;
    }

    public String getSupervisor() {
        return supervisorName;
    }

    public void setSupervisor(String supervisor) {
        this.supervisorName = supervisor;
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
        return !lstPallet.isEmpty() && (lstPallet.size() > lstRobots.size());
    }
    
    //Verifica se precisa de caminhões
    public boolean VerifyNeedTrucks(){
        return lstTrucks.isEmpty() && !lstRobots.isEmpty();
    }
    
    //Adiciona um novo caminhão
    public void AddTruck(Truck pTruck){
        lstTrucks.add(pTruck);
    }
    
    //Inicia a produção da fábrica
    public void StartProduction(){
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

    public List<Pallet> getLstPallet() {
        return lstPallet;
    }
    
    //Adiciona um robô na lista
    public void AddRobotsList(Robot pRobot){
        lstRobots.add(pRobot);
    }
    
    //Remove um pallet para indicar que foi carregado no caminhão
    public void RemoveListPallet(){
        if(!lstPallet.isEmpty())
            lstPallet.remove(0);
    }
    
    //Remove um robô da lista quando ele volta para o ponto inicial
    public void RemoveListRobot(){
        if(lstRobots.isEmpty())
            lstRobots.remove(0);
    }
    
    //Remove um caminhão da lista quando ele sai para entrega
    public void RemoveListTruck(){
        if(!lstTrucks.isEmpty())
            lstTrucks.remove(0);
    }
    
    ///Adiciona um pallet dentro do caminhão
    public void AddPalletToTruck(){
        lstTrucks.stream().findFirst().get().setCurrentLength(lstTrucks.stream().findFirst().get().getCurrentLength() + 1);
    }
    
    //Habilita o caminhão a iniciar a carregar
    public void SetAbleToCharge(){
        lstTrucks.stream().findFirst().get().setIsOnLocation(true);
    }
}
