package S;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f7291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7292b;

    public e(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }
        this.f7291a = new Object[i8];
    }

    @Override // S.d
    public boolean a(Object instance) {
        AbstractC2304t.f(instance, "instance");
        if (!(!c(instance))) {
            throw new IllegalStateException("Already in the pool!".toString());
        }
        int i8 = this.f7292b;
        Object[] objArr = this.f7291a;
        if (i8 >= objArr.length) {
            return false;
        }
        objArr[i8] = instance;
        this.f7292b = i8 + 1;
        return true;
    }

    @Override // S.d
    public Object b() {
        int i8 = this.f7292b;
        if (i8 <= 0) {
            return null;
        }
        int i9 = i8 - 1;
        Object obj = this.f7291a[i9];
        AbstractC2304t.d(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f7291a[i9] = null;
        this.f7292b--;
        return obj;
    }

    public final boolean c(Object obj) {
        int i8 = this.f7292b;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.f7291a[i9] == obj) {
                return true;
            }
        }
        return false;
    }
}
