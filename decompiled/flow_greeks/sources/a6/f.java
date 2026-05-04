package a6;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends n5.a {
    public static final Parcelable.Creator<f> CREATOR = new r1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f159a;

    public f(boolean z10) {
        this.f159a = z10;
    }

    public boolean R() {
        return this.f159a;
    }

    public final JSONObject S() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rk", this.f159a);
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException("Error encoding AuthenticationExtensionsCredPropsOutputs to JSON object", e10);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f159a == ((f) obj).f159a;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f159a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, R());
        n5.c.b(parcel, iA);
    }
}
