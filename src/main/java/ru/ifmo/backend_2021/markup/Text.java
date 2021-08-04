package ru.ifmo.backend_2021.markup;
public class Text implements TT{
    String text;
    public Text(){
        this.text = "";
    }
    public Text(String str){
        this.text = str;
    }
    public void setText(String str) {
        this.text = str;
    }
    public StringBuilder toMarkdown(StringBuilder sb) {
        return sb.append(this.text);
    }
}