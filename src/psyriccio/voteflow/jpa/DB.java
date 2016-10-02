/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.voteflow.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import psyriccio.voteflow.Main;

/**
 *
 * @author psyriccio
 */
public class DB {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("vote-flow");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getMetamodel().getEntities().forEach((ent) -> {
            Main.log.info("Entity: {}", ent.getName());
        });
    }

}
