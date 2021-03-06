package ru.ifmo.backend_2021


object MarkupTestGenerator extends App {
  def generate(depth: Int): String = {
    val tree = GenParagraph(getTree(depth))
    s"""  test("test depth $depth") {
       |    val s = new java.lang.StringBuilder
       |    val tree = ${tree.code}
       |    assert(tree.toMarkdown(s).toString == "${tree.result}")
       |  }
       |""".stripMargin
  }
  def randomWord: String = {
    val chars = 'a' to 'z'
    val sb = new StringBuilder
    for (_ <- 1 to 3) {
      val randomNum = util.Random.nextInt(chars.length)
      sb.append(chars(randomNum))
    }
    sb.toString
  }

  def getTree(depth: Int): List[GenMarkupNode] =
    if (depth == 0) GenText(randomWord) :: Nil
    else {
      (for (_ <- 1 to util.Random.nextInt(depth) + 1) yield
        util.Random.nextInt(5) match {
          case 0 => GenParagraph(getTree(depth - 1))
          case 1 => GenStrong(getTree(depth - 1))
          case 2 => GenEmphasis(getTree(depth - 1))
          case 3 => GenStrikeout(getTree(depth - 1))
          case 4 => GenText(randomWord)
        }).toList
    }

  for (i <- 1 to 7) println(generate(i))

}

trait GenMarkupNode {
  def result: String
  def code: String
}

trait GenMarkupNodeWithChildren extends GenMarkupNode {
  def symbol: String
  def className: String
  def children: List[GenMarkupNode]
  def result: String = s"$symbol${children.map(_.result).mkString("")}$symbol"
  def code: String = s"$className(util.List.of(${children.map(_.code).mkString(",")}))"
}

case class GenParagraph(children: List[GenMarkupNode]) extends GenMarkupNodeWithChildren {
  def symbol: String = ""
  def className: String = "new Paragraph"
}

case class GenStrong(children: List[GenMarkupNode]) extends GenMarkupNodeWithChildren {
  def symbol: String = "__"
  def className: String = "new Strong"
}

case class GenEmphasis(children: List[GenMarkupNode]) extends GenMarkupNodeWithChildren {
  def symbol: String = "*"
  def className: String = "new Emphasis"
}

case class GenStrikeout(children: List[GenMarkupNode]) extends GenMarkupNodeWithChildren {
  def symbol: String = "~"
  def className: String = "new Strikeout"
}

case class GenText(result: String) extends GenMarkupNode {
  def code: String = s"""new Text("$result")"""
}
