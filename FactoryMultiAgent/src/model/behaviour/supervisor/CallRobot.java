/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.supervisor;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import java.util.Random;


/**
 * Quando o supervisor necessita chamar o robô
 * @author dougl
 */
public class CallRobot extends Behaviour{

    @Override
    public void action() {
        System.out.println("Sou o robô " + new Random().nextDouble());
    }   

   
    @Override
    public boolean done() {
        System.out.println("Terminei meu trabalho");
        return true;
    }

    
}
