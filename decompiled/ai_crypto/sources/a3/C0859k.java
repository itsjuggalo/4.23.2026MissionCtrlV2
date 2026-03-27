package a3;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: a3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0859k implements Z2.B {
    public static final Parcelable.Creator<C0859k> CREATOR = new C0857j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6246b;

    public C0859k(long j7, long j8) {
        this.f6245a = j7;
        this.f6246b = j8;
    }

    public static C0859k a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new C0859k(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.f6245a);
            jSONObject.put("creationTimestamp", this.f6246b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // Z2.B
    public final long l() {
        return this.f6246b;
    }

    @Override // Z2.B
    public final long q() {
        return this.f6245a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.x(parcel, 1, q());
        Q1.c.x(parcel, 2, l());
        Q1.c.b(parcel, iA);
    }
}
