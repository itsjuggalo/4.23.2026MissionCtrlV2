package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: loaded from: classes.dex */
final class c extends StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte f5417b;

    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder a(int i) {
        this.f5417b = (byte) (this.f5417b | 2);
        return this;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest build() {
        if (this.f5417b == 3) {
            return new e(this.f5416a, 0, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f5417b & 1) == 0) {
            sb.append(" cloudProjectNumber");
        }
        if ((this.f5417b & 2) == 0) {
            sb.append(" webViewRequestMode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder setCloudProjectNumber(long j4) {
        this.f5416a = j4;
        this.f5417b = (byte) (this.f5417b | 1);
        return this;
    }
}
