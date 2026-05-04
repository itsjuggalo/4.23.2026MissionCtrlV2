package zd;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f25768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ClassLoader f25770c;

    public j3(ClassLoader classLoader) {
        kotlin.jvm.internal.t.f(classLoader, "classLoader");
        this.f25768a = new WeakReference(classLoader);
        this.f25769b = System.identityHashCode(classLoader);
        this.f25770c = classLoader;
    }

    public final void a(ClassLoader classLoader) {
        this.f25770c = classLoader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j3) && this.f25768a.get() == ((j3) obj).f25768a.get();
    }

    public int hashCode() {
        return this.f25769b;
    }

    public String toString() {
        String string;
        ClassLoader classLoader = (ClassLoader) this.f25768a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
