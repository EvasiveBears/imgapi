#!/bin/bash
out_info=$(nohup java -jar imgapi.jar >dev/null 2>&1 &)
echo "${out_info}"