package a6;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends n5.a {
    public static final Parcelable.Creator<e> CREATOR = new p1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1 f146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u1 f148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f149e;

    public e(h0 h0Var, s1 s1Var, f fVar, u1 u1Var, String str) {
        this.f145a = h0Var;
        this.f146b = s1Var;
        this.f147c = fVar;
        this.f148d = u1Var;
        this.f149e = str;
    }

    public f R() {
        return this.f147c;
    }

    public h0 S() {
        return this.f145a;
    }

    public final JSONObject T() {
        try {
            JSONObject jSONObject = new JSONObject();
            f fVar = this.f147c;
            if (fVar != null) {
                jSONObject.put("credProps", fVar.S());
            }
            h0 h0Var = this.f145a;
            if (h0Var != null) {
                jSONObject.put("uvm", h0Var.S());
            }
            u1 u1Var = this.f148d;
            if (u1Var != null) {
                jSONObject.put("prf", u1Var.R());
            }
            String str = this.f149e;
            if (str != null) {
                jSONObject.put("txAuthSimple", str);
            }
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException("Error encoding AuthenticationExtensionsClientOutputs to JSON object", e10);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return com.google.android.gms.common.internal.q.b(this.f145a, eVar.f145a) && com.google.android.gms.common.internal.q.b(this.f146b, eVar.f146b) && com.google.android.gms.common.internal.q.b(this.f147c, eVar.f147c) && com.google.android.gms.common.internal.q.b(this.f148d, eVar.f148d) && com.google.android.gms.common.internal.q.b(this.f149e, eVar.f149e);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f145a, this.f146b, this.f147c, this.f148d, this.f149e);
    }

    public final String toString() {
        return "AuthenticationExtensionsClientOutputs{" + T().toString() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, S(), i10, false);
        n5.c.C(parcel, 2, this.f146b, i10, false);
        n5.c.C(parcel, 3, R(), i10, false);
        n5.c.C(parcel, 4, this.f148d, i10, false);
        n5.c.E(parcel, 5, this.f149e, false);
        n5.c.b(parcel, iA);
    }
}
