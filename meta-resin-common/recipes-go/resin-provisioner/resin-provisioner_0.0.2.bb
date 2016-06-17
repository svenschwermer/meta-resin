DESCRIPTION = "Resin Provisioner"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${RESIN_COREBASE}/COPYING.Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "coreos-systemd-go-dbus gorilla-mux"

SRC_URI = "git://github.com/resin-os/resin-provisioner;protocol=https;destsuffix=${PN}-${PV}/src/${GO_IMPORT}"
SRCREV = "d3aed1c9203e3c9fc1fdf610dabe4f18bb332e42"

inherit resin-go
GO_IMPORT = "github.com/resin-os/resin-provisioner"

# There is a bash script in the sources
RDEPENDS_${PN}-staticdev = "bash"
