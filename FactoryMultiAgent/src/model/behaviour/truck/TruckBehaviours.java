/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.truck;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;

/**
 * Máquina de estados que tem os estados dos caminhões
 * @author dougl
 */
public class TruckBehaviours extends FSMBehaviour {

    @Override
    public void registerFirstState(Behaviour state, String name) {
        super.registerFirstState(new GoCharge(), "GoCharge"); //Sai do ponto inicial e vai para o local de carga
    }

    @Override
    public void registerState(Behaviour state, String name) {
        super.registerState(new GoDelivery(), "GoDelivery"); //Depois de carregado sai para entrega
        super.registerState(new GoStartPoint(), "GoStartPoint");//Depois da entrega, volta ao ponto inicial
    }

    @Override
    public void registerTransition(String s1, String s2, int event) {
        super.registerTransition("GoCharge", "GoDelivery", 1); //Passa do estado de carregar para entregar
        super.registerTransition("GoDelivery", "GoStartPoint", 1);//Depois da entrega volta ao ponto inicial
    }
    
    
    
 
}
