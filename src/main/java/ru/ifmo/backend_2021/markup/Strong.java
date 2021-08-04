package ru.ifmo.backend_2021.markup;
import java.util.*;
public class Strong extends Text implements TT{
    private List<TT> list;
    public Strong(List<TT> objArr){
        this.list = objArr;
    }
    public StringBuilder toMarkdown(StringBuilder sb) {
        sb.append("__");
        this.list.forEach(t -> t.toMarkdown(sb));
        sb.append("__");
        return sb;
    }
}