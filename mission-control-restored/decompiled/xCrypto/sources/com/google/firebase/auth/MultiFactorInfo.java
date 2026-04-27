package com.google.firebase.auth;

import A1.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiFactorInfo extends a {
    public static final String FACTOR_ID_KEY = "factorIdKey";

    public abstract String getDisplayName();

    public abstract long getEnrollmentTimestamp();

    public abstract String getFactorId();

    public abstract String getUid();

    public abstract JSONObject toJson();
}
