const express = require('express');
var mongoose = require('mongoose');
/*var bcrypt = require('bcryptjs');
var bodyParser = require('body-parser');
var secretkey = require('./config/configurations').JWTKey;*/
var jwt = require('jsonwebtoken');

console.log('just changed it');


const { PORT = '3000' } = process.env
const app = express()

app.use((req, res, next) => {
    res.send('<h4>Backend is up </h4>')
})

app.listen(PORT)
