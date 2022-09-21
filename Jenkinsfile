pipeline {
    agent any

    environment {
        GITHUB_URL = "https://github.com/dinhdangkhoa0201/list-web-backend.git"
        GITHUB_CREDENTIAL = credentials("github-dinhdangkhoa0201")
    }

    stages {
        stage("Clone Code") {
            step {
                echo "Github url: ${GITHUB_URL}"
                echo "Github username: ${GITHUB_CREDENTIAL_USR}"
            }
        }
    }
}
