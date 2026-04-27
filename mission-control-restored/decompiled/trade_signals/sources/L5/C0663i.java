package L5;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: L5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0663i extends AbstractC0647a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B5.k f5181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f5182b;

    public C0663i(B5.k compute) {
        AbstractC2304t.f(compute, "compute");
        this.f5181a = compute;
        this.f5182b = new ConcurrentHashMap();
    }

    @Override // L5.AbstractC0647a
    public Object a(Class key) {
        AbstractC2304t.f(key, "key");
        ConcurrentHashMap concurrentHashMap = this.f5182b;
        Object obj = concurrentHashMap.get(key);
        if (obj != null) {
            return obj;
        }
        Object objInvoke = this.f5181a.invoke(key);
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(key, objInvoke);
        return objPutIfAbsent == null ? objInvoke : objPutIfAbsent;
    }
}
