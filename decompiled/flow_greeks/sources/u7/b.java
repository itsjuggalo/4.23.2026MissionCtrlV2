package u7;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x7.f0 f22232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f22234c;

    public b(x7.f0 f0Var, String str, File file) {
        if (f0Var == null) {
            throw new NullPointerException("Null report");
        }
        this.f22232a = f0Var;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f22233b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f22234c = file;
    }

    @Override // u7.z
    public x7.f0 b() {
        return this.f22232a;
    }

    @Override // u7.z
    public File c() {
        return this.f22234c;
    }

    @Override // u7.z
    public String d() {
        return this.f22233b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.f22232a.equals(zVar.b()) && this.f22233b.equals(zVar.d()) && this.f22234c.equals(zVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f22232a.hashCode() ^ 1000003) * 1000003) ^ this.f22233b.hashCode()) * 1000003) ^ this.f22234c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f22232a + ", sessionId=" + this.f22233b + ", reportFile=" + this.f22234c + "}";
    }
}
