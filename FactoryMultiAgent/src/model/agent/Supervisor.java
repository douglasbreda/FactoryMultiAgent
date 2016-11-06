/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;

/**
 *
 * @author dougl
 */
public class Supervisor extends Agent{
    
     @Override
    protected void setup(){
         System.out.println("Oi, sou o Supervisor e estou pronto para iniciar a produção!");
    }
}
