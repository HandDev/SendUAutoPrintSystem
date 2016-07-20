var fs = require('fs');
var path = require('path');
var mime = require('mime');

module.exports = function(app) {

    app.get('/', function(req, res) {
        res.end("Node-File-Upload");

    });
    app.post('/upload', function(req, res) {
        console.log(req.files.image.originalFilename);
        console.log(req.files.image.path);
        fs.readFile(req.files.image.path, function(err, data) {
            var dirname = "/home/rajamalw/Node/file-upload";
            var newPath = dirname + "/uploads/" + req.files.image.originalFilename;
            fs.writeFile(newPath, data, function(err) {
                if (err) {
                    res.json({
                        'response': "Error"
                    });
                } else {
                    res.json({
                        'response': "Saved"
                    });
                }
            });
        });
    });


    app.get('/uploads/:file', function(req, res) {
        file = req.params.file;
        var dirname = "./file-upload";
        var img = fs.readFileSync(dirname + "/uploads/" + file);
        res.writeHead(200, {
            'Content-Type': 'image/jpg'
        });
        res.end(img, 'binary');

    });

    app.get('/download', function(req, res) {
        var file = './test.txt';
        var filename = path.basename(file);
        var mimetype = mime.lookup(file);

        res.setHeader('Content-disposition', 'attachment; filename=' + filename);
        res.setHeader('Content-type', mimetype);

        var filestream = fs.createReadStream(file);
        filestream.pipe(res);
    });

};
