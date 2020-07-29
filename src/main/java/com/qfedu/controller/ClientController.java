package com.qfedu.controller;

import com.qfedu.pojo.Client;
import com.qfedu.service.IClientService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController {

    @Resource
    private IClientService clientService;

    @GetMapping("/Clients")
    public Map getAllClients(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) {
        List<Object> allClient = clientService.getAllClient(page, limit);
        Map<String, Object> clientMap = new HashMap<>();
        clientMap.put("code", 0);
        clientMap.put("msg", "");
        clientMap.put("count", clientService.getCount());
        clientMap.put("data", allClient);
        return clientMap;
    }

    @GetMapping("/GetClientById/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/GetNickName")
    public List<Map> getNickName() {
        return clientService.getNickName();
    }

    @PostMapping("/SaveClient")
    public String saveClient(Client client) {
        if (clientService.saveClient(client)) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateClient")
    public String updateClient(Client client) {
        if (clientService.updateClient(client)) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveClient/{id}")
    public String removeClient(@PathVariable int id) {
        if (clientService.removeClient(id)) {
            return "success";
        }
        return "failed";
    }
}
