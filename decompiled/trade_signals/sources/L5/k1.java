package L5;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f5197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ClassLoader f5199c;

    public k1(ClassLoader classLoader) {
        AbstractC2304t.f(classLoader, "classLoader");
        this.f5197a = new WeakReference(classLoader);
        this.f5198b = System.identityHashCode(classLoader);
        this.f5199c = classLoader;
    }

    public final void a(ClassLoader classLoader) {
        this.f5199c = classLoader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k1) && this.f5197a.get() == ((k1) obj).f5197a.get();
    }

    public int hashCode() {
        return this.f5198b;
    }

    public String toString() {
        String string;
        ClassLoader classLoader = (ClassLoader) this.f5197a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
