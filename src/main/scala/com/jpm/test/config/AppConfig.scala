package com.jpm.test.config
import com.typesafe.config.{Config, ConfigFactory}

// class to read App configuration
case class AppConfig(input: String,
                     testData: String,
                     ngram:Int)

object AppConfig {

  // Apply method to read the values from config file
  def apply(): AppConfig = {
    val conf: Config = ConfigFactory.load().resolve().getConfig("app")

    AppConfig(conf.getString("input"), conf.getString("test_data"),conf.getInt("ngram"))
  }
}