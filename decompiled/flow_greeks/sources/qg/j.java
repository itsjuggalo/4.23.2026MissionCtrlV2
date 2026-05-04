package qg;

import ng.y1;
import rg.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j {
    public static final d a(d dVar, int i10, pg.a aVar) {
        if (i10 < 0 && i10 != -2 && i10 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
        }
        if (i10 == -1 && aVar != pg.a.f18621a) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i10 == -1) {
            aVar = pg.a.f18622b;
            i10 = 0;
        }
        int i11 = i10;
        pg.a aVar2 = aVar;
        if (dVar instanceof rg.k) {
            return k.a.a((rg.k) dVar, null, i11, aVar2, 1, null);
        }
        return new rg.h(dVar, null, i11, aVar2, 2, null);
    }

    public static /* synthetic */ d b(d dVar, int i10, pg.a aVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            aVar = pg.a.f18621a;
        }
        return f.a(dVar, i10, aVar);
    }

    public static final void c(gd.i iVar) {
        if (iVar.get(y1.N) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + iVar).toString());
    }

    public static final d d(d dVar) {
        return b(dVar, -1, null, 2, null);
    }

    public static final d e(d dVar, gd.i iVar) {
        c(iVar);
        if (kotlin.jvm.internal.t.b(iVar, gd.j.f10531a)) {
            return dVar;
        }
        if (dVar instanceof rg.k) {
            return k.a.a((rg.k) dVar, iVar, 0, null, 6, null);
        }
        return new rg.h(dVar, iVar, 0, null, 12, null);
    }
}
