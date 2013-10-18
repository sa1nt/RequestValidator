package lv.sa1nt.requestvalidator.parser

import scala.util.parsing.combinator._
// import scala.util.parsing.json._

class RequestParserJTP extends JavaTokenParsers {
  def request = rep1(componentCall);
  def componentCall = "*S*" ~> componentName ~ callArgs <~ "*E*";
  def componentName = stringLiteral;
  def callArgs = stringLiteral;
}
