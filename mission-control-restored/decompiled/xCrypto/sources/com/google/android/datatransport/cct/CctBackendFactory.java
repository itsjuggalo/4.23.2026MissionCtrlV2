package com.google.android.datatransport.cct;

import Y0.d;
import b1.InterfaceC0860d;
import b1.h;
import b1.m;

/* JADX INFO: loaded from: classes.dex */
public class CctBackendFactory implements InterfaceC0860d {
    @Override // b1.InterfaceC0860d
    public m create(h hVar) {
        return new d(hVar.b(), hVar.e(), hVar.d());
    }
}
