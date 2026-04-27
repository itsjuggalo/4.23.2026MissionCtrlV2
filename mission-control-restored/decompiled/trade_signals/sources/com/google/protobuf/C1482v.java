package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: renamed from: com.google.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1482v extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J f16593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16594b;

    /* JADX INFO: renamed from: com.google.protobuf.v$a */
    public static class a extends C1482v {
        public a(String str) {
            super(str);
        }
    }

    public C1482v(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f16593a = null;
    }

    public static C1482v b() {
        return new C1482v("Protocol message end-group tag did not match expected tag.");
    }

    public static C1482v c() {
        return new C1482v("Protocol message contained an invalid tag (zero).");
    }

    public static C1482v d() {
        return new C1482v("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static C1482v f() {
        return new C1482v("CodedInputStream encountered a malformed varint.");
    }

    public static C1482v g() {
        return new C1482v("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C1482v h() {
        return new C1482v("Failed to parse the message.");
    }

    public static C1482v i() {
        return new C1482v("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static C1482v l() {
        return new C1482v("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static C1482v m() {
        return new C1482v("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.f16594b;
    }

    public void j() {
        this.f16594b = true;
    }

    public C1482v k(J j8) {
        this.f16593a = j8;
        return this;
    }

    public C1482v(String str) {
        super(str);
        this.f16593a = null;
    }
}
