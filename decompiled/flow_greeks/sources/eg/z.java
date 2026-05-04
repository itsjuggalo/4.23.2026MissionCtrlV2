package eg;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f8963a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f8964b = new AtomicInteger(0);

    public static final int g(z zVar, String it) {
        kotlin.jvm.internal.t.f(it, "it");
        return zVar.f8964b.getAndIncrement();
    }

    public final Map b() {
        return this.f8963a;
    }

    public abstract int c(ConcurrentHashMap concurrentHashMap, String str, pd.k kVar);

    public final n d(wd.d kClass) {
        kotlin.jvm.internal.t.f(kClass, "kClass");
        return new n(f(kClass));
    }

    public final int e(String keyQualifiedName) {
        kotlin.jvm.internal.t.f(keyQualifiedName, "keyQualifiedName");
        return c(this.f8963a, keyQualifiedName, new y(this));
    }

    public final int f(wd.d kClass) {
        kotlin.jvm.internal.t.f(kClass, "kClass");
        String strB = kClass.b();
        kotlin.jvm.internal.t.c(strB);
        return e(strB);
    }

    public final Collection h() {
        Collection collectionValues = this.f8963a.values();
        kotlin.jvm.internal.t.e(collectionValues, "<get-values>(...)");
        return collectionValues;
    }
}
