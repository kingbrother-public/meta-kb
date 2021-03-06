# Copyright 2018-2019 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the basic core image with minimal tests"

inherit core-image

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    package-management \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-dropbear \
    hwcodecs \
"
SDKIMAGE_FEATURES_append = " \
    staticdev-pkgs \
"
IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', ' weston weston-examples weston-init','', d)} \
    imx-test \
    packagegroup-kb-burn-tools \
    packagegroup-imx-security \
    fac-burn-emmc-full \
    ${@bb.utils.contains('MACHINENAME', 'kb-mx8mp', 'tf-upgrade', '', d)} \
"



export IMAGE_BASENAME = "kb-image-burn"
