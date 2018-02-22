/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemapedidos.model.dao;

import javax.persistence.EntityManager;
import org.ufpr.sistemapedidos.model.Produto;
import org.ufpr.sistemapedidos.utils.JpaUtil;

/**
 *
 * @author LuanComputacao
 */
public class ProdutoDAO {

    public void persist(Produto produto) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
