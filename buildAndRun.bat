@echo off
call mvn clean package
call docker build -t br.edu.ifsul.carro/SistemaCarro .
call docker rm -f SistemaCarro
call docker run -d -p 9080:9080 -p 9443:9443 --name SistemaCarro br.edu.ifsul.carro/SistemaCarro