# Golden-Team

add VM option: --add-opens=java.base/java.time=ALL-UNNAMED

to start docker with database: docker run --name mysql --rm -p 3308:3306 -e MYSQL_DATABASE=example -e MYSQL_ROOT_PASSWORD=password -d mysql