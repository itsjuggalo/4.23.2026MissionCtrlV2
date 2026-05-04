package zd;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap f25904a = new ConcurrentHashMap();

    public static final ke.k a(Class cls) {
        kotlin.jvm.internal.t.f(cls, "<this>");
        ClassLoader classLoaderJ = le.f.j(cls);
        j3 j3Var = new j3(classLoaderJ);
        ConcurrentMap concurrentMap = f25904a;
        WeakReference weakReference = (WeakReference) concurrentMap.get(j3Var);
        if (weakReference != null) {
            ke.k kVar = (ke.k) weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(j3Var, weakReference);
        }
        ke.k kVarA = ke.k.f14838c.a(classLoaderJ);
        while (true) {
            try {
                ConcurrentMap concurrentMap2 = f25904a;
                WeakReference weakReference2 = (WeakReference) concurrentMap2.putIfAbsent(j3Var, new WeakReference(kVarA));
                if (weakReference2 == null) {
                    return kVarA;
                }
                ke.k kVar2 = (ke.k) weakReference2.get();
                if (kVar2 != null) {
                    return kVar2;
                }
                concurrentMap2.remove(j3Var, weakReference2);
            } finally {
                j3Var.a(null);
            }
        }
    }
}
