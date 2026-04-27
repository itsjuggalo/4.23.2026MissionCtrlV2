package com.google.android.gms.common.internal;

import P1.C0653g;
import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseIntArray f11035a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0653g f11036b;

    public K(C0653g c0653g) {
        AbstractC1207s.k(c0653g);
        this.f11036b = c0653g;
    }

    public final int a(Context context, int i7) {
        return this.f11035a.get(i7, -1);
    }

    public final int b(Context context, a.f fVar) {
        AbstractC1207s.k(context);
        AbstractC1207s.k(fVar);
        int i7 = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int iA = a(context, minApkVersion);
        if (iA == -1) {
            int i8 = 0;
            while (true) {
                if (i8 >= this.f11035a.size()) {
                    i7 = -1;
                    break;
                }
                int iKeyAt = this.f11035a.keyAt(i8);
                if (iKeyAt > minApkVersion && this.f11035a.get(iKeyAt) == 0) {
                    break;
                }
                i8++;
            }
            iA = i7 == -1 ? this.f11036b.h(context, minApkVersion) : i7;
            this.f11035a.put(minApkVersion, iA);
        }
        return iA;
    }

    public final void c() {
        this.f11035a.clear();
    }
}
