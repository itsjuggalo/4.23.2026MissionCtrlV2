package e2;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends Q1.a {
    public static final Parcelable.Creator<e> CREATOR = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f13586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13588c;

    public e(b bVar, String str, String str2) {
        this.f13586a = (b) AbstractC1207s.k(bVar);
        this.f13588c = str;
        this.f13587b = str2;
    }

    public String A() {
        return this.f13587b;
    }

    public String B() {
        return this.f13588c;
    }

    public b C() {
        return this.f13586a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f13588c;
        if (str == null) {
            if (eVar.f13588c != null) {
                return false;
            }
        } else if (!str.equals(eVar.f13588c)) {
            return false;
        }
        if (!this.f13586a.equals(eVar.f13586a)) {
            return false;
        }
        String str2 = this.f13587b;
        if (str2 == null) {
            if (eVar.f13587b != null) {
                return false;
            }
        } else if (!str2.equals(eVar.f13587b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f13588c;
        int iHashCode = (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f13586a.hashCode();
        String str2 = this.f13587b;
        return (iHashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("keyHandle", Base64.encodeToString(this.f13586a.A(), 11));
            if (this.f13586a.B() != c.UNKNOWN) {
                jSONObject.put(DiagnosticsEntry.VERSION_KEY, this.f13586a.B().toString());
            }
            if (this.f13586a.C() != null) {
                jSONObject.put("transports", this.f13586a.C().toString());
            }
            String str = this.f13588c;
            if (str != null) {
                jSONObject.put("challenge", str);
            }
            String str2 = this.f13587b;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject.toString();
        } catch (JSONException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 2, C(), i7, false);
        Q1.c.E(parcel, 3, B(), false);
        Q1.c.E(parcel, 4, A(), false);
        Q1.c.b(parcel, iA);
    }
}
