package com.google.android.gms.common.api.internal;

import P1.C0650d;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1186x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0650d[] f11009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11011c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.x$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC1181s f11012a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0650d[] f11014c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11013b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11015d = 0;

        public /* synthetic */ a(h0 h0Var) {
        }

        public AbstractC1186x a() {
            AbstractC1207s.b(this.f11012a != null, "execute parameter required");
            return new g0(this, this.f11014c, this.f11013b, this.f11015d);
        }

        public a b(InterfaceC1181s interfaceC1181s) {
            this.f11012a = interfaceC1181s;
            return this;
        }

        public a c(boolean z7) {
            this.f11013b = z7;
            return this;
        }

        public a d(C0650d... c0650dArr) {
            this.f11014c = c0650dArr;
            return this;
        }

        public a e(int i7) {
            this.f11015d = i7;
            return this;
        }
    }

    public AbstractC1186x(C0650d[] c0650dArr, boolean z7, int i7) {
        this.f11009a = c0650dArr;
        boolean z8 = false;
        if (c0650dArr != null && z7) {
            z8 = true;
        }
        this.f11010b = z8;
        this.f11011c = i7;
    }

    public static a a() {
        return new a(null);
    }

    public abstract void b(a.b bVar, TaskCompletionSource taskCompletionSource);

    public boolean c() {
        return this.f11010b;
    }

    public final int d() {
        return this.f11011c;
    }

    public final C0650d[] e() {
        return this.f11009a;
    }
}
