package com.google.protobuf;

import com.google.protobuf.AbstractC1062i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends AbstractC1062i.AbstractC0160i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ByteBuffer f11010e;

    public e0(ByteBuffer byteBuffer) {
        C.b(byteBuffer, "buffer");
        this.f11010e = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    @Override // com.google.protobuf.AbstractC1062i
    public AbstractC1063j A() {
        return AbstractC1063j.k(this.f11010e, true);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public int B(int i4, int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            i4 = (i4 * 31) + this.f11010e.get(i7);
        }
        return i4;
    }

    @Override // com.google.protobuf.AbstractC1062i
    public int C(int i4, int i5, int i6) {
        return B0.u(i4, this.f11010e, i5, i6 + i5);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public AbstractC1062i F(int i4, int i5) {
        try {
            return new e0(R(i4, i5));
        } catch (ArrayIndexOutOfBoundsException e4) {
            throw e4;
        } catch (IndexOutOfBoundsException e5) {
            throw new ArrayIndexOutOfBoundsException(e5.getMessage());
        }
    }

    @Override // com.google.protobuf.AbstractC1062i
    public String J(Charset charset) {
        byte[] bArrG;
        int length;
        int iArrayOffset;
        if (this.f11010e.hasArray()) {
            bArrG = this.f11010e.array();
            iArrayOffset = this.f11010e.arrayOffset() + this.f11010e.position();
            length = this.f11010e.remaining();
        } else {
            bArrG = G();
            length = bArrG.length;
            iArrayOffset = 0;
        }
        return new String(bArrG, iArrayOffset, length, charset);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public void P(AbstractC1061h abstractC1061h) {
        abstractC1061h.a(this.f11010e.slice());
    }

    @Override // com.google.protobuf.AbstractC1062i.AbstractC0160i
    public boolean Q(AbstractC1062i abstractC1062i, int i4, int i5) {
        return F(0, i5).equals(abstractC1062i.F(i4, i5 + i4));
    }

    public final ByteBuffer R(int i4, int i5) {
        if (i4 < this.f11010e.position() || i5 > this.f11010e.limit() || i4 > i5) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i4), Integer.valueOf(i5)));
        }
        ByteBuffer byteBufferSlice = this.f11010e.slice();
        F.b(byteBufferSlice, i4 - this.f11010e.position());
        F.a(byteBufferSlice, i5 - this.f11010e.position());
        return byteBufferSlice;
    }

    @Override // com.google.protobuf.AbstractC1062i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1062i)) {
            return false;
        }
        AbstractC1062i abstractC1062i = (AbstractC1062i) obj;
        if (size() != abstractC1062i.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof e0 ? this.f11010e.equals(((e0) obj).f11010e) : obj instanceof n0 ? obj.equals(this) : this.f11010e.equals(abstractC1062i.f());
    }

    @Override // com.google.protobuf.AbstractC1062i
    public ByteBuffer f() {
        return this.f11010e.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.AbstractC1062i
    public byte k(int i4) {
        try {
            return this.f11010e.get(i4);
        } catch (ArrayIndexOutOfBoundsException e4) {
            throw e4;
        } catch (IndexOutOfBoundsException e5) {
            throw new ArrayIndexOutOfBoundsException(e5.getMessage());
        }
    }

    @Override // com.google.protobuf.AbstractC1062i
    public int size() {
        return this.f11010e.remaining();
    }

    @Override // com.google.protobuf.AbstractC1062i
    public void t(byte[] bArr, int i4, int i5, int i6) {
        ByteBuffer byteBufferSlice = this.f11010e.slice();
        F.b(byteBufferSlice, i4);
        byteBufferSlice.get(bArr, i5, i6);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public byte v(int i4) {
        return k(i4);
    }

    @Override // com.google.protobuf.AbstractC1062i
    public boolean x() {
        return B0.r(this.f11010e);
    }
}
