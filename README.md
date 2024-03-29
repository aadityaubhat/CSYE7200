# CSYE7200 Course Project

This repo is for Santander Product Recommendation competition.
The details of the competition can be found at https://www.kaggle.com/c/santander-product-recommendation

The train and test data files can be found at https://www.kaggle.com/c/santander-product-recommendation/data

This repository contains following things

* Data Cleaning - Contains Zeppelin Notebook to clean raw data
* Exploratory Analysis - Contains Zeppelin Notebook with Exploratory Data Analysis
* Model Fitting - Contains Zeppelin Notebook for Model Fitting and provides Product Recommendations
* ProductRecommendation - SBT project to ingest data and create Customer and Product Profile objects
* Project Planning Presentation - Project Proposal ppt
* Final Presentation - Project Conclusion ppt


Notes

Tools Used : Zeppelin Notebooks, IntelliJ Idea

Programming Language : Scala
	
In order to run the zeppelin notebooks on a local machine or cluster, download zeppelin from
https://zeppelin.apache.org/download.html

Configure the interpreters in Zeppelin according to your requirements

Download the Zeppelin Notebooks'json from the Repository and import the json into the installed Zeppelin instance

Download the Data file from Kaggle

Change the Data file location in the imported notebooks

Run the imported notebooks


SBT Project

To run the sbt project, clone the ProductRecommendation project.

Run the sbt clean test

There are 8 test cases in the sbt project.
