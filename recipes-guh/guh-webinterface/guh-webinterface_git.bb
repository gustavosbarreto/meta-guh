SUMMARY = "guh-webinterface"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1483ce9ce8d1f2f47a9dab293100ea91"

DEPENDS += "bower-native gulp-cli-native"

SRCREV = "797001933b27206309bbf52b7e6fd28b24bcd3e5"
SRC_URI = "git://github.com/guh/guh-webinterface;protocol=https"

inherit gulp bower-install

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${datadir}/guh-webinterface/public
    cp -rf dist/* ${D}${datadir}/guh-webinterface/public
}

FILES_${PN} += "${datadir}/guh-webinterface"
