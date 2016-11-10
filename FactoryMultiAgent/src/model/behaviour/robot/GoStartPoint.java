/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.robot;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Quando o robô volta ao ponto inicial
 * @author dougl
 */
public class GoStartPoint extends OneShotBehaviour{

    @Override
    public void action() {
        System.out.println("Robô: Estou voltando ao ponto inicial");
    }

    @Override
    public int onEnd() {
        System.out.println("Robô: Cheguei no ponto inicial e retornei 1");
        return 1;
    }

    
}
