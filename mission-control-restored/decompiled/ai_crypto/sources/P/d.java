package P;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f4241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4242b;

    public d(int i7) {
        if (i7 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f4241a = new Object[i7];
    }

    @Override // P.c
    public boolean a(Object instance) {
        r.f(instance, "instance");
        if (c(instance)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i7 = this.f4242b;
        Object[] objArr = this.f4241a;
        if (i7 >= objArr.length) {
            return false;
        }
        objArr[i7] = instance;
        this.f4242b = i7 + 1;
        return true;
    }

    @Override // P.c
    public Object b() {
        int i7 = this.f4242b;
        if (i7 <= 0) {
            return null;
        }
        int i8 = i7 - 1;
        Object obj = this.f4241a[i8];
        r.d(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f4241a[i8] = null;
        this.f4242b--;
        return obj;
    }

    public final boolean c(Object obj) {
        int i7 = this.f4242b;
        for (int i8 = 0; i8 < i7; i8++) {
            if (this.f4241a[i8] == obj) {
                return true;
            }
        }
        return false;
    }
}
