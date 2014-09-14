FROM tauho/datomic-free:0.9.4699

RUN sed "s/host=0.0.0.0/host=datomic/" -i ~/datomic/free-transactor.properties
CMD ["/root/datomic/bin/transactor", "/root/datomic/free-transactor.properties"]

EXPOSE 4334

