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
    javac test_basic.java
    java TestBasic $args
    ;;
  "string" )
    javac test_string.java
    java TestString1 $args
    ;;
  "class" )
    javac -encoding UTF-8 test_class1.java
    java TestClass $args
    ;;
  "interface" ) 
    javac TestImport.java
    java TestImport $args
    ;;
esac





