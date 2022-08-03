const express = require('express');
/*var bcrypt = require('bcryptjs');
var bodyParser = require('body-parser');
var secretkey = require('./config/configurations').JWTKey;*/
var jwt = require('jsonwebtoken');
var mysql = require('mysql');
const app = express()

console.log('just changed it');


var con = mysql.createConnection({
    port: "3306",
    host: "192.168.0.9",
    user: "sales_tray_user",
    password: "password",
    database: "sales_tray"
});

con.connect(function(err) {
    if (err) throw err;
    console.log("DB Connected!");
});

app.get('/', function(req, res){
    res.send('<h4>Backend is up </h4>');
});

app.get('/check_db', async function (req, res) {
    const dbResponse = await checkDBConnection();
    console.log('response received from server query: ', dbResponse);
    res.send(dbResponse);
});

function checkDBConnection() {
    return new Promise((resolve, reject)=> {
        con.query("SELECT 'DB is UP' as Result", function (err, result, fields) {
            if (err) throw err;
            console.log('fromDB: ', result)
            resolve(JSON.stringify(result));
        });
    });
}

app.get('*', function(req, res){
    res.send('Sorry, this is an invalid URL.');
});


const { PORT = '3000' } = process.env

app.use((req, res, next) => {
    res.send('<h4>Backend is up </h4>')
})

app.listen(PORT)
