#!/bin/bash
javac MyPackage3/MyCalc.java
jar cf MyPackage3.jar MyPackage3
cp MyPackage3.jar ~/Library/Java/Extensions
