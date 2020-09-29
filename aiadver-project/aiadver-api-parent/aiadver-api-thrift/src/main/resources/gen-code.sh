#!/usr/bin/env bash

thrift --gen java --out ../java asr.thrift
thrift --gen java --out ../java tts.thrift
