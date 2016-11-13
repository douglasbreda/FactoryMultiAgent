/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.behaviour.robot.RobotBehaviours;

/**
 *
 * @author dougl
 */
public class Robot extends Agent {

    @Override
    protected void setup() {
        System.out.println("Oi, sou o robô, estou pronto...");
        RobotBehaviours oRobotBehaviour = new RobotBehaviours(this);
        oRobotBehaviour.StartBehaviours();
        oRobotBehaviour.SetTransitions();
        this.addBehaviour(oRobotBehaviour);
        
//        String supervisorName = (String) getArguments()[0];
//        this.addBehaviour(new OneShotBehaviour(this) {
//
//            @Override
//            public void action() {
//                if (!supervisorName.isEmpty()) {
//                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//                    msg.addReceiver(new AID(supervisorName, AID.ISLOCALNAME));
//                    msg.setLanguage("Portugûes");
//                    msg.setOntology("Iniciando");
//                    msg.setContent("LoadPoint");
//                    myAgent.send(msg);
//                }
//            }
//        });

    }
}
