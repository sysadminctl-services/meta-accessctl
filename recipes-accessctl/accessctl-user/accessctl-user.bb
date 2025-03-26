SUMMARY = "Creates the accessctl user and starts Chromium on boot"
DESCRIPTION = "Script to add the accessctl user and start Chromium at boot."
LICENSE = "CLOSED"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://setup_user.sh \
            file://start_chromium.sh"

do_install() {
    install -d ${D}/etc/init.d
    install -m 0755 ${WORKDIR}/setup_user.sh ${D}/etc/init.d/setup_user
    install -m 0755 ${WORKDIR}/start_chromium.sh ${D}/etc/init.d/start_chromium
}

do_postinst() {
    /etc/init.d/setup_user
    update-rc.d start_chromium defaults
}

FILES:${PN} += "/etc/init.d/start_chromium"
FILES:${PN} += "/etc/init.d/setup_user"
