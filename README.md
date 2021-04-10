# SYSC_4005_Project
By Andrew Dybka and Andrew Foster

To Run, run main method in simulation class.

<h3>Master Branch</h3>
This Branch has the original inspector 1 policy and runs 1 replication at a time output all data as it goes. This branch has each step output and output files show the running point estimation over time.

<h3>OriginalPolicyWithMassReplication Branch</h3>
This branch has the original inspector 1 policy but runs 1000 replications will less step by step output but the average of each point estimator after initialization phase.

<h3>InspectorsPolicyChange Branch</h3> 
This branch is the same as the master branch but with the new inspector policy implemented

<h3>PolicyChangeWithMassReplication Branch</h3>
This branch has the 1000 replications with the new policy with less set by step outpt but the average of each point estimator after initialization phase.

<h3>Output</h3>
All output will be in the 'resources' folder
output.csv: The running products per minute value. (In Master and InspectorPolicyChange branches)
insp2.csv&insp1.csv: The running percent idle time for each inspector respectively (In Master and InspectorPolicyChange branches)
avgOutput: The average output per minute after 25,000 minute initialization phase of each of the 1000 replications. (In OriginalPolicyWithMassReplication and PolicyChangeWithMassReplication branches)
avgInsp2.csv: The average percent idle time of inspector 2 after 25,000 minute initialization phase of each of the 1000 replications. (In OriginalPolicyWithMassReplication and PolicyChangeWithMassReplication branches)


