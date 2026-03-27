package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class E extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f12556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f12557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12558c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f12562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f12564i;

    public E(Iterable iterable) {
        this.f12556a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f12558c++;
        }
        this.f12559d = -1;
        if (h()) {
            return;
        }
        this.f12557b = C.f12549e;
        this.f12559d = 0;
        this.f12560e = 0;
        this.f12564i = 0L;
    }

    public final boolean h() {
        this.f12559d++;
        if (!this.f12556a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f12556a.next();
        this.f12557b = byteBuffer;
        this.f12560e = byteBuffer.position();
        if (this.f12557b.hasArray()) {
            this.f12561f = true;
            this.f12562g = this.f12557b.array();
            this.f12563h = this.f12557b.arrayOffset();
        } else {
            this.f12561f = false;
            this.f12564i = z0.k(this.f12557b);
            this.f12562g = null;
        }
        return true;
    }

    public final void i(int i7) {
        int i8 = this.f12560e + i7;
        this.f12560e = i8;
        if (i8 == this.f12557b.limit()) {
            h();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f12559d == this.f12558c) {
            return -1;
        }
        if (this.f12561f) {
            int i7 = this.f12562g[this.f12560e + this.f12563h] & 255;
            i(1);
            return i7;
        }
        int iW = z0.w(((long) this.f12560e) + this.f12564i) & 255;
        i(1);
        return iW;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) {
        if (this.f12559d == this.f12558c) {
            return -1;
        }
        int iLimit = this.f12557b.limit();
        int i9 = this.f12560e;
        int i10 = iLimit - i9;
        if (i8 > i10) {
            i8 = i10;
        }
        if (this.f12561f) {
            System.arraycopy(this.f12562g, i9 + this.f12563h, bArr, i7, i8);
            i(i8);
        } else {
            int iPosition = this.f12557b.position();
            F.b(this.f12557b, this.f12560e);
            this.f12557b.get(bArr, i7, i8);
            F.b(this.f12557b, iPosition);
            i(i8);
        }
        return i8;
    }
}
