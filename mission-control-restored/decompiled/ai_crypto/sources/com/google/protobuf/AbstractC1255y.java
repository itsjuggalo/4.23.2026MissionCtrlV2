package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.AbstractC1229a;
import com.google.protobuf.AbstractC1237f;
import com.google.protobuf.C;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.protobuf.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1255y extends AbstractC1229a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC1255y> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected w0 unknownFields = w0.c();

    /* JADX INFO: renamed from: com.google.protobuf.y$a */
    public static abstract class a extends AbstractC1229a.AbstractC0200a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1255y f12867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC1255y f12868b;

        public a(AbstractC1255y abstractC1255y) {
            this.f12867a = abstractC1255y;
            if (abstractC1255y.I()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f12868b = v();
        }

        public static void u(Object obj, Object obj2) {
            i0.a().d(obj).a(obj, obj2);
        }

        private AbstractC1255y v() {
            return this.f12867a.O();
        }

        @Override // com.google.protobuf.W
        public final boolean d() {
            return AbstractC1255y.H(this.f12868b, false);
        }

        public final AbstractC1255y n() {
            AbstractC1255y abstractC1255yH = h();
            if (abstractC1255yH.d()) {
                return abstractC1255yH;
            }
            throw AbstractC1229a.AbstractC0200a.m(abstractC1255yH);
        }

        @Override // com.google.protobuf.V.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public AbstractC1255y h() {
            if (!this.f12868b.I()) {
                return this.f12868b;
            }
            this.f12868b.J();
            return this.f12868b;
        }

        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVarC = a().c();
            aVarC.f12868b = h();
            return aVarC;
        }

        public final void q() {
            if (this.f12868b.I()) {
                return;
            }
            r();
        }

        public void r() {
            AbstractC1255y abstractC1255yV = v();
            u(abstractC1255yV, this.f12868b);
            this.f12868b = abstractC1255yV;
        }

        @Override // com.google.protobuf.W
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public AbstractC1255y a() {
            return this.f12867a;
        }

        public a t(AbstractC1255y abstractC1255y) {
            if (a().equals(abstractC1255y)) {
                return this;
            }
            q();
            u(this.f12868b, abstractC1255y);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.y$b */
    public static class b extends AbstractC1231b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC1255y f12869b;

        public b(AbstractC1255y abstractC1255y) {
            this.f12869b = abstractC1255y;
        }

        @Override // com.google.protobuf.f0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AbstractC1255y b(AbstractC1241j abstractC1241j, C1248q c1248q) {
            return AbstractC1255y.T(this.f12869b, abstractC1241j, c1248q);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.y$c */
    public static class c extends AbstractC1246o {
    }

    /* JADX INFO: renamed from: com.google.protobuf.y$d */
    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static C.e A() {
        return j0.c();
    }

    public static AbstractC1255y B(Class cls) {
        AbstractC1255y abstractC1255yA = defaultInstanceMap.get(cls);
        if (abstractC1255yA == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC1255yA = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e7) {
                throw new IllegalStateException("Class initialization cannot fail.", e7);
            }
        }
        if (abstractC1255yA == null) {
            abstractC1255yA = ((AbstractC1255y) z0.l(cls)).a();
            if (abstractC1255yA == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, abstractC1255yA);
        }
        return abstractC1255yA;
    }

    public static Object G(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e7);
        } catch (InvocationTargetException e8) {
            Throwable cause = e8.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean H(AbstractC1255y abstractC1255y, boolean z7) {
        byte bByteValue = ((Byte) abstractC1255y.w(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = i0.a().d(abstractC1255y).c(abstractC1255y);
        if (z7) {
            abstractC1255y.x(d.SET_MEMOIZED_IS_INITIALIZED, zC ? abstractC1255y : null);
        }
        return zC;
    }

    public static C.e L(C.e eVar) {
        int size = eVar.size();
        return eVar.e(size == 0 ? 10 : size * 2);
    }

    public static Object N(V v7, String str, Object[] objArr) {
        return new k0(v7, str, objArr);
    }

    public static AbstractC1255y P(AbstractC1255y abstractC1255y, AbstractC1240i abstractC1240i) {
        return p(Q(abstractC1255y, abstractC1240i, C1248q.b()));
    }

    public static AbstractC1255y Q(AbstractC1255y abstractC1255y, AbstractC1240i abstractC1240i, C1248q c1248q) {
        return p(S(abstractC1255y, abstractC1240i, c1248q));
    }

    public static AbstractC1255y R(AbstractC1255y abstractC1255y, byte[] bArr) {
        return p(U(abstractC1255y, bArr, 0, bArr.length, C1248q.b()));
    }

    public static AbstractC1255y S(AbstractC1255y abstractC1255y, AbstractC1240i abstractC1240i, C1248q c1248q) throws D {
        AbstractC1241j abstractC1241jY = abstractC1240i.y();
        AbstractC1255y abstractC1255yT = T(abstractC1255y, abstractC1241jY, c1248q);
        try {
            abstractC1241jY.a(0);
            return abstractC1255yT;
        } catch (D e7) {
            throw e7.k(abstractC1255yT);
        }
    }

    public static AbstractC1255y T(AbstractC1255y abstractC1255y, AbstractC1241j abstractC1241j, C1248q c1248q) throws D {
        AbstractC1255y abstractC1255yO = abstractC1255y.O();
        try {
            n0 n0VarD = i0.a().d(abstractC1255yO);
            n0VarD.i(abstractC1255yO, C1242k.O(abstractC1241j), c1248q);
            n0VarD.b(abstractC1255yO);
            return abstractC1255yO;
        } catch (D e7) {
            e = e7;
            if (e.a()) {
                e = new D(e);
            }
            throw e.k(abstractC1255yO);
        } catch (u0 e8) {
            throw e8.a().k(abstractC1255yO);
        } catch (IOException e9) {
            if (e9.getCause() instanceof D) {
                throw ((D) e9.getCause());
            }
            throw new D(e9).k(abstractC1255yO);
        } catch (RuntimeException e10) {
            if (e10.getCause() instanceof D) {
                throw ((D) e10.getCause());
            }
            throw e10;
        }
    }

    public static AbstractC1255y U(AbstractC1255y abstractC1255y, byte[] bArr, int i7, int i8, C1248q c1248q) throws D {
        AbstractC1255y abstractC1255yO = abstractC1255y.O();
        try {
            n0 n0VarD = i0.a().d(abstractC1255yO);
            n0VarD.j(abstractC1255yO, bArr, i7, i7 + i8, new AbstractC1237f.a(c1248q));
            n0VarD.b(abstractC1255yO);
            return abstractC1255yO;
        } catch (D e7) {
            e = e7;
            if (e.a()) {
                e = new D(e);
            }
            throw e.k(abstractC1255yO);
        } catch (u0 e8) {
            throw e8.a().k(abstractC1255yO);
        } catch (IOException e9) {
            if (e9.getCause() instanceof D) {
                throw ((D) e9.getCause());
            }
            throw new D(e9).k(abstractC1255yO);
        } catch (IndexOutOfBoundsException unused) {
            throw D.m().k(abstractC1255yO);
        }
    }

    public static void V(Class cls, AbstractC1255y abstractC1255y) {
        abstractC1255y.K();
        defaultInstanceMap.put(cls, abstractC1255y);
    }

    public static AbstractC1255y p(AbstractC1255y abstractC1255y) throws D {
        if (abstractC1255y == null || abstractC1255y.d()) {
            return abstractC1255y;
        }
        throw abstractC1255y.n().a().k(abstractC1255y);
    }

    public static C.d z() {
        return B.j();
    }

    @Override // com.google.protobuf.W
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final AbstractC1255y a() {
        return (AbstractC1255y) w(d.GET_DEFAULT_INSTANCE);
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
        i0.a().d(this).b(this);
        K();
    }

    public void K() {
        this.memoizedSerializedSize &= a.e.API_PRIORITY_OTHER;
    }

    @Override // com.google.protobuf.V
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public final a c() {
        return (a) w(d.NEW_BUILDER);
    }

    public AbstractC1255y O() {
        return (AbstractC1255y) w(d.NEW_MUTABLE_INSTANCE);
    }

    public void W(int i7) {
        this.memoizedHashCode = i7;
    }

    public void X(int i7) {
        if (i7 >= 0) {
            this.memoizedSerializedSize = (i7 & a.e.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i7);
        }
    }

    public final a Y() {
        return ((a) w(d.NEW_BUILDER)).t(this);
    }

    @Override // com.google.protobuf.V
    public int b() {
        return l(null);
    }

    @Override // com.google.protobuf.W
    public final boolean d() {
        return H(this, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return i0.a().d(this).d(this, (AbstractC1255y) obj);
        }
        return false;
    }

    @Override // com.google.protobuf.V
    public void f(AbstractC1243l abstractC1243l) {
        i0.a().d(this).h(this, C1244m.P(abstractC1243l));
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

    @Override // com.google.protobuf.V
    public final f0 j() {
        return (f0) w(d.GET_PARSER);
    }

    @Override // com.google.protobuf.AbstractC1229a
    public int l(n0 n0Var) {
        if (!I()) {
            if (E() != Integer.MAX_VALUE) {
                return E();
            }
            int iT = t(n0Var);
            X(iT);
            return iT;
        }
        int iT2 = t(n0Var);
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
        return i0.a().d(this).g(this);
    }

    public final int t(n0 n0Var) {
        return n0Var == null ? i0.a().d(this).e(this) : n0Var.e(this);
    }

    public String toString() {
        return X.f(this, super.toString());
    }

    public final a u() {
        return (a) w(d.NEW_BUILDER);
    }

    public final a v(AbstractC1255y abstractC1255y) {
        return u().t(abstractC1255y);
    }

    public Object w(d dVar) {
        return y(dVar, null, null);
    }

    public Object x(d dVar, Object obj) {
        return y(dVar, obj, null);
    }

    public abstract Object y(d dVar, Object obj, Object obj2);
}
