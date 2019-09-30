#!/usr/bing/env groovy

node('master') {
	echo "----------------------start git url----------------------"
    //checkout scm
  //git url: 'https://gitee.com/roclli/simple-maven-project-with-tests.git'
  git url: 'https://github.com/huangwenl/test.git'
	echo "----------------------version()----------------------"
  def v = version()
  if (v) {
      echo "---Building version ${v}---"
    }
  def mvnHome = tool 'mvn_home'
     echo "----------------------mvn -B -D verify----------------------"
  sh "${mvnHome}/bin/mvn -B -Dmaven.test.failure.ignore verify"
}

def version() {
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    echo "---${matcher[0][1]}---"   //---1.0-SNAPSHOT---
    echo "---${matcher[0][2]}---"   //---null---
    echo "---${matcher[0][3]}---"   //---null---
    echo "---${matcher[1][1]}---"   //---2.18.1---
    echo "---${matcher[1][2]}---"   //---null---
    echo "---${matcher[1][3]}---"   //---null---
    echo "---${matcher[2][1]}---"   //---4.11---
    echo "---${matcher[2][2]}---"   //---null---
    echo "---${matcher[2][3]}---"   //---null---
    matcher ? matcher[0][1] : null
}
