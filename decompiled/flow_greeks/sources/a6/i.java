package a6;

import a6.q;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import io.flutter.plugins.firebase.database.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i extends j {
    public static final Parcelable.Creator<i> CREATOR = new y1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f180c;

    public i(int i10, String str, int i11) {
        try {
            this.f178a = q.b(i10);
            this.f179b = str;
            this.f180c = i11;
        } catch (q.a e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public q R() {
        return this.f178a;
    }

    public int S() {
        return this.f178a.a();
    }

    public String T() {
        return this.f179b;
    }

    public final JSONObject U() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.ERROR_CODE, this.f178a.a());
            String str = this.f179b;
            if (str == null) {
                return jSONObject;
            }
            jSONObject.put(Constants.ERROR_MESSAGE, str);
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException("Error encoding AuthenticatorErrorResponse to JSON object", e10);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return com.google.android.gms.common.internal.q.b(this.f178a, iVar.f178a) && com.google.android.gms.common.internal.q.b(this.f179b, iVar.f179b) && com.google.android.gms.common.internal.q.b(Integer.valueOf(this.f180c), Integer.valueOf(iVar.f180c));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f178a, this.f179b, Integer.valueOf(this.f180c));
    }

    public String toString() {
        zzbi zzbiVarZza = zzbj.zza(this);
        zzbiVarZza.zza("errorCode", this.f178a.a());
        String str = this.f179b;
        if (str != null) {
            zzbiVarZza.zzb(com.amazon.a.a.o.b.f4552f, str);
        }
        return zzbiVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 2, S());
        n5.c.E(parcel, 3, T(), false);
        n5.c.t(parcel, 4, this.f180c);
        n5.c.b(parcel, iA);
    }
}
