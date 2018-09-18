package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;


@Controller
public class TestController {
    private DAO dao;

    @Autowired
    public TestController(DAO dao) {
        this.dao = dao;
    }



    @RequestMapping(method = RequestMethod.POST, value = "/save-item", produces = "text/plain")
    @ResponseBody
    public String saveOrder(){
       Item item = new Item();
       dao.save(item);
       return "ok";
    }

    /*@RequestMapping(method = RequestMethod.PUT, value = "/transferFile", produces = "text/plain")
    @ResponseBody
    public String transferFile(@RequestParam long fromId, @RequestParam long toId, @RequestParam long id) throws InternalServerError, BadRequestException {
        try {
            return fileService.transferFile(fromId,toId,id);
        } catch (BadRequestException e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/transferAll", produces = "text/plain")
    @ResponseBody
    public String transferAll(@RequestParam Long fromId,@RequestParam Long toId) throws InternalServerError, BadRequestException {
        try {
            return storageService.transferAll(fromId,toId).toString();
        } catch (BadRequestException e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }*/

    /*@RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    @ResponseBody
    public String delete(@RequestParam Long id) throws Exception {
        String message;
        try {
            fileService.delete(id);
            message = "Item with id :"+id+" is deleted.";
            return message;
        } catch (BadRequestException e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }*/

   /* private File mapToFile(HttpServletRequest req) throws BadRequestException {
        try {
            return mapper.readValue(
                    mapper.writeValueAsString(mapper.readTree(req.getInputStream()).path("file")),
                    new TypeReference<File>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            throw new BadRequestException("Internal server error");
        }
    }*/
}




