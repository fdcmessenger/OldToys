/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oldtoys.system.vo;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Administrator
 */
@Data
public class UserSearchDto implements Serializable {

    private Integer officeId;
    private Boolean includeChildren;
//    private Boolean isMain;
    private Integer typeId;
    private Boolean hasNoOffice;
    private String userName;
}
