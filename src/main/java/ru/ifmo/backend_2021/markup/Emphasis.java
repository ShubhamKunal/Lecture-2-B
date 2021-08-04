package ru.ifmo.backend_2021.markup;
import java.util.*;
public class Emphasis extends Text implements TT{
    String text;
    private List<TT> list;
    public Emphasis(List<TT> objArr){
        this.list = objArr;
    }
    public StringBuilder toMarkdown(StringBuilder sb) {
        sb.append('*');
        this.list.forEach(t -> t.toMarkdown(sb));
        sb.append('*');
        return sb;
    }
}