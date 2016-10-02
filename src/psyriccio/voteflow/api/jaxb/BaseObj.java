/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.voteflow.api.jaxb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author psyriccio
 */
@Entity
public class BaseObj {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    long id;

}
