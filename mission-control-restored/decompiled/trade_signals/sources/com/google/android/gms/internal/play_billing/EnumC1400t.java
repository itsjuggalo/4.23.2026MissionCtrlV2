package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1400t {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);


    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Q f15520q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15522a;

    static {
        P p8 = new P();
        for (EnumC1400t enumC1400t : values()) {
            p8.a(Integer.valueOf(enumC1400t.f15522a), enumC1400t);
        }
        f15520q = p8.b();
    }

    EnumC1400t(int i8) {
        this.f15522a = i8;
    }

    public static EnumC1400t a(int i8) {
        Q q8 = f15520q;
        Integer numValueOf = Integer.valueOf(i8);
        return !q8.containsKey(numValueOf) ? RESPONSE_CODE_UNSPECIFIED : (EnumC1400t) q8.get(numValueOf);
    }
}
