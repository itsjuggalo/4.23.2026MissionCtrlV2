package e6;

import g6.F;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f13984a = new F("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F f13985b = new F("PENDING");

    public static final o a(Object obj) {
        if (obj == null) {
            obj = f6.m.f14209a;
        }
        return new t(obj);
    }

    public static final d d(s sVar, H5.g gVar, int i7, d6.a aVar) {
        return (((i7 < 0 || i7 >= 2) && i7 != -2) || aVar != d6.a.DROP_OLDEST) ? r.a(sVar, gVar, i7, aVar) : sVar;
    }
}
