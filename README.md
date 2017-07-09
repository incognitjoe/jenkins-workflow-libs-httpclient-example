# Jenkins Shared Libraries Example

An example of extending [Jenkins Pipelines](https://jenkins.io/doc/book/pipeline/) with a Groovy
HTTPClient for making REST calls.

# Usage

Refer to the Jenkins Pipeline docs for setup instructions, but basically, this repo's contents should be added
to ${JENKINS_HOME}/workflow-libs. The gradle related files are merely for development purposes.

With the src/ and vars/ directories added to that folder, you can use the testingStuff global in your Pipeline job definitions,
e.g.:
```
node() {
    testingStuff.print_ghibli_films()
    String slackUrl = 'https://hooks.slack.com/services/use/real/hookurl'
    Map<?, ?> postBody = ["text": "greetings from jenkins", channel: "#random"]
    testingStuff.notifySlack(slackUrl, postBody)
}
```
would print out a list of Studio Ghibli films in your build log, then post a message to your Slack's #random channel.
