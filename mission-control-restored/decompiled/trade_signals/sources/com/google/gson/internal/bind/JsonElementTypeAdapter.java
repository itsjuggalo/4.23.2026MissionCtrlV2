package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.internal.x;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import p4.C2568a;
import p4.C2570c;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
class JsonElementTypeAdapter extends TypeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonElementTypeAdapter f16065a = new JsonElementTypeAdapter();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16066a;

        static {
            int[] iArr = new int[EnumC2569b.values().length];
            f16066a = iArr;
            try {
                iArr[EnumC2569b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16066a[EnumC2569b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16066a[EnumC2569b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16066a[EnumC2569b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16066a[EnumC2569b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16066a[EnumC2569b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private JsonElementTypeAdapter() {
    }

    private i g(C2568a c2568a, EnumC2569b enumC2569b) throws IOException {
        int i8 = a.f16066a[enumC2569b.ordinal()];
        if (i8 == 3) {
            return new n(c2568a.v0());
        }
        if (i8 == 4) {
            return new n(new x(c2568a.v0()));
        }
        if (i8 == 5) {
            return new n(Boolean.valueOf(c2568a.U()));
        }
        if (i8 == 6) {
            c2568a.r0();
            return k.f16252a;
        }
        throw new IllegalStateException("Unexpected token: " + enumC2569b);
    }

    private i h(C2568a c2568a, EnumC2569b enumC2569b) throws IOException {
        int i8 = a.f16066a[enumC2569b.ordinal()];
        if (i8 == 1) {
            c2568a.c();
            return new f();
        }
        if (i8 != 2) {
            return null;
        }
        c2568a.e();
        return new l();
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public i c(C2568a c2568a) throws IOException {
        if (c2568a instanceof com.google.gson.internal.bind.a) {
            return ((com.google.gson.internal.bind.a) c2568a).L0();
        }
        EnumC2569b enumC2569bX0 = c2568a.x0();
        i iVarH = h(c2568a, enumC2569bX0);
        if (iVarH == null) {
            return g(c2568a, enumC2569bX0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (c2568a.Q()) {
                String strI0 = iVarH instanceof l ? c2568a.i0() : null;
                EnumC2569b enumC2569bX02 = c2568a.x0();
                i iVarH2 = h(c2568a, enumC2569bX02);
                boolean z7 = iVarH2 != null;
                if (iVarH2 == null) {
                    iVarH2 = g(c2568a, enumC2569bX02);
                }
                if (iVarH instanceof f) {
                    ((f) iVarH).I(iVarH2);
                } else {
                    ((l) iVarH).I(strI0, iVarH2);
                }
                if (z7) {
                    arrayDeque.addLast(iVarH);
                    iVarH = iVarH2;
                }
            } else {
                if (iVarH instanceof f) {
                    c2568a.B();
                } else {
                    c2568a.D();
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
    public void e(C2570c c2570c, i iVar) throws IOException {
        if (iVar == null || iVar.C()) {
            c2570c.R();
            return;
        }
        if (iVar.H()) {
            n nVarF = iVar.f();
            if (nVarF.Q()) {
                c2570c.x0(nVarF.N());
                return;
            } else if (nVarF.O()) {
                c2570c.z0(nVarF.a());
                return;
            } else {
                c2570c.y0(nVarF.h());
                return;
            }
        }
        if (iVar.n()) {
            c2570c.f();
            Iterator it = iVar.d().iterator();
            while (it.hasNext()) {
                e(c2570c, (i) it.next());
            }
            c2570c.B();
            return;
        }
        if (!iVar.F()) {
            throw new IllegalArgumentException("Couldn't write " + iVar.getClass());
        }
        c2570c.n();
        for (Map.Entry entry : iVar.e().J()) {
            c2570c.O((String) entry.getKey());
            e(c2570c, (i) entry.getValue());
        }
        c2570c.D();
    }
}
