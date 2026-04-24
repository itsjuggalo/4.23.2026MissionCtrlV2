package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1119v extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J f11433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11434b;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.v$a */
    public static class a extends C1119v {
        public a(String str) {
            super(str);
        }
    }

    public C1119v(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f11433a = null;
    }

    public static C1119v b() {
        return new C1119v("Protocol message end-group tag did not match expected tag.");
    }

    public static C1119v c() {
        return new C1119v("Protocol message contained an invalid tag (zero).");
    }

    public static C1119v d() {
        return new C1119v("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static C1119v f() {
        return new C1119v("CodedInputStream encountered a malformed varint.");
    }

    public static C1119v g() {
        return new C1119v("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C1119v h() {
        return new C1119v("Failed to parse the message.");
    }

    public static C1119v i() {
        return new C1119v("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static C1119v l() {
        return new C1119v("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static C1119v m() {
        return new C1119v("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.f11434b;
    }

    public void j() {
        this.f11434b = true;
    }

    public C1119v k(J j8) {
        this.f11433a = j8;
        return this;
    }

    public C1119v(String str) {
        super(str);
        this.f11433a = null;
    }
}
