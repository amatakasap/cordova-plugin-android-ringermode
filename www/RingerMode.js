module.exports = {
  getMode: function(success, error) {
    cordova.exec(success, error, "RingerMode", "getMode", []);
  }
};
