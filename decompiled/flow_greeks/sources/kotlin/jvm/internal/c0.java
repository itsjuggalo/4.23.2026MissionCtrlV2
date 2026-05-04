package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f14932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14933b;

    public c0(Class jClass, String moduleName) {
        t.f(jClass, "jClass");
        t.f(moduleName, "moduleName");
        this.f14932a = jClass;
        this.f14933b = moduleName;
    }

    @Override // kotlin.jvm.internal.h
    public Class e() {
        return this.f14932a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c0) && t.b(e(), ((c0) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e() + " (Kotlin reflection is not available)";
    }
}
