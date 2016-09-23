#!/bin/bash

args=""
for arg in $@
do
    args="${args} ${arg}"
done

javac Test1.java

java Test1 $args

