package org.json.assignment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJson {
    public static <User> void main(String[] args) {
        try{
            ObjectMapper objmapper=new ObjectMapper();
            JsonNode rootNode=objmapper.readTree(new File("C:\\bridgelabz-workspace\\IOProgrammingJava\\src\\main\\java\\org\\json\\assignment\\Jsonfile.json"));

            for(JsonNode node:rootNode){
                String name=node.get("name").asText();
                String email=node.get("email").asText();
                System.out.println("Name :"+name+" ----> "+" Email "+email);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
