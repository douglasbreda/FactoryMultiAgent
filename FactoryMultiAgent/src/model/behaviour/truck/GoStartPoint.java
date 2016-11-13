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
 * Classe que muda o estado do caminhão para voltar ao ponto inicial
 * @author dougl
 */
public class GoStartPoint extends OneShotBehaviour {

    MessageFactory oMsgFactory = null;
    String supervisorName = "";
    
    public GoStartPoint(Agent a) {
        super(a);
        oMsgFactory = new MessageFactory();
    }

    @Override
    public void action() {
        
        if (this.getAgent().getArguments().length > 0) {
            supervisorName = (String) this.getAgent().getArguments()[0];
        }

        if (!supervisorName.isEmpty()) {
            myAgent.send(oMsgFactory.CreateNewMessage(supervisorName, "Iniciando", "GoStartPoint"));
        }
    }

    @Override
    public int onEnd() {
        myAgent.send(oMsgFactory.CreateNewMessage(supervisorName, "FinalizandoTruck", "FinishGoStartPoint"));
        return 1;
    }
}
