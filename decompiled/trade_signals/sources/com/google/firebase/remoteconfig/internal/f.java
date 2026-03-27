package com.google.firebase.remoteconfig.internal;

import b4.s;
import b4.u;

/* JADX INFO: loaded from: classes.dex */
public class f implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f15897c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f15898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u f15900c;

        public b() {
        }

        public f a() {
            return new f(this.f15898a, this.f15899b, this.f15900c);
        }

        public b b(u uVar) {
            this.f15900c = uVar;
            return this;
        }

        public b c(int i8) {
            this.f15899b = i8;
            return this;
        }

        public b d(long j8) {
            this.f15898a = j8;
            return this;
        }
    }

    public f(long j8, int i8, u uVar) {
        this.f15895a = j8;
        this.f15896b = i8;
        this.f15897c = uVar;
    }

    public static b d() {
        return new b();
    }

    @Override // b4.s
    public int a() {
        return this.f15896b;
    }

    @Override // b4.s
    public long b() {
        return this.f15895a;
    }

    @Override // b4.s
    public u c() {
        return this.f15897c;
    }
}
