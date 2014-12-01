package com.corejsf;

import java.util.List;

import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceRef;

import com.corejsf.amazon.AWSECommerceService;
import com.corejsf.amazon.AWSECommerceServicePortType;
import com.corejsf.amazon.Item;
import com.corejsf.amazon.ItemSearchRequest;
import com.corejsf.amazon.Items;

public class AuthorSearchBean {
   @WebServiceRef(wsdlLocation
="http://webservices.amazon.com/AWSECommerceService/AWSECommerceService.wsdl")
   private AWSECommerceService service;
   
   private String name;
   private List<Item> response;
   private String accessKey;

   public String getName() { return name; }
   public void setName(String newValue) { name = newValue; }

   public void setAccessKey(String newValue) { accessKey = newValue; }

   public String search() {
      try {         
         AWSECommerceServicePortType port = service.getAWSECommerceServicePort();

         ItemSearchRequest request = new ItemSearchRequest();
         request.getResponseGroup().add("ItemAttributes");
         request.setSearchIndex("Books");
         request.setAuthor(name);
         
         Holder<List<Items>> responseHolder = new Holder<List<Items>>();         
         port.itemSearch("", accessKey, "", "", "", "", request, null, null, 
               responseHolder);
         response=responseHolder.value.get(0).getItem();
         
         return "success";
       } catch(Exception e) {
          e.printStackTrace();
          return "failure";
       }       
   }

   public List<Item> getResponse() { return response; }
}
