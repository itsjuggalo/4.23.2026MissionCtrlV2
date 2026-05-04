package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.a;
import com.google.protobuf.c0;
import com.google.protobuf.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y extends com.google.protobuf.a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, y> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected v1 unknownFields = v1.c();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a extends a.AbstractC0113a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f7243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y f7244b;

        public a(y yVar) {
            this.f7243a = yVar;
            if (yVar.I()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f7244b = w();
        }

        public static void v(Object obj, Object obj2) {
            h1.a().d(obj).a(obj, obj2);
        }

        private y w() {
            return this.f7243a.O();
        }

        @Override // com.google.protobuf.v0
        public final boolean d() {
            return y.H(this.f7244b, false);
        }

        public final y n() {
            y yVarE = e();
            if (yVarE.d()) {
                return yVarE;
            }
            throw a.AbstractC0113a.m(yVarE);
        }

        @Override // com.google.protobuf.u0.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public y e() {
            if (!this.f7244b.I()) {
                return this.f7244b;
            }
            this.f7244b.J();
            return this.f7244b;
        }

        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVarC = a().c();
            aVarC.f7244b = e();
            return aVarC;
        }

        public final void q() {
            if (this.f7244b.I()) {
                return;
            }
            r();
        }

        public void r() {
            y yVarW = w();
            v(yVarW, this.f7244b);
            this.f7244b = yVarW;
        }

        @Override // com.google.protobuf.v0
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public y a() {
            return this.f7243a;
        }

        public a t(y yVar) {
            if (a().equals(yVar)) {
                return this;
            }
            q();
            v(this.f7244b, yVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends com.google.protobuf.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y f7245b;

        public b(y yVar) {
            this.f7245b = yVar;
        }

        @Override // com.google.protobuf.e1
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public y c(j jVar, q qVar) {
            return y.T(this.f7245b, jVar, qVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends o {
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

    public static c0.e A() {
        return i1.d();
    }

    public static y B(Class cls) {
        y yVar = defaultInstanceMap.get(cls);
        if (yVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                yVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (yVar != null) {
            return yVar;
        }
        y yVarA = ((y) y1.l(cls)).a();
        if (yVarA == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, yVarA);
        return yVarA;
    }

    public static Object G(Method method, Object obj, Object... objArr) {
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

    public static final boolean H(y yVar, boolean z10) {
        byte bByteValue = ((Byte) yVar.w(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = h1.a().d(yVar).c(yVar);
        if (z10) {
            yVar.x(d.SET_MEMOIZED_IS_INITIALIZED, zC ? yVar : null);
        }
        return zC;
    }

    public static c0.e L(c0.e eVar) {
        int size = eVar.size();
        return eVar.i(size == 0 ? 10 : size * 2);
    }

    public static Object N(u0 u0Var, String str, Object[] objArr) {
        return new j1(u0Var, str, objArr);
    }

    public static y P(y yVar, i iVar) {
        return p(Q(yVar, iVar, q.b()));
    }

    public static y Q(y yVar, i iVar, q qVar) {
        return p(S(yVar, iVar, qVar));
    }

    public static y R(y yVar, byte[] bArr) {
        return p(U(yVar, bArr, 0, bArr.length, q.b()));
    }

    public static y S(y yVar, i iVar, q qVar) throws d0 {
        j jVarS = iVar.S();
        y yVarT = T(yVar, jVarS, qVar);
        try {
            jVarS.a(0);
            return yVarT;
        } catch (d0 e10) {
            throw e10.k(yVarT);
        }
    }

    public static y T(y yVar, j jVar, q qVar) throws d0 {
        y yVarO = yVar.O();
        try {
            m1 m1VarD = h1.a().d(yVarO);
            m1VarD.i(yVarO, k.O(jVar), qVar);
            m1VarD.b(yVarO);
            return yVarO;
        } catch (d0 e10) {
            e = e10;
            if (e.a()) {
                e = new d0(e);
            }
            throw e.k(yVarO);
        } catch (t1 e11) {
            throw e11.a().k(yVarO);
        } catch (IOException e12) {
            if (e12.getCause() instanceof d0) {
                throw ((d0) e12.getCause());
            }
            throw new d0(e12).k(yVarO);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof d0) {
                throw ((d0) e13.getCause());
            }
            throw e13;
        }
    }

    public static y U(y yVar, byte[] bArr, int i10, int i11, q qVar) throws d0 {
        y yVarO = yVar.O();
        try {
            m1 m1VarD = h1.a().d(yVarO);
            m1VarD.j(yVarO, bArr, i10, i10 + i11, new f.a(qVar));
            m1VarD.b(yVarO);
            return yVarO;
        } catch (d0 e10) {
            d0 d0Var = e10;
            if (d0Var.a()) {
                d0Var = new d0(d0Var);
            }
            throw d0Var.k(yVarO);
        } catch (t1 e11) {
            throw e11.a().k(yVarO);
        } catch (IOException e12) {
            if (e12.getCause() instanceof d0) {
                throw ((d0) e12.getCause());
            }
            throw new d0(e12).k(yVarO);
        } catch (IndexOutOfBoundsException unused) {
            throw d0.m().k(yVarO);
        }
    }

    public static void V(Class cls, y yVar) {
        yVar.K();
        defaultInstanceMap.put(cls, yVar);
    }

    public static y p(y yVar) throws d0 {
        if (yVar == null || yVar.d()) {
            return yVar;
        }
        throw yVar.n().a().k(yVar);
    }

    public static c0.d z() {
        return b0.g();
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final y a() {
        return (y) w(d.GET_DEFAULT_INSTANCE);
    }

    public int D() {
        return this.memoizedHashCode;
    }

    public int E() {
        return this.memoizedSerializedSize & a.e.API_PRIORITY_OTHER;
    }

    public boolean F() {
        return D() == 0;
    }

    public boolean I() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public void J() {
        h1.a().d(this).b(this);
        K();
    }

    public void K() {
        this.memoizedSerializedSize &= a.e.API_PRIORITY_OTHER;
    }

    @Override // com.google.protobuf.u0
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public final a c() {
        return (a) w(d.NEW_BUILDER);
    }

    public y O() {
        return (y) w(d.NEW_MUTABLE_INSTANCE);
    }

    public void W(int i10) {
        this.memoizedHashCode = i10;
    }

    public void X(int i10) {
        if (i10 >= 0) {
            this.memoizedSerializedSize = (i10 & a.e.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i10);
        }
    }

    public final a Y() {
        return ((a) w(d.NEW_BUILDER)).t(this);
    }

    @Override // com.google.protobuf.u0
    public int b() {
        return l(null);
    }

    @Override // com.google.protobuf.v0
    public final boolean d() {
        return H(this, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return h1.a().d(this).d(this, (y) obj);
        }
        return false;
    }

    @Override // com.google.protobuf.u0
    public void g(l lVar) {
        h1.a().d(this).h(this, m.P(lVar));
    }

    public int hashCode() {
        if (I()) {
            return s();
        }
        if (F()) {
            W(s());
        }
        return D();
    }

    @Override // com.google.protobuf.u0
    public final e1 j() {
        return (e1) w(d.GET_PARSER);
    }

    @Override // com.google.protobuf.a
    public int l(m1 m1Var) {
        if (!I()) {
            if (E() != Integer.MAX_VALUE) {
                return E();
            }
            int iT = t(m1Var);
            X(iT);
            return iT;
        }
        int iT2 = t(m1Var);
        if (iT2 >= 0) {
            return iT2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iT2);
    }

    public Object o() {
        return w(d.BUILD_MESSAGE_INFO);
    }

    public void q() {
        this.memoizedHashCode = 0;
    }

    public void r() {
        X(a.e.API_PRIORITY_OTHER);
    }

    public int s() {
        return h1.a().d(this).g(this);
    }

    public final int t(m1 m1Var) {
        return m1Var == null ? h1.a().d(this).e(this) : m1Var.e(this);
    }

    public String toString() {
        return w0.f(this, super.toString());
    }

    public final a u() {
        return (a) w(d.NEW_BUILDER);
    }

    public final a v(y yVar) {
        return u().t(yVar);
    }

    public Object w(d dVar) {
        return y(dVar, null, null);
    }

    public Object x(d dVar, Object obj) {
        return y(dVar, obj, null);
    }

    public abstract Object y(d dVar, Object obj, Object obj2);
}
