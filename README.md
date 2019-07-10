<p align="center">
  <img src="https://www.corda.net/wp-content/uploads/2016/11/fg005_corda_b.png" alt="Corda" width="500">
</p>

# Bootcamp CorDapp

We'll develop the CorDapp using a test-driven approach. At each stage, you'll know your 
CorDapp is working once it passes both sets of tests defined in `src/test/java/bootcamp`.

## Set up

1. Download and install a JDK 8 JVM (minimum supported version 8u131)
2. Download and install IntelliJ Community Edition (supported versions 2017.x and 2018.x)
3. Download the bootcamp-cordapp repository:

       git clone https://github.com/corda/bootcamp-cordapp
       
4. Open IntelliJ. From the splash screen, click `Import Project`, select the `bootcamp—
cordapp` folder and click `Open`
5. Select `Import project from external model > Gradle > Next > Finish`
6. Click `File > Project Structure…` and select the Project SDK (Oracle JDK 8, 8u131+)

    i. Add a new SDK if required by clicking `New…` and selecting the JDK’s folder

7. Open the `Project` view by clicking `View > Tool Windows > Project`
8. Run the test in `src/test/java/java_bootcamp/ProjectImportedOKTest.java`. It should pass!

## Links to useful resources

This project contains example state, contract and flow implementations:

* `src/main/java/java_examples/ArtState`
* `src/main/java/java_examples/ArtContract`
* `src/main/java/java_examples/ArtTransferFlowInitiator`
* `src/main/java/java_examples/ArtTransferFlowResponder`

There are also several web resources that you will likely find useful for this
bootcamp:

* Key Concepts docs (`docs.corda.net/key-concepts.html`)
* API docs (`docs.corda.net/api-index.html`)
* Cheat sheet (`docs.corda.net/cheat-sheet.html`)
* Sample CorDapps (`www.corda.net/samples`)
* Stack Overflow (`www.stackoverflow.com/questions/tagged/corda`)

# Running 3 nodes and performing a transaction between Party A & Party B, but Party C doesn't see this transaction

When the Cordapp is done with required features implemented, run the following commands from command line/terminal. The instructions are for Mac OS X, but could vary for Windows OS 

* ./gradlew deployNodes (This will run the deployNodes task in the build.gradle file)
* cd build/nodes && runnodes

The above command will open 4 new terminal tabs (or terminal windows) for Notary, Party A, Party B & Party C. 

Navigate to the terminal tab of Party A and run the below command to issue 100 tokens to Party B. What we are doing is converting the ownership of those 100 tokens from Party A to Party B

* flow start TokenIssueFlow owner: PartyB, amount: 100

Run the below command in all nodes and you will see response with transactions only in Party A and Party B

* run vaultQuery contractStateType: bootcamp.TokenState
