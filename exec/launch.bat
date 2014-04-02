@ECHO OFF
color 8f
@echo Loading...
@echo:
java -jar chem-tools-v0.7-alpha.jar
@echo:
@echo Quitting...
ping 192.0.2.1 -n 1 -w 5000 >nul