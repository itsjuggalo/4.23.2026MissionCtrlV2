package androidx.datastore.preferences.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0339v extends AbstractC0319a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0339v> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected c0 unknownFields;

    public AbstractC0339v() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = c0.f4539f;
    }

    public static AbstractC0339v d(Class cls) {
        AbstractC0339v abstractC0339v = defaultInstanceMap.get(cls);
        if (abstractC0339v == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0339v = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC0339v != null) {
            return abstractC0339v;
        }
        AbstractC0339v abstractC0339v2 = (AbstractC0339v) ((AbstractC0339v) i0.d(cls)).c(6);
        if (abstractC0339v2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, abstractC0339v2);
        return abstractC0339v2;
    }

    public static Object e(Method method, AbstractC0319a abstractC0319a, Object... objArr) {
        try {
            return method.invoke(abstractC0319a, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean f(AbstractC0339v abstractC0339v, boolean z6) {
        byte bByteValue = ((Byte) abstractC0339v.c(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        S s6 = S.f4509c;
        s6.getClass();
        boolean zC = s6.a(abstractC0339v.getClass()).c(abstractC0339v);
        if (z6) {
            abstractC0339v.c(2);
        }
        return zC;
    }

    public static void j(Class cls, AbstractC0339v abstractC0339v) {
        abstractC0339v.h();
        defaultInstanceMap.put(cls, abstractC0339v);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0319a
    public final int a(V v2) {
        int i;
        int i6;
        if (g()) {
            if (v2 == null) {
                S s6 = S.f4509c;
                s6.getClass();
                i6 = s6.a(getClass()).i(this);
            } else {
                i6 = v2.i(this);
            }
            if (i6 >= 0) {
                return i6;
            }
            throw new IllegalStateException(a3.d.f(i6, "serialized size must be non-negative, was "));
        }
        int i7 = this.memoizedSerializedSize;
        if ((i7 & com.google.android.gms.common.api.f.API_PRIORITY_OTHER) != Integer.MAX_VALUE) {
            return i7 & com.google.android.gms.common.api.f.API_PRIORITY_OTHER;
        }
        if (v2 == null) {
            S s7 = S.f4509c;
            s7.getClass();
            i = s7.a(getClass()).i(this);
        } else {
            i = v2.i(this);
        }
        k(i);
        return i;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0319a
    public final void b(C0330l c0330l) {
        S s6 = S.f4509c;
        s6.getClass();
        V vA = s6.a(getClass());
        E e = c0330l.f4581a;
        if (e == null) {
            e = new E(c0330l);
        }
        vA.e(this, e);
    }

    public abstract Object c(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        S s6 = S.f4509c;
        s6.getClass();
        return s6.a(getClass()).g(this, (AbstractC0339v) obj);
    }

    public final boolean g() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void h() {
        this.memoizedSerializedSize &= com.google.android.gms.common.api.f.API_PRIORITY_OTHER;
    }

    public final int hashCode() {
        if (g()) {
            S s6 = S.f4509c;
            s6.getClass();
            return s6.a(getClass()).f(this);
        }
        if (this.memoizedHashCode == 0) {
            S s7 = S.f4509c;
            s7.getClass();
            this.memoizedHashCode = s7.a(getClass()).f(this);
        }
        return this.memoizedHashCode;
    }

    public final AbstractC0339v i() {
        return (AbstractC0339v) c(4);
    }

    public final void k(int i) {
        if (i < 0) {
            throw new IllegalStateException(a3.d.f(i, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i & com.google.android.gms.common.api.f.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = L.f4490a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        L.c(this, sb, 0);
        return sb.toString();
    }
}
