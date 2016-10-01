/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.voteflow.api;

import java.util.Date;
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
public class VoteSearchRequest {

    public enum SortMode {
        date_asc,
        date_desc,
        date_desc_true,
        result_asc,
        result_desc;

        @Override
        public String toString() {
            return this.name();
        }

    }

    String convocation;
    Date from;
    Date to;
    String faction;
    String deputy;
    String number;
    String keywords;
    int page;
    int limit;
    SortMode sort;

}
