While launching ElastiCache it will launch in VPC with security groups. 
For Lambda finctions to use the elastic cache make sure you have role access to VPC and your function should be in same VPC and Same Security Group. 
Else it wont get access to your cache cluster. 
While launching EC2 Instance this should also present in same VPC,Security group and have access Inbound, Outbound access to the Cache Cluster.
Else it wont connect to the ElastiCache Cluster.
Make sure you open port 6379 ---> for ElastiCache
22 ---> For SSh to EC2 Instance


================================================================

ElastiCache Set up on EC2 Instance
-------------------------------------------------------------------------
The below two commands will install the redis client
$ sudo yum install gcc

$ wget http://download.redis.io/redis-stable.tar.gz && tar xvzf redis-stable.tar.gz && cd redis-stable && make && sudo cp src/redis-cli /usr/local/bin/ && sudo chmod 755 /usr/local/bin/redis-cli

the below command is used to connect to your launched Redis Cluster
---------------------------------------------------------------------------
$ redis-cli -h myelasticrediscache.7zalm7.ng.0001.use1.cache.amazonaws.com -p 6379

keys * --->List all keys stored in Cache 
mget key ---> this will give the value for given key
