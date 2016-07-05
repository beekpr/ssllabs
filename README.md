# SSLLabs API Java Client & Tests

This is a tiny library which provided a Java client interface for the SSL Labs API and 
provides a quick way to integrate SSL Labs into a build infrastructure. The SSL Labs API allows developers 
to check websites for SSL vulnarabilities.

This library bases on the official API document from SSL Labs. For a complete description of the protocol please see 
https://github.com/ssllabs/ssllabs-scan/blob/stable/ssllabs-api-docs.md

The library uses retrofit [http://square.github.io/retrofit/] to perform all HTTP requests.

# Modules

This project contains of 2 modules:
* ssllabs-api
* ssllabs-junit

## ssllabs-api
This module contains the Java Client to talk to the SSLLabs Rest API. 
It supports both synchronous and asynchronous requests and is fully types. 
More information for how to use the module can be found in the README of the module

## ssllabs-junit
This module contains helper classes to quickly set up a JUnit test case to check hosts for known vulnarabilities.
More information for how to use the module can be found in the README of the module

# License
> Copyright 2016 Beekeeper
>
>Licensed under the Apache License, Version 2.0 (the "License");
>you may not use this file except in compliance with the License.
>You may obtain a copy of the License at
>
>   http://www.apache.org/licenses/LICENSE-2.0
>
>Unless required by applicable law or agreed to in writing, software
>distributed under the License is distributed on an "AS IS" BASIS,
>WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
>See the License for the specific language governing permissions and
>limitations under the License.
