package com.amazon.device.drm.a.c;

import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RequestId f14364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LicenseResponse.RequestStatus f14365b;

    public a a(LicenseResponse.RequestStatus requestStatus) {
        this.f14365b = requestStatus;
        return this;
    }

    public RequestId b() {
        return this.f14364a;
    }

    public LicenseResponse.RequestStatus c() {
        return this.f14365b;
    }

    public a a(RequestId requestId) {
        this.f14364a = requestId;
        return this;
    }

    public LicenseResponse a() {
        return new LicenseResponse(this);
    }
}
