FROM gitpod/workspace-full

USER gitpod

## Java setup Gitpod documentation - https://www.gitpod.io/docs/introduction/languages/java
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install java 21.0.5-jbr && \
    sdk default java 21.0.5-jbr"