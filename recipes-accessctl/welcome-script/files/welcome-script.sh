#!/bin/sh
echo ""
echo "==============================================="
echo "            SYSTEM INFORMATION"
echo "==============================================="
echo "Hostname:   $(hostname)"
echo "Kernel:     $(uname -r)"
echo "CPU:        $(grep 'model name' /proc/cpuinfo | head -1 | cut -d ':' -f2 | sed 's/^ *//')"
echo "Memory:    $(free -m | awk '/Mem:/ {print $2}') MB"
echo "Storage: $(df -h / | awk 'NR==2 {print $2}') total"


IP_ADDRESS=$(ip -4 addr show | grep 'inet ' | grep -v '127.0.0.1' | awk '{print $2}' | cut -d '/' -f1)
echo "IP Address: ${IP_ADDRESS}"


LEASES_FILE="/var/lib/misc/udhcpd.leases"
if [ -f "$LEASES_FILE" ]; then
    echo "DHCP Leases:"
    awk '{print "  " $3}' $LEASES_FILE
else
    echo "No DHCP leases."
fi

echo "==============================================="

