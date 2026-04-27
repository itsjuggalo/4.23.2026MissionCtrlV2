package com.google.firebase.sessions.dagger.internal;

import V2.a;
import com.google.firebase.sessions.dagger.Lazy;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleCheck<T> implements a, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile a provider;

    private DoubleCheck(a aVar) {
        this.provider = aVar;
    }

    public static <P extends a, T> Lazy<T> lazy(P p4) {
        return p4 instanceof Lazy ? (Lazy) p4 : new DoubleCheck((a) Preconditions.checkNotNull(p4));
    }

    public static <P extends a, T> a provider(P p4) {
        Preconditions.checkNotNull(p4);
        return p4 instanceof DoubleCheck ? p4 : new DoubleCheck(p4);
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        if (obj == UNINITIALIZED || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // V2.a
    public T get() {
        T t4;
        T t5 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t5 != obj) {
            return t5;
        }
        synchronized (this) {
            try {
                t4 = (T) this.instance;
                if (t4 == obj) {
                    t4 = (T) this.provider.get();
                    this.instance = reentrantCheck(this.instance, t4);
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t4;
    }
}
