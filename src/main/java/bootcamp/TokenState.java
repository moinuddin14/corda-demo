package bootcamp;

import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import net.corda.core.serialization.CordaSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/* Our state, defining a shared fact on the ledger.
 * See src/main/java/examples/ArtState.java for an example. */
@BelongsToContract(TokenContract.class)
//@CordaSerializable
public class TokenState implements ContractState {

    private final Party issuer;
    private final Party owner;
    private final int amount;
    private final List<AbstractParty> parties;

    public Party getIssuer() {
        return issuer;
    }

    public Party getOwner() {
        return owner;
    }

    public int getAmount() {
        return amount;
    }

    public List<AbstractParty> getParties() {
        return parties;
    }

    //    @ConstructorForDeserialization
    public TokenState(Party issuer, Party owner, int amount) {
        this.issuer = issuer;
        this.owner = owner;
        this.amount = amount;
        this.parties = new ArrayList<>();
        this.parties.add(issuer);
        this.parties.add(owner);
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return getParties();
    }
}