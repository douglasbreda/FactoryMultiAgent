/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.truck;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import model.MessageFactory;

/**
 *
 * @author dougl
 */
public class GoDelivery extends OneShotBehaviour{

    MessageFactory oMsgFactory = null;
    String supervisorName = "";
    
    public GoDelivery(Agent a) {
        super(a);
        oMsgFactory = new MessageFactory();
    }

    @Override
    public void action() {
        
        if (this.getAgent().getArguments().length > 0) {
            supervisorName = (String) this.getAgent().getArguments()[0];
        }

        if (!supervisorName.isEmpty()) {
            myAgent.send(oMsgFactory.CreateNewMessage(supervisorName, "IniciandoTruck", "GoDelivery"));
        }
    }

    @Override
    public int onEnd() {
        myAgent.send(oMsgFactory.CreateNewMessage(supervisorName, "FinalizandoTruck", "FinishGoDelivery"));
        return 1;
    }
}
