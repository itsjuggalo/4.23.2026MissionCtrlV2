package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements InterfaceC2145g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f18272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18273b;

    public x(Class jClass, String moduleName) {
        r.f(jClass, "jClass");
        r.f(moduleName, "moduleName");
        this.f18272a = jClass;
        this.f18273b = moduleName;
    }

    @Override // kotlin.jvm.internal.InterfaceC2145g
    public Class e() {
        return this.f18272a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && r.b(e(), ((x) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString() + " (Kotlin reflection is not available)";
    }
}
