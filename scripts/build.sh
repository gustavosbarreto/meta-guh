#!/bin/sh

set -e

. setup-environment build
bitbake guh-image
