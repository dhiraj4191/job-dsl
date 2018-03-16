git_url = "https://github.com/dhiraj4191/sample-sonar-repo.git"

job_path = "${new File(__FILE__).parent}"
jenkinsfile = job_path + "/Jenkinsfile"

pipelineJob("sonar-scan") {

  parameters {
    stringParam("GIT_URL", git_url, "GIT URL for sonar project")
  }        

  logRotator(numToKeep = 100)

  definition {
    cps {
      sandbox()
      script(readFileFromWorkspace(jenkinsfile))
    }
  }
} 