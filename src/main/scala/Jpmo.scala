package com.jpm.test

import com.jpm.test.config.AppConfig

object Jpmo extends App {

  val config: AppConfig = AppConfig()
  val input = config.input
  val testData = config.testData
  val length = config.ngram

  val ngram = util.generateNGram(input,length)
  val filteredData = util.filterList(ngram,testData)
  util.getProbability(filteredData,filteredData.length).foreach(println)
}
