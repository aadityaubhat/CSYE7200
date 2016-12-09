package edu.neu.coe.cyse7200

import scala.collection.mutable
import scala.io.Source
import scala.util.Try

/**
  *
  * @param customerCode Unique code for Customer
  * @param age Customer's age
  * @param sex Customer's gender
  * @param income Customer's income
  * @param segment Customer Segment VIP, Individual, College Graduated
  * @param customerType CustomerType Primary, Co-owner, Potential
  * @param customerAddress Customer's Address Profile
  * @param bankProfile Customer's Bank Profile
  */


case class Customer(customerCode: Int, age: Int, sex: String, income:Double, segment: Int, customerType: Int, customerAddress: Address, bankProfile: BankProfile)


/**
  *
  * @param primaryAddress Customer's Primary Address
  * @param country Customer's Country
  * @param provinceName Customer's Province Name
  * @param provinceCode Customer's Province Code
  * @param residenceIndex Customer's Residence Index
  * @param foreignIndex Customer's Foreign Index
  */
case class Address(primaryAddress:Boolean, country:String, provinceName:String, provinceCode:Int, residenceIndex:Boolean, foreignIndex:Boolean ){
  override def toString: String = s"$primaryAddress,$country,$provinceName,$provinceCode,$residenceIndex,$foreignIndex"
}

/**
  *
  * @param newIndex Customer New Index
  * @param joinDate Joining Date of Customer
  * @param seniority Customer's Seniority
  * @param employeeIndex Customer's Employee Index
  * @param employeeSpouseIndex Customer's Employee Spouse Index
  */
case class BankProfile(newIndex:Boolean, joinDate:String, seniority:Int, employeeIndex:Boolean, employeeSpouseIndex:Boolean) {
  override def toString: String = s"$newIndex, $joinDate, $seniority, $employeeIndex, $employeeSpouseIndex"
}


object Customer extends App{

  def apply(splitRow: Seq[String]): Customer = {
    //customerCode: Int, age: Int, sex: Char, income:Double, segment: Int, customerType: Int, customerAddress: Address, bankProfile: BankProfile
    val customerCode = splitRow(1).replace(" ", "").toInt
    val age = splitRow(5).replace(" ", "").toInt
    val sex = splitRow(4)
    val income = splitRow(22).replace(" ","").toDouble
    val segment = splitRow(23).split("-")(0).replace(" ", "").toInt
    val customerType = splitRow(23).replace(" ","").toInt
    //primaryAddress:Boolean, country:String, provinceName:String, provinceCode:Int, residenceIndex:String, foreignIndex:String
    val customerAddress = Address(Seq(splitRow(18),splitRow(3),splitRow(20),splitRow(19),splitRow(13), splitRow(14)))
    //newIndex:Boolean, joinDate:String, seniority:Int, employeeIndex:Boolean, employeeSpouseIndex:Boolean
    val bankProfile = BankProfile(Seq(splitRow(7),splitRow(6),splitRow(8),splitRow(2),splitRow(15)))

    Customer(customerCode, age, sex, income, segment, customerType, customerAddress, bankProfile)
  }

  trait IngestibleCustomer extends Ingestible[Customer]{
    def fromString(row: String): Try[Customer] = {
      // To-do use regex
      Try(Customer(row.split(""",(?=([^\"]*\"[^\"]*\")*[^\"]*$)""")))
    }

  }
}

object Address{
  def apply(params: Seq[String]): Address = {
    params match {
      case primaryAddress :: country :: provinceName :: provinceCode :: residenceIndex :: foreignIndex :: Nil=>
                                apply( {if(primaryAddress.replace(" ","").toInt == 1) true else false},
                                  country, provinceName,
                                  provinceCode.replace(" ", "").toInt,
                                  {residenceIndex.replace(" ","").toUpperCase() match {case "S" => true case _ => false}},
                                  {foreignIndex.replace(" ","").toUpperCase match  {case "S" => true case _ => false}})
      case _ => throw new Exception(s"parse error in Name: $this")
    }
  }
}

object BankProfile{
  def apply(params: Seq[String]): BankProfile = {
    params match {
      case newIndex :: joinDate :: seniority :: employeeIndex :: employeeSpouseIndex :: Nil =>
        apply({if(newIndex.replace(" ","").toInt == 1) true else false},
          joinDate, seniority.replace(" ","").toInt,
          {if(employeeIndex.replace(" ", "").toInt == 1) true else false},
          {if (employeeSpouseIndex.replace(" ", "").toInt == 1) true else false})
      case _ => throw new Exception(s"parse error in Name: $this")
    }
  }
}