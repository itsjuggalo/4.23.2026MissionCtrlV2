package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes.dex */
public final class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f7929a;

    public l(Class jClass) {
        j.e(jClass, "jClass");
        this.f7929a = jClass;
    }

    @Override // kotlin.jvm.internal.d
    public final Class a() {
        return this.f7929a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return j.a(this.f7929a, ((l) obj).f7929a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7929a.hashCode();
    }

    public final String toString() {
        return this.f7929a + " (Kotlin reflection is not available)";
    }
}
