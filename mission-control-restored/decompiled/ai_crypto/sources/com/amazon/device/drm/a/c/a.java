package com.amazon.device.drm.a.c;

import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RequestId f10253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LicenseResponse.RequestStatus f10254b;

    public LicenseResponse a() {
        return new LicenseResponse(this);
    }

    public RequestId b() {
        return this.f10253a;
    }

    public LicenseResponse.RequestStatus c() {
        return this.f10254b;
    }

    public a a(RequestId requestId) {
        this.f10253a = requestId;
        return this;
    }

    public a a(LicenseResponse.RequestStatus requestStatus) {
        this.f10254b = requestStatus;
        return this;
    }
}
