FROM node:16
WORKDIR /test-backend
COPY package.json .
RUN npm install
COPY . .
CMD npm start