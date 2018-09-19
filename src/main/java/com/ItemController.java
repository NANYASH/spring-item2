package com;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class ItemController {
    private DAO dao;
    private ObjectMapper mapper;


    @Autowired
    public ItemController(DAO dao) {
        this.dao = dao;
        this.mapper = new ObjectMapper();
    }



    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "text/plain")
    @ResponseBody
    public String save(HttpServletRequest req) throws BadRequestException {
        try {
            dao.save(mapToItem(req));
            return "ok";
        } catch (BadRequestException e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "text/plain")
    @ResponseBody
    public String update(HttpServletRequest req) throws BadRequestException {
        try {
            dao.update(mapToItem(req));
            return "ok";
        } catch (BadRequestException e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    @ResponseBody
    public String delete(@RequestParam Long id) throws BadRequestException {
        dao.delete(id);
        return "ok";
    }

    private Item mapToItem(HttpServletRequest req) throws BadRequestException {
        try {
            return mapper.readValue(
                    mapper.writeValueAsString(mapper.readTree(req.getInputStream()).path("item")),
                    new TypeReference<Item>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new BadRequestException("Something went wrong");
    }


}




