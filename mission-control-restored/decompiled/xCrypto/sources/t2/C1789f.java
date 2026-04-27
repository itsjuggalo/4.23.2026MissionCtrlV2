package t2;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import q2.w;
import s2.y;
import y2.C1946a;

/* JADX INFO: renamed from: t2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1789f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1789f f14767a = new C1789f();

    /* JADX INFO: renamed from: t2.f$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14768a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f14768a = iArr;
            try {
                iArr[y2.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14768a[y2.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14768a[y2.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14768a[y2.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14768a[y2.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14768a[y2.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private C1789f() {
    }

    @Override // q2.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public q2.j c(C1946a c1946a) throws IOException {
        if (c1946a instanceof C1790g) {
            return ((C1790g) c1946a).F0();
        }
        y2.b bVarR0 = c1946a.r0();
        q2.j jVarH = h(c1946a, bVarR0);
        if (jVarH == null) {
            return g(c1946a, bVarR0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (c1946a.d0()) {
                String strL0 = jVarH instanceof q2.m ? c1946a.l0() : null;
                y2.b bVarR02 = c1946a.r0();
                q2.j jVarH2 = h(c1946a, bVarR02);
                boolean z4 = jVarH2 != null;
                if (jVarH2 == null) {
                    jVarH2 = g(c1946a, bVarR02);
                }
                if (jVarH instanceof q2.g) {
                    ((q2.g) jVarH).q(jVarH2);
                } else {
                    ((q2.m) jVarH).q(strL0, jVarH2);
                }
                if (z4) {
                    arrayDeque.addLast(jVarH);
                    jVarH = jVarH2;
                }
            } else {
                if (jVarH instanceof q2.g) {
                    c1946a.E();
                } else {
                    c1946a.G();
                }
                if (arrayDeque.isEmpty()) {
                    return jVarH;
                }
                jVarH = (q2.j) arrayDeque.removeLast();
            }
        }
    }

    public final q2.j g(C1946a c1946a, y2.b bVar) throws IOException {
        int i4 = a.f14768a[bVar.ordinal()];
        if (i4 == 3) {
            return new q2.o(c1946a.p0());
        }
        if (i4 == 4) {
            return new q2.o(new y(c1946a.p0()));
        }
        if (i4 == 5) {
            return new q2.o(Boolean.valueOf(c1946a.h0()));
        }
        if (i4 == 6) {
            c1946a.n0();
            return q2.l.f14271a;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    public final q2.j h(C1946a c1946a, y2.b bVar) throws IOException {
        int i4 = a.f14768a[bVar.ordinal()];
        if (i4 == 1) {
            c1946a.f();
            return new q2.g();
        }
        if (i4 != 2) {
            return null;
        }
        c1946a.g();
        return new q2.m();
    }

    @Override // q2.w
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(y2.c cVar, q2.j jVar) throws IOException {
        if (jVar == null || jVar.n()) {
            cVar.e0();
            return;
        }
        if (jVar.p()) {
            q2.o oVarK = jVar.k();
            if (oVarK.y()) {
                cVar.r0(oVarK.v());
                return;
            } else if (oVarK.w()) {
                cVar.t0(oVarK.c());
                return;
            } else {
                cVar.s0(oVarK.l());
                return;
            }
        }
        if (jVar.m()) {
            cVar.p();
            Iterator it = jVar.f().iterator();
            while (it.hasNext()) {
                e(cVar, (q2.j) it.next());
            }
            cVar.E();
            return;
        }
        if (!jVar.o()) {
            throw new IllegalArgumentException("Couldn't write " + jVar.getClass());
        }
        cVar.x();
        for (Map.Entry entry : jVar.i().r()) {
            cVar.a0((String) entry.getKey());
            e(cVar, (q2.j) entry.getValue());
        }
        cVar.G();
    }
}
