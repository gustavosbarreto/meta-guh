SUMMARY = "guhd - IoT server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=c4ad0859102867dd32a276d78a480826"

DEPENDS += "qttools-native qtbase qtwebsockets qtconnectivity qtserialport"

SRCREV = "e0873f786f17dfb709b5391144738af4a87e415a"
SRC_URI = " \
    git://github.com/guh/guh;protocol=https \
    file://0001-Use-binaries-from-qttools-native.patch \
"

S = "${WORKDIR}/git"

inherit qmake5 update-rc.d

do_configure_prepend() {
    sed -e "s,\$\$system('dpkg-architecture -q DEB_HOST_MULTIARCH'),," \
        -i ${S}/guh.pri \
        -i ${S}/libguh/libguh.pro
}

do_compile_prepend() {
    export PATH=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}:$PATH
}

do_install_append() {
    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${S}/data/init/guhd ${D}/${sysconfdir}/init.d/guhd
}

EXTRA_QMAKEVARS_PRE += " \
    PREFIX=${prefix} \
    CONFIG+=disabletesting \
"

INITSCRIPT_NAME = "guhd"
INITSCRIPT_PARAMS = "start 99 5 2 ."

FILES_${PN} += "\
    ${libdir}/guh/plugins \
"