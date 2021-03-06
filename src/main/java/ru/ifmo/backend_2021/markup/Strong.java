package ru.ifmo.backend_2021.markup;

import java.util.List;

public class Strong extends Markup{
  @Override
  public StringBuilder toMarkdown(StringBuilder in) {
    return in;
  }

  public Strong(List<Markup> list) {
  }
}
