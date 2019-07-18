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

## Author

Gabriel Owoeye <owoeye.g.o@gmail.com>
