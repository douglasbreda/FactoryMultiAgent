/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.truck;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Classe que muda o status do caminhão para que ele vá carregar
 * @author dougl
 */
public class GoCharge extends OneShotBehaviour{

    @Override
    public void action() {
        System.out.println("Ok, estou indo até aí para carregar");
    }

    @Override
    public int onEnd() {
        return 1;
    }
}
