package com.google.android.gms.auth.api.identity;

import com.google.android.gms.auth.api.identity.ClearTokenRequest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ClearTokenRequest.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5394b;

    public a() {
    }

    @Override // com.google.android.gms.auth.api.identity.ClearTokenRequest.a
    public final ClearTokenRequest a() {
        if (this.f5393a != null) {
            return new ClearTokenRequest(this.f5393a, this.f5394b);
        }
        throw new IllegalStateException("Missing required properties: token");
    }

    @Override // com.google.android.gms.auth.api.identity.ClearTokenRequest.a
    public final ClearTokenRequest.a b(String str) {
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.f5393a = str;
        return this;
    }

    @Override // com.google.android.gms.auth.api.identity.ClearTokenRequest.a
    public final ClearTokenRequest.a c(String str) {
        this.f5394b = str;
        return this;
    }

    public a(ClearTokenRequest clearTokenRequest) {
        this.f5393a = clearTokenRequest.S();
        this.f5394b = clearTokenRequest.T();
    }
}
