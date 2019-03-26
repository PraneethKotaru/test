package com.jpm.test
import scala.collection.immutable.ListMap

object util {

  def cleanInput(input:String)={
    input.replaceAll( "[^a-zA-Z0-9 \n]","")
  }

  def generateNGram(words:String,ngram:Int) ={
    cleanInput(words).split("[ \n]").sliding(ngram).map(x => {x(0) -> x.drop(1).mkString(" ")} ).toList
  }

  def filterList(list: List[(String,String)], testData:String) = {
    list.filter(x=>{ x._1==testData}).map{x=>(x._2 )}
  }

  def getProbability(list: List[String], length:Int) = {
    val map=list.groupBy(identity).mapValues(_.size).map(x => (x._1,x._2.toDouble/length))
    ListMap(map.toSeq.sortWith(_._2 > _._2):_*)
  }
}
