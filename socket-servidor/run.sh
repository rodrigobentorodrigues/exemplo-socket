mvn clean install
sudo docker build -t atividade/socket .
sudo docker stop servidor
sudo docker rm servidor
#sudo docker run -p 10999:10999 -d --name servidor atividade/socket
sudo docker run -p 1234:1234 -d --name servidor atividade/socket
