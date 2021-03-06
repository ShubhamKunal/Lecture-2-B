package ru.ifmo.backend_2021.markup;

import java.util.List;

public class Paragraph extends Markup{
  @Override
  public StringBuilder toMarkdown(StringBuilder in) {
    return in;
  }

  public Paragraph(List<Markup> list) {
  }
}
