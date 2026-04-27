package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements InterfaceC1582g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f13433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13434b;

    public x(Class jClass, String moduleName) {
        r.f(jClass, "jClass");
        r.f(moduleName, "moduleName");
        this.f13433a = jClass;
        this.f13434b = moduleName;
    }

    @Override // kotlin.jvm.internal.InterfaceC1582g
    public Class d() {
        return this.f13433a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && r.b(d(), ((x) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return d() + " (Kotlin reflection is not available)";
    }
}
