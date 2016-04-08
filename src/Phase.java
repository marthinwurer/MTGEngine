/**
 * Created by benjamin on 4/4/16.
 */
public enum Phase {
    START_TURN,
    UPKEEP,
    DRAW,
    FIRST_MAIN,
    BEGIN_COMBAT,
    DECLARE_ATTACKERS,
    DECLARE_BLOCKERS,
    FIRST_STRIKE,
    COMBAT_DAMAGE,
    END_COMBAT,
    SECOND_MAIN,
    END_STEP,
    CLEANUP;

    private static Phase[] vals = Phase.values();

    public Phase next(){
        return vals[(this.ordinal() +1 ) % vals.length];
    }

    public boolean canCastSorcery(){
        return ( this == FIRST_MAIN || this == SECOND_MAIN );
    }
}
