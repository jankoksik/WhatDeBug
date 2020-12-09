package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckList {
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Integer> checked = new ArrayList<>();
    private String listName = "list";
    private char CheckMark = 'X';
    private char UnchecedkMark = ' ';
    private char rightBeracket = ']';
    private char leftBracket = '[';
    private boolean SpaceBetweenMarkAndBracket = false;
    private WhatTheBug.color CheckedColor = WhatTheBug.color.white;
    private WhatTheBug.color UncheckedColor = WhatTheBug.color.white;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public char getCheckMark() {
        return CheckMark;
    }

    public void setCheckMark(char checkMark) {
        CheckMark = checkMark;
    }

    public char getRightBeracket() {
        return rightBeracket;
    }

    public void setRightBeracket(char rightBeracket) {
        this.rightBeracket = rightBeracket;
    }

    public char getLeftBracket() {
        return leftBracket;
    }

    public void setLeftBracket(char leftBracket) {
        this.leftBracket = leftBracket;
    }

    public char getUnchecedkMark() {
        return UnchecedkMark;
    }

    public void setUnchecedkMark(char unchecedkMark) {
        UnchecedkMark = unchecedkMark;
    }

    public boolean isSpaceBetweenMarkAndBracket() {
        return SpaceBetweenMarkAndBracket;
    }

    public void setSpaceBetweenMarkAndBracket(boolean spaceBetweenMarkAndBracket) {
        SpaceBetweenMarkAndBracket = spaceBetweenMarkAndBracket;
    }

    public WhatTheBug.color getCheckedColor() {
        return CheckedColor;
    }

    public void setCheckedColor(WhatTheBug.color checkedColor) {
        CheckedColor = checkedColor;
    }

    public WhatTheBug.color getUncheckedColor() {
        return UncheckedColor;
    }

    public void setUncheckedColor(WhatTheBug.color uncheckedColor) {
        UncheckedColor = uncheckedColor;
    }

    public void add(String element)
    {
        list.add(element);
    }
    public void SetChecked(String element)
    {
        checked.add(list.indexOf(element));
    }
    public void SetChecked(int id)
    {
        checked.add(id);
    }
    public void Draw(){
        System.out.print(listName + "  : \n\n");
        for(String elements : list)
        {
            boolean ch = (checked.contains(list.indexOf(elements)));
            System.out.println("    " + leftBracket +  (isSpaceBetweenMarkAndBracket() ? " " : "" ) +  (ch ? WhatTheBug.coloredText("" + getCheckMark(),getCheckedColor() ) : WhatTheBug.coloredText("" + getUnchecedkMark(),getUncheckedColor() ) ) + (isSpaceBetweenMarkAndBracket() ? " " : "" ) +rightBeracket +  "  " + elements  );

        }

    }


}
