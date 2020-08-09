package com.aiadver.api.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lizhiyong
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoModel implements Serializable {

    private Integer id;

    private String name;
}
