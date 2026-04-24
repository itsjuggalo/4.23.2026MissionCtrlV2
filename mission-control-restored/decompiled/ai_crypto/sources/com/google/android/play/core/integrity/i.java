package com.google.android.play.core.integrity;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class i implements k {
    @Override // com.google.android.play.core.integrity.k
    public final com.google.android.gms.common.api.b a(Bundle bundle) {
        int i7 = bundle.getInt("error");
        if (i7 == 0) {
            return null;
        }
        return new IntegrityServiceException(i7, null);
    }
}
