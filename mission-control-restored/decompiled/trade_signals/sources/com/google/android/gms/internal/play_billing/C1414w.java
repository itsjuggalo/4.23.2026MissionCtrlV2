package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1414w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1410v f15529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C1410v f15530c;

    public /* synthetic */ C1414w(String str, AbstractC1418x abstractC1418x) {
        C1410v c1410v = new C1410v();
        this.f15529b = c1410v;
        this.f15530c = c1410v;
        str.getClass();
        this.f15528a = str;
    }

    public final C1414w a(Object obj) {
        C1410v c1410v = new C1410v();
        this.f15530c.f15524b = c1410v;
        this.f15530c = c1410v;
        c1410v.f15523a = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f15528a);
        sb.append('{');
        C1410v c1410v = this.f15529b.f15524b;
        String str = "";
        while (c1410v != null) {
            Object obj = c1410v.f15523a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            c1410v = c1410v.f15524b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
