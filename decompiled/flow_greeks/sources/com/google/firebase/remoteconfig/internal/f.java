package com.google.firebase.remoteconfig.internal;

import pa.s;
import pa.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f6550c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f6551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u f6553c;

        public f a() {
            return new f(this.f6551a, this.f6552b, this.f6553c);
        }

        public b b(u uVar) {
            this.f6553c = uVar;
            return this;
        }

        public b c(int i10) {
            this.f6552b = i10;
            return this;
        }

        public b d(long j10) {
            this.f6551a = j10;
            return this;
        }

        public b() {
        }
    }

    public static b d() {
        return new b();
    }

    @Override // pa.s
    public int a() {
        return this.f6549b;
    }

    @Override // pa.s
    public long b() {
        return this.f6548a;
    }

    @Override // pa.s
    public u c() {
        return this.f6550c;
    }

    public f(long j10, int i10, u uVar) {
        this.f6548a = j10;
        this.f6549b = i10;
        this.f6550c = uVar;
    }
}
