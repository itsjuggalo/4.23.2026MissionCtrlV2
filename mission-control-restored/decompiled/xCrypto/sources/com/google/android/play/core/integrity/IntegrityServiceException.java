package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class IntegrityServiceException extends com.google.android.gms.common.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f10066a;

    public IntegrityServiceException(int i4, Throwable th) {
        super(new Status(i4, String.format(Locale.ROOT, "Integrity API error (%d): %s.", Integer.valueOf(i4), com.google.android.play.core.integrity.model.a.a(i4))));
        if (i4 == 0) {
            throw new IllegalArgumentException("ErrorCode should not be 0.");
        }
        this.f10066a = th;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f10066a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
