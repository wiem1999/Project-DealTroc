/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link SsmlEmphasis}
 */
public class SsmlEmphasisTest {
    @Test
    public void testEmptyElement() {
        SsmlEmphasis elem = new SsmlEmphasis.Builder().build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<emphasis/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        SsmlEmphasis elem = new SsmlEmphasis.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3Cemphasis%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        SsmlEmphasis elem = new SsmlEmphasis.Builder("words").level(SsmlEmphasis.Level.STRONG).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<emphasis level=\"strong\">words</emphasis>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithExtraAttributes() {
        SsmlEmphasis elem = new SsmlEmphasis.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<emphasis a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithChildren() {
        SsmlEmphasis.Builder builder = new SsmlEmphasis.Builder();

        builder.break_(new SsmlBreak.Builder().strength(SsmlBreak.Strength.NONE).time("time").build());

        builder.emphasis(new SsmlEmphasis.Builder("words").level(SsmlEmphasis.Level.STRONG).build());

        builder.lang(new SsmlLang.Builder("words").xmlLang(SsmlLang.XmlLang.ARB).build());

        builder.phoneme(new SsmlPhoneme.Builder("words").alphabet(SsmlPhoneme.Alphabet.IPA).ph("ph").build());

        builder.prosody(new SsmlProsody.Builder("words").volume("volume").rate("rate").pitch("pitch").build());

        builder.sayAs(new SsmlSayAs.Builder("words")
                    .interpretAs(SsmlSayAs.InterpretAs.CHARACTERS)
                    .format(SsmlSayAs.Format.MDY)
                    .build());

        builder.sub(new SsmlSub.Builder("words").alias("alias").build());

        builder.w(new SsmlW.Builder("words").role("role").build());

        SsmlEmphasis elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<emphasis>" +
                "<break strength=\"none\" time=\"time\"/>" +
                "<emphasis level=\"strong\">words</emphasis>" +
                "<lang xml:lang=\"arb\">words</lang>" +
                "<phoneme alphabet=\"ipa\" ph=\"ph\">words</phoneme>" +
                "<prosody pitch=\"pitch\" rate=\"rate\" volume=\"volume\">words</prosody>" +
                "<say-as format=\"mdy\" interpret-as=\"characters\">words</say-as>" +
                "<sub alias=\"alias\">words</sub>" +
                "<w role=\"role\">words</w>" +
            "</emphasis>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithTextNode() {
        SsmlEmphasis.Builder builder = new SsmlEmphasis.Builder();

        builder.addText("Hey no tags!");

        SsmlEmphasis elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<emphasis>" +
            "Hey no tags!" +
            "</emphasis>",
            elem.toXml()
        );
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        SsmlEmphasis.Builder builder = new SsmlEmphasis.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<emphasis>" +
            "before" +
            "<Child>content</Child>" +
            "after" +
            "</emphasis>",
            builder.build().toXml()
        );
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        SsmlEmphasis.Builder builder = new SsmlEmphasis.Builder();
        SsmlEmphasis elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<emphasis>" +
            "<genericTag>" +
            "Some text" +
            "</genericTag>" +
            "</emphasis>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        SsmlEmphasis.Builder builder = new SsmlEmphasis.Builder();
        SsmlEmphasis elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<emphasis>" +
            "<genericTag key=\"value\">" +
            "someText" +
            "</genericTag>" +
            "</emphasis>",
            elem.toXml()
        );
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final SsmlEmphasis elem = new SsmlEmphasis.Builder("words").level(SsmlEmphasis.Level.STRONG).build();

        Assert.assertEquals(
            SsmlEmphasis.Builder.fromXml("<emphasis level=\"strong\">words</emphasis>").build().toXml(),
            elem.toXml()
        );
    }

    @Test
    public void testXmlChildrenDeserialization() {
        final SsmlEmphasis.Builder builder = new SsmlEmphasis.Builder();

        builder.break_(new SsmlBreak.Builder().strength(SsmlBreak.Strength.NONE).time("time").build());

        builder.emphasis(new SsmlEmphasis.Builder("words").level(SsmlEmphasis.Level.STRONG).build());

        builder.lang(new SsmlLang.Builder("words").xmlLang(SsmlLang.XmlLang.ARB).build());

        builder.phoneme(new SsmlPhoneme.Builder("words").alphabet(SsmlPhoneme.Alphabet.IPA).ph("ph").build());

        builder.prosody(new SsmlProsody.Builder("words").volume("volume").rate("rate").pitch("pitch").build());

        builder.sayAs(new SsmlSayAs.Builder("words")
                    .interpretAs(SsmlSayAs.InterpretAs.CHARACTERS)
                    .format(SsmlSayAs.Format.MDY)
                    .build());

        builder.sub(new SsmlSub.Builder("words").alias("alias").build());

        builder.w(new SsmlW.Builder("words").role("role").build());

        final SsmlEmphasis elem = builder.build();

        Assert.assertEquals(
            SsmlEmphasis.Builder.fromXml("<emphasis>" +
                "<break strength=\"none\" time=\"time\"/>" +
                "<emphasis level=\"strong\">words</emphasis>" +
                "<lang xml:lang=\"arb\">words</lang>" +
                "<phoneme alphabet=\"ipa\" ph=\"ph\">words</phoneme>" +
                "<prosody pitch=\"pitch\" rate=\"rate\" volume=\"volume\">words</prosody>" +
                "<say-as format=\"mdy\" interpret-as=\"characters\">words</say-as>" +
                "<sub alias=\"alias\">words</sub>" +
                "<w role=\"role\">words</w>" +
            "</emphasis>").build().toXml(),
            elem.toXml()
        );
    }

    @Test
    public void testXmlEmptyChildrenDeserialization() {
        final SsmlEmphasis.Builder builder = new SsmlEmphasis.Builder();

        builder.break_(new SsmlBreak.Builder().build());

        builder.emphasis(new SsmlEmphasis.Builder().build());

        builder.lang(new SsmlLang.Builder().build());

        builder.prosody(new SsmlProsody.Builder().build());

        builder.w(new SsmlW.Builder().build());

        final SsmlEmphasis elem = builder.build();

        Assert.assertEquals(
            SsmlEmphasis.Builder.fromXml("<emphasis>" +
                "<break/>" +
                "<emphasis/>" +
                "<lang/>" +
                "<prosody/>" +
                "<w/>" +
            "</emphasis>").build().toXml(),
            elem.toXml()
        );
    }
}