@echo off
cls
chcp 65001

cd src
javac loadbalancer/*.java
echo finish compile.

cmd /c START java loadbalancer/Server 6001
cmd /c START java loadbalancer/Server 6002
cmd /c START java loadbalancer/Server 6003
cmd /c START java loadbalancer/Server 6004

cmd /c START java loadbalancer/Loadbalancer
cmd /c START java loadbalancer/EchoClient
cmd /c START java loadbalancer/EchoClient
cmd /c START java loadbalancer/EchoClient
cmd /c START java loadbalancer/EchoClient
cmd /c START java loadbalancer/EchoClient
cmd /c START java loadbalancer/EchoClient


echo.
pause