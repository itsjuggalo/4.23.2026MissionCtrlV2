package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseIntArray f5733a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m5.f f5734b;

    public i0(m5.f fVar) {
        s.k(fVar);
        this.f5734b = fVar;
    }

    public final int a(Context context, a.f fVar) {
        s.k(context);
        s.k(fVar);
        int iH = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int iB = b(context, minApkVersion);
        if (iB != -1) {
            return iB;
        }
        SparseIntArray sparseIntArray = this.f5733a;
        synchronized (sparseIntArray) {
            int i10 = 0;
            while (true) {
                try {
                    if (i10 >= sparseIntArray.size()) {
                        iH = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i10);
                    if (iKeyAt > minApkVersion && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    }
                    i10++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (iH == -1) {
                iH = this.f5734b.h(context, minApkVersion);
            }
            sparseIntArray.put(minApkVersion, iH);
        }
        return iH;
    }

    public final int b(Context context, int i10) {
        int i11;
        SparseIntArray sparseIntArray = this.f5733a;
        synchronized (sparseIntArray) {
            i11 = sparseIntArray.get(i10, -1);
        }
        return i11;
    }

    public final void c() {
        SparseIntArray sparseIntArray = this.f5733a;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
    }
}
