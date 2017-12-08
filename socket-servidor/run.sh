mvn clean install
sudo docker build -t atividade/socket .
sudo docker stop servidor
sudo docker rm servidor
sudo docker run -p 1234:1234 -d --name servidor atividade/socket
