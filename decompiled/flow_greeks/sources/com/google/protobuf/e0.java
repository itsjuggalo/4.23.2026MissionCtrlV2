package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class e0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f6961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f6962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6963c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f6967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6969i;

    public e0(Iterable iterable) {
        this.f6961a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f6963c++;
        }
        this.f6964d = -1;
        if (b()) {
            return;
        }
        this.f6962b = c0.f6947e;
        this.f6964d = 0;
        this.f6965e = 0;
        this.f6969i = 0L;
    }

    public final boolean b() {
        this.f6964d++;
        if (!this.f6961a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f6961a.next();
        this.f6962b = byteBuffer;
        this.f6965e = byteBuffer.position();
        if (this.f6962b.hasArray()) {
            this.f6966f = true;
            this.f6967g = this.f6962b.array();
            this.f6968h = this.f6962b.arrayOffset();
        } else {
            this.f6966f = false;
            this.f6969i = y1.k(this.f6962b);
            this.f6967g = null;
        }
        return true;
    }

    public final void c(int i10) {
        int i11 = this.f6965e + i10;
        this.f6965e = i11;
        if (i11 == this.f6962b.limit()) {
            b();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f6964d == this.f6963c) {
            return -1;
        }
        if (this.f6966f) {
            int i10 = this.f6967g[this.f6965e + this.f6968h] & 255;
            c(1);
            return i10;
        }
        int iW = y1.w(((long) this.f6965e) + this.f6969i) & 255;
        c(1);
        return iW;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        if (this.f6964d == this.f6963c) {
            return -1;
        }
        int iLimit = this.f6962b.limit();
        int i12 = this.f6965e;
        int i13 = iLimit - i12;
        if (i11 > i13) {
            i11 = i13;
        }
        if (this.f6966f) {
            System.arraycopy(this.f6967g, i12 + this.f6968h, bArr, i10, i11);
            c(i11);
            return i11;
        }
        int iPosition = this.f6962b.position();
        f0.b(this.f6962b, this.f6965e);
        this.f6962b.get(bArr, i10, i11);
        f0.b(this.f6962b, iPosition);
        c(i11);
        return i11;
    }
}
