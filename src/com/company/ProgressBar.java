package com.company;

public class ProgressBar {
   private double CurrentValue = 0;
   private double MaxValue = 10.0;
   private int size = 10;
   private char FilledCharacter = '█';
   private char BlankCharacter = '░';
   private WhatTheBug.color FilledColor =  WhatTheBug.color.white;
   private WhatTheBug.color BlankColor =  WhatTheBug.color.white;


    /**
     * get current value of progressbar
     * @return
     */
    public double getCurrentValue() {
        return CurrentValue;
    }

    /**
     * set current value
     * @param currentValue
     */
    public void setCurrentValue(double currentValue) {
        CurrentValue = currentValue;
    }

    /**
     * get max value [100% on progress bar]
     * @return
     */
    public double getMaxValue() {
        return MaxValue;
    }

    /**
     * set max value [100% on progress bar]
     * @param maxValue
     */
    public void setMaxValue(double maxValue) {
        MaxValue = maxValue;
    }

    /**
     * get size of progressbar [in characters]
     * eg. HH.. <- progress bar of 4
     * @return
     */
    public int getSize() {
        return size;
    }
    /**
     * set size of progressbar [in characters]
     * eg. HH.. <- progress bar of 4
     * @return
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * get a character that will represent completed part of progressbar
     * @return
     */
    public char getFilledCharacter() {
        return FilledCharacter;
    }
    /**
     * set a character that will represent completed part of progressbar
     * @return
     */
    public void setFilledCharacter(char filledCharacter) {
        FilledCharacter = filledCharacter;
    }
    /**
     * get a character that will represent not completed part of progressbar
     * @return
     */
    public char getBlankCharacter() {
        return BlankCharacter;
    }
    /**
     * set a character that will represent not completed part of progressbar
     * @return
     */
    public void setBlankCharacter(char blankCharacter) {
        BlankCharacter = blankCharacter;
    }

    /**
     * get color of progressbar character that will represent completed part of progressbar
     * @return
     */
    public WhatTheBug.color getFilledColor() {
        return FilledColor;
    }
    /**
     * set color of progressbar character that will represent completed part of progressbar
     * @return
     */
    public void setFilledColor( WhatTheBug.color filledColor) {
        FilledColor = filledColor;
    }
    /**
     * get color of progressbar character that will represent not completed part of progressbar
     * @return
     */
    public  WhatTheBug.color getBlankColor() {
        return BlankColor;
    }
    /**
     * set color of progressbar character that will represent not completed part of progressbar
     * @return
     */
    public void setBlankColor( WhatTheBug.color blankColor) {
        BlankColor = blankColor;
    }

    /**
     * get string representation of progressbar
     * @return
     */
    public String GetDraw(){
        String result = "";
        if(getCurrentValue() > getMaxValue()){
            setCurrentValue(MaxValue);
        }
        double passer = getMaxValue()/getSize();
        int currentState = (int)(Math.floor(getCurrentValue() / passer));
        String part1="";
        for(int i=0; i< currentState; i++)
        {
            part1+= getFilledCharacter();
        }
        result = WhatTheBug.coloredText(part1, getFilledColor());
        part1="";
        for(int i=0; i< getSize()-currentState; i++)
        {
           part1 += getBlankCharacter();
        }
        result += WhatTheBug.coloredText(part1, getBlankColor());
        return result;
    }

    /**
     * get string representation of progressbar
     * @param currentValue
     * @return
     */
    public String GetDraw(double currentValue){
        CurrentValue = currentValue;
        return GetDraw();
    }

    /**
     * draw progressbar on screen (println)
     */
    public void Draw(){
    System.out.print(GetDraw());
    }
    /**
     * draw progressbar on screen (println)
     */
    public void Draw(double currentValue){
        System.out.print(GetDraw(currentValue));
    }


}
