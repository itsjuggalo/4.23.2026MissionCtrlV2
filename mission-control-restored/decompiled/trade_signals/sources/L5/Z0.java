package L5;

import X5.AbstractC0990f;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap f5139a = new ConcurrentHashMap();

    public static final W5.k a(Class cls) {
        AbstractC2304t.f(cls, "<this>");
        ClassLoader classLoaderJ = AbstractC0990f.j(cls);
        k1 k1Var = new k1(classLoaderJ);
        ConcurrentMap concurrentMap = f5139a;
        WeakReference weakReference = (WeakReference) concurrentMap.get(k1Var);
        if (weakReference != null) {
            W5.k kVar = (W5.k) weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(k1Var, weakReference);
        }
        W5.k kVarA = W5.k.f9300c.a(classLoaderJ);
        while (true) {
            try {
                ConcurrentMap concurrentMap2 = f5139a;
                WeakReference weakReference2 = (WeakReference) concurrentMap2.putIfAbsent(k1Var, new WeakReference(kVarA));
                if (weakReference2 == null) {
                    return kVarA;
                }
                W5.k kVar2 = (W5.k) weakReference2.get();
                if (kVar2 != null) {
                    return kVar2;
                }
                concurrentMap2.remove(k1Var, weakReference2);
            } finally {
                k1Var.a(null);
            }
        }
    }
}
