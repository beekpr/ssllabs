# SSL Labs Test Base
This module contains a jUnit test class which can be used to easily test multiple hosts for ssl vulnarabilities

# Download
This plugin can be downloaded as a [jar](https://bintray.com/beekeeper/maven/download_file?file_path=io%2Fbeekeeper%2Fssllabs%2Fssllabs-junit%2F1.0.1%2Fssllabs-junit-1.0.1.jar)
or via maven or gradle (prefered)
## Maven
Include the following dependency in your `pom.xml`
```
<dependency>
  <groupId>io.beekeeper.ssllabs</groupId>
  <artifactId>ssllabs-junit</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
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
compile 'io.beekeeper.ssllabs:ssllabs-junit:1.0.1'
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
    testCompile 'junit:junit:4.12'
    testCompile 'io.beekeeper.ssllabs:ssllabs-junit:1.0.1'
}

```

# Use

To create a test which will test a list of hosts, create a test class:
```
package io.beekeeper.ssllabs.test;

import io.beekeeper.ssllabs.junit.BaseSSLLabsTest;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ExampleSSLTest extends BaseSSLLabsTest {

    public ExampleSSLTest(String host) {
        super(host);
    }

    @Parameters(name = "Host: {0}")
    public static Iterable<String> data() {
        return Arrays.asList("foo.example.com", "bar.example.com", "zip.example.com");
    }

}
```

And that is it. You can now execute the test (e.g. `./gradle test` or `mvn test`) and it will test the hosts `foo.example.com`, `bar.example.com` and `zip.example.com`
for vulnarabilities. The test runner will test each host and create a separate assertion for each host.

By default, the test will pass if all the endpoints for a given host have a grade which is equal or better
than "A".

# Customization
The `BaseSSLLabsTest` allows for some customizations. It is straightforward to change the minimum grade for the hosts.
To change the minimum grade, simple change the protected `hostMatcher` field to a new host matcher. E.g.

```
    public ExampleSSLTest(String host) {
        super(host);
        // Allow the hosts to get a grade of A- and up
        hostMatcher = new HostGradeMatcher("A-");
    }
```

It is also possible to create your own host matcher which will perform more checks. For more information on Matchers, 
see the following [tutorial](http://www.vogella.com/tutorials/Hamcrest/article.html)
