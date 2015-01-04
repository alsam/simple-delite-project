package my.delite.framework.codegen.cuda

import my.delite.framework.codegen.MyTarget

trait MyTargetCuda extends MyTarget {
  import IR._

  val name = "Cuda"
}
