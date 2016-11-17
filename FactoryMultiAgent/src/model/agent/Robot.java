/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import model.behaviour.robot.RobotBehaviours;

/**
 *
 * @author dougl
 */
public class Robot extends Agent {
    
    private Supervisor supervisorMain = null;
    
    @Override
    protected void setup() {
        
        try {
            if (this.getArguments().length > 1) {
                supervisorMain = (Supervisor) this.getArguments()[1];
                supervisorMain.AddRobotList(this);
            }
        } catch (Exception ex) {
            //nothing
        }

        RobotBehaviours oRobotBehaviour = new RobotBehaviours(this);
        oRobotBehaviour.StartBehaviours();
        oRobotBehaviour.SetTransitions();
        this.addBehaviour(oRobotBehaviour);
    }
    
    //Verifica se o caminhão já está no local para carga
    public boolean VerifyExistsTruck(){
        return this.supervisorMain.getoFactory().getLstTrucks().size() > 0;         
    }
    
    //Verifica se o caminhão já não está cheio
    public boolean VerifyTruckIsFull(){
        return this.supervisorMain.getoFactory().getLstTrucks().stream().findFirst().get().IsFull();
    }

    @Override
    protected void takeDown() {
        try{
            DFService.deregister(this);
        }catch(FIPAException ex){
            
        }
    }
    
    
}
