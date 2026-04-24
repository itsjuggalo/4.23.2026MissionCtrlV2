package com.bumptech.glide.load.data;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f14830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f14831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public X0.b f14832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14833d;

    public c(OutputStream outputStream, X0.b bVar) {
        this(outputStream, bVar, 65536);
    }

    public final void a() throws IOException {
        int i8 = this.f14833d;
        if (i8 > 0) {
            this.f14830a.write(this.f14831b, 0, i8);
            this.f14833d = 0;
        }
    }

    public final void c() throws IOException {
        if (this.f14833d == this.f14831b.length) {
            a();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f14830a.close();
            e();
        } catch (Throwable th) {
            this.f14830a.close();
            throw th;
        }
    }

    public final void e() {
        byte[] bArr = this.f14831b;
        if (bArr != null) {
            this.f14832c.d(bArr);
            this.f14831b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f14830a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        byte[] bArr = this.f14831b;
        int i9 = this.f14833d;
        this.f14833d = i9 + 1;
        bArr[i9] = (byte) i8;
        c();
    }

    public c(OutputStream outputStream, X0.b bVar, int i8) {
        this.f14830a = outputStream;
        this.f14832c = bVar;
        this.f14831b = (byte[]) bVar.e(i8, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = 0;
        do {
            int i11 = i9 - i10;
            int i12 = i8 + i10;
            int i13 = this.f14833d;
            if (i13 == 0 && i11 >= this.f14831b.length) {
                this.f14830a.write(bArr, i12, i11);
                return;
            }
            int iMin = Math.min(i11, this.f14831b.length - i13);
            System.arraycopy(bArr, i12, this.f14831b, this.f14833d, iMin);
            this.f14833d += iMin;
            i10 += iMin;
            c();
        } while (i10 < i9);
    }
}
