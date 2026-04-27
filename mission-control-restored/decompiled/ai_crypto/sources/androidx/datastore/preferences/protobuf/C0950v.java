package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0950v extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J f7621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7622b;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.v$a */
    public static class a extends C0950v {
        public a(String str) {
            super(str);
        }
    }

    public C0950v(String str) {
        super(str);
        this.f7621a = null;
    }

    public static C0950v b() {
        return new C0950v("Protocol message end-group tag did not match expected tag.");
    }

    public static C0950v c() {
        return new C0950v("Protocol message contained an invalid tag (zero).");
    }

    public static C0950v d() {
        return new C0950v("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static C0950v f() {
        return new C0950v("CodedInputStream encountered a malformed varint.");
    }

    public static C0950v g() {
        return new C0950v("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C0950v h() {
        return new C0950v("Failed to parse the message.");
    }

    public static C0950v i() {
        return new C0950v("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static C0950v l() {
        return new C0950v("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static C0950v m() {
        return new C0950v("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.f7622b;
    }

    public void j() {
        this.f7622b = true;
    }

    public C0950v k(J j7) {
        this.f7621a = j7;
        return this;
    }

    public C0950v(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f7621a = null;
    }
}
