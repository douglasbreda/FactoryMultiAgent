/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.robot;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Quando o robô vai carregar
 * @author dougl
 */
public class Charge extends OneShotBehaviour {

    @Override
    public void action() {
        System.out.println("Sou o robô e estou carregando");
    }

    @Override
    public int onEnd() {
        System.out.println("Terminei de carregar, retornei 1");
        return 1;
    }
    
    
}
