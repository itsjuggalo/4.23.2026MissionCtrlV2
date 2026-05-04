package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import c5.v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ClearTokenRequest extends n5.a implements ReflectedParcelable {
    public static final Parcelable.Creator<ClearTokenRequest> CREATOR = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5377b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a {
        public abstract ClearTokenRequest a();

        public abstract a b(String str);

        public abstract a c(String str);
    }

    public ClearTokenRequest(String str, String str2) {
        this.f5376a = str;
        this.f5377b = str2;
    }

    public static a R() {
        return new com.google.android.gms.auth.api.identity.a();
    }

    public String S() {
        return this.f5376a;
    }

    public final String T() {
        return this.f5377b;
    }

    public final a U() {
        return new com.google.android.gms.auth.api.identity.a(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ClearTokenRequest) {
            ClearTokenRequest clearTokenRequest = (ClearTokenRequest) obj;
            if (q.b(this.f5376a, clearTokenRequest.f5376a) && q.b(this.f5377b, clearTokenRequest.f5377b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return q.c(this.f5376a, this.f5377b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.E(parcel, 1, S(), false);
        c.E(parcel, 2, this.f5377b, false);
        c.b(parcel, iA);
    }
}
