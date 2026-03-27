package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class j implements k {
    @Override // com.google.android.play.core.integrity.k
    public final com.google.android.gms.common.api.b a(Bundle bundle) {
        int i4 = bundle.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        if (i4 == 0) {
            return null;
        }
        return new StandardIntegrityException(i4, null);
    }
}
