package b6;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.s;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends n5.a {
    public static final Parcelable.Creator<e> CREATOR = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2995c;

    public e(b bVar, String str, String str2) {
        this.f2993a = (b) s.k(bVar);
        this.f2995c = str;
        this.f2994b = str2;
    }

    public String R() {
        return this.f2994b;
    }

    public String S() {
        return this.f2995c;
    }

    public b T() {
        return this.f2993a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f2995c;
        if (str == null) {
            if (eVar.f2995c != null) {
                return false;
            }
        } else if (!str.equals(eVar.f2995c)) {
            return false;
        }
        if (!this.f2993a.equals(eVar.f2993a)) {
            return false;
        }
        String str2 = this.f2994b;
        if (str2 == null) {
            if (eVar.f2994b != null) {
                return false;
            }
        } else if (!str2.equals(eVar.f2994b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f2995c;
        int iHashCode = (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f2993a.hashCode();
        String str2 = this.f2994b;
        return (iHashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("keyHandle", Base64.encodeToString(this.f2993a.R(), 11));
            if (this.f2993a.S() != c.UNKNOWN) {
                jSONObject.put(DiagnosticsEntry.VERSION_KEY, this.f2993a.S().toString());
            }
            if (this.f2993a.T() != null) {
                jSONObject.put("transports", this.f2993a.T().toString());
            }
            String str = this.f2995c;
            if (str != null) {
                jSONObject.put("challenge", str);
            }
            String str2 = this.f2994b;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 2, T(), i10, false);
        n5.c.E(parcel, 3, S(), false);
        n5.c.E(parcel, 4, R(), false);
        n5.c.b(parcel, iA);
    }
}
