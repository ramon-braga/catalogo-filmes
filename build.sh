#!/bin/bash
apt-get update -y
apt-get install -y maven
mvn clean install