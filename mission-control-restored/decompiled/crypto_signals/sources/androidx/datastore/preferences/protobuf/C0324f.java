package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0324f extends C0325g {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4548f;

    public C0324f(byte[] bArr, int i, int i6) {
        super(bArr);
        C0325g.b(i, i + i6, bArr.length);
        this.e = i;
        this.f4548f = i6;
    }

    @Override // androidx.datastore.preferences.protobuf.C0325g
    public final byte a(int i) {
        int i6 = this.f4548f;
        if (((i6 - (i + 1)) | i) >= 0) {
            return this.f4553b[this.e + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(a3.d.f(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(a3.d.h("Index > length: ", i, i6, ", "));
    }

    @Override // androidx.datastore.preferences.protobuf.C0325g
    public final void f(byte[] bArr, int i) {
        System.arraycopy(this.f4553b, this.e, bArr, 0, i);
    }

    @Override // androidx.datastore.preferences.protobuf.C0325g
    public final int h() {
        return this.e;
    }

    @Override // androidx.datastore.preferences.protobuf.C0325g
    public final byte k(int i) {
        return this.f4553b[this.e + i];
    }

    @Override // androidx.datastore.preferences.protobuf.C0325g
    public final int size() {
        return this.f4548f;
    }
}
