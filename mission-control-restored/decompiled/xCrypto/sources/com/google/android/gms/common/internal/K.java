package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import z1.C1989g;

/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseIntArray f9852a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1989g f9853b;

    public K(C1989g c1989g) {
        AbstractC0940s.k(c1989g);
        this.f9853b = c1989g;
    }

    public final int a(Context context, int i4) {
        return this.f9852a.get(i4, -1);
    }

    public final int b(Context context, a.f fVar) {
        AbstractC0940s.k(context);
        AbstractC0940s.k(fVar);
        int iH = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int iA = a(context, minApkVersion);
        if (iA != -1) {
            return iA;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.f9852a.size()) {
                iH = -1;
                break;
            }
            int iKeyAt = this.f9852a.keyAt(i4);
            if (iKeyAt > minApkVersion && this.f9852a.get(iKeyAt) == 0) {
                break;
            }
            i4++;
        }
        if (iH == -1) {
            iH = this.f9853b.h(context, minApkVersion);
        }
        this.f9852a.put(minApkVersion, iH);
        return iH;
    }

    public final void c() {
        this.f9852a.clear();
    }
}
