package h3;

import java.io.File;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: h3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1688b extends AbstractC1675F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2074F f14797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f14799c;

    public C1688b(AbstractC2074F abstractC2074F, String str, File file) {
        if (abstractC2074F == null) {
            throw new NullPointerException("Null report");
        }
        this.f14797a = abstractC2074F;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f14798b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f14799c = file;
    }

    @Override // h3.AbstractC1675F
    public AbstractC2074F b() {
        return this.f14797a;
    }

    @Override // h3.AbstractC1675F
    public File c() {
        return this.f14799c;
    }

    @Override // h3.AbstractC1675F
    public String d() {
        return this.f14798b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1675F)) {
            return false;
        }
        AbstractC1675F abstractC1675F = (AbstractC1675F) obj;
        return this.f14797a.equals(abstractC1675F.b()) && this.f14798b.equals(abstractC1675F.d()) && this.f14799c.equals(abstractC1675F.c());
    }

    public int hashCode() {
        return ((((this.f14797a.hashCode() ^ 1000003) * 1000003) ^ this.f14798b.hashCode()) * 1000003) ^ this.f14799c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f14797a + ", sessionId=" + this.f14798b + ", reportFile=" + this.f14799c + "}";
    }
}
