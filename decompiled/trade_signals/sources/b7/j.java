package b7;

import Y6.InterfaceC1033u0;
import c7.k;
import kotlin.jvm.internal.AbstractC2304t;
import s5.C2712j;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class j {
    public static final d a(d dVar, int i8, a7.a aVar) {
        if (i8 < 0 && i8 != -2 && i8 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i8).toString());
        }
        if (i8 == -1 && aVar != a7.a.f10173a) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i8 == -1) {
            aVar = a7.a.f10174b;
            i8 = 0;
        }
        int i9 = i8;
        a7.a aVar2 = aVar;
        if (dVar instanceof c7.k) {
            return k.a.a((c7.k) dVar, null, i9, aVar2, 1, null);
        }
        return new c7.h(dVar, null, i9, aVar2, 2, null);
    }

    public static /* synthetic */ d b(d dVar, int i8, a7.a aVar, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = -2;
        }
        if ((i9 & 2) != 0) {
            aVar = a7.a.f10173a;
        }
        return f.a(dVar, i8, aVar);
    }

    public static final void c(InterfaceC2711i interfaceC2711i) {
        if (interfaceC2711i.a(InterfaceC1033u0.f9694L) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + interfaceC2711i).toString());
    }

    public static final d d(d dVar) {
        return b(dVar, -1, null, 2, null);
    }

    public static final d e(d dVar, InterfaceC2711i interfaceC2711i) {
        c(interfaceC2711i);
        if (AbstractC2304t.b(interfaceC2711i, C2712j.f23116a)) {
            return dVar;
        }
        if (dVar instanceof c7.k) {
            return k.a.a((c7.k) dVar, interfaceC2711i, 0, null, 6, null);
        }
        return new c7.h(dVar, interfaceC2711i, 0, null, 12, null);
    }
}
