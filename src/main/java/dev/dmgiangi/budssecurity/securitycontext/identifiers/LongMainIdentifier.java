package dev.dmgiangi.budssecurity.securitycontext.identifiers;

/**
 * LongMainIdentifier implements MainIdentifier and use a long as main Identifier
 * <p>
 * {@inheritDoc}
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
 * @since 28 09 2022
 */
public class LongMainIdentifier implements MainIdentifier {
    private final long mainIdentifier;

    /**
     * Constructor for LongMainIdentifier.
     *
     * @param mainIdentifier a long
     */
    public LongMainIdentifier(long mainIdentifier) {
        this.mainIdentifier = mainIdentifier;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean compareTo(MainIdentifier other) {
        if (other == null || this.getClass() != other.getClass()) return false;

        LongMainIdentifier that = (LongMainIdentifier) other;

        return this.mainIdentifier == that.mainIdentifier;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String mainIdentifierAsString() {
        return mainIdentifier + "";
    }
}
