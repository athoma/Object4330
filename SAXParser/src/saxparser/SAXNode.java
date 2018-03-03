/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author athomaperry
 */
public class SAXNode {
    private String key;
    private String string = "";
    private Map<String, List<SAXNode>> properties;
    private Map<String, String> attributes;
    
    public SAXNode() {}
    
    public SAXNode(String key, String value, Map<String, List<SAXNode>> properties) {
        this(key);
        this.string = value;
        this.properties = properties;
    }
    
    public void addProperty(String name, SAXNode node) {
        if(properties == null) {
            properties = new HashMap<String, List<SAXNode>>();
        }
        properties.putIfAbsent(name, new ArrayList<SAXNode>());
        properties.get(name).add(node);
    }
    
    public void deleteProperty(String name) {
        if(properties == null) {
            return;
        }
        properties.remove(name);
    }
    
    public boolean propertyExists(String name) {
        if (properties == null){
            return false;
        }
        return this.properties.containsKey(name);
    }
    
    public Map<String,String> getAttributes() {
        return attributes;
    }
    
    public int getAttributesLength() {
        return attributes.size();
    }
    
    public SAXNode(String key) {
        this.key = key;
        this.attributes = new HashMap<>();
    }
    
    public List<SAXNode> getProperty(String name) {
        return properties.get(name);
    }
    
    public Map<String, List<SAXNode>> getProperties() {
        return properties;
    }
    
    public void setAttributes(String key, String value) {
        this.attributes.put(key, value);
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getValue() {
        return string;
    }
    
    public void setValue(String value) {
        this.string = value;
    }
}

