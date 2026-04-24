package com.amazon.a.a.n.a.a;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.amazon.a.a.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9791a = "EMPTY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9792b = "MISSING_FIELD";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f9793c = 1;

    private g(String str, String str2) {
        super("MALFORMED_RESPONSE", str, str2);
    }

    public static final g a(String str) {
        return new g(f9792b, str);
    }

    public static final g d() {
        return new g(f9791a, null);
    }
}
