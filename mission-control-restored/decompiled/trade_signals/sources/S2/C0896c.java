package S2;

import java.io.File;

/* JADX INFO: renamed from: S2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0896c extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.F f7524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f7526c;

    public C0896c(V2.F f8, String str, File file) {
        if (f8 == null) {
            throw new NullPointerException("Null report");
        }
        this.f7524a = f8;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f7525b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f7526c = file;
    }

    @Override // S2.B
    public V2.F b() {
        return this.f7524a;
    }

    @Override // S2.B
    public File c() {
        return this.f7526c;
    }

    @Override // S2.B
    public String d() {
        return this.f7525b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b8 = (B) obj;
        return this.f7524a.equals(b8.b()) && this.f7525b.equals(b8.d()) && this.f7526c.equals(b8.c());
    }

    public int hashCode() {
        return ((((this.f7524a.hashCode() ^ 1000003) * 1000003) ^ this.f7525b.hashCode()) * 1000003) ^ this.f7526c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f7524a + ", sessionId=" + this.f7525b + ", reportFile=" + this.f7526c + "}";
    }
}
