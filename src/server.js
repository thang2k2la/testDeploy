import { createServer } from 'http';
import app from './app.js';
const port = process.env.port || 3000;

const server = createServer(app);

server.listen(port);