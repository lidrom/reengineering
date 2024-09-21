java -XX:StartFlightRecording=filename=recordingRefactored.jfr,dumponexit=true,settings=profile MainRefactored && \
 jfr print --events jdk.GCHeapSummary recordingRefactored.jfr