SUMMARY = "Custom welcome script with system info"
SECTION = "base"
LICENSE = "CLOSED"
SRC_URI = "file://welcome-script.sh"

do_install() {
    install -d ${D}/etc/profile.d
    install -m 0755 ${WORKDIR}/welcome-script.sh ${D}/etc/profile.d/welcome-script.sh
}

FILES:${PN} += "/etc/profile.d/welcome-script.sh"

