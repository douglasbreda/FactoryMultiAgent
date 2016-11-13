/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jade.core.AID;
import jade.lang.acl.ACLMessage;

/**
 * Classe para criar e retornar as mensagens
 *
 * @author dougl
 */
public class MessageFactory {

    //Sobrecarga com apenas os valores que geralmente são alterados
    public ACLMessage CreateNewMessage(String pAIDName, String pOntology, String pContent){
        return CreateNewMessage(ACLMessage.INFORM, pAIDName, "Português", pOntology, pContent);
    }
    
    //Cria a mensagem de acordo com os parâmetros
    public ACLMessage CreateNewMessage(int pPerfom, String pAIDName, String pLanguage, String pOntology, String pContent) {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        
        msg.addReceiver(new AID(pAIDName, AID.ISLOCALNAME));
        msg.setLanguage(pLanguage);
        msg.setOntology(pOntology);
        msg.setContent(pContent);

        return msg;
    }
}
