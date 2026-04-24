package com.google.android.gms.common.internal;

import Q1.C0795g;
import R1.a;
import android.content.Context;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseIntArray f14923a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0795g f14924b;

    public E(C0795g c0795g) {
        AbstractC1294n.j(c0795g);
        this.f14924b = c0795g;
    }

    public final int a(Context context, int i8) {
        return this.f14923a.get(i8, -1);
    }

    public final int b(Context context, a.f fVar) {
        AbstractC1294n.j(context);
        AbstractC1294n.j(fVar);
        int i8 = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int iA = a(context, minApkVersion);
        if (iA == -1) {
            int i9 = 0;
            while (true) {
                if (i9 >= this.f14923a.size()) {
                    i8 = -1;
                    break;
                }
                int iKeyAt = this.f14923a.keyAt(i9);
                if (iKeyAt > minApkVersion && this.f14923a.get(iKeyAt) == 0) {
                    break;
                }
                i9++;
            }
            iA = i8 == -1 ? this.f14924b.h(context, minApkVersion) : i8;
            this.f14923a.put(minApkVersion, iA);
        }
        return iA;
    }

    public final void c() {
        this.f14923a.clear();
    }
}
