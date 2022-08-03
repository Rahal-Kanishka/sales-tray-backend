const express = require('express');
/*var bcrypt = require('bcryptjs');
var bodyParser = require('body-parser');
var secretkey = require('./config/configurations').JWTKey;*/
var jwt = require('jsonwebtoken');
var mysql = require('mysql');

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


const { PORT = '3000' } = process.env
const app = express()

app.use((req, res, next) => {
    res.send('<h4>Backend is up </h4>')
})

app.listen(PORT)
