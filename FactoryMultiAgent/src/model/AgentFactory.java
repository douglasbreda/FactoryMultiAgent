/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.agent.Supervisor;
import view.FactoryMultiAgent;

/**
 * Classe para criação genérica de agentes
 *
 * @author dougl
 */
public class AgentFactory {

    private jade.core.Runtime runtime = null;
    private Profile profile = null;
    private AgentContainer agentcontainer = null;

    ///Inicia o container
    public AgentFactory() {
        this.runtime = jade.core.Runtime.instance();
        this.profile = new ProfileImpl(true);
        this.agentcontainer = runtime.createMainContainer(profile);
    }

    //Cria e inicia os agentes de acordo com os parâmetros
    public AgentController CreateAgent(String pAgentName, String pClassName) {

        AgentController agentController = null;
        try {
            agentController = agentcontainer.createNewAgent(pAgentName, pClassName, new Object[]{});
            agentController.start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(FactoryMultiAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return agentController;
    }

}
