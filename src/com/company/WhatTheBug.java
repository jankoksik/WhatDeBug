/**
 * @author N0pe
 * @version 1.0.0
 */
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WhatTheBug {

    /**
     * text colors
     */
    public enum color {
        red, green, blue, black, yellow, purple, cyan, white, rainbowRand, rainbowSeq

    }

    /**
     * print out some data like errors etc
     */
    public static <T> void log(String Title, T data)
    {
        System.out.println();
        System.out.println("+" + getTable(Title.length()+6, '-') + "+");
        System.out.println("|   "+ Title+"   |");
        System.out.println("+" + getTable(Title.length()+6, '-')+ "+");
        System.out.println("| ");
        System.out.println("| "+data);
        System.out.println("| ");
        System.out.println();
    }
    /**
     * print out some data from ArrayList
     */
    public static <T> void log(String Title, ArrayList<T> data)
    {
        System.out.println();
        System.out.println("+" + getTable(Title.length()+6, '-') + "+");
        System.out.println("|   "+ Title+"   |");
        System.out.println("+" + getTable(Title.length()+6, '-')+ "+");
        System.out.println("| ");
        for(T element : data)
        {
            System.out.println("| "+element);
        }
        System.out.println("| ");
        System.out.println();
    }
    private static String getTable(int tyt, char character){
        String x = "";
        for(int i = 0; i<tyt; i++)
        {
            x+=character;
        }
        return x;
    }
    /**
     * print 2d table
     * where every new array inside an array is a new row
     */
    private static void table(String[][] input_data)
    {
        int rowmax =  Arrays.stream(input_data).map(row -> row.length).max(Integer::compare).get();
        String[][] Data = new String[input_data.length][rowmax];
        String[][] Datacc = input_data.clone();
        int yc =0;

        for(String y[] : input_data ) {
            int xc =0;
            for(String x : y)
            {
                String text = "";

                text = Datacc[yc][xc].replace("\u001B[0m","");
                text = text.replace("\u001B[30m","");
                text = text.replace("\u001B[31m","");
                text = text.replace("\u001B[32m","");
                text = text.replace("\u001B[33m","");
                text = text.replace("\u001B[34m","");
                text = text.replace("\u001B[35m","");
                text = text.replace("\u001B[36m","");
                text = text.replace("\u001B[37m","");
                Data[yc][xc] = text;


                xc++;
            }
            yc+=1;
        }
        char leftUp = '╔';
        char vertical = '║';
        char rightUp = '╗';
        char rightDown = '╝';
        char horizontal = '═';
        char leftDown = '╚';
        char cross = '╬';
        char rightWing = '╠';
        char DownWing = '╦';
        char leftWing = '╣';
        char upWing = '╩';

        int maxx = 0;
        for(String y[] : Data )
        {
            int currx = 0;
            int columnsc = 0;
            boolean pszy = true;
            for(String x : y)
            {
                if(x!= null) {
                    if (pszy) {
                        pszy = false;
                        currx += 4;
                        currx += x.length();
                    } else {
                        currx += x.length() + 3;
                    }
                }

            }

            if(currx > maxx)
                maxx = currx;

        }

        String line ="";
        String linec = "";


        line+=leftUp;
        for (String x : Data[0]) {
            if(x == null){continue;}
            for (int i = 0; i < x.length() + 2; i++) {
                line+=horizontal;
            }
            line+=DownWing;
        }
        line = line.substring(0,line.length() - 1);
        while(line.length() < maxx-1)
        {
            line+=horizontal;
        }
        line+= rightUp;
        System.out.println(line);
        line = "";
        String OLdLine = "";


        int calscy = -1;
        for(String y[] : Data)
        {
            calscy +=1;
            int calcx = 0;
            for(String x : y)
            {
                if(x!= null) {
                    line+=vertical + " ";
                    line+= x;
                    line += " ";

                    linec += vertical + " ";
                    linec += input_data[calscy][calcx];
                    linec += " ";

                    calcx++;
                }
            }

            while(line.length() < maxx-1)
            {
                line+=" ";
                linec +=" ";
            }

            if(OLdLine!=""){
                String przerywnik ="";
                przerywnik += rightWing;
                int k=1;
                while(przerywnik.length() <maxx-1)
                {

                    if(line.charAt(k)==vertical && OLdLine.charAt(k)==vertical)
                    {
                        przerywnik += cross;
                    }
                    else if(line.charAt(k)==vertical)
                    {
                        przerywnik+= DownWing;
                    }
                    else if(OLdLine.charAt(k)==vertical)
                    {
                        przerywnik += upWing;
                    }
                    else {
                        przerywnik += horizontal;
                    }


                    k+=1;
                }
                przerywnik += leftWing;

                System.out.println(przerywnik);
            }



            OLdLine  = line;

            line+=vertical;
            linec +=vertical;
            System.out.println(linec);
            linec = "";
            line = "";
        }





        line+=leftDown;
        for (String x : Data[Data.length-1]) {
            if(x==null){continue;}
            for (int i = 0; i < x.length() + 2; i++) {
                line+=horizontal;
            }
            line+=upWing;
        }
        line = line.substring(0,line.length() - 1);
        while(line.length() < maxx-1)
        {
            line+=horizontal;
        }
        line+= rightDown;
        System.out.println(line);




    }
    /**
     * Generate some colored text
     */
    public static String coloredText(String text, color Color) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        String ending = "";
        switch (Color) {
            case rainbowRand:
                ArrayList<String> rainbowColors = new ArrayList<String>();
                rainbowColors.add("\u001B[31m");
                rainbowColors.add("\u001B[32m");
                rainbowColors.add("\u001B[33m");
                rainbowColors.add("\u001B[34m");
                rainbowColors.add("\u001B[35m");
                rainbowColors.add("\u001B[36m");
                Random rand = new Random();
                char[] t = text.toCharArray();
                String fin = "";
                for(char s : t){
                    int randomElementIndex =  rand.nextInt(rainbowColors.size());
                    ending = rainbowColors.get(randomElementIndex);
                    fin += ending + s ;
                }
                fin += ANSI_RESET;
                return fin;
            case rainbowSeq:
                ArrayList<String> rainbowColor = new ArrayList<String>();
                rainbowColor.add("\u001B[31m");
                rainbowColor.add("\u001B[32m");
                rainbowColor.add("\u001B[33m");
                rainbowColor.add("\u001B[34m");
                rainbowColor.add("\u001B[35m");
                rainbowColor.add("\u001B[36m");
                char[] ar = text.toCharArray();
                String res = "";
                int iter = 0;
                for(char s : ar){
                    ending = rainbowColor.get(iter);
                    iter+=1;
                    if(iter>rainbowColor.size()-1)
                        iter=0;
                    res += ending + s ;
                }
                res += ANSI_RESET;
                return res;
            case red:
                ending = ANSI_RED;
                break;
            case green:
                ending = ANSI_GREEN;
                break;
            case blue:
                ending = ANSI_BLUE;
                break;
            case yellow:
                ending = ANSI_YELLOW;
                break;
            case black:
                ending = ANSI_BLACK;
                break;
            case purple:
                ending = ANSI_PURPLE;
                break;
            case cyan:
                ending = ANSI_CYAN;
                break;
            case white:
                ending = ANSI_WHITE;
                break;
            default:
                ending = ANSI_WHITE;
                break;


        }
        return  ending + text + ANSI_RESET;
    }

    public static void main(String[] Args){
        table(new String[][]{{coloredText("Hello there", color.rainbowSeq), "!"}, {"I am a sample table "}, {"as you can ","see","I am "+coloredText("rly", color.red)+" easy to use"}}); ;

        ProgressBar pb = new ProgressBar();
        pb.setFilledColor(color.blue);
        pb.setBlankColor(color.black);
        String text = "Sample progressbar";
        pb.setSize(text.length());
        table(new String[][] {{text}, {pb.GetDraw(4.0)}});

        pb.setSize(10);
        pb.setFilledColor(color.green);
        Table x = new Table();
        x.flatTable(new String[][] {{"Loadning ..."}, {pb.GetDraw(7.0) + " 70%"}});
        Table c = new Table();
        c.flatTable(new String[][] {{"Some Data", "x"}, {"Product quantity", coloredText("44", color.cyan)}, {"Generated raports", coloredText("412", color.cyan)}, {"Vm's running", coloredText("5", color.cyan)}, {"Carrots sold", coloredText("2134", color.cyan)}, {"it can be null"}} );
        Table v = new Table();
        v.flatTable(new String[][] {{"many \n label \n table", "example", "to \n see result"}});
        System.out.print("\n");
        CheckList cl = new CheckList();

        cl.setCheckMark('V');
        cl.setUnchecedkMark('X');
        cl.setUncheckedColor(color.red);
        cl.setCheckedColor(color.green);
        cl.setLeftBracket('<');
        cl.setRightBeracket('>');

        cl.setListName("Shopping list");
        cl.add("buy milk");
        cl.add("buy cheese");
        cl.add("buy eggs");
        cl.add("buy butter");
        cl.add("buy ham");

        cl.SetChecked("buy eggs");
        cl.SetChecked(4);

        cl.Draw();
        log("sample log", "sample data");
    }



}









