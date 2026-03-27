package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class StandardIntegrityException extends com.google.android.gms.common.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f10067a;

    public StandardIntegrityException(int i4, Throwable th) {
        super(new Status(i4, String.format(Locale.ROOT, "Standard Integrity API error (%d): %s.", Integer.valueOf(i4), com.google.android.play.core.integrity.model.b.a(i4))));
        if (i4 == 0) {
            throw new IllegalArgumentException("ErrorCode should not be 0.");
        }
        this.f10067a = th;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f10067a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
