package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static void Save (String log){
        BufferedWriter writer = null;

        try {
            String filePath = "log.txt";

            writer = new BufferedWriter(new FileWriter(filePath,true));
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            writer.write(""+log+" "+date+"\n");
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (writer != null){
                    writer.close();

                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
