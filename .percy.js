const fs  = require('fs')
module.exports = {
  version: 2,
  percy: {
    useSystemProxy: false,
    skipBaseBuild: false
  },
  snapshot: {
    widths: [
      375,
      1280
    ],
    minHeight: 1024,
    percyCSS: fs.readFileSync('./style.css').toString('utf8'),
    enableJavaScript: false,
    cliEnableJavaScript: true,
    disableShadowDOM: false,
    responsiveSnapshotCapture: false
  },
  discovery: {
    allowedHostnames: [],
    disallowedHostnames: [],
    networkIdleTimeout: 100,
    captureMockedServiceWorker: false,
    retry: false
  },
  upload: {
    files: '**/*.{png,jpg,jpeg}',
    ignore: '',
    stripExtensions: false
  }
}
