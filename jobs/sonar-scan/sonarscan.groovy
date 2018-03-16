git_url = GIT_URL

job_path = "${new File(__FILE__).parent}"
jenkinsfile = job_path + "/Jenkinsfile"

pipelineJob("sonar-scan") {

  parameters {
    stringParam("LIB_GIT_URL", lib_git_url, "GIT URL of jenkins libraries")
  }        

  logRotator(numToKeep = 100)

  definition {
    cps {
      sandbox()
      script(readFileFromWorkspace(jenkinsfile))
    }
  }
} 