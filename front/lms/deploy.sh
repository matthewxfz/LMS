#!/bin/bash
sudo nohup bash -c "sudo node bin/www &> /var/log/lms/lms.out" &
