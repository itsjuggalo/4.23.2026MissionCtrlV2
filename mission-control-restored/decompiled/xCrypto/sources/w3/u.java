package w3;

import y3.F;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f15678a = new F("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F f15679b = new F("PENDING");

    public static final o a(Object obj) {
        if (obj == null) {
            obj = x3.m.f15775a;
        }
        return new t(obj);
    }

    public static final d d(s sVar, Z2.i iVar, int i4, v3.a aVar) {
        return (((i4 < 0 || i4 >= 2) && i4 != -2) || aVar != v3.a.DROP_OLDEST) ? r.a(sVar, iVar, i4, aVar) : sVar;
    }
}
