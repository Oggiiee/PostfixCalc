package com.company;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Vad vill du beräkna?");
            String s = sc.nextLine();
            if(s.toLowerCase().equals("q")){
                System.out.println("beräkningarna avslutade.");
                break;
            }else{
                System.out.println("svar = "+Calc(s));
            }
        }
    }


    public static String Calc(String exp) {

        List<String> processedList = new ArrayList<String>();
        if (!exp.isEmpty()) {
            StringTokenizer st = new StringTokenizer(exp);
            while (st.hasMoreTokens()) {
                processedList.add(st.nextToken());
            }
        }

        MyStackList<String> s = new MyStackList<>();
        Iterator<String> iter = processedList.iterator();

        while (iter.hasNext()) {
            String temp = iter.next();
            if (temp.matches("[*-/+]")) {
                double rs = Double.parseDouble(s.pop());
                double ls = Double.parseDouble(s.pop());

                if (temp.equals("*")) {
                    double result = ls * rs;
                    s.push("" + result);
                } else if (temp.equals("-")) {
                    double result = ls - rs;
                    s.push("" + result);
                } else if (temp.equals("/")) {
                    double result = ls / rs;
                    s.push("" + result);
                } else if (temp.equals("+")) {
                    double result = ls + rs;
                    s.push("" + result);
                }
            } else {
                s.push(temp);
            }
        }
        return s.pop();
    }
}