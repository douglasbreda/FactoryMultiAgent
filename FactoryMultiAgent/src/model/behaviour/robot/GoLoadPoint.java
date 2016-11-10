/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.robot;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Quando o robô vai o ponto de carregamento
 * @author dougl
 */
public class GoLoadPoint extends OneShotBehaviour{

    @Override
    public void action() {
        System.out.println("Robô: Estou indo para o ponto de carga");
    }

    @Override
    public int onEnd() {
        System.out.println("Robô: cheguei no ponto de carga e retornei 1");
        return 1;
    }
    
    
}
