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

