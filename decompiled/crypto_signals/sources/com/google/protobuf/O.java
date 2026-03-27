package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class O extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5662a;

    public static O a() {
        return new O("Protocol message end-group tag did not match expected tag.");
    }

    public static O b() {
        return new O("Protocol message contained an invalid tag (zero).");
    }

    public static O c() {
        return new O("Protocol message had invalid UTF-8.");
    }

    public static N d() {
        return new N("Protocol message tag had invalid wire type.");
    }

    public static O e() {
        return new O("CodedInputStream encountered a malformed varint.");
    }

    public static O f() {
        return new O("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static O g() {
        return new O("Failed to parse the message.");
    }

    public static O h() {
        return new O("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
