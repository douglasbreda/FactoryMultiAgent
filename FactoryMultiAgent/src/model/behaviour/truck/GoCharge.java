/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.truck;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MessageFactory;

/**
 * Classe que muda o status do caminhão para que ele vá carregar
 *
 * @author dougl
 */
public class GoCharge extends OneShotBehaviour {

    MessageFactory oMsgFactory = null;
    String supervisorName = "";

    public GoCharge(Agent a) {
        super(a);
        oMsgFactory = new MessageFactory();
    }

    @Override
    public void action() {

        if (this.getAgent().getArguments().length > 0) {
            supervisorName = (String) this.getAgent().getArguments()[0];
        }

        if (!supervisorName.isEmpty()) {
            myAgent.send(oMsgFactory.CreateNewMessage(supervisorName, "Truck", "StartingGoCharge"));
        }
    }

    @Override
    public int onEnd() {
        try {
            Thread.sleep(3000);//leva três segundos para ir da garagem até o ponto de entrega
            myAgent.send(oMsgFactory.CreateNewMessage(supervisorName, "Truck", "FinishGoCharge"));
        } catch (InterruptedException ex) {
            Logger.getLogger(GoCharge.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
}
