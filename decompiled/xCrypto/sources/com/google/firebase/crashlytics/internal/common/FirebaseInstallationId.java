package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseInstallationId {
    private final String authToken;
    private final String fid;

    public FirebaseInstallationId(String str, String str2) {
        this.fid = str;
        this.authToken = str2;
    }

    public static /* synthetic */ FirebaseInstallationId copy$default(FirebaseInstallationId firebaseInstallationId, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = firebaseInstallationId.fid;
        }
        if ((i4 & 2) != 0) {
            str2 = firebaseInstallationId.authToken;
        }
        return firebaseInstallationId.copy(str, str2);
    }

    public final String component1() {
        return this.fid;
    }

    public final String component2() {
        return this.authToken;
    }

    public final FirebaseInstallationId copy(String str, String str2) {
        return new FirebaseInstallationId(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirebaseInstallationId)) {
            return false;
        }
        FirebaseInstallationId firebaseInstallationId = (FirebaseInstallationId) obj;
        return kotlin.jvm.internal.r.b(this.fid, firebaseInstallationId.fid) && kotlin.jvm.internal.r.b(this.authToken, firebaseInstallationId.authToken);
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getFid() {
        return this.fid;
    }

    public int hashCode() {
        String str = this.fid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.authToken;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FirebaseInstallationId(fid=" + this.fid + ", authToken=" + this.authToken + ')';
    }
}
