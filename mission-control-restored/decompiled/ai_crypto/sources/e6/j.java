package e6;

import b6.InterfaceC1101w0;
import f6.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class j {
    public static final d a(d dVar, int i7, d6.a aVar) {
        if (i7 < 0 && i7 != -2 && i7 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i7).toString());
        }
        if (i7 == -1 && aVar != d6.a.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i7 == -1) {
            aVar = d6.a.DROP_OLDEST;
            i7 = 0;
        }
        int i8 = i7;
        d6.a aVar2 = aVar;
        return dVar instanceof f6.k ? k.a.a((f6.k) dVar, null, i8, aVar2, 1, null) : new f6.h(dVar, null, i8, aVar2, 2, null);
    }

    public static /* synthetic */ d b(d dVar, int i7, d6.a aVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = -2;
        }
        if ((i8 & 2) != 0) {
            aVar = d6.a.SUSPEND;
        }
        return f.a(dVar, i7, aVar);
    }

    public static final void c(H5.g gVar) {
        if (gVar.get(InterfaceC1101w0.f9097L) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + gVar).toString());
    }

    public static final d d(d dVar) {
        return b(dVar, -1, null, 2, null);
    }

    public static final d e(d dVar, H5.g gVar) {
        c(gVar);
        return kotlin.jvm.internal.r.b(gVar, H5.h.f2671a) ? dVar : dVar instanceof f6.k ? k.a.a((f6.k) dVar, gVar, 0, null, 6, null) : new f6.h(dVar, gVar, 0, null, 12, null);
    }
}
