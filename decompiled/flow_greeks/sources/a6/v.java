package a6;

import a6.z;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.internal.fido.zzcf;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzh;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class v extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzgx f273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzcf f271d = zzcf.zzm(zzh.zza, zzh.zzb);
    public static final Parcelable.Creator<v> CREATOR = new y0();

    public v(String str, zzgx zzgxVar, List list) {
        com.google.android.gms.common.internal.s.k(str);
        try {
            this.f272a = z.a(str);
            this.f273b = (zzgx) com.google.android.gms.common.internal.s.k(zzgxVar);
            this.f274c = list;
        } catch (z.a e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static v U(JSONObject jSONObject) {
        return new v(jSONObject.getString("type"), Base64.decode(jSONObject.getString(DiagnosticsEntry.ID_KEY), 11), jSONObject.has("transports") ? Transport.b(jSONObject.getJSONArray("transports")) : null);
    }

    public byte[] R() {
        return this.f273b.zzm();
    }

    public List S() {
        return this.f274c;
    }

    public String T() {
        return this.f272a.toString();
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (!this.f272a.equals(vVar.f272a) || !com.google.android.gms.common.internal.q.b(this.f273b, vVar.f273b)) {
            return false;
        }
        List list2 = this.f274c;
        if (list2 == null && vVar.f274c == null) {
            return true;
        }
        return list2 != null && (list = vVar.f274c) != null && list2.containsAll(list) && vVar.f274c.containsAll(this.f274c);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f272a, this.f273b, this.f274c);
    }

    public final String toString() {
        return "PublicKeyCredentialDescriptor{\n type=" + String.valueOf(this.f272a) + ", \n id=" + t5.c.e(R()) + ", \n transports=" + String.valueOf(this.f274c) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, T(), false);
        n5.c.k(parcel, 3, R(), false);
        n5.c.I(parcel, 4, S(), false);
        n5.c.b(parcel, iA);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(String str, byte[] bArr, List list) {
        this(str, zzgx.zzl(bArr, 0, bArr.length), list);
        zzgx zzgxVar = zzgx.zzb;
    }
}
