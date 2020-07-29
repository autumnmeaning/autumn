package com.qfedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adhibition {
    private int id;
    private String corpName;
    private String appName;
    private String appKey;
    private String AppSecret;
    private String redirectUrl;
    private int linit;
    private String description;
    private int cusId;
    private int state;

}
