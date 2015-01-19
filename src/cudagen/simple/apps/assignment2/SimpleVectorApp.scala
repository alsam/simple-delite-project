package ppl.apps.assignment2

import ppl.dsl.assignment2.{SimpleVectorApplicationRunner, SimpleVectorApplication}
import ppl.delite.runtime._

object SimpleVectorAppRunner extends SimpleVectorApplicationRunner with SimpleVectorApp {
  //reifyEffects {
  //  //args = Array("out.deg")
  //  System.out.println("-D- printme")
  //  main()
  //  //execute(scala.Array("out.deg"))
    Config.numCuda = 0
    Delite.embeddedMain(scala.Array("out.deg", "42"), staticDataMap)
  //}
}

trait SimpleVectorApp extends SimpleVectorApplication {

  //ppl.delite.framework.Config.debug = true
  ppl.delite.framework.Config.generateCUDA = true

  def main() {
    val x = Vector[Int](100) + 1
    val y = Vector[Int](100) + 2

    val z = x + y
    z.pprint

    //val f = z.filter
    //f.pprint
    
    //val res = z.sum
    //println(res)
  }
}
