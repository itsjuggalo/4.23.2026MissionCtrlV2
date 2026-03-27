package com.google.firebase;

import G1.q;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.C0943v;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseOptions {
    private static final String API_KEY_RESOURCE_NAME = "google_api_key";
    private static final String APP_ID_RESOURCE_NAME = "google_app_id";
    private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
    private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
    private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
    private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
    private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
    private final String apiKey;
    private final String applicationId;
    private final String databaseUrl;
    private final String gaTrackingId;
    private final String gcmSenderId;
    private final String projectId;
    private final String storageBucket;

    public static final class Builder {
        private String apiKey;
        private String applicationId;
        private String databaseUrl;
        private String gaTrackingId;
        private String gcmSenderId;
        private String projectId;
        private String storageBucket;

        public Builder() {
        }

        public FirebaseOptions build() {
            return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
        }

        public Builder setApiKey(String str) {
            this.apiKey = AbstractC0940s.f(str, "ApiKey must be set.");
            return this;
        }

        public Builder setApplicationId(String str) {
            this.applicationId = AbstractC0940s.f(str, "ApplicationId must be set.");
            return this;
        }

        public Builder setDatabaseUrl(String str) {
            this.databaseUrl = str;
            return this;
        }

        public Builder setGaTrackingId(String str) {
            this.gaTrackingId = str;
            return this;
        }

        public Builder setGcmSenderId(String str) {
            this.gcmSenderId = str;
            return this;
        }

        public Builder setProjectId(String str) {
            this.projectId = str;
            return this;
        }

        public Builder setStorageBucket(String str) {
            this.storageBucket = str;
            return this;
        }

        public Builder(FirebaseOptions firebaseOptions) {
            this.applicationId = firebaseOptions.applicationId;
            this.apiKey = firebaseOptions.apiKey;
            this.databaseUrl = firebaseOptions.databaseUrl;
            this.gaTrackingId = firebaseOptions.gaTrackingId;
            this.gcmSenderId = firebaseOptions.gcmSenderId;
            this.storageBucket = firebaseOptions.storageBucket;
            this.projectId = firebaseOptions.projectId;
        }
    }

    public static FirebaseOptions fromResource(Context context) {
        C0943v c0943v = new C0943v(context);
        String strA = c0943v.a(APP_ID_RESOURCE_NAME);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new FirebaseOptions(strA, c0943v.a(API_KEY_RESOURCE_NAME), c0943v.a(DATABASE_URL_RESOURCE_NAME), c0943v.a(GA_TRACKING_ID_RESOURCE_NAME), c0943v.a(GCM_SENDER_ID_RESOURCE_NAME), c0943v.a(STORAGE_BUCKET_RESOURCE_NAME), c0943v.a(PROJECT_ID_RESOURCE_NAME));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return AbstractC0939q.b(this.applicationId, firebaseOptions.applicationId) && AbstractC0939q.b(this.apiKey, firebaseOptions.apiKey) && AbstractC0939q.b(this.databaseUrl, firebaseOptions.databaseUrl) && AbstractC0939q.b(this.gaTrackingId, firebaseOptions.gaTrackingId) && AbstractC0939q.b(this.gcmSenderId, firebaseOptions.gcmSenderId) && AbstractC0939q.b(this.storageBucket, firebaseOptions.storageBucket) && AbstractC0939q.b(this.projectId, firebaseOptions.projectId);
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getGaTrackingId() {
        return this.gaTrackingId;
    }

    public String getGcmSenderId() {
        return this.gcmSenderId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getStorageBucket() {
        return this.storageBucket;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
    }

    public String toString() {
        return AbstractC0939q.d(this).a("applicationId", this.applicationId).a("apiKey", this.apiKey).a("databaseUrl", this.databaseUrl).a("gcmSenderId", this.gcmSenderId).a("storageBucket", this.storageBucket).a("projectId", this.projectId).toString();
    }

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AbstractC0940s.o(!q.b(str), "ApplicationId must be set.");
        this.applicationId = str;
        this.apiKey = str2;
        this.databaseUrl = str3;
        this.gaTrackingId = str4;
        this.gcmSenderId = str5;
        this.storageBucket = str6;
        this.projectId = str7;
    }
}
