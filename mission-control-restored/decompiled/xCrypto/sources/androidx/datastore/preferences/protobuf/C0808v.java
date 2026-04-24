package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0808v extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J f7213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7214b;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.v$a */
    public static class a extends C0808v {
        public a(String str) {
            super(str);
        }
    }

    public C0808v(String str) {
        super(str);
        this.f7213a = null;
    }

    public static C0808v b() {
        return new C0808v("Protocol message end-group tag did not match expected tag.");
    }

    public static C0808v c() {
        return new C0808v("Protocol message contained an invalid tag (zero).");
    }

    public static C0808v d() {
        return new C0808v("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static C0808v f() {
        return new C0808v("CodedInputStream encountered a malformed varint.");
    }

    public static C0808v g() {
        return new C0808v("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C0808v h() {
        return new C0808v("Failed to parse the message.");
    }

    public static C0808v i() {
        return new C0808v("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static C0808v l() {
        return new C0808v("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static C0808v m() {
        return new C0808v("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.f7214b;
    }

    public void j() {
        this.f7214b = true;
    }

    public C0808v k(J j4) {
        this.f7213a = j4;
        return this;
    }

    public C0808v(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f7213a = null;
    }
}
