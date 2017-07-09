import org.incognitjoe.JenkinsHttpClient

def print_ghibli_films() {
    JenkinsHttpClient http = new JenkinsHttpClient()
    println(http.get('https://ghibliapi.herokuapp.com/films/'))
}

def notifySlack(String slackHookUrl, Map<?, ?> postBody) {
    JenkinsHttpClient http = new JenkinsHttpClient()
    http.post_json(slackHookUrl, postBody)
}
