package com.google.protobuf;

import com.google.protobuf.C;

/* JADX INFO: loaded from: classes.dex */
public enum f0 implements C.c {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C.d f11019d = new C.d() { // from class: com.google.protobuf.f0.a
        @Override // com.google.protobuf.C.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f0 a(int i4) {
            return f0.a(i4);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11021a;

    f0(int i4) {
        this.f11021a = i4;
    }

    public static f0 a(int i4) {
        if (i4 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    @Override // com.google.protobuf.C.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f11021a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
