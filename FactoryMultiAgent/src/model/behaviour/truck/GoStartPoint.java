/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.truck;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Classe que muda o estado do caminhão para voltar ao ponto inicial
 * @author dougl
 */
public class GoStartPoint extends OneShotBehaviour {

    @Override
    public void action() {
        System.out.println("Estou voltando para a garagem");
    }

    @Override
    public int onEnd() {
        return 1;
    }
}
