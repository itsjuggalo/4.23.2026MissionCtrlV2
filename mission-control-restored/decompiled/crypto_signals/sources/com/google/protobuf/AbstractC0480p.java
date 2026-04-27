package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0480p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5777b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5778c;

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long d(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static C0474m h(byte[] bArr, int i, int i6, boolean z6) {
        C0474m c0474m = new C0474m(bArr, i, i6, z6);
        try {
            c0474m.j(i6);
            return c0474m;
        } catch (O e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int A();

    public abstract int B();

    public abstract long C();

    public abstract boolean D(int i);

    public void E() {
        int iA;
        do {
            iA = A();
            if (iA == 0) {
                return;
            }
            int i = this.f5776a;
            if (i >= this.f5777b) {
                throw new O("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.f5776a = i + 1;
            this.f5776a--;
        } while (D(iA));
    }

    public abstract void a(int i);

    public abstract int f();

    public abstract boolean g();

    public abstract void i(int i);

    public abstract int j(int i);

    public abstract boolean k();

    public abstract C0470k l();

    public abstract double m();

    public abstract int o();

    public abstract int p();

    public abstract long q();

    public abstract float r();

    public abstract int s();

    public abstract long t();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract String y();

    public abstract String z();
}
