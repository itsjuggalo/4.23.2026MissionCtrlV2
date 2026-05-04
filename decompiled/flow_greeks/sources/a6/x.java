package a6;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.internal.fido.zzia;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x extends c0 {
    public static final Parcelable.Creator<x> CREATOR = new a1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e0 f282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g0 f283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ResultReceiver f286j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f291e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e0 f292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public g0 f293g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public d f294h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Long f295i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ResultReceiver f296j;

        public x a() {
            byte[] bArr = this.f287a;
            Double d10 = this.f288b;
            String str = this.f289c;
            List list = this.f290d;
            Integer num = this.f291e;
            e0 e0Var = this.f292f;
            g0 g0Var = this.f293g;
            return new x(bArr, d10, str, list, num, e0Var, g0Var == null ? null : g0Var.toString(), this.f294h, this.f295i, null, this.f296j);
        }

        public a b(List list) {
            this.f290d = list;
            return this;
        }

        public a c(d dVar) {
            this.f294h = dVar;
            return this;
        }

        public a d(byte[] bArr) {
            this.f287a = (byte[]) com.google.android.gms.common.internal.s.k(bArr);
            return this;
        }

        public a e(Integer num) {
            this.f291e = num;
            return this;
        }

        public a f(String str) {
            this.f289c = (String) com.google.android.gms.common.internal.s.k(str);
            return this;
        }

        public a g(Double d10) {
            this.f288b = d10;
            return this;
        }

        public a h(e0 e0Var) {
            this.f292f = e0Var;
            return this;
        }

        public final a i(Long l10) {
            this.f295i = l10;
            return this;
        }

        public final a j(g0 g0Var) {
            this.f293g = g0Var;
            return this;
        }
    }

    public x(byte[] bArr, Double d10, String str, List list, Integer num, e0 e0Var, String str2, d dVar, Long l10, String str3, ResultReceiver resultReceiver) {
        this.f286j = resultReceiver;
        if (str3 == null || !zzia.zzc()) {
            this.f277a = (byte[]) com.google.android.gms.common.internal.s.k(bArr);
            this.f278b = d10;
            this.f279c = (String) com.google.android.gms.common.internal.s.k(str);
            this.f280d = list;
            this.f281e = num;
            this.f282f = e0Var;
            this.f285i = l10;
            if (str2 != null) {
                try {
                    this.f283g = g0.a(str2);
                } catch (m1 e10) {
                    throw new IllegalArgumentException(e10);
                }
            } else {
                this.f283g = null;
            }
            this.f284h = dVar;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            a aVar = new a();
            aVar.d(t5.c.b(jSONObject.getString("challenge")));
            if (jSONObject.has("timeout")) {
                aVar.g(Double.valueOf(jSONObject.getDouble("timeout") / 1000.0d));
            } else if (jSONObject.has("timeoutSeconds")) {
                aVar.g(Double.valueOf(jSONObject.getDouble("timeoutSeconds")));
            }
            aVar.f(jSONObject.getString("rpId"));
            JSONArray jSONArray = jSONObject.has("allowList") ? jSONObject.getJSONArray("allowList") : jSONObject.has("allowCredentials") ? jSONObject.getJSONArray("allowCredentials") : null;
            if (jSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    arrayList.add(v.U(jSONArray.getJSONObject(i10)));
                }
                aVar.b(arrayList);
            }
            if (jSONObject.has(com.amazon.a.a.o.b.B)) {
                aVar.e(Integer.valueOf(jSONObject.getInt(com.amazon.a.a.o.b.B)));
            }
            if (jSONObject.has("tokenBinding")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("tokenBinding");
                aVar.h(new e0(jSONObject2.getString("status"), jSONObject2.has(DiagnosticsEntry.ID_KEY) ? jSONObject2.getString(DiagnosticsEntry.ID_KEY) : null));
            }
            if (jSONObject.has("userVerification")) {
                aVar.j(g0.a(jSONObject.getString("userVerification")));
            }
            if (jSONObject.has("authenticationExtensions")) {
                aVar.c(d.T(jSONObject.getJSONObject("authenticationExtensions")));
            } else if (jSONObject.has("extensions")) {
                aVar.c(d.T(jSONObject.getJSONObject("extensions")));
            }
            if (jSONObject.has("longRequestId")) {
                aVar.i(Long.valueOf(jSONObject.getLong("longRequestId")));
            }
            x xVarA = aVar.a();
            this.f277a = xVarA.f277a;
            this.f278b = xVarA.f278b;
            this.f279c = xVarA.f279c;
            this.f280d = xVarA.f280d;
            this.f281e = xVarA.f281e;
            this.f282f = xVarA.f282f;
            this.f283g = xVarA.f283g;
            this.f284h = xVarA.f284h;
            this.f285i = xVarA.f285i;
        } catch (m1 e11) {
            e = e11;
            throw new IllegalArgumentException(e);
        } catch (JSONException e12) {
            e = e12;
            throw new IllegalArgumentException(e);
        }
    }

    public List R() {
        return this.f280d;
    }

    public d S() {
        return this.f284h;
    }

    public byte[] T() {
        return this.f277a;
    }

    public Integer U() {
        return this.f281e;
    }

    public String V() {
        return this.f279c;
    }

    public Double W() {
        return this.f278b;
    }

    public e0 X() {
        return this.f282f;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Arrays.equals(this.f277a, xVar.f277a) && com.google.android.gms.common.internal.q.b(this.f278b, xVar.f278b) && com.google.android.gms.common.internal.q.b(this.f279c, xVar.f279c) && (((list = this.f280d) == null && xVar.f280d == null) || (list != null && (list2 = xVar.f280d) != null && list.containsAll(list2) && xVar.f280d.containsAll(this.f280d))) && com.google.android.gms.common.internal.q.b(this.f281e, xVar.f281e) && com.google.android.gms.common.internal.q.b(this.f282f, xVar.f282f) && com.google.android.gms.common.internal.q.b(this.f283g, xVar.f283g) && com.google.android.gms.common.internal.q.b(this.f284h, xVar.f284h) && com.google.android.gms.common.internal.q.b(this.f285i, xVar.f285i);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(Arrays.hashCode(this.f277a)), this.f278b, this.f279c, this.f280d, this.f281e, this.f282f, this.f283g, this.f284h, this.f285i);
    }

    public final String toString() {
        d dVar = this.f284h;
        g0 g0Var = this.f283g;
        e0 e0Var = this.f282f;
        List list = this.f280d;
        return "PublicKeyCredentialRequestOptions{\n challenge=" + t5.c.e(this.f277a) + ", \n timeoutSeconds=" + this.f278b + ", \n rpId='" + this.f279c + "', \n allowList=" + String.valueOf(list) + ", \n requestId=" + this.f281e + ", \n tokenBinding=" + String.valueOf(e0Var) + ", \n userVerification=" + String.valueOf(g0Var) + ", \n authenticationExtensions=" + String.valueOf(dVar) + ", \n longRequestId=" + this.f285i + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.k(parcel, 2, T(), false);
        n5.c.o(parcel, 3, W(), false);
        n5.c.E(parcel, 4, V(), false);
        n5.c.I(parcel, 5, R(), false);
        n5.c.w(parcel, 6, U(), false);
        n5.c.C(parcel, 7, X(), i10, false);
        g0 g0Var = this.f283g;
        n5.c.E(parcel, 8, g0Var == null ? null : g0Var.toString(), false);
        n5.c.C(parcel, 9, S(), i10, false);
        n5.c.z(parcel, 10, this.f285i, false);
        n5.c.E(parcel, 11, null, false);
        n5.c.C(parcel, 12, this.f286j, i10, false);
        n5.c.b(parcel, iA);
    }
}
