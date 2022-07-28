FROM node:16
WORKDIR /sales-tray-backend
COPY package.json .
RUN npm install
COPY . .
CMD npm start
