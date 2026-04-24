package P2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: P2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0208f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A2.c f2438b;

    public C0208f(int i, A2.c cVar) {
        this.f2437a = i;
        this.f2438b = cVar;
    }

    public static C0208f a(int i, HashMap map) {
        A2.c cVarL = Q2.g.f2671a;
        for (Map.Entry entry : map.entrySet()) {
            cVarL = cVarL.l((Q2.h) entry.getKey(), ((z) entry.getValue()).f2504a);
        }
        return new C0208f(i, cVarL);
    }
}
