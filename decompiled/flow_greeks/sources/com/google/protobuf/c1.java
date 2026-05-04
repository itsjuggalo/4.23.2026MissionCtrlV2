package com.google.protobuf;

import com.google.protobuf.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends i.AbstractC0115i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ByteBuffer f6949e;

    public c1(ByteBuffer byteBuffer) {
        c0.b(byteBuffer, "buffer");
        this.f6949e = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    @Override // com.google.protobuf.i
    public byte A(int i10) {
        return e(i10);
    }

    @Override // com.google.protobuf.i
    public boolean K() {
        return z1.r(this.f6949e);
    }

    @Override // com.google.protobuf.i
    public j S() {
        return j.j(this.f6949e, true);
    }

    @Override // com.google.protobuf.i
    public int T(int i10, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + this.f6949e.get(i13);
        }
        return i10;
    }

    @Override // com.google.protobuf.i
    public int U(int i10, int i11, int i12) {
        return z1.u(i10, this.f6949e, i11, i12 + i11);
    }

    @Override // com.google.protobuf.i
    public i X(int i10, int i11) {
        try {
            return new c1(j0(i10, i11));
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new ArrayIndexOutOfBoundsException(e11.getMessage());
        }
    }

    @Override // com.google.protobuf.i
    public String b0(Charset charset) {
        byte[] bArrY;
        int length;
        int iArrayOffset;
        if (this.f6949e.hasArray()) {
            bArrY = this.f6949e.array();
            iArrayOffset = this.f6949e.arrayOffset() + this.f6949e.position();
            length = this.f6949e.remaining();
        } else {
            bArrY = Y();
            length = bArrY.length;
            iArrayOffset = 0;
        }
        return new String(bArrY, iArrayOffset, length, charset);
    }

    @Override // com.google.protobuf.i
    public ByteBuffer c() {
        return this.f6949e.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.i
    public byte e(int i10) {
        try {
            return this.f6949e.get(i10);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new ArrayIndexOutOfBoundsException(e11.getMessage());
        }
    }

    @Override // com.google.protobuf.i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (size() != iVar.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof c1 ? this.f6949e.equals(((c1) obj).f6949e) : obj instanceof l1 ? obj.equals(this) : this.f6949e.equals(iVar.c());
    }

    @Override // com.google.protobuf.i
    public void h0(h hVar) {
        hVar.a(this.f6949e.slice());
    }

    @Override // com.google.protobuf.i.AbstractC0115i
    public boolean i0(i iVar, int i10, int i11) {
        return X(0, i11).equals(iVar.X(i10, i11 + i10));
    }

    public final ByteBuffer j0(int i10, int i11) {
        if (i10 < this.f6949e.position() || i11 > this.f6949e.limit() || i10 > i11) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        ByteBuffer byteBufferSlice = this.f6949e.slice();
        f0.b(byteBufferSlice, i10 - this.f6949e.position());
        f0.a(byteBufferSlice, i11 - this.f6949e.position());
        return byteBufferSlice;
    }

    @Override // com.google.protobuf.i
    public int size() {
        return this.f6949e.remaining();
    }

    @Override // com.google.protobuf.i
    public void w(byte[] bArr, int i10, int i11, int i12) {
        ByteBuffer byteBufferSlice = this.f6949e.slice();
        f0.b(byteBufferSlice, i10);
        byteBufferSlice.get(bArr, i11, i12);
    }
}
