#!/bin/bash

# Instalar Maven
apt-get update
apt-get install -y maven

# Build com Maven
mvn clean install