package s0;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f19926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19927b;

    public d(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f19926a = new Object[i10];
    }

    @Override // s0.c
    public boolean a(Object instance) {
        t.f(instance, "instance");
        if (c(instance)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i10 = this.f19927b;
        Object[] objArr = this.f19926a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = instance;
        this.f19927b = i10 + 1;
        return true;
    }

    @Override // s0.c
    public Object b() {
        int i10 = this.f19927b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object obj = this.f19926a[i11];
        t.d(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f19926a[i11] = null;
        this.f19927b--;
        return obj;
    }

    public final boolean c(Object obj) {
        int i10 = this.f19927b;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f19926a[i11] == obj) {
                return true;
            }
        }
        return false;
    }
}
