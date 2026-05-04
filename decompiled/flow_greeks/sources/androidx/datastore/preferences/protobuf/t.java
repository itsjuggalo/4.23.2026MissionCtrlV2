package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.u;
import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t extends androidx.datastore.preferences.protobuf.a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, t> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected f1 unknownFields = f1.c();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a extends a.AbstractC0020a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f1896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t f1897b;

        public a(t tVar) {
            this.f1896a = tVar;
            if (tVar.C()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f1897b = p();
        }

        public static void o(Object obj, Object obj2) {
            t0.a().d(obj).a(obj, obj2);
        }

        private t p() {
            return this.f1896a.I();
        }

        public final t i() {
            t tVarE = e();
            if (tVarE.A()) {
                return tVarE;
            }
            throw a.AbstractC0020a.h(tVarE);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public t e() {
            if (!this.f1897b.C()) {
                return this.f1897b;
            }
            this.f1897b.D();
            return this.f1897b;
        }

        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVarC = a().c();
            aVarC.f1897b = e();
            return aVarC;
        }

        public final void l() {
            if (this.f1897b.C()) {
                return;
            }
            m();
        }

        public void m() {
            t tVarP = p();
            o(tVarP, this.f1897b);
            this.f1897b = tVarP;
        }

        @Override // androidx.datastore.preferences.protobuf.k0
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public t a() {
            return this.f1896a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends androidx.datastore.preferences.protobuf.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t f1898b;

        public b(t tVar) {
            this.f1898b = tVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends k {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static final boolean B(t tVar, boolean z10) {
        byte bByteValue = ((Byte) tVar.q(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = t0.a().d(tVar).c(tVar);
        if (z10) {
            tVar.r(d.SET_MEMOIZED_IS_INITIALIZED, zC ? tVar : null);
        }
        return zC;
    }

    public static u.b F(u.b bVar) {
        int size = bVar.size();
        return bVar.i(size == 0 ? 10 : size * 2);
    }

    public static Object H(j0 j0Var, String str, Object[] objArr) {
        return new v0(j0Var, str, objArr);
    }

    public static t J(t tVar, InputStream inputStream) {
        return k(K(tVar, g.g(inputStream), m.b()));
    }

    public static t K(t tVar, g gVar, m mVar) throws v {
        t tVarI = tVar.I();
        try {
            x0 x0VarD = t0.a().d(tVarI);
            x0VarD.h(tVarI, h.O(gVar), mVar);
            x0VarD.b(tVarI);
            return tVarI;
        } catch (d1 e10) {
            throw e10.a().k(tVarI);
        } catch (v e11) {
            e = e11;
            if (e.a()) {
                e = new v(e);
            }
            throw e.k(tVarI);
        } catch (IOException e12) {
            if (e12.getCause() instanceof v) {
                throw ((v) e12.getCause());
            }
            throw new v(e12).k(tVarI);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof v) {
                throw ((v) e13.getCause());
            }
            throw e13;
        }
    }

    public static void L(Class cls, t tVar) {
        tVar.E();
        defaultInstanceMap.put(cls, tVar);
    }

    public static t k(t tVar) throws v {
        if (tVar == null || tVar.A()) {
            return tVar;
        }
        throw tVar.h().a().k(tVar);
    }

    public static u.b t() {
        return u0.d();
    }

    public static t u(Class cls) {
        t tVar = defaultInstanceMap.get(cls);
        if (tVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                tVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (tVar != null) {
            return tVar;
        }
        t tVarA = ((t) h1.i(cls)).a();
        if (tVarA == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, tVarA);
        return tVarA;
    }

    public static Object z(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public final boolean A() {
        return B(this, true);
    }

    public boolean C() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public void D() {
        t0.a().d(this).b(this);
        E();
    }

    public void E() {
        this.memoizedSerializedSize &= a.e.API_PRIORITY_OTHER;
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final a c() {
        return (a) q(d.NEW_BUILDER);
    }

    public t I() {
        return (t) q(d.NEW_MUTABLE_INSTANCE);
    }

    public void M(int i10) {
        this.memoizedHashCode = i10;
    }

    public void N(int i10) {
        if (i10 >= 0) {
            this.memoizedSerializedSize = (i10 & a.e.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    public int b() {
        return g(null);
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    public void d(i iVar) {
        t0.a().d(this).i(this, j.P(iVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return t0.a().d(this).d(this, (t) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public int g(x0 x0Var) {
        if (!C()) {
            if (x() != Integer.MAX_VALUE) {
                return x();
            }
            int iO = o(x0Var);
            N(iO);
            return iO;
        }
        int iO2 = o(x0Var);
        if (iO2 >= 0) {
            return iO2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iO2);
    }

    public int hashCode() {
        if (C()) {
            return n();
        }
        if (y()) {
            M(n());
        }
        return w();
    }

    public Object j() {
        return q(d.BUILD_MESSAGE_INFO);
    }

    public void l() {
        this.memoizedHashCode = 0;
    }

    public void m() {
        N(a.e.API_PRIORITY_OTHER);
    }

    public int n() {
        return t0.a().d(this).g(this);
    }

    public final int o(x0 x0Var) {
        return x0Var == null ? t0.a().d(this).e(this) : x0Var.e(this);
    }

    public final a p() {
        return (a) q(d.NEW_BUILDER);
    }

    public Object q(d dVar) {
        return s(dVar, null, null);
    }

    public Object r(d dVar, Object obj) {
        return s(dVar, obj, null);
    }

    public abstract Object s(d dVar, Object obj, Object obj2);

    public String toString() {
        return l0.f(this, super.toString());
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final t a() {
        return (t) q(d.GET_DEFAULT_INSTANCE);
    }

    public int w() {
        return this.memoizedHashCode;
    }

    public int x() {
        return this.memoizedSerializedSize & a.e.API_PRIORITY_OTHER;
    }

    public boolean y() {
        return w() == 0;
    }
}
