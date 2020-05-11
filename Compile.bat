@Echo OFF
cd /d %~dp0
javac -cp classes/ -d classes/ src/exceptions/*.java
javac -cp classes/ -d classes/ src/validations/*.java
javac -cp classes/ -d classes/ src/processor/*.java
javac -cp classes/ -d classes/ src/data/*.java
javac -cp classes/ -d classes/ src/login/*.java
javac -cp classes/ -d classes/ src/main/*.java