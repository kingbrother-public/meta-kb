SUMMARY = "kb hmi 2.0"
DESCRIPTION = "kb hdmi 2.0 qt application"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://licenses/GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"

S = "${WORKDIR}"

SRC_URI = "file://licenses/GPL-2 \
		   file://home/root/mxapp2 \
		   file://usr/lib/fonts/msyh.ttc \
		   file://usr/share/kb/ecg.dat \
		   file://usr/share/kb/resp.text \
		   file://kb_logo.png \
          "
          


S = "${WORKDIR}"
ROOT_HOME="/home/root"


					

do_install (){
	install -d ${D}${systemd_system_unitdir}
	install -d ${D}${datadir}
	install -d ${D}${datadir}/kb
	install -d ${D}${datadir}/kb/Video
	install -d ${D}${datadir}/kb/Audio
	install -d ${D}${datadir}/kb/Capture
	install -d ${D}${nonarch_libdir}/fonts
	install -d ${D}${ROOT_HOME}
	install -d ${D}${bindir}

	
	install -m 755 ${WORKDIR}${nonarch_libdir}/fonts/msyh.ttc ${D}${nonarch_libdir}/fonts/msyh.ttc
	install -m 755 ${WORKDIR}${datadir}/kb/ecg.dat ${D}${datadir}/kb/ecg.dat
	install -m 755 ${WORKDIR}${datadir}/kb/resp.text ${D}${datadir}/kb/resp.text


  install -d -m 755 ${D}/home/root/.kb_demo
  install -d -m 755 ${D}/home/root/.kb_demo/icon
  install -m 755 ${WORKDIR}/${ROOT_HOME}/mxapp2  ${D}${bindir}/mxapp2
	install -m 755 ${WORKDIR}/kb_logo.png ${D}/home/root/.kb_demo/icon/kb_logo.png


}


FILES_${PN} = "/"
INSANE_SKIP_${PN} = "file-rdeps"
