package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0788a;
import androidx.datastore.preferences.protobuf.AbstractC0807u;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0806t extends AbstractC0788a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0806t> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected g0 unknownFields = g0.c();

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$a */
    public static abstract class a extends AbstractC0788a.AbstractC0100a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0806t f7196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC0806t f7197b;

        public a(AbstractC0806t abstractC0806t) {
            this.f7196a = abstractC0806t;
            if (abstractC0806t.y()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f7197b = l();
        }

        public static void k(Object obj, Object obj2) {
            U.a().d(obj).a(obj, obj2);
        }

        private AbstractC0806t l() {
            return this.f7196a.E();
        }

        public final AbstractC0806t e() {
            AbstractC0806t abstractC0806tBuildPartial = buildPartial();
            if (abstractC0806tBuildPartial.w()) {
                return abstractC0806tBuildPartial;
            }
            throw AbstractC0788a.AbstractC0100a.d(abstractC0806tBuildPartial);
        }

        @Override // androidx.datastore.preferences.protobuf.J.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AbstractC0806t buildPartial() {
            if (!this.f7197b.y()) {
                return this.f7197b;
            }
            this.f7197b.z();
            return this.f7197b;
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVarNewBuilderForType = getDefaultInstanceForType().newBuilderForType();
            aVarNewBuilderForType.f7197b = buildPartial();
            return aVarNewBuilderForType;
        }

        public final void h() {
            if (this.f7197b.y()) {
                return;
            }
            i();
        }

        public void i() {
            AbstractC0806t abstractC0806tL = l();
            k(abstractC0806tL, this.f7197b);
            this.f7197b = abstractC0806tL;
        }

        @Override // androidx.datastore.preferences.protobuf.K
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public AbstractC0806t getDefaultInstanceForType() {
            return this.f7196a;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$b */
    public static class b extends AbstractC0789b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0806t f7198b;

        public b(AbstractC0806t abstractC0806t) {
            this.f7198b = abstractC0806t;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$c */
    public static class c extends AbstractC0798k {
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

    public static AbstractC0807u.b B(AbstractC0807u.b bVar) {
        int size = bVar.size();
        return bVar.a(size == 0 ? 10 : size * 2);
    }

    public static Object D(J j4, String str, Object[] objArr) {
        return new W(j4, str, objArr);
    }

    public static AbstractC0806t F(AbstractC0806t abstractC0806t, InputStream inputStream) {
        return g(G(abstractC0806t, AbstractC0794g.g(inputStream), C0800m.b()));
    }

    public static AbstractC0806t G(AbstractC0806t abstractC0806t, AbstractC0794g abstractC0794g, C0800m c0800m) throws C0808v {
        AbstractC0806t abstractC0806tE = abstractC0806t.E();
        try {
            Y yD = U.a().d(abstractC0806tE);
            yD.h(abstractC0806tE, C0795h.O(abstractC0794g), c0800m);
            yD.b(abstractC0806tE);
            return abstractC0806tE;
        } catch (e0 e4) {
            throw e4.a().k(abstractC0806tE);
        } catch (C0808v e5) {
            e = e5;
            if (e.a()) {
                e = new C0808v(e);
            }
            throw e.k(abstractC0806tE);
        } catch (IOException e6) {
            if (e6.getCause() instanceof C0808v) {
                throw ((C0808v) e6.getCause());
            }
            throw new C0808v(e6).k(abstractC0806tE);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof C0808v) {
                throw ((C0808v) e7.getCause());
            }
            throw e7;
        }
    }

    public static void H(Class cls, AbstractC0806t abstractC0806t) {
        abstractC0806t.A();
        defaultInstanceMap.put(cls, abstractC0806t);
    }

    public static AbstractC0806t g(AbstractC0806t abstractC0806t) throws C0808v {
        if (abstractC0806t == null || abstractC0806t.w()) {
            return abstractC0806t;
        }
        throw abstractC0806t.d().a().k(abstractC0806t);
    }

    public static AbstractC0807u.b p() {
        return V.i();
    }

    public static AbstractC0806t q(Class cls) {
        AbstractC0806t abstractC0806t = defaultInstanceMap.get(cls);
        if (abstractC0806t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0806t = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (abstractC0806t != null) {
            return abstractC0806t;
        }
        AbstractC0806t defaultInstanceForType = ((AbstractC0806t) i0.i(cls)).getDefaultInstanceForType();
        if (defaultInstanceForType == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, defaultInstanceForType);
        return defaultInstanceForType;
    }

    public static Object v(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean x(AbstractC0806t abstractC0806t, boolean z4) {
        byte bByteValue = ((Byte) abstractC0806t.m(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = U.a().d(abstractC0806t).c(abstractC0806t);
        if (z4) {
            abstractC0806t.n(d.SET_MEMOIZED_IS_INITIALIZED, zC ? abstractC0806t : null);
        }
        return zC;
    }

    public void A() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.J
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final a newBuilderForType() {
        return (a) m(d.NEW_BUILDER);
    }

    public AbstractC0806t E() {
        return (AbstractC0806t) m(d.NEW_MUTABLE_INSTANCE);
    }

    public void I(int i4) {
        this.memoizedHashCode = i4;
    }

    public void J(int i4) {
        if (i4 >= 0) {
            this.memoizedSerializedSize = (i4 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i4);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public void a(AbstractC0796i abstractC0796i) {
        U.a().d(this).i(this, C0797j.P(abstractC0796i));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0788a
    public int c(Y y4) {
        if (!y()) {
            if (t() != Integer.MAX_VALUE) {
                return t();
            }
            int iK = k(y4);
            J(iK);
            return iK;
        }
        int iK2 = k(y4);
        if (iK2 >= 0) {
            return iK2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iK2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return U.a().d(this).d(this, (AbstractC0806t) obj);
        }
        return false;
    }

    public Object f() {
        return m(d.BUILD_MESSAGE_INFO);
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public int getSerializedSize() {
        return c(null);
    }

    public void h() {
        this.memoizedHashCode = 0;
    }

    public int hashCode() {
        if (y()) {
            return j();
        }
        if (u()) {
            I(j());
        }
        return s();
    }

    public void i() {
        J(Integer.MAX_VALUE);
    }

    public int j() {
        return U.a().d(this).g(this);
    }

    public final int k(Y y4) {
        return y4 == null ? U.a().d(this).e(this) : y4.e(this);
    }

    public final a l() {
        return (a) m(d.NEW_BUILDER);
    }

    public Object m(d dVar) {
        return o(dVar, null, null);
    }

    public Object n(d dVar, Object obj) {
        return o(dVar, obj, null);
    }

    public abstract Object o(d dVar, Object obj, Object obj2);

    @Override // androidx.datastore.preferences.protobuf.K
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final AbstractC0806t getDefaultInstanceForType() {
        return (AbstractC0806t) m(d.GET_DEFAULT_INSTANCE);
    }

    public int s() {
        return this.memoizedHashCode;
    }

    public int t() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public String toString() {
        return L.f(this, super.toString());
    }

    public boolean u() {
        return s() == 0;
    }

    public final boolean w() {
        return x(this, true);
    }

    public boolean y() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public void z() {
        U.a().d(this).b(this);
        A();
    }
}
