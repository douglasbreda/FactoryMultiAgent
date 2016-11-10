/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jade.wrapper.AgentController;

/**
 *
 * @author dougl
 */
public class CentralController {

    private AgentController controller = null;
    private AgentFactory oAgentFactory = null;
    
    public CentralController() {
        oAgentFactory = new AgentFactory();
    }
    
    //Inicia o processo
    public void Start(){
        
        controller = this.oAgentFactory.CreateAgent("Supervisor", model.agent.Supervisor.class.getName());
    }
}
