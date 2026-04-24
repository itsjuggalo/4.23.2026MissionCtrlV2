package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0457d0 {
    public static C0455c0 a(Object obj, Object obj2) {
        C0455c0 c0455c0D = (C0455c0) obj;
        C0455c0 c0455c0 = (C0455c0) obj2;
        if (!c0455c0.isEmpty()) {
            if (!c0455c0D.f5712a) {
                c0455c0D = c0455c0D.d();
            }
            c0455c0D.c();
            if (!c0455c0.isEmpty()) {
                c0455c0D.putAll(c0455c0);
            }
        }
        return c0455c0D;
    }
}
