package com.revenuecat.purchases.hybridcommon;

import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorContainer {
    private final int code;
    private final Map<String, Object> info;
    private final String message;

    public ErrorContainer(int i4, String message, Map<String, ? extends Object> info) {
        r.f(message, "message");
        r.f(info, "info");
        this.code = i4;
        this.message = message;
        this.info = info;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ErrorContainer copy$default(ErrorContainer errorContainer, int i4, String str, Map map, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = errorContainer.code;
        }
        if ((i5 & 2) != 0) {
            str = errorContainer.message;
        }
        if ((i5 & 4) != 0) {
            map = errorContainer.info;
        }
        return errorContainer.copy(i4, str, map);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final Map<String, Object> component3() {
        return this.info;
    }

    public final ErrorContainer copy(int i4, String message, Map<String, ? extends Object> info) {
        r.f(message, "message");
        r.f(info, "info");
        return new ErrorContainer(i4, message, info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorContainer)) {
            return false;
        }
        ErrorContainer errorContainer = (ErrorContainer) obj;
        return this.code == errorContainer.code && r.b(this.message, errorContainer.message) && r.b(this.info, errorContainer.info);
    }

    public final int getCode() {
        return this.code;
    }

    public final Map<String, Object> getInfo() {
        return this.info;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31) + this.info.hashCode();
    }

    public String toString() {
        return "ErrorContainer(code=" + this.code + ", message=" + this.message + ", info=" + this.info + ')';
    }
}
