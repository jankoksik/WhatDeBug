package com.company;

import java.util.ArrayList;
import java.util.Map;

public class Table {
   private int[] LineCount; //number of text lines in each row
   private int[] maxchar; //max character at each column
   private String[][] array;

    private char leftUp = '╔';
    private char vertical = '║';
    private char rightUp = '╗';
    private char rightDown = '╝';
    private char horizontal = '═';
    private char leftDown = '╚';
    private char cross = '╬';
    private char rightWing = '╠';
    private char DownWing = '╦';
    private char leftWing = '╣';
    private char upWing = '╩';

    public Table(){
        array = new String[1][1];
        array[0][0]="";
    }
    public Table(int columns,int rows){
        array = new String[columns][rows];
        for(int i=0; i<columns; i++)
            for(int c=0; c<rows; c++)
                array[i][c]="";

    }

    /**
     *  generate table with even columns
     *  you can use mutiline here :)
     *  its for lazy people to use insted of
     *  Table t = new Table();
     *  t.setContent([...]);
     *  t.draw();
     *
     *  u use
     *  Table t = new Table();
     * t.flatTable([...]);
     *
     * @param input_data
     */
    public void flatTable(String[][] input_data) {
        int LoopCounter = 0;
        int rowCounter = 0;
        int longestRow = 0;
        boolean FRun = true;

        //calculating longest row
        for (String[] input_datum : input_data)
            if (input_datum.length > longestRow)
                longestRow = input_datum.length;

        // get columns width and number of enters
        LineCount = new int[input_data.length];
        maxchar = new int[longestRow];

        int counter1 = 0;
        int counter2 = 0;

        for (String[] y : input_data) {
            for (String x : y) {
                if (x == null) continue;
                String[] spliter = x.split("\n");
                if (LineCount[counter2] < spliter.length) {
                    LineCount[counter2] = spliter.length;
                }
            }
            counter2 += 1;
        }
        // split data to some fancy arrays
        String[][] Data = input_data.clone();
        input_data = Split2dArray(input_data);
        Data = Split2dArray(Data);


        //String[][] Datacc = input_data.clone();


        // replace illegal characters
        int yc = 0;
        for (String[] y : Data) {
            int xc = 0;
            for (String x : y) {

                String text = "";
                if (Data[yc][xc] == null) Data[yc][xc] = "";
                text = Data[yc][xc].replace("\u001B[0m", "");
                text = text.replace("\u001B[30m", "");
                text = text.replace("\u001B[31m", "");
                text = text.replace("\u001B[32m", "");
                text = text.replace("\u001B[33m", "");
                text = text.replace("\u001B[34m", "");
                text = text.replace("\u001B[35m", "");
                text = text.replace("\u001B[36m", "");
                text = text.replace("\u001B[37m", "");

                Data[yc][xc] = text;
                xc++;
            }
            yc += 1;
        }
        for (String[] y : Data) {
            for (String x : y) {
                if (x == null) continue;
                String[] spliter = x.split("\n");
                for (String max : spliter) {
                    if (maxchar[counter1] < max.length()) {
                        maxchar[counter1] = max.length();
                    }
                }

            }
            counter1 += 1;

        }

        // print top border
        String line = "";

        line += leftUp;
        for (int len : maxchar) {
            for (int i = 0; i < len + 2; i++) {
                line += horizontal;
            }
            line += DownWing;
        }
        line = line.substring(0, line.length() - 1);
        line += rightUp;
        System.out.println(line);

        // print content

        for (int c = 0; c < Data[0].length; c++) {
            //break line
            if (!FRun) {
                LoopCounter += 1;
                if (LoopCounter == LineCount[rowCounter]) {
                    rowCounter += 1;
                    String breakLine = "";
                    breakLine += rightWing;
                    for (int h : maxchar) {
                        for (int o = 0; o < h + 2; o++) {
                            breakLine += horizontal;
                        }
                        breakLine += cross;
                    }
                    breakLine = breakLine.substring(0, breakLine.length() - 1);
                    breakLine += leftWing;
                    System.out.println(breakLine);
                    LoopCounter = 0;
                }
            }
            FRun = false;
            //print proper content
            line = "";
            for (int i = 0; i < Data.length; i++) {
                line += vertical;
                int calc = (maxchar[i] - Data[i][c].length() + 1) / 2;
                for (int sp = 0; sp <= calc; sp++) {
                    line += " ";
                }
                line += (input_data[i][c] != null) ? input_data[i][c] : "";

                for (int cp = 0; cp <= maxchar[i] - Data[i][c].length() - calc; cp++) {
                    line += " ";
                }

            }
            line += vertical;
            System.out.println(line);


        }

        // bottom border
        line = "";
        line += leftDown;
        for (int len : maxchar) {
            for (int i = 0; i < len + 2; i++) {
                line += horizontal;
            }
            line += upWing;
        }
        line = line.substring(0, line.length() - 1);
        line += rightDown;
        System.out.println(line);

    }

