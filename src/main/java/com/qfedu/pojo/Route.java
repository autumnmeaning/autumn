package com.qfedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private int id;
    private String gatewayApiName;
    private String insideApiUrl;
    private String serviceId;
    private String description;
    private int state;
    private int idempotents;
    private int needfee;
}
