package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import m4.d;
import m4.h;
import m4.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class CctBackendFactory implements d {
    @Override // m4.d
    public m create(h hVar) {
        return new j4.d(hVar.b(), hVar.e(), hVar.d());
    }
}
