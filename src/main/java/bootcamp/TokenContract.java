package bootcamp;

import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

/* Our contract, governing how our state will evolve over time.
 * See src/main/java/examples/ArtContract.java for an example. */
public class TokenContract implements Contract {
    public static String ID = "bootcamp.TokenContract";

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        if(tx.getInputStates().size() != 0) throw new IllegalArgumentException("Zero inputs expected");
        if(tx.getOutputStates().size() != 1) throw new IllegalArgumentException("Cannot contain more than one output");
        if(tx.getCommands().size() != 1) throw new IllegalArgumentException("Cannot have more than one command");
        if(!(tx.getOutput(0) instanceof TokenState)) throw new IllegalArgumentException("Token Output State should be an instance of TokenState");
        if(((TokenState) tx.getOutput(0)).getAmount() <= 0) throw new IllegalArgumentException("Token output amount cannot be less than 1");
//        if(!(tx.getCommand(0).component1() instanceof Commands.Issue)) throw new IllegalArgumentException("Token Command should be an instance of Issue");
        if(!(tx.getCommand(0).getValue() instanceof Commands.Issue)) throw new IllegalArgumentException("Token Command should be an instance of Issue");
        if(!(tx.getCommand(0).getSigners().contains(((TokenState) tx.getOutput(0)).getIssuer().getOwningKey()))) throw new IllegalArgumentException("Issuer should be a signer");
    }

    public interface Commands extends CommandData {
        class Issue implements Commands { }
    }
}