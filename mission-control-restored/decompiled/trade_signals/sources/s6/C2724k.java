package s6;

import java.io.IOException;

/* JADX INFO: renamed from: s6.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2724k extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f23185a;

    public C2724k(String str) {
        super(str);
        this.f23185a = null;
    }

    public static C2724k b() {
        return new C2724k("Protocol message end-group tag did not match expected tag.");
    }

    public static C2724k c() {
        return new C2724k("Protocol message contained an invalid tag (zero).");
    }

    public static C2724k d() {
        return new C2724k("Protocol message had invalid UTF-8.");
    }

    public static C2724k e() {
        return new C2724k("Protocol message tag had invalid wire type.");
    }

    public static C2724k f() {
        return new C2724k("CodedInputStream encountered a malformed varint.");
    }

    public static C2724k g() {
        return new C2724k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C2724k h() {
        return new C2724k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static C2724k j() {
        return new C2724k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static C2724k k() {
        return new C2724k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public p a() {
        return this.f23185a;
    }

    public C2724k i(p pVar) {
        this.f23185a = pVar;
        return this;
    }
}
