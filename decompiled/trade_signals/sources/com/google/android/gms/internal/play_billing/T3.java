package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public abstract class T3 {
    public static G0 a(Q3 q32) {
        O3 o32 = new O3();
        S3 s32 = new S3(o32);
        o32.f15197b = s32;
        o32.f15196a = q32.getClass();
        try {
            o32.f15196a = q32.a(o32);
        } catch (Exception e8) {
            s32.d(e8);
        }
        return s32;
    }
}
