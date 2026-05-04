package a6;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.internal.fido.zzgx;
import io.flutter.plugins.firebase.analytics.Constants;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u1 extends n5.a {
    public static final Parcelable.Creator<u1> CREATOR = new v1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzgx f270b;

    public u1(boolean z10, zzgx zzgxVar) {
        this.f269a = z10;
        this.f270b = zzgxVar;
    }

    public final JSONObject R() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f269a) {
                jSONObject.put(Constants.ENABLED, true);
            }
            byte[] bArrS = S();
            if (bArrS != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("first", Base64.encodeToString(Arrays.copyOf(bArrS, 32), 11));
                if (bArrS.length == 64) {
                    jSONObject2.put("second", Base64.encodeToString(Arrays.copyOfRange(bArrS, 32, 64), 11));
                }
                jSONObject.put("results", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException("Error encoding AuthenticationExtensionsPrfOutputs to JSON object", e10);
        }
    }

    public final byte[] S() {
        zzgx zzgxVar = this.f270b;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u1)) {
            return false;
        }
        u1 u1Var = (u1) obj;
        return this.f269a == u1Var.f269a && com.google.android.gms.common.internal.q.b(this.f270b, u1Var.f270b);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f269a), this.f270b);
    }

    public final String toString() {
        return "AuthenticationExtensionsPrfOutputs{" + R().toString() + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        boolean z10 = this.f269a;
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, z10);
        n5.c.k(parcel, 2, S(), false);
        n5.c.b(parcel, iA);
    }
}
