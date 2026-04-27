package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class W implements H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f16326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f16328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16329d;

    public W(J j8, String str, Object[] objArr) {
        char cCharAt;
        this.f16326a = j8;
        this.f16327b = str;
        this.f16328c = objArr;
        int iCharAt = str.charAt(0);
        if (iCharAt >= 55296) {
            int i8 = iCharAt & 8191;
            int i9 = 13;
            int i10 = 1;
            while (true) {
                int i11 = i10 + 1;
                cCharAt = str.charAt(i10);
                if (cCharAt < 55296) {
                    break;
                }
                i8 |= (cCharAt & 8191) << i9;
                i9 += 13;
                i10 = i11;
            }
            iCharAt = i8 | (cCharAt << i9);
        }
        this.f16329d = iCharAt;
    }

    @Override // com.google.protobuf.H
    public boolean a() {
        return (this.f16329d & 2) == 2;
    }

    @Override // com.google.protobuf.H
    public J b() {
        return this.f16326a;
    }

    @Override // com.google.protobuf.H
    public T c() {
        int i8 = this.f16329d;
        return (i8 & 1) != 0 ? T.PROTO2 : (i8 & 4) == 4 ? T.EDITIONS : T.PROTO3;
    }

    public Object[] d() {
        return this.f16328c;
    }

    public String e() {
        return this.f16327b;
    }
}
