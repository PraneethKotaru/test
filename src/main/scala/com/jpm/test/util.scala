package com.jpm.test
import scala.collection.immutable.ListMap

object util {

  // Clean the input for non alphaNumerics
  def cleanInput(input:String)={
    input.replaceAll( "[^a-zA-Z0-9 \n]","")
  }

  // generate the N-Gram as list for given input
  def generateNGram(words:String,ngram:Int) ={
    cleanInput(words).split("[ \n]").sliding(ngram).map(x => {x(0) -> x.drop(1).mkString(" ")} ).toList
  }

  // filter the list for required N-Gram
  def filterList(list: List[(String,String)], testData:String) = {
    list.filter(x=>{ x._1==testData}).map{x=>(x._2 )}
  }

  // get probability and sort N-Gram with respect to probability.
  def getProbability(list: List[String], length:Int) = {
    val map=list.groupBy(identity).mapValues(_.size).map(x => (x._1,x._2.toDouble/length))
    ListMap(map.toSeq.sortWith(_._2 > _._2):_*)
  }
}
