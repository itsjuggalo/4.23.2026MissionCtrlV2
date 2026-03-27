package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import z1.C1986d;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0920y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1986d[] f9832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9834c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.y$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC0915t f9835a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C1986d[] f9837c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9836b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9838d = 0;

        public /* synthetic */ a(k0 k0Var) {
        }

        public AbstractC0920y a() {
            AbstractC0940s.b(this.f9835a != null, "execute parameter required");
            return new j0(this, this.f9837c, this.f9836b, this.f9838d);
        }

        public a b(InterfaceC0915t interfaceC0915t) {
            this.f9835a = interfaceC0915t;
            return this;
        }

        public a c(boolean z4) {
            this.f9836b = z4;
            return this;
        }

        public a d(C1986d... c1986dArr) {
            this.f9837c = c1986dArr;
            return this;
        }

        public a e(int i4) {
            this.f9838d = i4;
            return this;
        }
    }

    public AbstractC0920y(C1986d[] c1986dArr, boolean z4, int i4) {
        this.f9832a = c1986dArr;
        boolean z5 = false;
        if (c1986dArr != null && z4) {
            z5 = true;
        }
        this.f9833b = z5;
        this.f9834c = i4;
    }

    public static a a() {
        return new a(null);
    }

    public abstract void b(a.b bVar, TaskCompletionSource taskCompletionSource);

    public boolean c() {
        return this.f9833b;
    }

    public final int d() {
        return this.f9834c;
    }

    public final C1986d[] e() {
        return this.f9832a;
    }
}
