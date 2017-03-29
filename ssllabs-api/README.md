# SSL Labs Java Client API
This module contains the Java Client for the SSL Labs API.

# Download
This plugin can be downloaded as a [jar](https://bintray.com/beekeeper/maven/download_file?file_path=io%2Fbeekeeper%2Fssllabs%2Fssllabs-api%2F1.0.1%2Fssllabs-api-1.0.1.jar)
or via maven or gradle (prefered)
## Maven
Include the following dependency in your `pom.xml`
```
<dependency>
  <groupId>io.beekeeper.ssllabs</groupId>
  <artifactId>ssllabs-api</artifactId>
  <version>1.0.3</version>
</dependency>
```
Please make sure that you add the `http://dl.bintray.com/beekeeper/maven` maven repository.

## Gradle
On gradle, simply include the following:
```
repositories { maven { url "http://dl.bintray.com/beekeeper/maven" } }
```

and

```
compile 'io.beekeeper.ssllabs:ssllabs-api:1.0.3'
```

into the dependencies section of the `build.gradle` file.

A complete `build.gradle` file may look like:

```
apply plugin: 'java'

repositories {
    jcenter()
    maven { url "http://dl.bintray.com/beekeeper/maven" }
}

dependencies {
    compile 'io.beekeeper.ssllabs:ssllabs-api:1.0.1'
}
```

# Use

The usage of the client is straightforward. Simply instantiate a instance of the `SSLLabsClient` class:

```
new SSLLabsClient();
```

You can also provide a custom api url in the constructor. 
To actually make calls to the service you need to call the `getService` method. E.g.

```
SSLLabsService service = new SSLLabsClient().getService(); 
```

At this point you can access all the API available from SSL Labs through normal methods. 
Please refer to the retrofit documentation on how to perform the web requests: http://square.github.io/retrofit/
