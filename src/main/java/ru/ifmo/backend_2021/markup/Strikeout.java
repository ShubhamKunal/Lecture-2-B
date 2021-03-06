package ru.ifmo.backend_2021.markup;

import java.util.List;

public class Strikeout extends Markup{
  @Override
  public StringBuilder toMarkdown(StringBuilder in) {
    return in;
  }

  public Strikeout(List<Markup> list) {
  }
}
