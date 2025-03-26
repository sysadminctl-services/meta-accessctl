SUMMARY = "Custom configuration for udhcpd (BusyBox DHCP Server)"
SECTION = "network"
LICENSE = "CLOSED"

# Incluir el paquete `udhcpd` de BusyBox
RDEPENDS:${PN} = "busybox"

SRC_URI = "file://udhcpd.conf \
           file://start-udhcpd"

do_install() {
    install -d ${D}/etc
    install -m 0644 ${WORKDIR}/udhcpd.conf ${D}/etc/udhcpd.conf

    install -d ${D}/etc/init.d
    install -m 0755 ${WORKDIR}/start-udhcpd ${D}/etc/init.d/start-udhcpd

    install -d ${D}/etc/rcS.d
    ln -s /etc/init.d/start-udhcpd ${D}/etc/rcS.d/S97start-udhcpd

    install -d ${D}/var/lib/misc
    touch ${D}/var/lib/misc/udhcpd.leases
    chmod 644 ${D}/var/lib/misc/udhcpd.leases
}

FILES:${PN} += "/etc/udhcpd.conf /etc/init.d/start-udhcpd /etc/rcS.d/S97start-udhcpd"
