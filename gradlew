#!/bin/sh
#
# Gradle Wrapper script
#
set -e
export JAVA_HOME="${JAVA_HOME:-$(dirname $0)/../jdk}"
exec "$(dirname $0)/gradle/wrapper/gradle-wrapper.jar" "$@"
