package b7;

import d7.D;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f13315a = new D("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D f13316b = new D("PENDING");

    public static final o a(Object obj) {
        if (obj == null) {
            obj = c7.m.f13599a;
        }
        return new t(obj);
    }

    public static final d d(s sVar, InterfaceC2711i interfaceC2711i, int i8, a7.a aVar) {
        return (((i8 < 0 || i8 >= 2) && i8 != -2) || aVar != a7.a.f10174b) ? r.a(sVar, interfaceC2711i, i8, aVar) : sVar;
    }
}
