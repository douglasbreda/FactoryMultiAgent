/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.robot;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Quando o robô descarrega no caminhão
 * @author dougl
 */
public class Uncharge extends OneShotBehaviour{

    @Override
    public void action() {
        System.out.println("Estou descarregando no caminhão");
    }

    @Override
    public int onEnd() {
        System.out.println("terminei de descarregar");
        return 1;
    }
    
    
    
}
