package w3;

import t3.InterfaceC1846w0;
import x3.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j {
    public static final d a(d dVar, int i4, v3.a aVar) {
        if (i4 < 0 && i4 != -2 && i4 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i4).toString());
        }
        if (i4 == -1 && aVar != v3.a.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i4 == -1) {
            aVar = v3.a.DROP_OLDEST;
            i4 = 0;
        }
        int i5 = i4;
        v3.a aVar2 = aVar;
        return dVar instanceof x3.k ? k.a.a((x3.k) dVar, null, i5, aVar2, 1, null) : new x3.h(dVar, null, i5, aVar2, 2, null);
    }

    public static /* synthetic */ d b(d dVar, int i4, v3.a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = -2;
        }
        if ((i5 & 2) != 0) {
            aVar = v3.a.SUSPEND;
        }
        return f.a(dVar, i4, aVar);
    }

    public static final void c(Z2.i iVar) {
        if (iVar.get(InterfaceC1846w0.f15039M) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + iVar).toString());
    }

    public static final d d(d dVar) {
        return b(dVar, -1, null, 2, null);
    }

    public static final d e(d dVar, Z2.i iVar) {
        c(iVar);
        return kotlin.jvm.internal.r.b(iVar, Z2.j.f6012a) ? dVar : dVar instanceof x3.k ? k.a.a((x3.k) dVar, iVar, 0, null, 6, null) : new x3.h(dVar, iVar, 0, null, 12, null);
    }
}
