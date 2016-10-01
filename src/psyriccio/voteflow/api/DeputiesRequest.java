/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.voteflow.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author psyriccio
 */
@Data
@Builder
@AllArgsConstructor
public class DeputiesRequest {

    String begin;
    String position;
    boolean current;

}
