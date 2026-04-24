package com.google.protobuf;

import androidx.datastore.preferences.protobuf.C0329k;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class E extends AbstractC0450a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, E> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected D0 unknownFields;

    public E() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = D0.f5638f;
    }

    public static void f(E e) throws O {
        if (!k(e, true)) {
            throw new O(new C0().getMessage());
        }
    }

    public static E i(Class cls) {
        E e = defaultInstanceMap.get(cls);
        if (e == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                e = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (e != null) {
            return e;
        }
        E e6 = (E) ((E) M0.b(cls)).h(6);
        if (e6 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, e6);
        return e6;
    }

    public static Object j(Method method, AbstractC0450a abstractC0450a, Object... objArr) {
        try {
            return method.invoke(abstractC0450a, objArr);
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

    public static final boolean k(E e, boolean z6) {
        byte bByteValue = ((Byte) e.h(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        C0479o0 c0479o0 = C0479o0.f5773c;
        c0479o0.getClass();
        boolean zC = c0479o0.a(e.getClass()).c(e);
        if (z6) {
            e.h(2);
        }
        return zC;
    }

    public static L n(L l6) {
        int size = l6.size();
        return l6.d(size == 0 ? 10 : size * 2);
    }

    public static E p(E e, byte[] bArr) throws O {
        int length = bArr.length;
        C0491v c0491vA = C0491v.a();
        E eO = e.o();
        try {
            C0479o0 c0479o0 = C0479o0.f5773c;
            c0479o0.getClass();
            InterfaceC0488t0 interfaceC0488t0A = c0479o0.a(eO.getClass());
            C0458e c0458e = new C0458e();
            c0491vA.getClass();
            interfaceC0488t0A.h(eO, bArr, 0, length, c0458e);
            interfaceC0488t0A.b(eO);
            f(eO);
            return eO;
        } catch (C0 e2) {
            throw new O(e2.getMessage());
        } catch (O e6) {
            if (e6.f5662a) {
                throw new O(e6.getMessage(), e6);
            }
            throw e6;
        } catch (IOException e7) {
            if (e7.getCause() instanceof O) {
                throw ((O) e7.getCause());
            }
            throw new O(e7.getMessage(), e7);
        } catch (IndexOutOfBoundsException unused) {
            throw O.h();
        }
    }

    public static E q(E e, AbstractC0480p abstractC0480p, C0491v c0491v) throws O {
        E eO = e.o();
        try {
            C0479o0 c0479o0 = C0479o0.f5773c;
            c0479o0.getClass();
            InterfaceC0488t0 interfaceC0488t0A = c0479o0.a(eO.getClass());
            C0329k c0329k = (C0329k) abstractC0480p.f5778c;
            if (c0329k == null) {
                c0329k = new C0329k(abstractC0480p);
            }
            interfaceC0488t0A.j(eO, c0329k, c0491v);
            interfaceC0488t0A.b(eO);
            return eO;
        } catch (C0 e2) {
            throw new O(e2.getMessage());
        } catch (O e6) {
            if (e6.f5662a) {
                throw new O(e6.getMessage(), e6);
            }
            throw e6;
        } catch (IOException e7) {
            if (e7.getCause() instanceof O) {
                throw ((O) e7.getCause());
            }
            throw new O(e7.getMessage(), e7);
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof O) {
                throw ((O) e8.getCause());
            }
            throw e8;
        }
    }

    public static void r(Class cls, E e) {
        e.m();
        defaultInstanceMap.put(cls, e);
    }

    @Override // com.google.protobuf.AbstractC0450a
    public final int c(InterfaceC0488t0 interfaceC0488t0) {
        int iE;
        int iE2;
        if (l()) {
            if (interfaceC0488t0 == null) {
                C0479o0 c0479o0 = C0479o0.f5773c;
                c0479o0.getClass();
                iE2 = c0479o0.a(getClass()).e(this);
            } else {
                iE2 = interfaceC0488t0.e(this);
            }
            if (iE2 >= 0) {
                return iE2;
            }
            throw new IllegalStateException(a3.d.f(iE2, "serialized size must be non-negative, was "));
        }
        int i = this.memoizedSerializedSize;
        if ((i & com.google.android.gms.common.api.f.API_PRIORITY_OTHER) != Integer.MAX_VALUE) {
            return i & com.google.android.gms.common.api.f.API_PRIORITY_OTHER;
        }
        if (interfaceC0488t0 == null) {
            C0479o0 c0479o02 = C0479o0.f5773c;
            c0479o02.getClass();
            iE = c0479o02.a(getClass()).e(this);
        } else {
            iE = interfaceC0488t0.e(this);
        }
        s(iE);
        return iE;
    }

    @Override // com.google.protobuf.AbstractC0450a
    public final void e(AbstractC0485s abstractC0485s) {
        C0479o0 c0479o0 = C0479o0.f5773c;
        c0479o0.getClass();
        InterfaceC0488t0 interfaceC0488t0A = c0479o0.a(getClass());
        Z z6 = abstractC0485s.f5795c;
        if (z6 == null) {
            z6 = new Z(abstractC0485s);
        }
        interfaceC0488t0A.f(this, z6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0479o0 c0479o0 = C0479o0.f5773c;
        c0479o0.getClass();
        return c0479o0.a(getClass()).g(this, (E) obj);
    }

    public final C g() {
        return (C) h(5);
    }

    public abstract Object h(int i);

    public final int hashCode() {
        if (l()) {
            C0479o0 c0479o0 = C0479o0.f5773c;
            c0479o0.getClass();
            return c0479o0.a(getClass()).i(this);
        }
        if (this.memoizedHashCode == 0) {
            C0479o0 c0479o02 = C0479o0.f5773c;
            c0479o02.getClass();
            this.memoizedHashCode = c0479o02.a(getClass()).i(this);
        }
        return this.memoizedHashCode;
    }

    public final boolean l() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void m() {
        this.memoizedSerializedSize &= com.google.android.gms.common.api.f.API_PRIORITY_OTHER;
    }

    public final E o() {
        return (E) h(4);
    }

    public final void s(int i) {
        if (i < 0) {
            throw new IllegalStateException(a3.d.f(i, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i & com.google.android.gms.common.api.f.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = AbstractC0463g0.f5722a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        AbstractC0463g0.c(this, sb, 0);
        return sb.toString();
    }
}
