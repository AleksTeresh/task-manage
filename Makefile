SHELL := /bin/bash

ENV_PARAMS := \
	DEPLOYMENT_ENVIRONMENT=development

package:
	mvn package

start:
	java -jar ./target/task-0.1.0.jar server


jooq-classes:
	mvn generate-sources -D jooq

