/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.twilio.twiml.TwiML;
import com.twilio.twiml.TwiMLException;

import java.util.HashMap;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Reject>}
 */
@JsonDeserialize(builder = Reject.Builder.class)
public class Reject extends TwiML {
    public enum Reason {
        REJECTED("rejected"),
        BUSY("busy");

        private final String value;

        private Reason(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final Reject.Reason reason;

    /**
     * For XML Serialization/Deserialization
     */
    private Reject() {
        this(new Builder());
    }

    /**
     * Create a new {@code <Reject>} element
     */
    private Reject(Builder b) {
        super("Reject", b);
        this.reason = b.reason;
    }

    /**
     * Attributes to set on the generated XML element
     *
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getReason() != null) {
            attrs.put("reason", this.getReason().toString());
        }

        return attrs;
    }

    /**
     * Rejection reason
     *
     * @return Rejection reason
     */
    public Reject.Reason getReason() {
        return reason;
    }

    /**
     * Create a new {@code <Reject>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <Reject.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                    "Failed to deserialize a Reject.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private Reject.Reason reason;

        /**
         * Rejection reason
         */
        @JacksonXmlProperty(isAttribute = true, localName = "reason")
        public Builder reason(Reject.Reason reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Add a child {@code <Parameter>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "Parameter")
        public Builder parameter(Parameter parameter) {
            this.children.add(parameter);
            return this;
        }

        /**
         * Create and return resulting {@code <Reject>} element
         */
        public Reject build() {
            return new Reject(this);
        }
    }
}