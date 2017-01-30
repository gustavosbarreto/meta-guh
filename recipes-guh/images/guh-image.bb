SUMMARY = "guhIO Image"

inherit core-image
inherit extrausers

SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += "splash"

EXTRA_USERS_PARAMS = "usermod -P root root;"

QT = " \
    qtbase \
    qtbase-plugins \
    qtbase-tools \
"

RPI_STUFF = " \
    bcm2835-tests \
    wiringpi \
    rpio \
    rpi-gpio \
    pi-blaster \
    userland \
"

IMAGE_INSTALL += " \
    kernel-modules \
    ca-certificates \
    guhd \
    guh-webinterface \
    ${QT} \
    ${RPI_STUFF} \
    ${CORE_IMAGE_BASE_INSTALL} \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

IMAGE_FEATURES += "\
    ssh-server-dropbear \
    hwcodecs \
"
