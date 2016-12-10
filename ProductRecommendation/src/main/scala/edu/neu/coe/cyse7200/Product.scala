package edu.neu.coe.cyse7200


/**
  *Product class contains product profile for a customer at a given date, the records are updated monthly.
  * @param customercode Unique Customer ID
  * @param date Date for the record
  * @param savingAcc savings account
  * @param gaurantees gaurantees
  * @param currentAcc current Account
  * @param derivedAcc derived account
  * @param payrollAcc payroll account
  * @param juniorAcc  junior account
  * @param moreParticularAcc more particular account
  * @param particularAcc particular account
  * @param particularPlusAccion particular plus account
  * @param shorttermDeposit shortterm deposit
  * @param medtermDeposit medium term deposits
  * @param longtermDeposit long term deposits
  * @param eAccount e-Account
  * @param funds funds
  * @param mortgage mortgage
  * @param pensionPlan plan pension
  * @param loan loan
  * @param taxes taxes
  * @param creditCard credit card
  * @param securities securities
  * @param homeAcc home account
  * @param payrollNomina nominal payroll
  * @param pensionNomina nominal pension
  * @param directDebit direct debit
  */


case class Product(customercode:Int,date:String, savingAcc:Boolean, gaurantees:Boolean, currentAcc:Boolean, derivedAcc:Boolean, payrollAcc:Boolean, juniorAcc:Boolean, moreParticularAcc:Boolean, particularAcc:Boolean, particularPlusAccion:Boolean, shorttermDeposit:Boolean, medtermDeposit:Boolean, longtermDeposit:Boolean, eAccount:Boolean, funds:Boolean, mortgage:Boolean, pensionPlan:Boolean, loan:Boolean, taxes:Boolean, creditCard:Boolean, securities:Boolean, homeAcc:Boolean, payrollNomina:String, pensionNomina:String, directDebit:Boolean){
  override def toString: String = s"$customercode,$date,$savingAcc,$gaurantees,$currentAcc,$derivedAcc,$payrollAcc,$juniorAcc,$moreParticularAcc,$particularAcc,$particularPlusAccion,$shorttermDeposit,$medtermDeposit,$longtermDeposit,$eAccount,$funds,$mortgage,$pensionPlan,$loan,$taxes,$creditCard,$securities,$homeAcc,$payrollNomina,$pensionNomina,$directDebit"
}

object Product extends App{

  def intToBool(num: Int):Boolean = num match {
    case 1 => true
    case 0 => false
    case _ => throw new Exception()
  }

  def apply(splitRow:Seq[String]):Product={

    val date = splitRow(0).replace(" ","")

    val customerCode = splitRow(1).replace(" ","").toInt

    val savingAcc = intToBool (splitRow(24).replace(" ","").toInt)
    val gaurantees=intToBool(splitRow(25).replace(" ","").toInt)
    val currentAcc=intToBool(splitRow(26).replace(" ","").toInt)
    val derivedAcc=intToBool (splitRow(27).replace(" ","").toInt)
    val payrollAcc=intToBool (splitRow(28).replace(" ","").toInt)
    val juniorAcc=intToBool (splitRow(29).replace(" ","").toInt)
    val moreParticularAcc= intToBool (splitRow(30).replace(" ","").toInt)
    val particularAcc= intToBool (splitRow(31).replace(" ","").toInt)
    val particularPlusAccion= intToBool (splitRow(32).replace(" ","").toInt)
    val shorttermDeposit= intToBool (splitRow(33).replace(" ","").toInt)
    val medtermDeposit= intToBool (splitRow(34).replace(" ","").toInt)
    val longtermDeposit= intToBool (splitRow(35).replace(" ","").toInt)
    val eAccount= intToBool (splitRow(36).replace(" ","").toInt)
    val funds= intToBool (splitRow(37).replace(" ","").toInt)
    val mortgage= intToBool (splitRow(38).replace(" ","").toInt)
    val pensionPlan= intToBool (splitRow(39).replace(" ","").toInt)
    val loan= intToBool (splitRow(40).replace(" ","").toInt)
    val taxes= intToBool (splitRow(41).replace(" ","").toInt)
    val creditCard= intToBool (splitRow(42).replace(" ","").toInt)
    val securities= intToBool (splitRow(43).replace(" ","").toInt)
    val homeAcc= intToBool(splitRow(44).replace(" ","").toInt)
    val payrollNomina= splitRow(45).replace(" ","")
    val pensionNomina= splitRow(46).replace(" ","")
    val directDebit= intToBool(splitRow(47).replace(" ","").toInt)

    Product(customerCode, date, savingAcc,gaurantees,currentAcc,derivedAcc,payrollAcc,juniorAcc,moreParticularAcc,particularAcc,particularPlusAccion,shorttermDeposit,medtermDeposit,longtermDeposit,eAccount,funds,mortgage,pensionPlan,loan,taxes,creditCard,securities,homeAcc,payrollNomina,pensionNomina,directDebit)

  }
}

