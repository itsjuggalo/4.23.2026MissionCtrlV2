package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
final class LengthCountingOutputStream extends OutputStream {
    private long length = 0;

    public long getLength() {
        return this.length;
    }

    @Override // java.io.OutputStream
    public void write(int i4) {
        this.length++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.length += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) {
        int i6;
        if (i4 >= 0 && i4 <= bArr.length && i5 >= 0 && (i6 = i4 + i5) <= bArr.length && i6 >= 0) {
            this.length += (long) i5;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
