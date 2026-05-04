package gf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class k extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f10687a;

    public k(String str) {
        super(str);
        this.f10687a = null;
    }

    public static k b() {
        return new k("Protocol message end-group tag did not match expected tag.");
    }

    public static k c() {
        return new k("Protocol message contained an invalid tag (zero).");
    }

    public static k d() {
        return new k("Protocol message had invalid UTF-8.");
    }

    public static k e() {
        return new k("Protocol message tag had invalid wire type.");
    }

    public static k f() {
        return new k("CodedInputStream encountered a malformed varint.");
    }

    public static k g() {
        return new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static k h() {
        return new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static k j() {
        return new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static k k() {
        return new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public p a() {
        return this.f10687a;
    }

    public k i(p pVar) {
        this.f10687a = pVar;
        return this;
    }
}
