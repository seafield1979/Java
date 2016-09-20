#!/bin/bash
javac Test1.java
javac MyPackage/Hoge.java

# jar cfm RunablePackage.jar MANIFEST.MF RunablePackage
jar cvfm RunablePackage.jar META-INF/MANIFEST.MF Test1.class MyPackage
