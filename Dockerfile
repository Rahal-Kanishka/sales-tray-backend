FROM node:16
WORKDIR /sales-tray-backend
COPY package.json .
RUN npm install -g nodemon
RUN npm install
COPY . .

# Exports
EXPOSE 3000 3306
CMD [ "npm", "run", "dev" ]
#CMD npm start
