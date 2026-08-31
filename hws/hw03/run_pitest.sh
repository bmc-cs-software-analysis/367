java -cp src/:test/:lib/pitest-entry-1.18.0.jar:lib/pitest-1.18.0.jar:lib/pitest-command-line-1.18.0.jar:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.pitest.mutationtest.commandline.MutationCoverageReport \
 --reportDir pitest-report \
 --sourceDirs src  \
 --targetClasses BuyTicket \
 --mutators ALL \
 --targetTests TestBuyTicket
 #--verbose
