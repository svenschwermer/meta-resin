DESCRIPTION = "Balena custom udev rules tool"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${RESIN_COREBASE}/COPYING.Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
    file://balena-custom-udev-rules \
    file://balena-custom-udev-rules.service \
    "
S = "${WORKDIR}"

inherit allarch systemd

SYSTEMD_SERVICE_${PN} = "balena-custom-udev-rules.service"

RDEPENDS_${PN} = " \
    coreutils \
    jq \
    udev \
    "

do_install() {
    install -d ${D}${bindir}
    install -m 0775 ${WORKDIR}/balena-custom-udev-rules ${D}${bindir}

    install -d ${D}${systemd_unitdir}/system
    install -c -m 0644 ${WORKDIR}/balena-custom-udev-rules.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@BASE_BINDIR@,${base_bindir},g' \
        -e 's,@SBINDIR@,${sbindir},g' \
        -e 's,@BINDIR@,${bindir},g' \
        ${D}${systemd_unitdir}/system/*.service
}
