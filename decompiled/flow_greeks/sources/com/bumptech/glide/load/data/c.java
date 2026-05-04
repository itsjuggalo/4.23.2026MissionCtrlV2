package com.bumptech.glide.load.data;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f5284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f5285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j3.b f5286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5287d;

    public c(OutputStream outputStream, j3.b bVar) {
        this(outputStream, bVar, 65536);
    }

    public final void b() throws IOException {
        int i10 = this.f5287d;
        if (i10 > 0) {
            this.f5284a.write(this.f5285b, 0, i10);
            this.f5287d = 0;
        }
    }

    public final void c() throws IOException {
        if (this.f5287d == this.f5285b.length) {
            b();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f5284a.close();
            e();
        } catch (Throwable th) {
            this.f5284a.close();
            throw th;
        }
    }

    public final void e() {
        byte[] bArr = this.f5285b;
        if (bArr != null) {
            this.f5286c.put(bArr);
            this.f5285b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        b();
        this.f5284a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f5285b;
        int i11 = this.f5287d;
        this.f5287d = i11 + 1;
        bArr[i11] = (byte) i10;
        c();
    }

    public c(OutputStream outputStream, j3.b bVar, int i10) {
        this.f5284a = outputStream;
        this.f5286c = bVar;
        this.f5285b = (byte[]) bVar.d(i10, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f5287d;
            if (i15 == 0 && i13 >= this.f5285b.length) {
                this.f5284a.write(bArr, i14, i13);
                return;
            }
            int iMin = Math.min(i13, this.f5285b.length - i15);
            System.arraycopy(bArr, i14, this.f5285b, this.f5287d, iMin);
            this.f5287d += iMin;
            i12 += iMin;
            c();
        } while (i12 < i11);
    }
}
