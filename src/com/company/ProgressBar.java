package com.company;

public class ProgressBar {
    double CurrentValue = 0;
    double MaxValue = 10.0;
    int size = 10;
    char FilledCharacter = '█';
    char BlankCharacter = '░';
    WhatTheBug.color FilledColor =  WhatTheBug.color.white;
    WhatTheBug.color BlankColor =  WhatTheBug.color.white;



    public double getCurrentValue() {
        return CurrentValue;
    }

    public void setCurrentValue(double currentValue) {
        CurrentValue = currentValue;
    }

    public double getMaxValue() {
        return MaxValue;
    }

    public void setMaxValue(double maxValue) {
        MaxValue = maxValue;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char getFilledCharacter() {
        return FilledCharacter;
    }

    public void setFilledCharacter(char filledCharacter) {
        FilledCharacter = filledCharacter;
    }

    public char getBlankCharacter() {
        return BlankCharacter;
    }

    public void setBlankCharacter(char blankCharacter) {
        BlankCharacter = blankCharacter;
    }

    public WhatTheBug.color getFilledColor() {
        return FilledColor;
    }

    public void setFilledColor( WhatTheBug.color filledColor) {
        FilledColor = filledColor;
    }

    public  WhatTheBug.color getBlankColor() {
        return BlankColor;
    }

    public void setBlankColor( WhatTheBug.color blankColor) {
        BlankColor = blankColor;
    }

    public String GetDraw(){
        String result = "";
        if(getCurrentValue() > getMaxValue()){
            setCurrentValue(MaxValue);
        }
        double passer = getSize()/getMaxValue();
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

    public String GetDraw(double currentValue){
        CurrentValue = currentValue;
        return GetDraw();
    }
    public void Draw(){
    System.out.print(GetDraw());
    }
    public void Draw(double currentValue){
        System.out.print(GetDraw(currentValue));
    }


}
