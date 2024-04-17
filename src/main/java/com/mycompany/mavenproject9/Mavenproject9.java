package com.mycompany.mavenproject9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class Mavenproject9 {

    public static void main(String[] args) {
        
//         УПРАЖНЕНИЕ №1  !!!

//        System.out.println("Practical task 2.2, Student Budrik Sophia, RIBO-04-22, Variant 4");
//        System.out.println("Start program!");
//        String server = "https://www.mirea.ru/";
//        HTTPRunnable hTTPRunnable = new HTTPRunnable(server, null);
//        Thread th = new Thread(hTTPRunnable);
//        th.start();
//        try{
//            th.join();
//        }catch(InterruptedException ex){
//            
//        }finally{
//            try{
//                FileWriter fw = new FileWriter("D:\\resp.html");
//                fw.write(hTTPRunnable.getResponseBody());
//                fw.close();
//                System.out.println("Success save response from server: " + server);
//            }catch(IOException ex){
//                System.out.println("Error response saving: " + ex.getMessage());
//            }
//            }

        // УПРАЖНЕНИЕ №2    !!!
        
       System.out.println("Practical task 2.2, Student Budrik Sophia, RIBO-04-22, Variant 4");
       System.out.println("Start program!");
       String server = "https://android-for-students.ru";
       String serverPath = "/materials/practical/hello.php";
       HashMap<String, String> map = new HashMap();
       map.put("name", "Budrik Sophia");
       map.put("group", "RIBO-04-22");
       HTTPRunnable1 httpRunnable = new HTTPRunnable1(server + serverPath, map);
       Thread th = new Thread(httpRunnable);
        th.start();
        try{
            th.join();
        }catch(InterruptedException ex){
            
        }finally{
           JSONObject jSONObject = new JSONObject(httpRunnable.getResponseBody());
           int result = jSONObject.getInt("result_code"); 
           System.out.println("Result: " + result);
           System.out.println("Type: " + jSONObject.getString("message_type"));
           System.out.println("Text: " + jSONObject.getString("message_text"));
           switch(result){
               case 1:
                   JSONArray jSONArray = jSONObject.getJSONArray("task_list");
                   for (int i = 0; i < jSONArray.length(); i++) {
                        System.out.println((i + 1) + ")"  + jSONArray.get(i));
                    }
                    break;
               case 0:
                   System.out.println("type: " + jSONObject.getString("message_type"));
                   System.out.println("text: " + jSONObject.getString("text"));
                   break;
               default:
                   break;
           }
    }
        }
    }


