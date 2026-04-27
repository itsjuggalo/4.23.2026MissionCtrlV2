package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0930a;
import androidx.datastore.preferences.protobuf.AbstractC0949u;
import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0948t extends AbstractC0930a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0948t> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected g0 unknownFields = g0.c();

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$a */
    public static abstract class a extends AbstractC0930a.AbstractC0122a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0948t f7604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractC0948t f7605b;

        public a(AbstractC0948t abstractC0948t) {
            this.f7604a = abstractC0948t;
            if (abstractC0948t.C()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f7605b = p();
        }

        public static void o(Object obj, Object obj2) {
            U.a().d(obj).a(obj, obj2);
        }

        private AbstractC0948t p() {
            return this.f7604a.I();
        }

        public final AbstractC0948t i() {
            AbstractC0948t abstractC0948tH = h();
            if (abstractC0948tH.A()) {
                return abstractC0948tH;
            }
            throw AbstractC0930a.AbstractC0122a.g(abstractC0948tH);
        }

        @Override // androidx.datastore.preferences.protobuf.J.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public AbstractC0948t h() {
            if (!this.f7605b.C()) {
                return this.f7605b;
            }
            this.f7605b.D();
            return this.f7605b;
        }

        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVarC = a().c();
            aVarC.f7605b = h();
            return aVarC;
        }

        public final void l() {
            if (this.f7605b.C()) {
                return;
            }
            m();
        }

        public void m() {
            AbstractC0948t abstractC0948tP = p();
            o(abstractC0948tP, this.f7605b);
            this.f7605b = abstractC0948tP;
        }

        @Override // androidx.datastore.preferences.protobuf.K
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public AbstractC0948t a() {
            return this.f7604a;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$b */
    public static class b extends AbstractC0931b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0948t f7606b;

        public b(AbstractC0948t abstractC0948t) {
            this.f7606b = abstractC0948t;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t$c */
    public static class c extends AbstractC0940k {
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

    public static final boolean B(AbstractC0948t abstractC0948t, boolean z7) {
        byte bByteValue = ((Byte) abstractC0948t.q(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = U.a().d(abstractC0948t).c(abstractC0948t);
        if (z7) {
            abstractC0948t.r(d.SET_MEMOIZED_IS_INITIALIZED, zC ? abstractC0948t : null);
        }
        return zC;
    }

    public static AbstractC0949u.b F(AbstractC0949u.b bVar) {
        int size = bVar.size();
        return bVar.e(size == 0 ? 10 : size * 2);
    }

    public static Object H(J j7, String str, Object[] objArr) {
        return new W(j7, str, objArr);
    }

    public static AbstractC0948t J(AbstractC0948t abstractC0948t, InputStream inputStream) {
        return k(K(abstractC0948t, AbstractC0936g.g(inputStream), C0942m.b()));
    }

    public static AbstractC0948t K(AbstractC0948t abstractC0948t, AbstractC0936g abstractC0936g, C0942m c0942m) throws C0950v {
        AbstractC0948t abstractC0948tI = abstractC0948t.I();
        try {
            Y yD = U.a().d(abstractC0948tI);
            yD.h(abstractC0948tI, C0937h.O(abstractC0936g), c0942m);
            yD.b(abstractC0948tI);
            return abstractC0948tI;
        } catch (e0 e7) {
            throw e7.a().k(abstractC0948tI);
        } catch (C0950v e8) {
            e = e8;
            if (e.a()) {
                e = new C0950v(e);
            }
            throw e.k(abstractC0948tI);
        } catch (IOException e9) {
            if (e9.getCause() instanceof C0950v) {
                throw ((C0950v) e9.getCause());
            }
            throw new C0950v(e9).k(abstractC0948tI);
        } catch (RuntimeException e10) {
            if (e10.getCause() instanceof C0950v) {
                throw ((C0950v) e10.getCause());
            }
            throw e10;
        }
    }

    public static void L(Class cls, AbstractC0948t abstractC0948t) {
        abstractC0948t.E();
        defaultInstanceMap.put(cls, abstractC0948t);
    }

    public static AbstractC0948t k(AbstractC0948t abstractC0948t) throws C0950v {
        if (abstractC0948t == null || abstractC0948t.A()) {
            return abstractC0948t;
        }
        throw abstractC0948t.g().a().k(abstractC0948t);
    }

    public static AbstractC0949u.b t() {
        return V.c();
    }

    public static AbstractC0948t u(Class cls) {
        AbstractC0948t abstractC0948tA = defaultInstanceMap.get(cls);
        if (abstractC0948tA == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0948tA = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e7) {
                throw new IllegalStateException("Class initialization cannot fail.", e7);
            }
        }
        if (abstractC0948tA == null) {
            abstractC0948tA = ((AbstractC0948t) i0.i(cls)).a();
            if (abstractC0948tA == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, abstractC0948tA);
        }
        return abstractC0948tA;
    }

    public static Object z(Method method, Object obj, Object... objArr) {
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
        this.memoizedSerializedSize &= a.e.API_PRIORITY_OTHER;
    }

    @Override // androidx.datastore.preferences.protobuf.J
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final a c() {
        return (a) q(d.NEW_BUILDER);
    }

    public AbstractC0948t I() {
        return (AbstractC0948t) q(d.NEW_MUTABLE_INSTANCE);
    }

    public void M(int i7) {
        this.memoizedHashCode = i7;
    }

    public void N(int i7) {
        if (i7 >= 0) {
            this.memoizedSerializedSize = (i7 & a.e.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i7);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public int b() {
        return f(null);
    }

    @Override // androidx.datastore.preferences.protobuf.J
    public void d(AbstractC0938i abstractC0938i) {
        U.a().d(this).i(this, C0939j.P(abstractC0938i));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return U.a().d(this).d(this, (AbstractC0948t) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0930a
    public int f(Y y7) {
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
        N(a.e.API_PRIORITY_OTHER);
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
    public final AbstractC0948t a() {
        return (AbstractC0948t) q(d.GET_DEFAULT_INSTANCE);
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
