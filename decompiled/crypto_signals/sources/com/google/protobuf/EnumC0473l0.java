package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0473l0 implements J {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5750a;

    EnumC0473l0(int i) {
        this.f5750a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f5750a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
