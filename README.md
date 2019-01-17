# aws-documentDB

AWS Document DB integration with spring data mongodb repository.

## Environment variables

Once AWS DocumentDB cluster is provisioned, update below property in <i>application.properties</i> file or pass it as an environment variable to point to cluster endpoint

```
spring.data.mongodb.uri=${mongo_uri}
```

### SSL setup for AWS DocumentDB: 

To connect through SSL, set below environment variable pointing to location of the certificate.

```
java -jar app.jar -DsslCertificate=<<PATH TO SSL CERTIFICATE>>
```

This can be downloaded from [SSL certs](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/UsingWithRDS.SSL.html) and copy it to base directory. Alternatively, you can provide absolute path to the variable ```sslCertificate```.

## How to build and run ?

- Clone the repository & run maven build 

```
./mvnw clean install -DskipTests
```

- Run using java command 

```
java -jar target/aws-documentdb-*.jar -DsslCertificate=/home/ec2-user/rds-ca-2015-us-east-1.pem -DSPRING_DATA_MONGO_URI=mongodb://admin:admin@mongodb.cluster-cktoiipu3bbd.us-east-1.docdb.amazonaws.com:27017/admin?replicaSet=rs0
```

>Note: Do not forget to update mongo uri as per cluster endpoint generated.

## Connecting outside VPC: 

Connecting to an Amazon DocumentDB Cluster from Outside an Amazon VPC
By design, you access Amazon DocumentDB (with MongoDB compatibility) resources from an Amazon EC2 instance within the same Amazon VPC as the Amazon DocumentDB resources. However, suppose that your use case requires that you or your application access your Amazon DocumentDB resources from outside the cluster's Amazon VPC. In that case, you can use SSH tunneling (also known as "port forwarding") to access your Amazon DocumentDB resources.

Read More here: [Outside VPC](https://docs.aws.amazon.com/documentdb/latest/developerguide/connect-from-outside-a-vpc.html)

## AWS Document DB documentation 

[AWS DocumentDB Guide](https://docs.aws.amazon.com/documentdb/latest/developerguide)


