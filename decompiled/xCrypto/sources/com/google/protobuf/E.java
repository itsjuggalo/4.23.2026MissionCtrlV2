package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class E extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f10928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f10929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10930c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f10934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10936i;

    public E(Iterable iterable) {
        this.f10928a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f10930c++;
        }
        this.f10931d = -1;
        if (e()) {
            return;
        }
        this.f10929b = C.f10885e;
        this.f10931d = 0;
        this.f10932e = 0;
        this.f10936i = 0L;
    }

    public final boolean e() {
        this.f10931d++;
        if (!this.f10928a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f10928a.next();
        this.f10929b = byteBuffer;
        this.f10932e = byteBuffer.position();
        if (this.f10929b.hasArray()) {
            this.f10933f = true;
            this.f10934g = this.f10929b.array();
            this.f10935h = this.f10929b.arrayOffset();
        } else {
            this.f10933f = false;
            this.f10936i = A0.k(this.f10929b);
            this.f10934g = null;
        }
        return true;
    }

    public final void f(int i4) {
        int i5 = this.f10932e + i4;
        this.f10932e = i5;
        if (i5 == this.f10929b.limit()) {
            e();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f10931d == this.f10930c) {
            return -1;
        }
        if (this.f10933f) {
            int i4 = this.f10934g[this.f10932e + this.f10935h] & 255;
            f(1);
            return i4;
        }
        int iW = A0.w(((long) this.f10932e) + this.f10936i) & 255;
        f(1);
        return iW;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) {
        if (this.f10931d == this.f10930c) {
            return -1;
        }
        int iLimit = this.f10929b.limit();
        int i6 = this.f10932e;
        int i7 = iLimit - i6;
        if (i5 > i7) {
            i5 = i7;
        }
        if (this.f10933f) {
            System.arraycopy(this.f10934g, i6 + this.f10935h, bArr, i4, i5);
            f(i5);
            return i5;
        }
        int iPosition = this.f10929b.position();
        F.b(this.f10929b, this.f10932e);
        this.f10929b.get(bArr, i4, i5);
        F.b(this.f10929b, iPosition);
        f(i5);
        return i5;
    }
}
