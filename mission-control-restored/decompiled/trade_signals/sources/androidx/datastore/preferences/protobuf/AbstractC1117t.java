package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC1099a;
import androidx.datastore.preferences.protobuf.AbstractC1118u;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1117t extends AbstractC1099a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC1117t> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected g0 unknownFields = g0.c();

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$a */
    public static abstract class a extends AbstractC1099a.AbstractC0179a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1117t f11416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC1117t f11417b;

        public a(AbstractC1117t abstractC1117t) {
            this.f11416a = abstractC1117t;
            if (abstractC1117t.C()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f11417b = r();
        }

        public static void q(Object obj, Object obj2) {
            U.a().d(obj).a(obj, obj2);
        }

        private AbstractC1117t r() {
            return this.f11416a.I();
        }

        public final AbstractC1117t j() {
            AbstractC1117t abstractC1117tF = f();
            if (abstractC1117tF.A()) {
                return abstractC1117tF;
            }
            throw AbstractC1099a.AbstractC0179a.i(abstractC1117tF);
        }

        @Override // androidx.datastore.preferences.protobuf.J.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public AbstractC1117t f() {
            if (!this.f11417b.C()) {
                return this.f11417b;
            }
            this.f11417b.D();
            return this.f11417b;
        }

        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVarD = b().d();
            aVarD.f11417b = f();
            return aVarD;
        }

        public final void m() {
            if (this.f11417b.C()) {
                return;
            }
            o();
        }

        public void o() {
            AbstractC1117t abstractC1117tR = r();
            q(abstractC1117tR, this.f11417b);
            this.f11417b = abstractC1117tR;
        }

        @Override // androidx.datastore.preferences.protobuf.K
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public AbstractC1117t b() {
            return this.f11416a;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$b */
    public static class b extends AbstractC1100b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC1117t f11418b;

        public b(AbstractC1117t abstractC1117t) {
            this.f11418b = abstractC1117t;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$c */
    public static class c extends AbstractC1109k {
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$d */
    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static final boolean B(AbstractC1117t abstractC1117t, boolean z7) {
        byte bByteValue = ((Byte) abstractC1117t.q(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = U.a().d(abstractC1117t).c(abstractC1117t);
        if (z7) {
            abstractC1117t.r(d.SET_MEMOIZED_IS_INITIALIZED, zC ? abstractC1117t : null);
        }
        return zC;
    }

    public static AbstractC1118u.b F(AbstractC1118u.b bVar) {
        int size = bVar.size();
        return bVar.i(size == 0 ? 10 : size * 2);
    }

    public static Object H(J j8, String str, Object[] objArr) {
        return new W(j8, str, objArr);
    }

    public static AbstractC1117t J(AbstractC1117t abstractC1117t, InputStream inputStream) {
        return k(K(abstractC1117t, AbstractC1105g.g(inputStream), C1111m.b()));
    }

    public static AbstractC1117t K(AbstractC1117t abstractC1117t, AbstractC1105g abstractC1105g, C1111m c1111m) throws C1119v {
        AbstractC1117t abstractC1117tI = abstractC1117t.I();
        try {
            Y yD = U.a().d(abstractC1117tI);
            yD.h(abstractC1117tI, C1106h.O(abstractC1105g), c1111m);
            yD.b(abstractC1117tI);
            return abstractC1117tI;
        } catch (e0 e8) {
            throw e8.a().k(abstractC1117tI);
        } catch (C1119v e9) {
            e = e9;
            if (e.a()) {
                e = new C1119v(e);
            }
            throw e.k(abstractC1117tI);
        } catch (IOException e10) {
            if (e10.getCause() instanceof C1119v) {
                throw ((C1119v) e10.getCause());
            }
            throw new C1119v(e10).k(abstractC1117tI);
        } catch (RuntimeException e11) {
            if (e11.getCause() instanceof C1119v) {
                throw ((C1119v) e11.getCause());
            }
            throw e11;
        }
    }

    public static void L(Class cls, AbstractC1117t abstractC1117t) {
        abstractC1117t.E();
        defaultInstanceMap.put(cls, abstractC1117t);
    }

    public static AbstractC1117t k(AbstractC1117t abstractC1117t) throws C1119v {
        if (abstractC1117t == null || abstractC1117t.A()) {
            return abstractC1117t;
        }
        throw abstractC1117t.h().a().k(abstractC1117t);
    }

    public static AbstractC1118u.b t() {
        return V.e();
    }

    public static AbstractC1117t u(Class cls) {
        AbstractC1117t abstractC1117tB = defaultInstanceMap.get(cls);
        if (abstractC1117tB == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC1117tB = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e8) {
                throw new IllegalStateException("Class initialization cannot fail.", e8);
            }
        }
        if (abstractC1117tB == null) {
            abstractC1117tB = ((AbstractC1117t) i0.i(cls)).b();
            if (abstractC1117tB == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, abstractC1117tB);
        }
        return abstractC1117tB;
    }

    public static Object z(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e8);
        } catch (InvocationTargetException e9) {
            Throwable cause = e9.getCause();
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
        U.a().d(this).b(this);
        E();
    }

    public void E() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.J
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final a d() {
        return (a) q(d.NEW_BUILDER);
    }

    public AbstractC1117t I() {
        return (AbstractC1117t) q(d.NEW_MUTABLE_INSTANCE);
    }

    public void M(int i8) {
        this.memoizedHashCode = i8;
    }

    public void N(int i8) {
        if (i8 >= 0) {
            this.memoizedSerializedSize = (i8 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i8);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public int c() {
        return g(null);
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public void e(AbstractC1107i abstractC1107i) {
        U.a().d(this).i(this, C1108j.P(abstractC1107i));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return U.a().d(this).d(this, (AbstractC1117t) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1099a
    public int g(Y y7) {
        if (!C()) {
            if (x() != Integer.MAX_VALUE) {
                return x();
            }
            int iO = o(y7);
            N(iO);
            return iO;
        }
        int iO2 = o(y7);
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
        N(Integer.MAX_VALUE);
    }

    public int n() {
        return U.a().d(this).g(this);
    }

    public final int o(Y y7) {
        return y7 == null ? U.a().d(this).e(this) : y7.e(this);
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
        return L.f(this, super.toString());
    }

    @Override // androidx.datastore.preferences.protobuf.K
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final AbstractC1117t b() {
        return (AbstractC1117t) q(d.GET_DEFAULT_INSTANCE);
    }

    public int w() {
        return this.memoizedHashCode;
    }

    public int x() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public boolean y() {
        return w() == 0;
    }
}
