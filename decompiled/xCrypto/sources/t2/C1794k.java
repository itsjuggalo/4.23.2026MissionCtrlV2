package t2;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q2.u;
import q2.v;
import q2.w;
import q2.x;
import s2.z;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: t2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1794k extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f14791c = g(u.f14286a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2.e f14792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f14793b;

    /* JADX INFO: renamed from: t2.k$a */
    public class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f14794a;

        public a(v vVar) {
            this.f14794a = vVar;
        }

        @Override // q2.x
        public w create(q2.e eVar, C1925a c1925a) {
            a aVar = null;
            if (c1925a.c() == Object.class) {
                return new C1794k(eVar, this.f14794a, aVar);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: t2.k$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14795a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f14795a = iArr;
            try {
                iArr[y2.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14795a[y2.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14795a[y2.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14795a[y2.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14795a[y2.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14795a[y2.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public /* synthetic */ C1794k(q2.e eVar, v vVar, a aVar) {
        this(eVar, vVar);
    }

    public static x f(v vVar) {
        return vVar == u.f14286a ? f14791c : g(vVar);
    }

    private static x g(v vVar) {
        return new a(vVar);
    }

    @Override // q2.w
    public Object c(C1946a c1946a) throws IOException {
        y2.b bVarR0 = c1946a.r0();
        Object objI = i(c1946a, bVarR0);
        if (objI == null) {
            return h(c1946a, bVarR0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (c1946a.d0()) {
                String strL0 = objI instanceof Map ? c1946a.l0() : null;
                y2.b bVarR02 = c1946a.r0();
                Object objI2 = i(c1946a, bVarR02);
                boolean z4 = objI2 != null;
                if (objI2 == null) {
                    objI2 = h(c1946a, bVarR02);
                }
                if (objI instanceof List) {
                    ((List) objI).add(objI2);
                } else {
                    ((Map) objI).put(strL0, objI2);
                }
                if (z4) {
                    arrayDeque.addLast(objI);
                    objI = objI2;
                }
            } else {
                if (objI instanceof List) {
                    c1946a.E();
                } else {
                    c1946a.G();
                }
                if (arrayDeque.isEmpty()) {
                    return objI;
                }
                objI = arrayDeque.removeLast();
            }
        }
    }

    @Override // q2.w
    public void e(y2.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.e0();
            return;
        }
        w wVarK = this.f14792a.k(obj.getClass());
        if (!(wVarK instanceof C1794k)) {
            wVarK.e(cVar, obj);
        } else {
            cVar.x();
            cVar.G();
        }
    }

    public final Object h(C1946a c1946a, y2.b bVar) throws IOException {
        int i4 = b.f14795a[bVar.ordinal()];
        if (i4 == 3) {
            return c1946a.p0();
        }
        if (i4 == 4) {
            return this.f14793b.a(c1946a);
        }
        if (i4 == 5) {
            return Boolean.valueOf(c1946a.h0());
        }
        if (i4 == 6) {
            c1946a.n0();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    public final Object i(C1946a c1946a, y2.b bVar) throws IOException {
        int i4 = b.f14795a[bVar.ordinal()];
        if (i4 == 1) {
            c1946a.f();
            return new ArrayList();
        }
        if (i4 != 2) {
            return null;
        }
        c1946a.g();
        return new z();
    }

    public C1794k(q2.e eVar, v vVar) {
        this.f14792a = eVar;
        this.f14793b = vVar;
    }
}
