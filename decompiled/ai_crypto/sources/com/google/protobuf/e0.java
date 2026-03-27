package com.google.protobuf;

import com.google.protobuf.C;

/* JADX INFO: loaded from: classes.dex */
public enum e0 implements C.a {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C.b f12637d = new C.b() { // from class: com.google.protobuf.e0.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12639a;

    e0(int i7) {
        this.f12639a = i7;
    }

    @Override // com.google.protobuf.C.a
    public final int d() {
        if (this != UNRECOGNIZED) {
            return this.f12639a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
