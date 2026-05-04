package zd;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pd.k f25743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f25744b;

    public i(pd.k compute) {
        kotlin.jvm.internal.t.f(compute, "compute");
        this.f25743a = compute;
        this.f25744b = new ConcurrentHashMap();
    }

    @Override // zd.a
    public Object a(Class key) {
        kotlin.jvm.internal.t.f(key, "key");
        ConcurrentHashMap concurrentHashMap = this.f25744b;
        Object obj = concurrentHashMap.get(key);
        if (obj != null) {
            return obj;
        }
        Object objInvoke = this.f25743a.invoke(key);
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(key, objInvoke);
        return objPutIfAbsent == null ? objInvoke : objPutIfAbsent;
    }
}
