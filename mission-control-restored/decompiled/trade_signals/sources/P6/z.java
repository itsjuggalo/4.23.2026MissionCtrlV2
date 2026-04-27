package P6;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6595a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f6596b = new AtomicInteger(0);

    public static final int g(z zVar, String it) {
        AbstractC2304t.f(it, "it");
        return zVar.f6596b.getAndIncrement();
    }

    public final Map b() {
        return this.f6595a;
    }

    public abstract int c(ConcurrentHashMap concurrentHashMap, String str, B5.k kVar);

    public final n d(I5.d kClass) {
        AbstractC2304t.f(kClass, "kClass");
        return new n(e(kClass));
    }

    public final int e(I5.d kClass) {
        AbstractC2304t.f(kClass, "kClass");
        String strQ = kClass.q();
        AbstractC2304t.c(strQ);
        return f(strQ);
    }

    public final int f(String keyQualifiedName) {
        AbstractC2304t.f(keyQualifiedName, "keyQualifiedName");
        return c(this.f6595a, keyQualifiedName, new y(this));
    }

    public final Collection h() {
        Collection collectionValues = this.f6595a.values();
        AbstractC2304t.e(collectionValues, "<get-values>(...)");
        return collectionValues;
    }
}
