package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f1920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1921b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends v {
        public a(String str) {
            super(str);
        }
    }

    public v(String str) {
        super(str);
        this.f1920a = null;
    }

    public static v b() {
        return new v("Protocol message end-group tag did not match expected tag.");
    }

    public static v c() {
        return new v("Protocol message contained an invalid tag (zero).");
    }

    public static v d() {
        return new v("Protocol message had invalid UTF-8.");
    }

    public static a e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static v f() {
        return new v("CodedInputStream encountered a malformed varint.");
    }

    public static v g() {
        return new v("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static v h() {
        return new v("Failed to parse the message.");
    }

    public static v i() {
        return new v("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static v l() {
        return new v("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static v m() {
        return new v("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public boolean a() {
        return this.f1921b;
    }

    public void j() {
        this.f1921b = true;
    }

    public v k(j0 j0Var) {
        this.f1920a = j0Var;
        return this;
    }

    public v(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f1920a = null;
    }
}
