/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.robot;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;

/**
 * Comportamento chamada quando o robô precisa carregar o pallet
 * @author dougl
 */
public class RobotBehaviours extends FSMBehaviour{

    @Override
    public void onStart() {
        System.out.println("Iniciou");
        setExecutionState("GoLoadPoint");
    }

    
    
    @Override
    public void registerFirstState(Behaviour state, String name) {
        super.registerFirstState(new GoLoadPoint(), "GoLoadPoint"); //Estado inicial que leva o robô até o ponto de carga
    }

    @Override
    public void registerState(Behaviour state, String name) {
        super.registerState(new Charge(), "Charge");//Quando o robô está carregando
        super.registerState(new GoTruck(), "GoTruck");//Depois de carregar o robô se dirige até o caminhão
        super.registerState(new Uncharge(), "Uncharge");//Ao chegar no caminhão 
        
    }

    @Override
    public void registerLastState(Behaviour state, String name) {
        super.registerLastState(new GoStartPoint(), "GoStarPoint");//Volta ao ponto inicial
    }

    @Override
    public void registerDefaultTransition(String s1, String s2, String[] toBeReset) {
        super.registerDefaultTransition("GoLoadPoint", "Charge", new String[]{"GoLoadPoint", "Charge"});
    }
    
    

    @Override
    public void registerTransition(String s1, String s2, int event) {
        super.registerTransition("GoLoadPoint", "Charge", 1); //Passa do estado de ir ao ponto de carga para carregar
        super.registerTransition("Charge", "GoTruck", 1);//Depois de carregar se dirige ao caminhão
        super.registerTransition("GoTruck", "Uncharge", 1);//Ao chegar no caminhão descarrega
        super.registerTransition("Uncharge", "GoStartPoint", 1);//Retorna ao ponto inicial
    }
    
    
    
}
