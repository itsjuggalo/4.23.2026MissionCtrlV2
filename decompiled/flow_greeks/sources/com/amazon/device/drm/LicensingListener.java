package com.amazon.device.drm;

import com.amazon.device.drm.model.LicenseResponse;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface LicensingListener {
    void onLicenseCommandResponse(LicenseResponse licenseResponse);
}
