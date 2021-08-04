package ru.ifmo.backend_2021.markup;
import java.util.*;
public class Paragraph implements TT{
    private List<TT> list;

    public Paragraph(List<TT> objArr){
        this.list = objArr;
    }
    public StringBuilder toMarkdown(StringBuilder sb) {
        this.list.forEach(t -> t.toMarkdown(sb));
        return sb;
    }
}