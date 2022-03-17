package com.example.task12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Component
public class HashFile {
    private File in;
    private File out;

    @PostConstruct
    public void postConstruct() throws IOException, NoSuchAlgorithmException {
        System.out.println("In postConstruct method");
        PrintWriter printWriter = new PrintWriter(new FileWriter(out));
        if (in == null) {
            System.out.println("Print null to out");
            printWriter.println("null");
            printWriter.close();
        } else {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(in));
            while (true) {
                String line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                    System.out.println(line);
                }
                else break;
            }
            byte[] encodedhash;
            for (String line : lines) {
                encodedhash = digest.digest(
                        line.getBytes(StandardCharsets.UTF_8));
                printWriter.print(encodedhash);
            }
            printWriter.close();
        }
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("In preDestroy method");
//        if (in != null) in.delete();
        System.out.println(in.getName() + " " + out.getName());
    }

    @Value("${in:}")
    public void setIn(String in) {
        System.out.println("Set in");
        if (in.length() != 0) this.in = new File(in);
    }

    @Value("${out}")
    public void setOut(String out) {
        System.out.println("Set out");
        this.out = new File(out);
    }

}
