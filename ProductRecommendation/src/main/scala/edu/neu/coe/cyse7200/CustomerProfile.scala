package edu.neu.coe.cyse7200

/**
  * This class represents the customer profile from the Santander Product recommendation competition
  * This class includes customer's attributes such as age, address, income, etc
  * This class does not include customer's products
  * Created by aadityabhat on 12/7/16.
  */


case class CustomerProfile(customerCode: BigInt, age:Int, sex:Char,  customerType:Int, customerAddress: Address, bankProfile: BankProfile) {

}


/**
  *
  * @param primaryAddress
  * @param country
  * @param provinceName
  * @param provinceCode
  * @param residenceIndex
  * @param foreignIndex
  */
case class Address(primaryAddress:Boolean, country:String, provinceName:String, provinceCode:Int, residenceIndex:Char, foreignIndex:Char ){

}


case class BankProfile(newIndex:Boolean, joinDate:String, seniority:Int, employeeIndex:Boolean, employeeSpouseIndex:Boolean ){

}