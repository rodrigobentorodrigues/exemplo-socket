mvn clean install
sudo docker build -t atividade/socket2 .
sudo docker stop cliente
sudo docker rm cliente
sudo docker run -d --name cliente --link servidor:host-socket atividade/socket2
