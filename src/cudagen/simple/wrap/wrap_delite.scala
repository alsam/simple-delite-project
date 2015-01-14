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
    System.out.println("-D- now call from super:  ??CudaGenDeliteArrayOps.emitNode")
    System.out.println("-D- now call from super: " + this.getClass.getName + " ??CudaGenDeliteArrayOps.emitNode")
    System.out.println("-D- sym.pos: " + sym.pos + " sym: " + sym.toString + " rhs: " + rhs.toString)
    //assert(false)

    super.emitNode(sym, rhs)
  }

  override def emitBlock(y: Block[Any]): Unit = {
    System.out.println("-D- called MyCudaGenDeliteArrayOps.emitBlock y: " + y.toString)
    super.emitBlock(y)
  }

  override def traverseStm(stm: Stm) = {
    System.out.println("-D- called MyCudaGenDeliteArrayOps.traverseStm stm: " + stm.toString)
    super.traverseStm(stm)
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

  override def emitKernelHeader(syms: List[Sym[Any]], vals: List[Sym[Any]], vars: List[Sym[Any]], resultType: String, resultIsVar: Boolean, external: Boolean): Unit = {
    System.out.println("-D- called MyCudaGenDeliteArrayOps.emitKernelHeader syms: " + syms.toString + " vals: " + vals.toString)
    super.emitKernelHeader(syms, vals, vars, resultType, resultIsVar, external)
  }

  override def emitKernelFooter(syms: List[Sym[Any]], vals: List[Sym[Any]], vars: List[Sym[Any]], resultType: String, resultIsVar: Boolean, external: Boolean): Unit = {
    System.out.println("-D- called MyCudaGenDeliteArrayOps.emitKernelFooter syms: " + syms.toString + " vals: " + vals.toString)
    super.emitKernelFooter(syms, vals, vars, resultType, resultIsVar, external)
  }

  // Initializer
  //def finalizeGenerator(): Unit = {}

  override def kernelInit(syms: List[Sym[Any]], vals: List[Sym[Any]], vars: List[Sym[Any]], resultIsVar: Boolean): Unit = {
    System.out.println("-D- called MyCudaGenDeliteArrayOps.kernelInit syms: " + syms.toString + " vals: " + vals.toString)
    super.kernelInit(syms, vals, vars, resultIsVar)
  }


}

trait MyCudaGenDeliteOps extends CudaGenDeliteOps {
  import IR._

  override def emitFatNode(symList: List[Sym[Any]], rhs: FatDef) = {
    System.out.println("-D- called MyCudaGenDeliteOps.emitFatNode symList: " + symList.toString + " rhs: " + rhs.toString)
    super.emitFatNode(symList, rhs)
  }

}