    private static int getColumnWidth(String[][] input_data, int col) {
        int max = 0;
        for (int i = 0; i < input_data.length; i++) {
            if (input_data[i][col] != null && input_data[i][col].length() > max) {
                max = input_data[i][col].length();
            }
        }
        return max;
    }
    private static String[][] Split2dArray(String[][] array) {
        int longestRow = 0;
        int returnState = 0;
        int saveReturnState = 0;
        for (int row = 0; row < array.length; row++)
            if (array[row].length > longestRow)
                longestRow = array[row].length;
        String[][] cleanArray = new String[longestRow][CalcHight(array)];

        for (String[] line : array) {
            int row = 0;
            for (String cell : line) {
                int lineNmbr = returnState;
                if (cell == null) continue;
                for (String splited : cell.split("\n")) {
                    cleanArray[row][lineNmbr] = splited;
                    lineNmbr += 1;
                    if (lineNmbr > saveReturnState)
                        saveReturnState = lineNmbr;
                }
                row += 1;

            }
            //row+=1;
            returnState = saveReturnState;
        }

        return cleanArray;
    }
    private static int CalcHight(String[][] array) {
        ArrayList<Integer> hights = new ArrayList<>();
        int index = 0;
        for (String[] line : array) {
            for (String cell : line) {
                if (cell == null) continue;
                for (String splited : cell.split("\n")) {
                    if (hights.size() > index) {
                        hights.add(index, hights.get(index) + 1);
                        hights.remove(index + 1);
                    } else
                        hights.add(index, 1);


                }
                index += 1;
            }
            index = 0;
        }
        int max = 0;
        for (int x : hights) {
            if (x > max)
                max = x;
        }
        return max;
    }

    /**
     * get back to default table style
     */
    public void DefaultStyle() {
        leftUp = '╔';
        vertical = '║';
        rightUp = '╗';
        rightDown = '╝';
        horizontal = '═';
        leftDown = '╚';
        cross = '╬';
        rightWing = '╠';
        DownWing = '╦';
        leftWing = '╣';
        upWing = '╩';

    }

    /**
     *  generate all table using only one character
     * @param character
     */
    public void ChangeStyleForOneCharacter(char character) {
        leftUp = character;
        vertical = character;
        rightUp = character;
        rightDown = character;
        horizontal = character;
        leftDown = character;
        cross = character;
        rightWing = character;
        DownWing = character;
        leftWing = character;
        upWing = character;
    }

    /**
     *  single line style [+ , -, |]
     */
    public void SingleLineStyle() {
        leftUp = '+';
        vertical = '|';
        rightUp = '+';
        rightDown = '+';
        horizontal = '-';
        leftDown = '+';
        cross = '+';
        rightWing = '+';
        DownWing = '+';
        leftWing = '+';
        upWing = '+';
    }

    /**
     * set your own style
     * @param leftUp
     */
    public void setLeftUpCorner(char leftUp) {
        this.leftUp = leftUp;
    }
    /**
     * set your own style
     *
     */
    public void setVertical(char vertical) {
        this.vertical = vertical;
    }
    /**
     * set your own style
     *
     */
    public void setRightUpCorner(char rightUp) {
        this.rightUp = rightUp;
    }

    /**
     * set your own style
     *
     */
    public void setRightDownCorner(char rightDown) {
        this.rightDown = rightDown;
    }

