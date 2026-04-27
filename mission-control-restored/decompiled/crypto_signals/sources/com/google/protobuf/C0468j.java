package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0468j extends C0470k {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5740f;

    public C0468j(byte[] bArr, int i, int i6) {
        super(bArr);
        AbstractC0472l.h(i, i + i6, bArr.length);
        this.e = i;
        this.f5740f = i6;
    }

    @Override // com.google.protobuf.C0470k, com.google.protobuf.AbstractC0472l
    public final byte c(int i) {
        AbstractC0472l.f(i, this.f5740f);
        return this.f5741d[this.e + i];
    }

    @Override // com.google.protobuf.C0470k, com.google.protobuf.AbstractC0472l
    public final void l(int i, byte[] bArr, int i6, int i7) {
        System.arraycopy(this.f5741d, this.e + i, bArr, i6, i7);
    }

    @Override // com.google.protobuf.C0470k, com.google.protobuf.AbstractC0472l
    public final byte n(int i) {
        return this.f5741d[this.e + i];
    }

    @Override // com.google.protobuf.C0470k, com.google.protobuf.AbstractC0472l
    public final int size() {
        return this.f5740f;
    }

    @Override // com.google.protobuf.C0470k
    public final int y() {
        return this.e;
    }
}
