/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.robot;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Quando o robô se dirige até o caminhão
 * @author dougl
 */
public class GoTruck extends OneShotBehaviour{

    @Override
    public void action() {
        System.out.println("Robô: Estou indo para o caminhão");
    }

    @Override
    public int onEnd() {
        System.out.println("Robô: Cheguei no caminhão e retornei 1");
        return 1;
    }
    
}
