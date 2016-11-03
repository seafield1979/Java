#!/bin/bash

# 引数を文字列形式に変換する
# $1=100 $2=200 $3=300 の場合 "100 200 300"になる
args=""
for arg in $@
do
    args="${args} ${arg}"
done

case $1 in
  "basic" ) 
    javac TestBasic.java
    java TestBasic $args
    ;;
  "array" )
    javac TestArray.java
    java TestArray $args
    ;;
  "string" )
    javac TestString.java
    java TestString1 $args
    ;;
  "class" )
    javac -encoding UTF-8 TestClass.java
    java TestClass $args
    ;;
  "interface" ) 
    javac TestImport.java
    java TestImport $args
    ;;
  "exception" )
    javac TestException.java
    java TestException $args
    ;;
  "thread" )
    javac TestThread.java
    java TestThread $args
    ;;
  "file" ) 
    javac TestFile.java
    java TestFile $args
    ;;
  "collection" ) 
    javac TestCollection.java
    java TestCollection $args
    ;;
  "enum" )
    javac TestEnum.java
    java TestEnum $args
    ;;
  "time" )
    javac TestTime.java
    java TestTime $args
    ;;
  "callback" )
    javac TestCallback.java
    java TestCallback $args
    ;;
  "math" )
    javac TestMath.java
    java TestMath $args
    ;;

esac





