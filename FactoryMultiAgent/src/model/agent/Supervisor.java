/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentFactory;
import model.Factory;

/**
 *
 * @author dougl
 */
public class Supervisor extends Agent {

    private Factory oFactory = null;
    private static int iNumRobot = 0;
    private static int iNumTruck = 0;
    private AgentFactory oAgentFactory = null;
    
    @Override
    protected void setup() {
        oAgentFactory = new AgentFactory();
        
        oFactory = new Factory();
        oFactory.setSupervisor(this.getAID().getLocalName());
        oFactory.StartProduction();
        System.out.println("Oi, sou o Supervisor e estou pronto para iniciar a produção!");

        addBehaviour(new CyclicBehaviour(this) {

            @Override
            public void action() {

                
                    ACLMessage msg = myAgent.receive();

                    if (msg != null) {
                        String content = msg.getContent();

                        if (content.equalsIgnoreCase("LoadPoint")) {
                            System.out.println("O Robô " + msg.getSender().getLocalName() + " está indo ao ponto de carga.");
                            oFactory.AddRobotsList(iNumRobot);
                        }else if(content.equalsIgnoreCase("Charge")){
                            System.out.println("O Robô " + msg.getSender().getLocalName() + " está carregando.");
                        }else if(content.equalsIgnoreCase("GoTruck")){
                            System.out.println("O Robô " + msg.getSender().getLocalName() + " está indo até o caminhão.");
                        }else if(content.equalsIgnoreCase("Uncharge")){
                            System.out.println("O Robô " + msg.getSender().getLocalName() + " está indo descarregar.");
                        }else if(content.equalsIgnoreCase("GoStartPoint")){
                            System.out.println("O Robô " + msg.getSender().getLocalName() + " está voltando a posição inicial");
                        }else{
                            block();
                        }
                            
                    }
               if (oFactory.VerifyNeedRobot()) {
                    CallRobot();
               }

                if (oFactory.VerifyNeedTrucks()) {
                    CallTruck();
                }

            }
        });
    }

    public void setoFactory(Factory oFactory) {
        this.oFactory = oFactory;
    }

    //Chama os robôs
    public void CallRobot() {
        this.oAgentFactory.CreateAgent("Robô" + ++iNumRobot, model.agent.Robot.class.getName(), new Object[]{oFactory.getSupervisor()});
    }

    //Chama o caminhão
    public void CallTruck() {
        this.oAgentFactory.CreateAgent("Caminhão" + ++iNumTruck, model.agent.Truck.class.getName());
    }
}
