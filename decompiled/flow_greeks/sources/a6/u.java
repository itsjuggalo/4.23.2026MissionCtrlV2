package a6;

import a6.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import com.google.android.gms.internal.fido.zzbl;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u extends c0 {
    public static final Parcelable.Creator<u> CREATOR = new w0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e0 f251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ResultReceiver f255m;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y f256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a0 f257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Double f260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public k f262g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f263h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public e0 f264i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public c f265j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public d f266k;

        public u a() {
            y yVar = this.f256a;
            a0 a0Var = this.f257b;
            byte[] bArr = this.f258c;
            List list = this.f259d;
            Double d10 = this.f260e;
            List list2 = this.f261f;
            k kVar = this.f262g;
            Integer num = this.f263h;
            e0 e0Var = this.f264i;
            c cVar = this.f265j;
            return new u(yVar, a0Var, bArr, list, d10, list2, kVar, num, e0Var, cVar == null ? null : cVar.toString(), this.f266k, null, null);
        }

        public a b(c cVar) {
            this.f265j = cVar;
            return this;
        }

        public a c(d dVar) {
            this.f266k = dVar;
            return this;
        }

        public a d(k kVar) {
            this.f262g = kVar;
            return this;
        }

        public a e(byte[] bArr) {
            this.f258c = (byte[]) com.google.android.gms.common.internal.s.k(bArr);
            return this;
        }

        public a f(List list) {
            this.f261f = list;
            return this;
        }

        public a g(List list) {
            this.f259d = (List) com.google.android.gms.common.internal.s.k(list);
            return this;
        }

        public a h(y yVar) {
            this.f256a = (y) com.google.android.gms.common.internal.s.k(yVar);
            return this;
        }

        public a i(Double d10) {
            this.f260e = d10;
            return this;
        }

        public a j(a0 a0Var) {
            this.f257b = (a0) com.google.android.gms.common.internal.s.k(a0Var);
            return this;
        }
    }

    public u(y yVar, a0 a0Var, byte[] bArr, List list, Double d10, List list2, k kVar, Integer num, e0 e0Var, String str, d dVar, String str2, ResultReceiver resultReceiver) {
        this.f255m = resultReceiver;
        if (str2 != null) {
            try {
                u uVarD0 = d0(new JSONObject(str2));
                this.f243a = uVarD0.f243a;
                this.f244b = uVarD0.f244b;
                this.f245c = uVarD0.f245c;
                this.f246d = uVarD0.f246d;
                this.f247e = uVarD0.f247e;
                this.f248f = uVarD0.f248f;
                this.f249g = uVarD0.f249g;
                this.f250h = uVarD0.f250h;
                this.f251i = uVarD0.f251i;
                this.f252j = uVarD0.f252j;
                this.f253k = uVarD0.f253k;
                this.f254l = str2;
                return;
            } catch (JSONException e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        this.f243a = (y) com.google.android.gms.common.internal.s.k(yVar);
        this.f244b = (a0) com.google.android.gms.common.internal.s.k(a0Var);
        this.f245c = (byte[]) com.google.android.gms.common.internal.s.k(bArr);
        this.f246d = (List) com.google.android.gms.common.internal.s.k(list);
        this.f247e = d10;
        this.f248f = list2;
        this.f249g = kVar;
        this.f250h = num;
        this.f251i = e0Var;
        if (str != null) {
            try {
                this.f252j = c.a(str);
            } catch (c.a e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            this.f252j = null;
        }
        this.f253k = dVar;
        this.f254l = null;
    }

    public static u d0(JSONObject jSONObject) throws JSONException {
        zzbl zzblVarZzc;
        a aVar = new a();
        JSONObject jSONObject2 = jSONObject.getJSONObject("rp");
        Parcelable.Creator<y> creator = y.CREATOR;
        aVar.h(new y(jSONObject2.getString(DiagnosticsEntry.ID_KEY), jSONObject2.getString("name"), jSONObject2.has("icon") ? jSONObject2.optString("icon") : null));
        JSONObject jSONObject3 = jSONObject.getJSONObject(Constants.USER);
        Parcelable.Creator<a0> creator2 = a0.CREATOR;
        aVar.j(new a0(t5.c.b(jSONObject3.getString(DiagnosticsEntry.ID_KEY)), jSONObject3.getString("name"), jSONObject3.has("icon") ? jSONObject3.optString("icon") : null, jSONObject3.optString("displayName")));
        aVar.e(t5.c.b(jSONObject.getString("challenge")));
        JSONArray jSONArray = jSONObject.getJSONArray("pubKeyCredParams");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i10);
            try {
                zzblVarZzc = zzbl.zzd(new w(jSONObject4.getString("type"), jSONObject4.getInt("alg")));
            } catch (IllegalArgumentException unused) {
                zzblVarZzc = zzbl.zzc();
            }
            if (zzblVarZzc.zzb()) {
                arrayList.add(zzblVarZzc.zza());
            }
        }
        aVar.g(arrayList);
        if (jSONObject.has("timeout")) {
            aVar.i(Double.valueOf(jSONObject.getDouble("timeout") / 1000.0d));
        }
        if (jSONObject.has("excludeCredentials")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("excludeCredentials");
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                arrayList2.add(v.U(jSONArray2.getJSONObject(i11)));
            }
            aVar.f(arrayList2);
        }
        if (jSONObject.has("authenticatorSelection")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("authenticatorSelection");
            Parcelable.Creator<k> creator3 = k.CREATOR;
            aVar.d(new k(jSONObject5.has("authenticatorAttachment") ? jSONObject5.optString("authenticatorAttachment") : null, jSONObject5.has("requireResidentKey") ? Boolean.valueOf(jSONObject5.optBoolean("requireResidentKey")) : null, jSONObject5.has("userVerification") ? jSONObject5.optString("userVerification") : null, jSONObject5.has("residentKey") ? jSONObject5.optString("residentKey") : null));
        }
        if (jSONObject.has("extensions")) {
            aVar.c(d.T(jSONObject.getJSONObject("extensions")));
        }
        if (jSONObject.has("attestation")) {
            try {
                aVar.b(c.a(jSONObject.getString("attestation")));
            } catch (c.a e10) {
                Log.w("PKCCreationOptions", "Invalid AttestationConveyancePreference", e10);
                aVar.b(c.NONE);
            }
        }
        return aVar.a();
    }

    public String R() {
        c cVar = this.f252j;
        if (cVar == null) {
            return null;
        }
        return cVar.toString();
    }

    public d S() {
        return this.f253k;
    }

    public k T() {
        return this.f249g;
    }

    public byte[] U() {
        return this.f245c;
    }

    public List V() {
        return this.f248f;
    }

    public String W() {
        return this.f254l;
    }

    public List X() {
        return this.f246d;
    }

    public Integer Y() {
        return this.f250h;
    }

    public y Z() {
        return this.f243a;
    }

    public Double a0() {
        return this.f247e;
    }

    public e0 b0() {
        return this.f251i;
    }

    public a0 c0() {
        return this.f244b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return com.google.android.gms.common.internal.q.b(this.f243a, uVar.f243a) && com.google.android.gms.common.internal.q.b(this.f244b, uVar.f244b) && Arrays.equals(this.f245c, uVar.f245c) && com.google.android.gms.common.internal.q.b(this.f247e, uVar.f247e) && this.f246d.containsAll(uVar.f246d) && uVar.f246d.containsAll(this.f246d) && (((list = this.f248f) == null && uVar.f248f == null) || (list != null && (list2 = uVar.f248f) != null && list.containsAll(list2) && uVar.f248f.containsAll(this.f248f))) && com.google.android.gms.common.internal.q.b(this.f249g, uVar.f249g) && com.google.android.gms.common.internal.q.b(this.f250h, uVar.f250h) && com.google.android.gms.common.internal.q.b(this.f251i, uVar.f251i) && com.google.android.gms.common.internal.q.b(this.f252j, uVar.f252j) && com.google.android.gms.common.internal.q.b(this.f253k, uVar.f253k) && com.google.android.gms.common.internal.q.b(this.f254l, uVar.f254l);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f243a, this.f244b, Integer.valueOf(Arrays.hashCode(this.f245c)), this.f246d, this.f247e, this.f248f, this.f249g, this.f250h, this.f251i, this.f252j, this.f253k, this.f254l);
    }

    public final String toString() {
        d dVar = this.f253k;
        c cVar = this.f252j;
        e0 e0Var = this.f251i;
        k kVar = this.f249g;
        List list = this.f248f;
        List list2 = this.f246d;
        byte[] bArr = this.f245c;
        a0 a0Var = this.f244b;
        return "PublicKeyCredentialCreationOptions{\n rp=" + String.valueOf(this.f243a) + ", \n user=" + String.valueOf(a0Var) + ", \n challenge=" + t5.c.e(bArr) + ", \n parameters=" + String.valueOf(list2) + ", \n timeoutSeconds=" + this.f247e + ", \n excludeList=" + String.valueOf(list) + ", \n authenticatorSelection=" + String.valueOf(kVar) + ", \n requestId=" + this.f250h + ", \n tokenBinding=" + String.valueOf(e0Var) + ", \n attestationConveyancePreference=" + String.valueOf(cVar) + ", \n authenticationExtensions=" + String.valueOf(dVar) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 2, Z(), i10, false);
        n5.c.C(parcel, 3, c0(), i10, false);
        n5.c.k(parcel, 4, U(), false);
        n5.c.I(parcel, 5, X(), false);
        n5.c.o(parcel, 6, a0(), false);
        n5.c.I(parcel, 7, V(), false);
        n5.c.C(parcel, 8, T(), i10, false);
        n5.c.w(parcel, 9, Y(), false);
        n5.c.C(parcel, 10, b0(), i10, false);
        n5.c.E(parcel, 11, R(), false);
        n5.c.C(parcel, 12, S(), i10, false);
        n5.c.E(parcel, 13, W(), false);
        n5.c.C(parcel, 14, this.f255m, i10, false);
        n5.c.b(parcel, iA);
    }
}