    /**
     * set your own style
     *
     */
    public void setHorizontal(char horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * set your own style
     *
     */
    public void setLeftDownCorner(char leftDown) {
        this.leftDown = leftDown;
    }

    /**
     * set your own style
     *
     */
    public void setCross(char cross) {
        this.cross = cross;
    }

    /**
     * set your own style
     *
     */
    public void setRightWing(char rightWing) {
        this.rightWing = rightWing;
    }

    /**
     * set your own style
     *
     */
    public void setDownWing(char downWing) {
        DownWing = downWing;
    }

    /**
     * set your own style
     *
     */
    public void setLeftWing(char leftWing) {
        this.leftWing = leftWing;
    }

    /**
     * set your own style
     *
     */
    public void setUpWing(char upWing) {
        this.upWing = upWing;
    }

    /**
     * draw content
     */
    public void Draw(){
        flatTable(array);
    }

    private int getMaxLengthOfArrayRows(){
        int max= 0;
        for(String[] x : array)
        {
            if(max < x.length)
            {
                max = x.length;
            }
        }
        return max;
    }

    private void extendArrayRows(String[] row){
        int getNewLength = Math.max(row.length, getMaxLengthOfArrayRows());
        int getNewHight = array.length + 1;

        String[][] newArray = new String[getNewHight][getNewLength];

        for(int y=0; y<array.length; y++){
            for(int x=0; x<getMaxLengthOfArrayRows(); x++){
                if(array[y][x] == null)continue;
                newArray[y][x] = array[y][x];
            }
        }
        for(int c=0; c<row.length; c++){
            newArray[getNewHight-1][c] = row[c];
        }
        array = newArray;
    }

    private void extendArrayColumn(String[] Col){
        int getNewLength = getMaxLengthOfArrayRows()+1;
        int getNewHight = Math.max(array.length, Col.length) ;

        String[][] newArray = new String[getNewHight][getNewLength];

        for(int y=0; y<array.length; y++){
            for(int x=0; x<getMaxLengthOfArrayRows(); x++){
                if(array[y][x] == null)continue;
                newArray[y][x] = array[y][x];
            }
        }
        for(int c=0; c<Col.length; c++){
            newArray[c][getNewLength-1] = Col[c];
        }
        for(int t=1; t<= getNewHight - array.length; t++) {
            for (int z = 0; z < getNewLength-1; z++) {
                newArray[getNewHight - t][z] = "";
            }
        }
        array = newArray;
    }

    /**
     * add row at the bottom of the table
     * @param row
     */
    public void addRow(String[] row){
        extendArrayRows(row);
    }

    /**
     * add column at the end of table
     * @param col
     */
    public void addColumn(String[] col){
        extendArrayColumn(col);
    }

    /**
     * set content of table (much faster than extending table)
     * @param content
     */
    public void setContent(String [][] content)
    {
        array = content;
    }

    /**
     * edit cell of table
     * @param column starts from 0
     * @param row starts from 0
     * @param text new content
     * @return returns if operation was succesfull
     */
    public boolean edit(int column, int row, String text){
        if(column < array.length && row < getMaxLengthOfArrayRows()) {
            array[column][row] = text;
            return true;
        }
        return false;
    }

    public static void main(String[] Args) {
        //Table t = new Table();
        //t.flatTable(new String[][]{{"many\nlabel\ntable", "example", "to \n see result"}, {"new row \n check", "to see what can \n happen"}});
//
        //Table tb = new Table();
        //tb.ChangeStyleForOneCharacter('.');
        //tb.flatTable(new String[][]{{"Some Data", "x"}, {"Product quantity", WhatTheBug.coloredText("44", WhatTheBug.color.cyan)}, {"Generated raports", WhatTheBug.coloredText("412", WhatTheBug.color.cyan)}, {"Vm's running", WhatTheBug.coloredText("5", WhatTheBug.color.cyan)}, {"Carrots sold", WhatTheBug.coloredText("2134", WhatTheBug.color.cyan)}, {"it can be null"}});
//
        //Table tx = new Table();
        //tx.SingleLineStyle();
        //tx.flatTable(new String[][]{{"many \n label \n table", "\n" + WhatTheBug.coloredText("example", WhatTheBug.color.rainbowSeq), "to \n see result"}, {"new row \n check", "to see what can \n happen"}});
        Table t = new Table(4,3);
        t.setContent(new String[][]{{"Some Data", "x"}, {"Product quantity", WhatTheBug.coloredText("44", WhatTheBug.color.cyan)}});
        //t.Draw();
        t.edit(0,1, "edited");
        //t.Draw();
        t.extendArrayRows(new String[] {"some\n"+WhatTheBug.coloredText("cool", WhatTheBug.color.purple)+"\ndata", "yes\nplz"});
       // t.Draw();
        t.extendArrayColumn(new String[] {"new col", "hope", "it", "works!"});
        t.Draw();



    }


}
