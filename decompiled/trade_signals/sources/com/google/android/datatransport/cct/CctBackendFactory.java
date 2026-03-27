package com.google.android.datatransport.cct;

import A1.d;
import A1.h;
import A1.m;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class CctBackendFactory implements d {
    @Override // A1.d
    public m create(h hVar) {
        return new x1.d(hVar.b(), hVar.e(), hVar.d());
    }
}
