package ru.ifmo.backend_2021.markup;

import java.util.List;

public class Emphasis extends Markup{
  @Override
  public StringBuilder toMarkdown(StringBuilder in) {
    return in;
  }

  public Emphasis(List<Markup> list) {
  }
}
