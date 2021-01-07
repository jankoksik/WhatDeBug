package com.company;

import java.util.ArrayList;

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

    /**
     * get name of list
     * @return
     */
    public String getListName() {
        return listName;
    }

    /**
     * set name of list
     * @param listName
     */
    public void setListName(String listName) {
        this.listName = listName;
    }

    /**
     *  get character of checked elements of the list
     * @return
     */
    public char getCheckMark() {
        return CheckMark;
    }
    /**
     *  set character of checked elements of the list
     * @return
     */
    public void setCheckMark(char checkMark) {
        CheckMark = checkMark;
    }

    /**
     * get right bracket of mark of the list
     * @return
     */
    public char getRightBeracket() {
        return rightBeracket;
    }
    /**
     * set right bracket of mark of the list
     *
     */
    public void setRightBeracket(char rightBeracket) {
        this.rightBeracket = rightBeracket;
    }
    /**
     * get left bracket of mark of the list
     * @return
     */
    public char getLeftBracket() {
        return leftBracket;
    }
    /**
     * set right bracket of mark of the list
     *
     */
    public void setLeftBracket(char leftBracket) {
        this.leftBracket = leftBracket;
    }
    /**
     *  get character of unchecked elements of the list
     * @return
     */
    public char getUnchecedkMark() {
        return UnchecedkMark;
    }
    /**
     *  set character of unchecked elements of the list
     * @return
     */
    public void setUnchecedkMark(char unchecedkMark) {
        UnchecedkMark = unchecedkMark;
    }
    /**
     * is it set to place a space between mark and bracket ?
     *  eg. [ V ] vs [V]
     * @return
     */
    public boolean isSpaceBetweenMarkAndBracket() {
        return SpaceBetweenMarkAndBracket;
    }
    /**
     *  do u want a space between mark and bracket ?
     *  eg. [ V ] vs [V]
     * @return
     */
    public void setSpaceBetweenMarkAndBracket(boolean spaceBetweenMarkAndBracket) {
        SpaceBetweenMarkAndBracket = spaceBetweenMarkAndBracket;
    }

    /**
     *  get color of check mark
     * @return
     */

    public WhatTheBug.color getCheckedColor() {
        return CheckedColor;
    }

    /**
     * set color of check mark
     * @param checkedColor
     */
    public void setCheckedColor(WhatTheBug.color checkedColor) {
        CheckedColor = checkedColor;
    }

    /**
     * get color of unchecked mark
     * @return
     */
    public WhatTheBug.color getUncheckedColor() {
        return UncheckedColor;
    }

    /**
     * set color of unset mark
     * @param uncheckedColor
     */
    public void setUncheckedColor(WhatTheBug.color uncheckedColor) {
        UncheckedColor = uncheckedColor;
    }

    /**
     *  add element to list
     * @param element
     */
    public void add(String element)
    {
        list.add(element);
    }

    /**
     * set element as checked
     * @param element
     */
    public void SetChecked(String element)
    {
        checked.add(list.indexOf(element));
    }

    /**
     * set element as checked by id
     * @param id
     */
    public void SetChecked(int id)
    {
        checked.add(id);
    }

    /**
     * Draw checklist
     */
    public void Draw(){
        System.out.print(listName + "  : \n\n");
        for(String elements : list)
        {
            boolean ch = (checked.contains(list.indexOf(elements)));
            System.out.println("    " + leftBracket +  (isSpaceBetweenMarkAndBracket() ? " " : "" ) +  (ch ? WhatTheBug.coloredText("" + getCheckMark(),getCheckedColor() ) : WhatTheBug.coloredText("" + getUnchecedkMark(),getUncheckedColor() ) ) + (isSpaceBetweenMarkAndBracket() ? " " : "" ) +rightBeracket +  "  " + elements  );

        }

    }

    /**
     * check if element is checked by id
     * @param id
     * @return
     */
    public boolean isChecked(int id)
    {
        return checked.contains(id);
    }

    /**
     * check if element is checked by String
     * @param element
     * @return
     */
    public boolean isChecked(String element)
    {
        return checked.contains(list.indexOf(element));
    }

    /**
     * uncheck element by id
     * @param id
     */
    public void uncheck(int id){
        checked.remove(id);
    }
    /**
     * uncheck element by String
     * @param element
     */
    public void uncheck(String element){
        checked.remove(checked.indexOf(element));
    }




}
