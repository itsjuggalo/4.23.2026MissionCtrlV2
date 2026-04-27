package com.google.protobuf;

import com.google.protobuf.AbstractC1462a;
import com.google.protobuf.AbstractC1481u;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1480t extends AbstractC1462a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC1480t> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected g0 unknownFields = g0.c();

    /* JADX INFO: renamed from: com.google.protobuf.t$a */
    public static abstract class a extends AbstractC1462a.AbstractC0263a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1480t f16576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC1480t f16577b;

        public a(AbstractC1480t abstractC1480t) {
            this.f16576a = abstractC1480t;
            if (abstractC1480t.F()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f16577b = w();
        }

        public static void v(Object obj, Object obj2) {
            U.a().d(obj).a(obj, obj2);
        }

        private AbstractC1480t w() {
            return this.f16576a.L();
        }

        @Override // com.google.protobuf.K
        public final boolean e() {
            return AbstractC1480t.E(this.f16577b, false);
        }

        public final AbstractC1480t o() {
            AbstractC1480t abstractC1480tF = f();
            if (abstractC1480tF.e()) {
                return abstractC1480tF;
            }
            throw AbstractC1462a.AbstractC0263a.m(abstractC1480tF);
        }

        @Override // com.google.protobuf.J.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public AbstractC1480t f() {
            if (!this.f16577b.F()) {
                return this.f16577b;
            }
            this.f16577b.G();
            return this.f16577b;
        }

        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVarD = b().d();
            aVarD.f16577b = f();
            return aVarD;
        }

        public final void r() {
            if (this.f16577b.F()) {
                return;
            }
            s();
        }

        public void s() {
            AbstractC1480t abstractC1480tW = w();
            v(abstractC1480tW, this.f16577b);
            this.f16577b = abstractC1480tW;
        }

        @Override // com.google.protobuf.K
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public AbstractC1480t b() {
            return this.f16576a;
        }

        public a u(AbstractC1480t abstractC1480t) {
            if (b().equals(abstractC1480t)) {
                return this;
            }
            r();
            v(this.f16577b, abstractC1480t);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.t$b */
    public static class b extends AbstractC1463b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC1480t f16578b;

        public b(AbstractC1480t abstractC1480t) {
            this.f16578b = abstractC1480t;
        }

        @Override // com.google.protobuf.S
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public AbstractC1480t c(AbstractC1468g abstractC1468g, C1474m c1474m) {
            return AbstractC1480t.M(this.f16578b, abstractC1468g, c1474m);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.t$c */
    public static class c extends AbstractC1472k {
    }

    /* JADX INFO: renamed from: com.google.protobuf.t$d */
    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static Object D(Method method, Object obj, Object... objArr) {
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

    public static final boolean E(AbstractC1480t abstractC1480t, boolean z7) {
        byte bByteValue = ((Byte) abstractC1480t.u(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = U.a().d(abstractC1480t).c(abstractC1480t);
        if (z7) {
            abstractC1480t.v(d.SET_MEMOIZED_IS_INITIALIZED, zC ? abstractC1480t : null);
        }
        return zC;
    }

    public static AbstractC1481u.d I(AbstractC1481u.d dVar) {
        int size = dVar.size();
        return dVar.i(size == 0 ? 10 : size * 2);
    }

    public static Object K(J j8, String str, Object[] objArr) {
        return new W(j8, str, objArr);
    }

    public static AbstractC1480t M(AbstractC1480t abstractC1480t, AbstractC1468g abstractC1468g, C1474m c1474m) throws C1482v {
        AbstractC1480t abstractC1480tL = abstractC1480t.L();
        try {
            Y yD = U.a().d(abstractC1480tL);
            yD.i(abstractC1480tL, C1469h.O(abstractC1468g), c1474m);
            yD.b(abstractC1480tL);
            return abstractC1480tL;
        } catch (e0 e8) {
            throw e8.a().k(abstractC1480tL);
        } catch (C1482v e9) {
            e = e9;
            if (e.a()) {
                e = new C1482v(e);
            }
            throw e.k(abstractC1480tL);
        } catch (IOException e10) {
            if (e10.getCause() instanceof C1482v) {
                throw ((C1482v) e10.getCause());
            }
            throw new C1482v(e10).k(abstractC1480tL);
        } catch (RuntimeException e11) {
            if (e11.getCause() instanceof C1482v) {
                throw ((C1482v) e11.getCause());
            }
            throw e11;
        }
    }

    public static void N(Class cls, AbstractC1480t abstractC1480t) {
        abstractC1480t.H();
        defaultInstanceMap.put(cls, abstractC1480t);
    }

    public static AbstractC1481u.d x() {
        return V.e();
    }

    public static AbstractC1480t y(Class cls) {
        AbstractC1480t abstractC1480tB = defaultInstanceMap.get(cls);
        if (abstractC1480tB == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC1480tB = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e8) {
                throw new IllegalStateException("Class initialization cannot fail.", e8);
            }
        }
        if (abstractC1480tB == null) {
            abstractC1480tB = ((AbstractC1480t) j0.k(cls)).b();
            if (abstractC1480tB == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, abstractC1480tB);
        }
        return abstractC1480tB;
    }

    public int A() {
        return this.memoizedHashCode;
    }

    public int B() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public boolean C() {
        return A() == 0;
    }

    public boolean F() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public void G() {
        U.a().d(this).b(this);
        H();
    }

    public void H() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.J
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final a d() {
        return (a) u(d.NEW_BUILDER);
    }

    public AbstractC1480t L() {
        return (AbstractC1480t) u(d.NEW_MUTABLE_INSTANCE);
    }

    public void O(int i8) {
        this.memoizedHashCode = i8;
    }

    public void P(int i8) {
        if (i8 >= 0) {
            this.memoizedSerializedSize = (i8 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i8);
        }
    }

    public final a Q() {
        return ((a) u(d.NEW_BUILDER)).u(this);
    }

    @Override // com.google.protobuf.J
    public int c() {
        return k(null);
    }

    @Override // com.google.protobuf.K
    public final boolean e() {
        return E(this, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return U.a().d(this).d(this, (AbstractC1480t) obj);
        }
        return false;
    }

    @Override // com.google.protobuf.J
    public void h(AbstractC1470i abstractC1470i) {
        U.a().d(this).h(this, C1471j.P(abstractC1470i));
    }

    public int hashCode() {
        if (F()) {
            return q();
        }
        if (C()) {
            O(q());
        }
        return A();
    }

    @Override // com.google.protobuf.J
    public final S j() {
        return (S) u(d.GET_PARSER);
    }

    @Override // com.google.protobuf.AbstractC1462a
    public int k(Y y7) {
        if (!F()) {
            if (B() != Integer.MAX_VALUE) {
                return B();
            }
            int iR = r(y7);
            P(iR);
            return iR;
        }
        int iR2 = r(y7);
        if (iR2 >= 0) {
            return iR2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iR2);
    }

    public Object n() {
        return u(d.BUILD_MESSAGE_INFO);
    }

    public void o() {
        this.memoizedHashCode = 0;
    }

    public void p() {
        P(Integer.MAX_VALUE);
    }

    public int q() {
        return U.a().d(this).g(this);
    }

    public final int r(Y y7) {
        return y7 == null ? U.a().d(this).e(this) : y7.e(this);
    }

    public final a s() {
        return (a) u(d.NEW_BUILDER);
    }

    public final a t(AbstractC1480t abstractC1480t) {
        return s().u(abstractC1480t);
    }

    public String toString() {
        return L.f(this, super.toString());
    }

    public Object u(d dVar) {
        return w(dVar, null, null);
    }

    public Object v(d dVar, Object obj) {
        return w(dVar, obj, null);
    }

    public abstract Object w(d dVar, Object obj, Object obj2);

    @Override // com.google.protobuf.K
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public final AbstractC1480t b() {
        return (AbstractC1480t) u(d.GET_DEFAULT_INSTANCE);
    }
}
