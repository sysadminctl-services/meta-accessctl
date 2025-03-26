#!/bin/sh

### BEGIN INIT INFO
# Provides:          start_chromium
# Required-Start:    $local_fs $network
# Should-Start:      $syslog
# Default-Start:     2 3 4 5
# Default-Stop:
# Short-Description: Start Chromium at boot
### END INIT INFO

case "$1" in
  start)
    # Start Chromium as user 'accessctl' in fullscreen mode
    su - accessctl -c "chromium --no-sandbox --kiosk https://sysadminctl.services"
    ;;
  stop)
    # Stop Chromium if needed (this is optional)
    pkill chromium
    ;;
  *)
    echo "Usage: /etc/init.d/start_chromium {start|stop}"
    exit 1
esac

exit 0
