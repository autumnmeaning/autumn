package com.qfedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @GetMapping("/ControlPage")
    public String controlPage() {
        return "controlpage.html";
    }

    @GetMapping("/Page")
    public String page() {
        return "clients.html";
    }

    @GetMapping("/SaveClient")
    public String saveClient() {
        return "saveclient.html";
    }

    @GetMapping("/UpdateClient/{id}")
    public String updateClient(@PathVariable int id) {
        return "showclient1.html?id=" + id;
    }

    @GetMapping("/SelectClient/{id}")
    public String selectClient(@PathVariable int id) {
        return "showclient2.html?id=" + id;
    }

    @GetMapping("/AdhibitionsPage")
    public String adhibitionsPage() {
        return "adhibitions.html";
    }

    @GetMapping("/SaveAdhibition")
    public String saveAdhibition() {
        return "saveadhibition.html";
    }

    @GetMapping("/UpdateAdhibition/{id}")
    public String updateAdhibition(@PathVariable int id) {
        return "showadhibition1.html?id=" + id;
    }

    @GetMapping("/SelectAdhibition/{id}")
    public String selectAdhibition(@PathVariable int id) {
        return "showadhibition2.html?id=" + id;
    }

    @GetMapping("/RoutesPage")
    public String routesPage() {
        return "routes.html";
    }

    @GetMapping("/SaveRoute")
    public String saveRoute() {
        return "saveroute.html";
    }

    @GetMapping("/UpdateRoute/{id}")
    public String updateRoute(@PathVariable int id) {
        return "showroute1.html?id=" + id;
    }

    @GetMapping("/SelectRoute/{id}")
    public String selectRoute(@PathVariable int id) {
        return "showroute2.html?id=" + id;
    }
}
