#!/bin/sh
### BEGIN INIT INFO
# Provides:          setup_user
# Required-Start:    
# Required-Stop:     
# Default-Start:     S
# Default-Stop:
# Short-Description: Create the accessctl user to exec chromium
### END INIT INFO

echo "Creating the new user accessctl"

if ! id "accessctl" >/dev/null 2>&1; then
    adduser -D -h /home/accessctl -s /bin/sh accessctl
    echo "User accessctl created sucessfully."
else
    echo "User accessctl already exists on the system"
fi
