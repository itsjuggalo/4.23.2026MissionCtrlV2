package G;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f449b;

    public d(int i4) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f448a = new Object[i4];
    }

    @Override // G.c
    public boolean a(Object instance) {
        r.f(instance, "instance");
        if (c(instance)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i4 = this.f449b;
        Object[] objArr = this.f448a;
        if (i4 >= objArr.length) {
            return false;
        }
        objArr[i4] = instance;
        this.f449b = i4 + 1;
        return true;
    }

    @Override // G.c
    public Object b() {
        int i4 = this.f449b;
        if (i4 <= 0) {
            return null;
        }
        int i5 = i4 - 1;
        Object obj = this.f448a[i5];
        r.d(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f448a[i5] = null;
        this.f449b--;
        return obj;
    }

    public final boolean c(Object obj) {
        int i4 = this.f449b;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.f448a[i5] == obj) {
                return true;
            }
        }
        return false;
    }
}
