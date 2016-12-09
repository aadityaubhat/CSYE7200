package edu.neu.coe.cyse7200


import org.scalatest.{FlatSpec, Matchers}

class CustomerSpec extends FlatSpec with Matchers {
  behavior of "Address"

  it should "work for Seq[String]" in {
    Address(Seq(" 1", "USA", "MA", "21", "S  ", "N  ")) should matchPattern {
      case Address(true, "USA", "MA", 21, true, false) =>
    }
  }
}