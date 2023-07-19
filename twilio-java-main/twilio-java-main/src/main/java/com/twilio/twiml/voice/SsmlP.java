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

/**
 * TwiML wrapper for {@code <p>}
 */
@JsonDeserialize(builder = SsmlP.Builder.class)
public class SsmlP extends TwiML {
    private final String words;

    /**
     * For XML Serialization/Deserialization
     */
    private SsmlP() {
        this(new Builder());
    }

    /**
     * Create a new {@code <p>} element
     */
    private SsmlP(Builder b) {
        super("p", b);
        this.words = b.words;
    }

    /**
     * The body of the TwiML element
     *
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getWords() == null ? null : this.getWords();
    }

    /**
     * Words to speak
     *
     * @return Words to speak
     */
    public String getWords() {
        return words;
    }

    /**
     * Create a new {@code <p>} element
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends TwiML.Builder<Builder> {
        /**
         * Create and return a {@code <SsmlP.Builder>} from an XML string
         */
        public static Builder fromXml(final String xml) throws TwiMLException {
            try {
                return OBJECT_MAPPER.readValue(xml, Builder.class);
            } catch (final JsonProcessingException jpe) {
                throw new TwiMLException(
                    "Failed to deserialize a SsmlP.Builder from the provided XML string: " + jpe.getMessage());
            } catch (final Exception e) {
                throw new TwiMLException("Unhandled exception: " + e.getMessage());
            }
        }

        private String words;

        /**
         * Create a {@code <p>} with words
         */
        public Builder(String words) {
            this.words = words;
        }

        /**
         * Create a {@code <p>} with child elements
         */
        public Builder() {
        }

        /**
         * Add a child {@code <break>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "break")
        public Builder break_(SsmlBreak ssmlBreak) {
            this.children.add(ssmlBreak);
            return this;
        }

        /**
         * Add a child {@code <emphasis>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "emphasis")
        public Builder emphasis(SsmlEmphasis ssmlEmphasis) {
            this.children.add(ssmlEmphasis);
            return this;
        }

        /**
         * Add a child {@code <lang>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "lang")
        public Builder lang(SsmlLang ssmlLang) {
            this.children.add(ssmlLang);
            return this;
        }

        /**
         * Add a child {@code <phoneme>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "phoneme")
        public Builder phoneme(SsmlPhoneme ssmlPhoneme) {
            this.children.add(ssmlPhoneme);
            return this;
        }

        /**
         * Add a child {@code <prosody>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "prosody")
        public Builder prosody(SsmlProsody ssmlProsody) {
            this.children.add(ssmlProsody);
            return this;
        }

        /**
         * Add a child {@code <s>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "s")
        public Builder s(SsmlS ssmlS) {
            this.children.add(ssmlS);
            return this;
        }

        /**
         * Add a child {@code <say-as>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "say-as")
        public Builder sayAs(SsmlSayAs ssmlSayAs) {
            this.children.add(ssmlSayAs);
            return this;
        }

        /**
         * Add a child {@code <sub>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "sub")
        public Builder sub(SsmlSub ssmlSub) {
            this.children.add(ssmlSub);
            return this;
        }

        /**
         * Add a child {@code <w>} element
         */
        @JacksonXmlProperty(isAttribute = false, localName = "w")
        public Builder w(SsmlW ssmlW) {
            this.children.add(ssmlW);
            return this;
        }

        /**
         * Create and return resulting {@code <p>} element
         */
        public SsmlP build() {
            return new SsmlP(this);
        }
    }
}