# check-apikey-policy

A policy that only permits requests with API key.

The policy only permits requests with an api key.
This is not normally necessary. However, I have an API that is still in development, and the internals (like definitions, plans, policies, etc) can change. However, users of the API should be able to access it via API keys. In essence, I want the mutability of a public API and the authentication of "private" APIs (APIs with contracts). 
The result is a public API with this policy applied. All callers of the api must have valid x-api-key and I am still able to change the underlying internals of the API.

## How it works

On receiving a request, the policy checks if the request has an api key. 
If it doesn't, it fails the request. 
If it does, it passes the request on.
Note that, if the api key is invalid, normal apiman validation will still occur down the line; and the request will still be blocked with the default apiman error message for invalid api keys.

## Build
This is a maven project. `mvn clean install` will build and install it into the default/set maven repository. And the plugin can then be installed from the apimanui interface. If your apimanui is deployed remotely, the remote system must have maven installed, and this project must then be deployed/installed into the remote system's maven repository before it can be found/used by the remote apimanui.

Moreover, this project references the parent [apiman-plugins](https://github.com/apiman/apiman-plugins) project's [pom.xml](https://github.com/apiman/apiman-plugins/blob/master/pom.xml). You can either edit your [pom.xml](pom.xml) file specifying the path to the parent pom, or clone this project into your local clone of [apiman-plugins](https://github.com/apiman/apiman-plugins). Put it in the root folder, like the other plugins there already.

## Author

Gabriel Owoeye <owoeye.g.o@gmail.com>
