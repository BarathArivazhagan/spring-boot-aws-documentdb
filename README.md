# Spring Boot AWS DocumentDB

AWS Document DB integration with spring data mongodb repository.


#### Compatability Matrix

Choose the branch based on below versions.


<table>
 <tr>
    <th style="text-align:left">Branch/Version</th>
    <th style="text-align:left">Spring Boot</th>
  </tr>
  <tr>
    <td>master</td>
    <td>2.5.5</td>
  </tr>
  <tr>
    <td>2.1.2</td>
    <td>2.1.2.RELEASE</td>
  </tr>
  
</table>

#### Environment variables

Once AWS DocumentDB cluster is provisioned, update below property in <i>application.properties</i> file or pass it as an environment variable to point to cluster endpoint

```
spring.data.mongodb.uri=${mongo_uri}
```

#### SSL setup for AWS DocumentDB: 

To connect through SSL, set below environment variable pointing to location of the certificate.

```
java -DsslCertificate=<<PATH TO SSL CERTIFICATE>> -jar app.jar 
```

This can be downloaded from [SSL certs](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/UsingWithRDS.SSL.html) and copy it to base directory. Alternatively, you can provide absolute path to the variable ```sslCertificate```.

#### How to build and run ?

- Clone the repository & run maven build 

```
./mvnw clean install -DskipTests
```

- Run using java command 

```
java  -DsslCertificate=./ssl/rds-combined-ca-bundle.pem -DSPRING_DATA_MONGO_URI=mongodb://admin:admin@mongodb.cluster-123456.us-east-1.docdb.amazonaws.com:27017/admin?ssl=true&ssl_ca_certs=rds-combined-ca-us-gov-bundle.pem&replicaSet=rs0&readPreference=secondaryPreferred&retryWrites=false -jar target/aws-documentdb-*.jar
```

>Note: Do not forget to update mongo uri as per cluster endpoint generated.

#### Connecting outside VPC: 

Connecting to an Amazon DocumentDB Cluster from Outside an Amazon VPC
By design, you access Amazon DocumentDB (with MongoDB compatibility) resources from an Amazon EC2 instance within the same Amazon VPC as the Amazon DocumentDB resources. However, suppose that your use case requires that you or your application access your Amazon DocumentDB resources from outside the cluster's Amazon VPC. In that case, you can use SSH tunneling (also known as "port forwarding") to access your Amazon DocumentDB resources.

Read More here: [Outside VPC](https://docs.aws.amazon.com/documentdb/latest/developerguide/connect-from-outside-a-vpc.html)

## SSL Certs

CA bundle can be found here [SSL CERTS](../ssl)

Download the bundles from AWS

```
wget https://s3.amazonaws.com/rds-downloads/rds-combined-ca-bundle.pem
```

## Docker Support 

- Build Docker image
 
```
docker build -t aws-document-db .
```

- Run docker image

````
docker run --name demo -e SPRING_DATA_MONGODB_URI=<<insert-mongo-uri-here>>  -e JAVA_OPTS="-DsslCertificate=./ssl/rds-combined-ca-bundle.pem" aws-document-db
````
-Cleanup the docker resources 

```
docker stop demo && docker rm demo
```

## AWS Updating your certificates

[AWS DocumentDB Certificates](https://docs.aws.amazon.com/documentdb/latest/developerguide/ca_cert_rotation.html)

#### AWS Document DB documentation 


[AWS DocumentDB Guide](https://docs.aws.amazon.com/documentdb/latest/developerguide)


