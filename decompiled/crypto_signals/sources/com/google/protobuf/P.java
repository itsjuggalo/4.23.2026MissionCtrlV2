package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class P extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f5663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f5664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5666d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5667f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f5668k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5669l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5670m;

    public final boolean d() {
        this.f5666d++;
        Iterator it = this.f5663a;
        if (!it.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) it.next();
        this.f5664b = byteBuffer;
        this.e = byteBuffer.position();
        if (this.f5664b.hasArray()) {
            this.f5667f = true;
            this.f5668k = this.f5664b.array();
            this.f5669l = this.f5664b.arrayOffset();
            return true;
        }
        this.f5667f = false;
        this.f5670m = M0.f5656c.j(this.f5664b, M0.f5659g);
        this.f5668k = null;
        return true;
    }

    public final void f(int i) {
        int i6 = this.e + i;
        this.e = i6;
        if (i6 == this.f5664b.limit()) {
            d();
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f5666d == this.f5665c) {
            return -1;
        }
        if (this.f5667f) {
            int i = this.f5668k[this.e + this.f5669l] & 255;
            f(1);
            return i;
        }
        int iE = M0.f5656c.e(((long) this.e) + this.f5670m) & 255;
        f(1);
        return iE;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) {
        if (this.f5666d == this.f5665c) {
            return -1;
        }
        int iLimit = this.f5664b.limit();
        int i7 = this.e;
        int i8 = iLimit - i7;
        if (i6 > i8) {
            i6 = i8;
        }
        if (this.f5667f) {
            System.arraycopy(this.f5668k, i7 + this.f5669l, bArr, i, i6);
            f(i6);
            return i6;
        }
        int iPosition = this.f5664b.position();
        this.f5664b.position(this.e);
        this.f5664b.get(bArr, i, i6);
        this.f5664b.position(iPosition);
        f(i6);
        return i6;
    }
}
