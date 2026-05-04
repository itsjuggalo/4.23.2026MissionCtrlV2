package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.internal.x;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import gb.c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
class JsonElementTypeAdapter extends TypeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonElementTypeAdapter f6701a = new JsonElementTypeAdapter();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6702a;

        static {
            int[] iArr = new int[gb.b.values().length];
            f6702a = iArr;
            try {
                iArr[gb.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6702a[gb.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6702a[gb.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6702a[gb.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6702a[gb.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6702a[gb.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private JsonElementTypeAdapter() {
    }

    private i g(gb.a aVar, gb.b bVar) throws IOException {
        int i10 = a.f6702a[bVar.ordinal()];
        if (i10 == 3) {
            return new n(aVar.l0());
        }
        if (i10 == 4) {
            return new n(new x(aVar.l0()));
        }
        if (i10 == 5) {
            return new n(Boolean.valueOf(aVar.d0()));
        }
        if (i10 == 6) {
            aVar.j0();
            return k.f6876a;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    private i h(gb.a aVar, gb.b bVar) throws IOException {
        int i10 = a.f6702a[bVar.ordinal()];
        if (i10 == 1) {
            aVar.c();
            return new f();
        }
        if (i10 != 2) {
            return null;
        }
        aVar.e();
        return new l();
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public i c(gb.a aVar) throws IOException {
        if (aVar instanceof com.google.gson.internal.bind.a) {
            return ((com.google.gson.internal.bind.a) aVar).B0();
        }
        gb.b bVarN0 = aVar.n0();
        i iVarH = h(aVar, bVarN0);
        if (iVarH == null) {
            return g(aVar, bVarN0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.Z()) {
                String strH0 = iVarH instanceof l ? aVar.h0() : null;
                gb.b bVarN02 = aVar.n0();
                i iVarH2 = h(aVar, bVarN02);
                boolean z10 = iVarH2 != null;
                if (iVarH2 == null) {
                    iVarH2 = g(aVar, bVarN02);
                }
                if (iVarH instanceof f) {
                    ((f) iVarH).s(iVarH2);
                } else {
                    ((l) iVarH).s(strH0, iVarH2);
                }
                if (z10) {
                    arrayDeque.addLast(iVarH);
                    iVarH = iVarH2;
                }
            } else {
                if (iVarH instanceof f) {
                    aVar.E();
                } else {
                    aVar.G();
                }
                if (arrayDeque.isEmpty()) {
                    return iVarH;
                }
                iVarH = (i) arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(c cVar, i iVar) throws IOException {
        if (iVar == null || iVar.p()) {
            cVar.a0();
            return;
        }
        if (iVar.r()) {
            n nVarE = iVar.e();
            if (nVarE.L()) {
                cVar.n0(nVarE.A());
                return;
            } else if (nVarE.G()) {
                cVar.p0(nVarE.a());
                return;
            } else {
                cVar.o0(nVarE.f());
                return;
            }
        }
        if (iVar.g()) {
            cVar.o();
            Iterator it = iVar.c().iterator();
            while (it.hasNext()) {
                e(cVar, (i) it.next());
            }
            cVar.E();
            return;
        }
        if (!iVar.q()) {
            throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
        }
        cVar.u();
        for (Map.Entry entry : iVar.d().u()) {
            cVar.R((String) entry.getKey());
            e(cVar, (i) entry.getValue());
        }
        cVar.G();
    }
}
