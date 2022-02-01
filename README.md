
# Selenium-POM-TestNG
# Prerequisites
  1.Install jdk 8 or any LTS version
  
  2.Configure JAVA_HOME and GRADLE_HOME
  
  3.Download Allure 2.17.2 and configure environment path
  
  4.Stable internet connection
  
# How to run this project
 1.Clone the repo
 
 2.Open cmd in the root folder
 
 3.Give following commands:
   
   
   
   
   
   gradle clean test
   
   allure generate allure-results --clean -o allure-report
   
   allure serve allure-results
   
   
   
   
   
![TestNG](https://user-images.githubusercontent.com/61241763/151925779-d58995f7-2a76-4c74-a672-7ba8dee2aa33.PNG)
