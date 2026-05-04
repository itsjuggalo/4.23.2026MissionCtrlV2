package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzia;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class t extends n5.a {
    public static final Parcelable.Creator<t> CREATOR = new x0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzgx f236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f242i;

    public t(String str, String str2, zzgx zzgxVar, h hVar, g gVar, i iVar, e eVar, String str3, String str4) {
        boolean z10 = false;
        com.google.android.gms.common.internal.s.b((hVar != null && gVar == null && iVar == null) || (hVar == null && gVar != null && iVar == null) || (hVar == null && gVar == null && iVar != null), "Must provide a response object.");
        if (iVar != null || (str != null && zzgxVar != null)) {
            z10 = true;
        }
        com.google.android.gms.common.internal.s.b(z10, "Must provide id and rawId if not an error response.");
        this.f234a = str;
        this.f235b = str2;
        this.f236c = zzgxVar;
        this.f237d = hVar;
        this.f238e = gVar;
        this.f239f = iVar;
        this.f240g = eVar;
        this.f241h = str3;
        this.f242i = null;
    }

    public String R() {
        return this.f241h;
    }

    public e S() {
        return this.f240g;
    }

    public String T() {
        return this.f234a;
    }

    public byte[] U() {
        zzgx zzgxVar = this.f236c;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public j V() {
        h hVar = this.f237d;
        if (hVar != null) {
            return hVar;
        }
        g gVar = this.f238e;
        if (gVar != null) {
            return gVar;
        }
        i iVar = this.f239f;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalStateException("No response set.");
    }

    public String W() {
        return this.f235b;
    }

    public String X() {
        return Y().toString();
    }

    public final JSONObject Y() {
        JSONObject jSONObjectU;
        try {
            JSONObject jSONObject = new JSONObject();
            zzgx zzgxVar = this.f236c;
            if (zzgxVar != null && zzgxVar.zzm().length > 0) {
                jSONObject.put("rawId", t5.c.e(this.f236c.zzm()));
            }
            String str = this.f241h;
            if (str != null) {
                jSONObject.put("authenticatorAttachment", str);
            }
            String str2 = this.f235b;
            if (str2 != null && this.f239f == null) {
                jSONObject.put("type", str2);
            }
            String str3 = this.f234a;
            if (str3 != null) {
                jSONObject.put(DiagnosticsEntry.ID_KEY, str3);
            }
            String str4 = "response";
            g gVar = this.f238e;
            boolean z10 = true;
            if (gVar != null) {
                jSONObjectU = gVar.W();
            } else {
                h hVar = this.f237d;
                if (hVar != null) {
                    jSONObjectU = hVar.V();
                } else {
                    i iVar = this.f239f;
                    z10 = false;
                    if (iVar != null) {
                        jSONObjectU = iVar.U();
                        str4 = "error";
                    } else {
                        jSONObjectU = null;
                    }
                }
            }
            if (jSONObjectU != null) {
                jSONObject.put(str4, jSONObjectU);
            }
            e eVar = this.f240g;
            if (eVar != null) {
                jSONObject.put("clientExtensionResults", eVar.T());
                return jSONObject;
            }
            if (z10) {
                jSONObject.put("clientExtensionResults", new JSONObject());
            }
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException("Error encoding PublicKeyCredential to JSON object", e10);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return com.google.android.gms.common.internal.q.b(this.f234a, tVar.f234a) && com.google.android.gms.common.internal.q.b(this.f235b, tVar.f235b) && com.google.android.gms.common.internal.q.b(this.f236c, tVar.f236c) && com.google.android.gms.common.internal.q.b(this.f237d, tVar.f237d) && com.google.android.gms.common.internal.q.b(this.f238e, tVar.f238e) && com.google.android.gms.common.internal.q.b(this.f239f, tVar.f239f) && com.google.android.gms.common.internal.q.b(this.f240g, tVar.f240g) && com.google.android.gms.common.internal.q.b(this.f241h, tVar.f241h);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f234a, this.f235b, this.f236c, this.f238e, this.f237d, this.f239f, this.f240g, this.f241h);
    }

    public final String toString() {
        zzgx zzgxVar = this.f236c;
        byte[] bArrZzm = zzgxVar == null ? null : zzgxVar.zzm();
        String str = this.f235b;
        String str2 = this.f234a;
        h hVar = this.f237d;
        g gVar = this.f238e;
        i iVar = this.f239f;
        e eVar = this.f240g;
        String str3 = this.f241h;
        return "PublicKeyCredential{\n id='" + str2 + "', \n type='" + str + "', \n rawId=" + t5.c.e(bArrZzm) + ", \n registerResponse=" + String.valueOf(hVar) + ", \n signResponse=" + String.valueOf(gVar) + ", \n errorResponse=" + String.valueOf(iVar) + ", \n extensionsClientOutputs=" + String.valueOf(eVar) + ", \n authenticatorAttachment='" + str3 + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (zzia.zzc()) {
            this.f242i = Y().toString();
        }
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, T(), false);
        n5.c.E(parcel, 2, W(), false);
        n5.c.k(parcel, 3, U(), false);
        n5.c.C(parcel, 4, this.f237d, i10, false);
        n5.c.C(parcel, 5, this.f238e, i10, false);
        n5.c.C(parcel, 6, this.f239f, i10, false);
        n5.c.C(parcel, 7, S(), i10, false);
        n5.c.E(parcel, 8, R(), false);
        n5.c.E(parcel, 9, this.f242i, false);
        n5.c.b(parcel, iA);
        this.f242i = null;
    }

    public t(String str, String str2, byte[] bArr, h hVar, g gVar, i iVar, e eVar, String str3, String str4) {
        this(str, str2, bArr == null ? null : zzgx.zzl(bArr, 0, bArr.length), hVar, gVar, iVar, eVar, str3, str4);
    }
}
