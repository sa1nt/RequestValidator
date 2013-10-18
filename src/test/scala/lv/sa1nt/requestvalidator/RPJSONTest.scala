package lv.sa1nt.requestvalidator

import org.junit.Test
import lv.sa1nt.requestvalidator.parser.RequestParserJson
import org.junit.Assert._

class RPJSONTest {
    val singleCall = """ *S* "componentName1" "callArgs1" *E* """;
    val doubleCall = singleCall + """ *S* "componentName2" "callArgs2" *E*  """;
   
    @Test 
    def testRequestParserDouble() : Unit = {
      val p = new RequestParserJson
      
      p.parseFull(p.request, doubleCall) match {
        case p.Success(r, _) => {
            println(r.toString);
            assertEquals(r.toString, """List(("componentName1"~"callArgs1"), ("componentName2"~"callArgs2"))""");
        }
        case x => fail(x.toString)
      }    
    }

    @Test 
    def testRequestParserSingle() : Unit = {
      val p = new RequestParserJson
      
      p.parseFull(p.request, singleCall) match {
        case p.Success(r, _) => {
            println(r.toString);
            assertEquals(r.toString, """List(("componentName1"~"callArgs1"))""");
        }
        case x => fail(x.toString)
      }    
    }
    
    @Test 
    def testRequestParserEmpty() : Unit = {
      val p = new RequestParserJson
      val input = """  """;
      
      p.parseFull(p.request, input) match {
        case p.Success(r, _) => fail(r.toString)
        case x => {
            println(x.toString);
            assert(true);
        }
      }    
    }

}
