#!/usr/bin/env bash

set -e

fswatch -e ".*" -i "\\.kt$" src | xargs -n1 -o sh -c "./test-commit.sh"
