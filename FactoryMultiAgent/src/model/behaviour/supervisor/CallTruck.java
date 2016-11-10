/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.supervisor;

import jade.core.behaviours.Behaviour;
import java.util.Random;

/**
 * Quando o supervisor necessita chamar o caminhão
 * @author dougl
 */
public class CallTruck extends Behaviour{

    @Override
    public void action() {
        System.out.println("Sou o caminhão " + new Random().nextDouble());
    }

    @Override
    public boolean done() {
        
        System.out.println("Estou saindo para entrega");
        return true;
    }
    
}
