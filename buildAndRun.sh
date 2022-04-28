#!/bin/sh
mvn clean package && docker build -t br.edu.ifsul.carro/SistemaCarro .
docker rm -f SistemaCarro || true && docker run -d -p 9080:9080 -p 9443:9443 --name SistemaCarro br.edu.ifsul.carro/SistemaCarro