const express = require('express');
const app = express();
const http = require('http');
const server = http.createServer(app);
const { Server } = require("socket.io");
const io = new Server(server);

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/interface.html');
});

io.on('connection', (socket) => {
  console.log('a user connected');
  socket.on('cmd',(cmd)=>{
    console.log(cmd);
  })
});

server.listen(3000, () => {
  console.log('listening on *:3000');
});