package n7;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements m7.b0 {
    public static final Parcelable.Creator<k> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16806b;

    public k(long j10, long j11) {
        this.f16805a = j10;
        this.f16806b = j11;
    }

    public static k a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new k(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.f16805a);
            jSONObject.put("creationTimestamp", this.f16806b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // m7.b0
    public final long q() {
        return this.f16806b;
    }

    @Override // m7.b0
    public final long w() {
        return this.f16805a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.x(parcel, 1, w());
        n5.c.x(parcel, 2, q());
        n5.c.b(parcel, iA);
    }
}
