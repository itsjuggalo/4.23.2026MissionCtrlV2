package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class d0 extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u0 f6953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6954b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends d0 {
        public a(String str) {
            super(str);
        }
    }

    public d0(String str) {
        super(str);
        this.f6953a = null;
    }

    public static d0 b() {
        return new d0("Protocol message end-group tag did not match expected tag.");
    }

    public static d0 c() {
        return new d0("Protocol message contained an invalid tag (zero).");
    }

    public static d0 d() {
        return new d0("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static d0 f() {
        return new d0("CodedInputStream encountered a malformed varint.");
    }

    public static d0 g() {
        return new d0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static d0 h() {
        return new d0("Failed to parse the message.");
    }

    public static d0 i() {
        return new d0("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static d0 l() {
        return new d0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static d0 m() {
        return new d0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.f6954b;
    }

    public void j() {
        this.f6954b = true;
    }

    public d0 k(u0 u0Var) {
        this.f6953a = u0Var;
        return this;
    }

    public d0(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f6953a = null;
    }
}
