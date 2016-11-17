/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import java.util.Random;
import model.behaviour.truck.TruckBehaviours;

/**
 *
 * @author dougl
 */
public class Truck extends Agent {

    @Override
    protected void setup() {
        this.iMax = new Random(1).nextInt(10);
        Supervisor supervisorMain = null;
        try {
            if (this.getArguments().length > 1) {
                supervisorMain = (Supervisor) this.getArguments()[1];
                supervisorMain.AddTruckList(this);
            }
        } catch (Exception ex) {
            //nothing
        }
        
        oTruckBehaviour = new TruckBehaviours(this);
        oTruckBehaviour.StartBehaviours();
        oTruckBehaviour.SetTransitions();
        this.addBehaviour(oTruckBehaviour);
    }

    
    
    
    //Número máximo de caixas
    private int iMax = 0;    
    
    //Contém a quantidade atual de pallets
    private int currentLength = 0;

    private boolean isOnLocation = false;

    public int getiMax() {
        return iMax;
    }

    public boolean IsOnLocation() {
        return isOnLocation;
    }

    public void setIsOnLocation(boolean isOnLocation) {
        this.isOnLocation = isOnLocation;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    @Override
    protected void takeDown() {
        try{
            DFService.deregister(this);
        }catch(FIPAException ex){
            
        }
    }
    

    public void setCurrentLength(int pCurrentLength) {
        this.currentLength = pCurrentLength;
    }

    public void setiMax(int iMax) {
        this.iMax = iMax;
    }
    
    TruckBehaviours oTruckBehaviour = null;
    
    //Verifica se o caminhão está pronto para sair para entrega
    public boolean IsFull(){
        return currentLength == iMax;
    }
}
