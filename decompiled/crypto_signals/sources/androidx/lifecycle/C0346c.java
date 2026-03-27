package androidx.lifecycle;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0346c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f4672b;

    public C0346c(int i, Method method) {
        this.f4671a = i;
        this.f4672b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0346c)) {
            return false;
        }
        C0346c c0346c = (C0346c) obj;
        return this.f4671a == c0346c.f4671a && this.f4672b.getName().equals(c0346c.f4672b.getName());
    }

    public final int hashCode() {
        return this.f4672b.getName().hashCode() + (this.f4671a * 31);
    }
}
