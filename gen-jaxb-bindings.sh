#!/bin/bash
xjc -nv -extension -mark-generated -d ./src -p psyriccio.voteflow.api.jaxb.topics -xmlschema ./src/psyriccio/voteflow/api/jaxb/topics.xsd
xjc -nv -extension -mark-generated -d ./src -p psyriccio.voteflow.api.jaxb.classes -xmlschema ./src/psyriccio/voteflow/api/jaxb/classes.xsd
xjc -nv -extension -mark-generated -d ./src -p psyriccio.voteflow.api.jaxb.deputies -xmlschema ./src/psyriccio/voteflow/api/jaxb/deputies.xsd
xjc -nv -extension -mark-generated -d ./src -p psyriccio.voteflow.api.jaxb.stages -xmlschema ./src/psyriccio/voteflow/api/jaxb/stages.xsd
xjc -nv -extension -mark-generated -d ./src -p psyriccio.voteflow.api.jaxb.votes -xmlschema ./src/psyriccio/voteflow/api/jaxb/votes.xsd
xjc -nv -extension -mark-generated -d ./src -p psyriccio.voteflow.api.jaxb.periods -xmlschema ./src/psyriccio/voteflow/api/jaxb/periods.xsd
xjc -nv -extension -mark-generated -d ./src -p psyriccio.voteflow.api.jaxb.federalorgans -xmlschema ./src/psyriccio/voteflow/api/jaxb/federal-organs.xsd
