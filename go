docker build -t lein docker/lein
docker build -t datomic docker/datomic
docker build -t data docker/data

docker run --name lein-data -v ~/share:/data data
docker run -d --name datomic -p 4334:4334 -p 3449:3449 datomic
docker run --link datomic:datomic --volumes-from lein-data --name lein -p 80:80 -p 3449:3449 lein
