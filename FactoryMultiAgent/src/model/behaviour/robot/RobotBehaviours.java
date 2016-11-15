/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.robot;

import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;

/**
 * Comportamento chamada quando o robô precisa carregar o pallet
 *
 * @author dougl
 */
public class RobotBehaviours extends FSMBehaviour {

    public RobotBehaviours(Agent a) {
        super(a);
    }
    
    @Override
    public void onStart() {
        System.out.println("Iniciou");
    }

    //seta os estados
    public void StartBehaviours() {
        this.registerFirstState(new GoLoadPoint(this.getAgent()), "GoLoadPoint"); //Estado inicial que leva o robô até o ponto de carga
        this.registerState(new Charge(this.getAgent()), "Charge");//Quando o robô está carregando
        this.registerState(new GoTruck(this.getAgent()), "GoTruck");//Depois de carregar o robô se dirige até o caminhão
        this.registerState(new Uncharge(this.getAgent()), "Uncharge");//Ao chegar no caminhão 
        this.registerLastState(new GoStartPoint(this.getAgent()), "GoStartPoint");//Volta ao ponto inicial
        
    }
    
    //Define as transições
    public void SetTransitions() {
        this.registerTransition("GoLoadPoint", "Charge", 1); //Passa do estado de ir ao ponto de carga para carregar
        this.registerTransition("Charge", "GoTruck", 1);//Depois de carregar se dirige ao caminhão
        this.registerTransition("GoTruck", "Uncharge", 1);//Ao chegar no caminhão descarrega
        this.registerTransition("Uncharge", "GoStartPoint", 1);//Retorna ao ponto inicial
        this.registerTransition("Uncharge", "Uncharge", 0);//Retorna ao ponto inicial
        this.registerDefaultTransition("GoLoadPoint", "Charge", new String[]{"GoLoadPoint", "Charge"}); 
        
    }
}
