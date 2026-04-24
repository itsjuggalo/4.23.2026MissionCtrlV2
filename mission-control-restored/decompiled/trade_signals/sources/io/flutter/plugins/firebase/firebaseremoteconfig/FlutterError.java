package io.flutter.plugins.firebase.firebaseremoteconfig;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class FlutterError extends Throwable {
    private final String code;
    private final Object details;
    private final String message;

    public FlutterError(String code, String str, Object obj) {
        AbstractC2304t.f(code, "code");
        this.code = code;
        this.message = str;
        this.details = obj;
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

    public /* synthetic */ FlutterError(String str, String str2, Object obj, int i8, AbstractC2296k abstractC2296k) {
        this(str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : obj);
    }
}
