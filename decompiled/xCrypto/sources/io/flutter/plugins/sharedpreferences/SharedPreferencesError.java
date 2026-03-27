package io.flutter.plugins.sharedpreferences;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferencesError extends Throwable {
    private final String code;
    private final Object details;
    private final String message;

    public /* synthetic */ SharedPreferencesError(String str, String str2, Object obj, int i4, AbstractC1585j abstractC1585j) {
        this(str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : obj);
    }

    public final String getCode() {
        return this.code;
    }

    public final Object getDetails() {
        return this.details;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public SharedPreferencesError(String code, String str, Object obj) {
        kotlin.jvm.internal.r.f(code, "code");
        this.code = code;
        this.message = str;
        this.details = obj;
    }
}
