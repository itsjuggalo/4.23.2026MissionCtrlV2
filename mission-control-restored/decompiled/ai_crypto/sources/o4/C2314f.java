package o4;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import l4.AbstractC2177j;
import l4.C2174g;
import l4.w;
import n4.y;
import t4.C2657a;

/* JADX INFO: renamed from: o4.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2314f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2314f f20076a = new C2314f();

    /* JADX INFO: renamed from: o4.f$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20077a;

        static {
            int[] iArr = new int[t4.b.values().length];
            f20077a = iArr;
            try {
                iArr[t4.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20077a[t4.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20077a[t4.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20077a[t4.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20077a[t4.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20077a[t4.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private C2314f() {
    }

    @Override // l4.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC2177j c(C2657a c2657a) throws IOException {
        if (c2657a instanceof C2315g) {
            return ((C2315g) c2657a).a1();
        }
        t4.b bVarM0 = c2657a.M0();
        AbstractC2177j abstractC2177jH = h(c2657a, bVarM0);
        if (abstractC2177jH == null) {
            return g(c2657a, bVarM0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (c2657a.y0()) {
                String strG0 = abstractC2177jH instanceof l4.m ? c2657a.G0() : null;
                t4.b bVarM02 = c2657a.M0();
                AbstractC2177j abstractC2177jH2 = h(c2657a, bVarM02);
                boolean z7 = abstractC2177jH2 != null;
                if (abstractC2177jH2 == null) {
                    abstractC2177jH2 = g(c2657a, bVarM02);
                }
                if (abstractC2177jH instanceof C2174g) {
                    ((C2174g) abstractC2177jH).n(abstractC2177jH2);
                } else {
                    ((l4.m) abstractC2177jH).n(strG0, abstractC2177jH2);
                }
                if (z7) {
                    arrayDeque.addLast(abstractC2177jH);
                    abstractC2177jH = abstractC2177jH2;
                }
            } else {
                if (abstractC2177jH instanceof C2174g) {
                    c2657a.M();
                } else {
                    c2657a.O();
                }
                if (arrayDeque.isEmpty()) {
                    return abstractC2177jH;
                }
                abstractC2177jH = (AbstractC2177j) arrayDeque.removeLast();
            }
        }
    }

    public final AbstractC2177j g(C2657a c2657a, t4.b bVar) throws IOException {
        int i7 = a.f20077a[bVar.ordinal()];
        if (i7 == 3) {
            return new l4.o(c2657a.K0());
        }
        if (i7 == 4) {
            return new l4.o(new y(c2657a.K0()));
        }
        if (i7 == 5) {
            return new l4.o(Boolean.valueOf(c2657a.C0()));
        }
        if (i7 == 6) {
            c2657a.I0();
            return l4.l.f18379a;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    public final AbstractC2177j h(C2657a c2657a, t4.b bVar) throws IOException {
        int i7 = a.f20077a[bVar.ordinal()];
        if (i7 == 1) {
            c2657a.i();
            return new C2174g();
        }
        if (i7 != 2) {
            return null;
        }
        c2657a.A();
        return new l4.m();
    }

    @Override // l4.w
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(t4.c cVar, AbstractC2177j abstractC2177j) throws IOException {
        if (abstractC2177j == null || abstractC2177j.k()) {
            cVar.z0();
            return;
        }
        if (abstractC2177j.m()) {
            l4.o oVarG = abstractC2177j.g();
            if (oVarG.x()) {
                cVar.M0(oVarG.t());
                return;
            } else if (oVarG.u()) {
                cVar.O0(oVarG.a());
                return;
            } else {
                cVar.N0(oVarG.h());
                return;
            }
        }
        if (abstractC2177j.j()) {
            cVar.G();
            Iterator it = abstractC2177j.b().iterator();
            while (it.hasNext()) {
                e(cVar, (AbstractC2177j) it.next());
            }
            cVar.M();
            return;
        }
        if (!abstractC2177j.l()) {
            throw new IllegalArgumentException("Couldn't write " + abstractC2177j.getClass());
        }
        cVar.H();
        for (Map.Entry entry : abstractC2177j.c().p()) {
            cVar.i0((String) entry.getKey());
            e(cVar, (AbstractC2177j) entry.getValue());
        }
        cVar.O();
    }
}
