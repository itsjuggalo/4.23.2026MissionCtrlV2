package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class StandardIntegrityException extends com.google.android.gms.common.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f11850a;

    public StandardIntegrityException(int i7, Throwable th) {
        super(new Status(i7, String.format(Locale.ROOT, "Standard Integrity API error (%d): %s.", Integer.valueOf(i7), com.google.android.play.core.integrity.model.b.a(i7))));
        if (i7 == 0) {
            throw new IllegalArgumentException("ErrorCode should not be 0.");
        }
        this.f11850a = th;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f11850a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
