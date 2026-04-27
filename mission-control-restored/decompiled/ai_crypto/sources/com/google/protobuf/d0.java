package com.google.protobuf;

import com.google.protobuf.AbstractC1240i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends AbstractC1240i.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ByteBuffer f12633e;

    public d0(ByteBuffer byteBuffer) {
        C.b(byteBuffer, "buffer");
        this.f12633e = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    @Override // com.google.protobuf.AbstractC1240i
    public int A(int i7, int i8, int i9) {
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            i7 = (i7 * 31) + this.f12633e.get(i10);
        }
        return i7;
    }

    @Override // com.google.protobuf.AbstractC1240i
    public int B(int i7, int i8, int i9) {
        return A0.u(i7, this.f12633e, i8, i9 + i8);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public AbstractC1240i E(int i7, int i8) {
        try {
            return new d0(Q(i7, i8));
        } catch (ArrayIndexOutOfBoundsException e7) {
            throw e7;
        } catch (IndexOutOfBoundsException e8) {
            throw new ArrayIndexOutOfBoundsException(e8.getMessage());
        }
    }

    @Override // com.google.protobuf.AbstractC1240i
    public String I(Charset charset) {
        byte[] bArrF;
        int length;
        int iArrayOffset;
        if (this.f12633e.hasArray()) {
            bArrF = this.f12633e.array();
            iArrayOffset = this.f12633e.arrayOffset() + this.f12633e.position();
            length = this.f12633e.remaining();
        } else {
            bArrF = F();
            length = bArrF.length;
            iArrayOffset = 0;
        }
        return new String(bArrF, iArrayOffset, length, charset);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public void O(AbstractC1239h abstractC1239h) {
        abstractC1239h.a(this.f12633e.slice());
    }

    @Override // com.google.protobuf.AbstractC1240i.h
    public boolean P(AbstractC1240i abstractC1240i, int i7, int i8) {
        return E(0, i8).equals(abstractC1240i.E(i7, i8 + i7));
    }

    public final ByteBuffer Q(int i7, int i8) {
        if (i7 < this.f12633e.position() || i8 > this.f12633e.limit() || i7 > i8) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i7), Integer.valueOf(i8)));
        }
        ByteBuffer byteBufferSlice = this.f12633e.slice();
        F.b(byteBufferSlice, i7 - this.f12633e.position());
        F.a(byteBufferSlice, i8 - this.f12633e.position());
        return byteBufferSlice;
    }

    @Override // com.google.protobuf.AbstractC1240i
    public ByteBuffer b() {
        return this.f12633e.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.AbstractC1240i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1240i)) {
            return false;
        }
        AbstractC1240i abstractC1240i = (AbstractC1240i) obj;
        if (size() != abstractC1240i.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof d0 ? this.f12633e.equals(((d0) obj).f12633e) : obj instanceof m0 ? obj.equals(this) : this.f12633e.equals(abstractC1240i.b());
    }

    @Override // com.google.protobuf.AbstractC1240i
    public byte g(int i7) {
        try {
            return this.f12633e.get(i7);
        } catch (ArrayIndexOutOfBoundsException e7) {
            throw e7;
        } catch (IndexOutOfBoundsException e8) {
            throw new ArrayIndexOutOfBoundsException(e8.getMessage());
        }
    }

    @Override // com.google.protobuf.AbstractC1240i
    public void r(byte[] bArr, int i7, int i8, int i9) {
        ByteBuffer byteBufferSlice = this.f12633e.slice();
        F.b(byteBufferSlice, i7);
        byteBufferSlice.get(bArr, i8, i9);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public int size() {
        return this.f12633e.remaining();
    }

    @Override // com.google.protobuf.AbstractC1240i
    public byte t(int i7) {
        return g(i7);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public boolean w() {
        return A0.r(this.f12633e);
    }

    @Override // com.google.protobuf.AbstractC1240i
    public AbstractC1241j y() {
        return AbstractC1241j.j(this.f12633e, true);
    }
}
