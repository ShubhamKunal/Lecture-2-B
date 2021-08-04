package ru.ifmo.backend_2021.markup;
import java.util.*;
public class Strikeout extends Text implements TT{
    private List<TT> list;
    public Strikeout(List<TT> objArr){
        this.list = objArr;
    }
    public StringBuilder toMarkdown(StringBuilder sb) {
        sb.append('~');
        this.list.forEach(t -> t.toMarkdown(sb));
        sb.append('~');
        return sb;
    }
}