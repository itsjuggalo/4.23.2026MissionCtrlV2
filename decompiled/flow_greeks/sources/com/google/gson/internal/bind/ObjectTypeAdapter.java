package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.y;
import com.google.gson.t;
import com.google.gson.u;
import com.google.gson.v;
import gb.c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f6713c = g(t.f6891a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f6714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f6715b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6717a;

        static {
            int[] iArr = new int[gb.b.values().length];
            f6717a = iArr;
            try {
                iArr[gb.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6717a[gb.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6717a[gb.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6717a[gb.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6717a[gb.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6717a[gb.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static v f(u uVar) {
        return uVar == t.f6891a ? f6713c : g(uVar);
    }

    private static v g(final u uVar) {
        return new v() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, fb.a aVar) {
                if (aVar.c() == Object.class) {
                    return new ObjectTypeAdapter(gson, uVar);
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.TypeAdapter
    public Object c(gb.a aVar) throws IOException {
        gb.b bVarN0 = aVar.n0();
        Object objI = i(aVar, bVarN0);
        if (objI == null) {
            return h(aVar, bVarN0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.Z()) {
                String strH0 = objI instanceof Map ? aVar.h0() : null;
                gb.b bVarN02 = aVar.n0();
                Object objI2 = i(aVar, bVarN02);
                boolean z10 = objI2 != null;
                if (objI2 == null) {
                    objI2 = h(aVar, bVarN02);
                }
                if (objI instanceof List) {
                    ((List) objI).add(objI2);
                } else {
                    ((Map) objI).put(strH0, objI2);
                }
                if (z10) {
                    arrayDeque.addLast(objI);
                    objI = objI2;
                }
            } else {
                if (objI instanceof List) {
                    aVar.E();
                } else {
                    aVar.G();
                }
                if (arrayDeque.isEmpty()) {
                    return objI;
                }
                objI = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void e(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.a0();
            return;
        }
        TypeAdapter typeAdapterL = this.f6714a.l(obj.getClass());
        if (!(typeAdapterL instanceof ObjectTypeAdapter)) {
            typeAdapterL.e(cVar, obj);
        } else {
            cVar.u();
            cVar.G();
        }
    }

    public final Object h(gb.a aVar, gb.b bVar) throws IOException {
        int i10 = a.f6717a[bVar.ordinal()];
        if (i10 == 3) {
            return aVar.l0();
        }
        if (i10 == 4) {
            return this.f6715b.a(aVar);
        }
        if (i10 == 5) {
            return Boolean.valueOf(aVar.d0());
        }
        if (i10 == 6) {
            aVar.j0();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    public final Object i(gb.a aVar, gb.b bVar) throws IOException {
        int i10 = a.f6717a[bVar.ordinal()];
        if (i10 == 1) {
            aVar.c();
            return new ArrayList();
        }
        if (i10 != 2) {
            return null;
        }
        aVar.e();
        return new y();
    }

    public ObjectTypeAdapter(Gson gson, u uVar) {
        this.f6714a = gson;
        this.f6715b = uVar;
    }
}
