#!/bin/bash
sbt packageBin stage && sudo ./target/universal/stage/bin/event-listener
