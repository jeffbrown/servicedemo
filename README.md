# Http Client Example


## Consul

The sample may be easily demonstrated using Consul.
Make sure Consul is running on port 8500 of localhost.
[Docker](http://docker.com) may be used to easily start Consul.

`docker run -p 8500:8500 consul`

## Start The Backend Service

Run multiple instances of the backend service by running the following command
in different terminal sessions.  Each instance will start on their own unique
random port number.
 
`./gradlew backend:run`

Once the instances are up and running you should see
it registered in Consul under the name `backend`.  Check
at http://localhost:8500/.

## Start The Front End Server

`./gradlew server:run`

Once the application is up and running send a request to
http://localhost:8086/home which should render
information about which backend service the front end
server communicated with.  You should notice that the
server is round-robining across each of the backend 
services.

```
$ curl http://localhost:8086/home
{"port":51149,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":65441,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":22780,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":51149,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":65441,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":22780,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":51149,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":65441,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":22780,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":51149,"host":"localhost"}
 $ curl http://localhost:8086/home
{"port":65441,"host":"localhost"}
 $ curl http://localhost:8086/home
```