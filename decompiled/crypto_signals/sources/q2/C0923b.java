package q2;

import java.io.File;
import t2.C1114B;

/* JADX INFO: renamed from: q2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1114B f9163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f9165c;

    public C0923b(C1114B c1114b, String str, File file) {
        this.f9163a = c1114b;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f9164b = str;
        this.f9165c = file;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0923b)) {
            return false;
        }
        C0923b c0923b = (C0923b) obj;
        return this.f9163a.equals(c0923b.f9163a) && this.f9164b.equals(c0923b.f9164b) && this.f9165c.equals(c0923b.f9165c);
    }

    public final int hashCode() {
        return ((((this.f9163a.hashCode() ^ 1000003) * 1000003) ^ this.f9164b.hashCode()) * 1000003) ^ this.f9165c.hashCode();
    }

    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f9163a + ", sessionId=" + this.f9164b + ", reportFile=" + this.f9165c + "}";
    }
}
