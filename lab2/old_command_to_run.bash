java -XX:StartFlightRecording=filename=recordingOld.jfr,dumponexit=true,settings=profile MainOld && \
 jfr print --events jdk.GCHeapSummary recordingOld.jfr