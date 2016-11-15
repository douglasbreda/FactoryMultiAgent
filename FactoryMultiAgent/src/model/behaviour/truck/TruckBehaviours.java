/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.truck;

import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;

/**
 * Máquina de estados que tem os estados dos caminhões
 * @author dougl
 */
public class TruckBehaviours extends FSMBehaviour {

    public TruckBehaviours(Agent a) {
        super(a);
    }
    
    ///Inicia os estados com os comportamentos
    public void StartBehaviours(){
        this.registerFirstState(new GoCharge(this.getAgent()), "GoCharge"); //Sai do ponto inicial e vai para o local de carga
        this.registerState(new GoDelivery(this.getAgent()), "GoDelivery"); //Depois de carregado sai para entrega
        this.registerLastState(new GoStartPoint(this.getAgent()), "GoStartPoint");//Depois da entrega, volta ao ponto inicial
        
    }
    
    //Define as transições entre os estados do caminhão
    public void SetTransitions(){
        this.registerTransition("GoCharge", "GoDelivery", 1); //Passa do estado de carregar para entregar
        this.registerTransition("GoDelivery", "GoStartPoint", 1);//Depois da entrega volta ao ponto inicial
        this.registerDefaultTransition("GoDelivery", "GoCharge", new String[]{ "GoDelivery", "GoCharge"}); 
    }
}
