package com.google.protobuf;

import com.google.protobuf.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public enum d1 implements c0.a {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0.b f6957d = new c0.b() { // from class: com.google.protobuf.d1.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6959a;

    d1(int i10) {
        this.f6959a = i10;
    }

    @Override // com.google.protobuf.c0.a
    public final int d() {
        if (this != UNRECOGNIZED) {
            return this.f6959a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
