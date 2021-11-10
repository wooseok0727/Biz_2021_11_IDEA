package com.wooseok.readbook.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EncryptEx_02 {

    public static void main(String[] args) throws FileNotFoundException {

        String propsFile = "./src/main/webapp/WEB-INF/spring/props/" +
                "db.conn.properties";

        Map<String,String> sysEnvList = System.getenv();

        Set<String> keys = sysEnvList.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + sysEnvList.get(key));
        }

        String salt = sysEnvList.get("wooseok.com");
        System.out.println("시스템 환경변수 : " + salt);

        String driver = "db.driver=com.mysql.cj.jdbc.Driver";
        String url = "db.url=jdbc:mysql://localhost:3306/ReadBookDB";
        Scanner scan = new Scanner(System.in);

        System.out.printf("username : ");
        String username = scan.nextLine();

        System.out.printf("password : ");
        String password = scan.nextLine();

        StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();

        pbe.setAlgorithm("PBEWithMD5andDES");
        pbe.setPassword(salt);

        String encUsername = pbe.encrypt(username);
        String encPassword = pbe.encrypt(password);

        String saveUSername = String.format("db.username=ENC(%s)",encUsername);
        String savePassword = String.format("db.password=ENC(%s)",encPassword);

        PrintWriter out = new PrintWriter(propsFile);
        out.println(driver);
        out.println(url);
        out.println(saveUSername);
        out.println(savePassword);
        out.flush();
        out.close();

        scan.close();
        System.out.println("Properties 파일 생성 완료");
    }
}
