package lv.sa1nt.requestvalidator.parser

import scala.util.parsing.json._

class RequestParserJson extends JSON {
  def request = rep1(componentCall);
  def componentCall = "*S*" ~> componentName ~ callArgs <~ "*E*";
  def componentName = ident;
  def callArgs = jsonObj;
}
