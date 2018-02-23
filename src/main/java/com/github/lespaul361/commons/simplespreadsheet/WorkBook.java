/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.simplespreadsheet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Hamilton
 */
public class WorkBook implements FileFormats, Serializable {

    private List<Sheet> sheets = new ArrayList<>();
    private static final long serialVersionUID = -527556904949593L;
}
