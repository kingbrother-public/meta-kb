SUMMARY = "kb regulatory"
DESCRIPTION = "sometimes driver will request firmware and wait for a 60s or 120s, We feed the firmware to it"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://licenses/GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"


inherit  systemd

S = "${WORKDIR}"

SRC_URI = "file://kb-regulatory.service \
					 file://kb-regulatory \
           file://licenses/GPL-2 \
          "
          



					

do_install(){
	install -d ${D}${systemd_system_unitdir}
	install -d ${D}${sysconfdir}

	install -m 644 ${WORKDIR}/kb-regulatory.service ${D}${systemd_system_unitdir}/kb-regulatory.service
	install -m 755 ${WORKDIR}/kb-regulatory ${D}${sysconfdir}/kb-regulatory
}


SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "kb-regulatory.service"
SYSTEMD_AUTO_ENABLE = "enable"

