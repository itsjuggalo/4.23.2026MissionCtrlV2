package i2;

import android.text.TextUtils;

/* JADX INFO: renamed from: i2.g1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1816g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X3 f15791a;

    public C1816g1(X3 x32) {
        this.f15791a = x32;
    }

    public static C1816g1 c(String str) {
        return new C1816g1((TextUtils.isEmpty(str) || str.length() > 1) ? X3.UNINITIALIZED : C1771a4.j(str.charAt(0)));
    }

    public final X3 a() {
        return this.f15791a;
    }

    public final String b() {
        return String.valueOf(C1771a4.m(this.f15791a));
    }
}
