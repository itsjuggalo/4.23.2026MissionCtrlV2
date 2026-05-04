package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f22558d;

    public c0(String processName, int i10, int i11, boolean z10) {
        kotlin.jvm.internal.t.f(processName, "processName");
        this.f22555a = processName;
        this.f22556b = i10;
        this.f22557c = i11;
        this.f22558d = z10;
    }

    public final int a() {
        return this.f22557c;
    }

    public final int b() {
        return this.f22556b;
    }

    public final String c() {
        return this.f22555a;
    }

    public final boolean d() {
        return this.f22558d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return kotlin.jvm.internal.t.b(this.f22555a, c0Var.f22555a) && this.f22556b == c0Var.f22556b && this.f22557c == c0Var.f22557c && this.f22558d == c0Var.f22558d;
    }

    public int hashCode() {
        return (((((this.f22555a.hashCode() * 31) + Integer.hashCode(this.f22556b)) * 31) + Integer.hashCode(this.f22557c)) * 31) + Boolean.hashCode(this.f22558d);
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.f22555a + ", pid=" + this.f22556b + ", importance=" + this.f22557c + ", isDefaultProcess=" + this.f22558d + ')';
    }
}
