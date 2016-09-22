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
esac





