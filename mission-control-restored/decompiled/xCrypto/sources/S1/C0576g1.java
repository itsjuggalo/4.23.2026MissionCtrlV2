package S1;

import android.text.TextUtils;

/* JADX INFO: renamed from: S1.g1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0576g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X3 f4632a;

    public C0576g1(X3 x32) {
        this.f4632a = x32;
    }

    public static C0576g1 c(String str) {
        return new C0576g1((TextUtils.isEmpty(str) || str.length() > 1) ? X3.UNINITIALIZED : C0531a4.j(str.charAt(0)));
    }

    public final X3 a() {
        return this.f4632a;
    }

    public final String b() {
        return String.valueOf(C0531a4.m(this.f4632a));
    }
}
