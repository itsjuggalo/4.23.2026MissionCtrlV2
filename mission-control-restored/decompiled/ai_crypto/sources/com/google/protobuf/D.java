package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class D extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public V f12554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12555b;

    public static class a extends D {
        public a(String str) {
            super(str);
        }
    }

    public D(String str) {
        super(str);
        this.f12554a = null;
    }

    public static D b() {
        return new D("Protocol message end-group tag did not match expected tag.");
    }

    public static D c() {
        return new D("Protocol message contained an invalid tag (zero).");
    }

    public static D d() {
        return new D("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static D f() {
        return new D("CodedInputStream encountered a malformed varint.");
    }

    public static D g() {
        return new D("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static D h() {
        return new D("Failed to parse the message.");
    }

    public static D i() {
        return new D("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static D l() {
        return new D("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static D m() {
        return new D("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.f12555b;
    }

    public void j() {
        this.f12555b = true;
    }

    public D k(V v7) {
        this.f12554a = v7;
        return this;
    }

    public D(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f12554a = null;
    }
}
