package com.jpm.test

import com.jpm.test.config.AppConfig

object Jpmo extends App {

  val config: AppConfig = AppConfig()
  val input = config.input
  val testData = config.testData
  val length = config.ngram

  // get the N-Gram for given data.
  val ngram = util.generateNGram(input,length)

  //filter out required N-Gram values.
  val filteredData = util.filterList(ngram,testData)

  //Generate probobility and sort the values then print them.
  util.getProbability(filteredData,filteredData.length).foreach(println)
}
