/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.truck;

import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author dougl
 */
public class GoDelivery extends OneShotBehaviour{

    @Override
    public void action() {
        System.out.println("Não posso mais carregar, estou saindo para entrega");
    }

    @Override
    public int onEnd() {
        return 1;
    }
    
}
