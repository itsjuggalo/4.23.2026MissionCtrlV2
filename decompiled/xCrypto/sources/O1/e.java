package O1;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends A1.a {
    public static final Parcelable.Creator<e> CREATOR = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3127c;

    public e(b bVar, String str, String str2) {
        this.f3125a = (b) AbstractC0940s.k(bVar);
        this.f3127c = str;
        this.f3126b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f3127c;
        if (str == null) {
            if (eVar.f3127c != null) {
                return false;
            }
        } else if (!str.equals(eVar.f3127c)) {
            return false;
        }
        if (!this.f3125a.equals(eVar.f3125a)) {
            return false;
        }
        String str2 = this.f3126b;
        if (str2 == null) {
            if (eVar.f3126b != null) {
                return false;
            }
        } else if (!str2.equals(eVar.f3126b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f3127c;
        int iHashCode = (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f3125a.hashCode();
        String str2 = this.f3126b;
        return (iHashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public String i() {
        return this.f3126b;
    }

    public String k() {
        return this.f3127c;
    }

    public b l() {
        return this.f3125a;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("keyHandle", Base64.encodeToString(this.f3125a.i(), 11));
            if (this.f3125a.k() != c.UNKNOWN) {
                jSONObject.put(DiagnosticsEntry.VERSION_KEY, this.f3125a.k().toString());
            }
            if (this.f3125a.l() != null) {
                jSONObject.put("transports", this.f3125a.l().toString());
            }
            String str = this.f3127c;
            if (str != null) {
                jSONObject.put("challenge", str);
            }
            String str2 = this.f3126b;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject.toString();
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 2, l(), i4, false);
        A1.c.E(parcel, 3, k(), false);
        A1.c.E(parcel, 4, i(), false);
        A1.c.b(parcel, iA);
    }
}
