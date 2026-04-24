package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class C implements InterfaceC2293h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f20463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20464b;

    public C(Class jClass, String moduleName) {
        AbstractC2304t.f(jClass, "jClass");
        AbstractC2304t.f(moduleName, "moduleName");
        this.f20463a = jClass;
        this.f20464b = moduleName;
    }

    @Override // kotlin.jvm.internal.InterfaceC2293h
    public Class e() {
        return this.f20463a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C) && AbstractC2304t.b(e(), ((C) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e() + " (Kotlin reflection is not available)";
    }
}
