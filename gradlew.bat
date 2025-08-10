@echo off
set JAVA_HOME=%JAVA_HOME%
if "%JAVA_HOME%"=="" set JAVA_HOME=%~dp0..\jdk
set GRADLE_HOME=%~dp0gradle
"%GRADLE_HOME%\bin\gradle.bat" %*
