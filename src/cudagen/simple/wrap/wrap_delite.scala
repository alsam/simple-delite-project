package ppl.dsl.wrap_delite

import java.io.PrintWriter
import scala.virtualization.lms.common._
import scala.reflect.{SourceContext, RefinedManifest}
import scala.virtualization.lms.internal.{GenerationFailedException, GenericFatCodegen}
import ppl.delite.framework.ops._
import ppl.delite.framework.Util._
import ppl.delite.framework.Config
import scala.collection.mutable.HashSet

import ppl.delite.framework.datastructures._

trait MyCudaGenDeliteArrayOps extends CudaGenDeliteArrayOps {
  import IR._
  
  System.out.println("-D- called OUTSIDE MyCudaGenDeliteArrayOps")

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = {
    System.out.println("-D- called MyCudaGenDeliteArrayOps.emitNode")
    System.out.println("-D- now call CudaGenDeliteArrayOps.emitNode")

    super.emitNode(sym, rhs)
  }

  override def initializeGenerator(buildDir:String, args: Array[String]): Unit = {

    System.out.println("-D- called MyCudaGenDeliteArrayOps.initializeGenerator for buildDir: " + buildDir)
    System.out.println("-D- now call CudaCodegen.initializeGenerator")

    super.initializeGenerator(buildDir, args)
  }

  override def emitSource[A : Manifest](args: List[Sym[_]], body: Block[A], className: String, out: PrintWriter) = {

    System.out.println("-D- called MyCudaGenDeliteArrayOps.emitSource for class: " + className)
    System.out.println("-D- now call CudaCodegen.emitSource")

    super.emitSource(args, body, className, out)
  }

}
