#!/bin/bash
javac com/sunsunsoft/MyPackage3/MyCalc.java
javac com/sunsunsoft/MyPackage3/AAA/Hoge2.java
javac com/sunsunsoft/MyPackage3/BBB/Hoge3.java

jar cf SunSunSoft.jar com
cp SunSunSoft.jar ~/Library/Java/Extensions
