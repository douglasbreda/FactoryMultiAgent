/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
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

                    switch (msg.getOntology()) {
                        case "Robot":
                            if (content.contains("Starting")) {
                                if (content.equalsIgnoreCase("StartingLoadPoint")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " está indo ao ponto de carga.");
                                } else if (content.equalsIgnoreCase("StartingCharge")) {
                                    System.out.println("O  " + msg.getSender().getLocalName() + " está carregando.");
                                } else if (content.equalsIgnoreCase("StartingGoTruck")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " está indo até o caminhão.");
                                } else if (content.equalsIgnoreCase("StartingUncharge")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " está indo descarregar.");
                                } else if (content.equalsIgnoreCase("StartingGoStartPoint")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " está voltando a posição inicial.");
                                } else {
                                    block();
                                }
                            } else {
                                if (content.equalsIgnoreCase("FinishLoadPoint")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " chegou ao local de carga.");
                                } else if (content.equalsIgnoreCase("FinishCharge")) {
                                    System.out.println("O  " + msg.getSender().getLocalName() + " finalizou o carregamento.");
                                    oFactory.RemoveListPallet();
                                } else if (content.equalsIgnoreCase("FinishGoTruck")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " chegou no caminhão.");
                                } else if (content.equalsIgnoreCase("FinishUncharge")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " terminou de descarregar no caminhão.");
                                    oFactory.AddPalletToTruck();
                                } else if (content.equalsIgnoreCase("FinishGoStartPoint")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " voltou ao ponto inicial.");
                                    oFactory.RemoveListRobot();
                                } else {
                                    block();
                                }
                            }
                            break;
                        case "Truck":
                            if (content.contains("Starting")) {
                                if (content.equalsIgnoreCase("StartingGoCharge")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " está indo ao ponto de carga.");
                                } else if (content.equalsIgnoreCase("StartingGoDelivery")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " está saindo para descarregar.");
                                } else if (content.equalsIgnoreCase("StartingGoStartPoint")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " está voltando a posição inicial.");
                                } else {
                                    block();
                                }
                            } else if(content.contains("Finish")){
                                if (content.equalsIgnoreCase("FinishGoCharge")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " chegou ao local de carga.");
                                    oFactory.SetAbleToCharge();
                                } else if (content.equalsIgnoreCase("FinishGoDelivery")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " chegou no local de entrega.");
                                } else if (content.equalsIgnoreCase("FinishGoStartPoint")) {
                                    System.out.println("O " + msg.getSender().getLocalName() + " chegou na garagem.");
                                    oFactory.RemoveListTruck();
                                } else {
                                    block();
                                }
                            }else{
                                if(content.equalsIgnoreCase("WaitingGoDelivery")){
                                    System.out.println("O " + msg.getSender().getLocalName() + " está aguardando até ser carregado totalmente.");
                                }
                            }
                            break;
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

    public Factory getoFactory() {
        return oFactory;
    }

    public void setoFactory(Factory oFactory) {
        this.oFactory = oFactory;
    }

    //Chama os robôs
    public void CallRobot() {
        this.oAgentFactory.CreateAgent("Robô " + ++iNumRobot, model.agent.Robot.class.getName(), new Object[]{oFactory.getSupervisor(), this});
    }

    //Chama o caminhão
    public void CallTruck() {
        this.oAgentFactory.CreateAgent("Caminhão " + ++iNumTruck, model.agent.Truck.class.getName(), new Object[]{oFactory.getSupervisor(), this});
    }

    //Adiciona um robô a lista da fábrica
    public void AddRobotList(Robot pRobot) {
        this.oFactory.AddRobotsList(pRobot);
    }

    //Adiciona um caminhão a lista da fábrica
    public void AddTruckList(Truck pTruck) {
        this.oFactory.AddTruck(pTruck);
    }
}
