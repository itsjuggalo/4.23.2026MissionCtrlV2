package a6;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends n5.a {
    public static final Parcelable.Creator<d> CREATOR = new q1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f2 f113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l2 f115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l0 f116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0 f117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h2 f118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q0 f119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s f120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u0 f121j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f1 f122k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s0 f123l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r f124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f0 f125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f2 f126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l2 f127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l0 f128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public n0 f129f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public h2 f130g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public q0 f131h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public s f132i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public u0 f133j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public f1 f134k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public s0 f135l;

        public d a() {
            return new d(this.f124a, this.f126c, this.f125b, this.f127d, this.f128e, this.f129f, this.f130g, this.f131h, this.f132i, this.f133j, this.f134k, this.f135l);
        }

        public a b(r rVar) {
            this.f124a = rVar;
            return this;
        }

        public a c(s sVar) {
            this.f132i = sVar;
            return this;
        }

        public a d(f0 f0Var) {
            this.f125b = f0Var;
            return this;
        }

        public final a e(f2 f2Var) {
            this.f126c = f2Var;
            return this;
        }

        public final a f(h2 h2Var) {
            this.f130g = h2Var;
            return this;
        }

        public final a g(l2 l2Var) {
            this.f127d = l2Var;
            return this;
        }

        public final a h(l0 l0Var) {
            this.f128e = l0Var;
            return this;
        }

        public final a i(n0 n0Var) {
            this.f129f = n0Var;
            return this;
        }

        public final a j(q0 q0Var) {
            this.f131h = q0Var;
            return this;
        }

        public final a k(u0 u0Var) {
            this.f133j = u0Var;
            return this;
        }

        public final a l(f1 f1Var) {
            this.f134k = f1Var;
            return this;
        }
    }

    public d(r rVar, f2 f2Var, f0 f0Var, l2 l2Var, l0 l0Var, n0 n0Var, h2 h2Var, q0 q0Var, s sVar, u0 u0Var, f1 f1Var, s0 s0Var) {
        this.f112a = rVar;
        this.f114c = f0Var;
        this.f113b = f2Var;
        this.f115d = l2Var;
        this.f116e = l0Var;
        this.f117f = n0Var;
        this.f118g = h2Var;
        this.f119h = q0Var;
        this.f120i = sVar;
        this.f121j = u0Var;
        this.f122k = f1Var;
        this.f123l = s0Var;
    }

    public static d T(JSONObject jSONObject) throws JSONException {
        a aVar = new a();
        if (jSONObject.has("fidoAppIdExtension")) {
            aVar.b(new r(jSONObject.getJSONObject("fidoAppIdExtension").getString("appid")));
        }
        if (jSONObject.has("appid")) {
            aVar.b(new r(jSONObject.getString("appid")));
        }
        if (jSONObject.has("prf")) {
            if (jSONObject.has("prfAlreadyHashed")) {
                throw new JSONException("both prf and prfAlreadyHashed extensions found");
            }
            aVar.k(u0.R(jSONObject.getJSONObject("prf"), false));
        } else if (jSONObject.has("prfAlreadyHashed")) {
            aVar.k(u0.R(jSONObject.getJSONObject("prfAlreadyHashed"), true));
        }
        if (jSONObject.has("cableAuthenticationExtension")) {
            JSONArray jSONArray = jSONObject.getJSONArray("cableAuthenticationExtension");
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                arrayList.add(new d2(jSONObject2.getLong(DiagnosticsEntry.VERSION_KEY), Base64.decode(jSONObject2.getString("clientEid"), 11), Base64.decode(jSONObject2.getString("authenticatorEid"), 11), Base64.decode(jSONObject2.getString("sessionPreKey"), 11)));
            }
            aVar.e(new f2(arrayList));
        }
        if (jSONObject.has("userVerificationMethodExtension")) {
            aVar.d(new f0(jSONObject.getJSONObject("userVerificationMethodExtension").getBoolean("uvm")));
        }
        if (jSONObject.has("google_multiAssertionExtension")) {
            aVar.g(new l2(jSONObject.getJSONObject("google_multiAssertionExtension").getBoolean("requestForMultiAssertion")));
        }
        if (jSONObject.has("google_sessionIdExtension")) {
            aVar.h(new l0(jSONObject.getJSONObject("google_sessionIdExtension").getInt("sessionId")));
        }
        if (jSONObject.has("google_silentVerificationExtension")) {
            aVar.i(new n0(jSONObject.getJSONObject("google_silentVerificationExtension").getBoolean("silentVerification")));
        }
        if (jSONObject.has("devicePublicKeyExtension")) {
            aVar.f(new h2(jSONObject.getJSONObject("devicePublicKeyExtension").getBoolean("devicePublicKey")));
        }
        if (jSONObject.has("google_tunnelServerIdExtension")) {
            aVar.j(new q0(jSONObject.getJSONObject("google_tunnelServerIdExtension").getString("tunnelServerId")));
        }
        if (jSONObject.has("google_thirdPartyPaymentExtension")) {
            aVar.c(new s(jSONObject.getJSONObject("google_thirdPartyPaymentExtension").getBoolean("thirdPartyPayment")));
        }
        if (jSONObject.has("txAuthSimple")) {
            aVar.l(new f1(jSONObject.getString("txAuthSimple")));
        }
        return aVar.a();
    }

    public r R() {
        return this.f112a;
    }

    public f0 S() {
        return this.f114c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return com.google.android.gms.common.internal.q.b(this.f112a, dVar.f112a) && com.google.android.gms.common.internal.q.b(this.f113b, dVar.f113b) && com.google.android.gms.common.internal.q.b(this.f114c, dVar.f114c) && com.google.android.gms.common.internal.q.b(this.f115d, dVar.f115d) && com.google.android.gms.common.internal.q.b(this.f116e, dVar.f116e) && com.google.android.gms.common.internal.q.b(this.f117f, dVar.f117f) && com.google.android.gms.common.internal.q.b(this.f118g, dVar.f118g) && com.google.android.gms.common.internal.q.b(this.f119h, dVar.f119h) && com.google.android.gms.common.internal.q.b(this.f120i, dVar.f120i) && com.google.android.gms.common.internal.q.b(this.f121j, dVar.f121j) && com.google.android.gms.common.internal.q.b(this.f122k, dVar.f122k) && com.google.android.gms.common.internal.q.b(this.f123l, dVar.f123l);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f112a, this.f113b, this.f114c, this.f115d, this.f116e, this.f117f, this.f118g, this.f119h, this.f120i, this.f121j, this.f122k, this.f123l);
    }

    public final String toString() {
        f1 f1Var = this.f122k;
        u0 u0Var = this.f121j;
        s sVar = this.f120i;
        q0 q0Var = this.f119h;
        h2 h2Var = this.f118g;
        n0 n0Var = this.f117f;
        l0 l0Var = this.f116e;
        l2 l2Var = this.f115d;
        f0 f0Var = this.f114c;
        f2 f2Var = this.f113b;
        return "AuthenticationExtensions{\n fidoAppIdExtension=" + String.valueOf(this.f112a) + ", \n cableAuthenticationExtension=" + String.valueOf(f2Var) + ", \n userVerificationMethodExtension=" + String.valueOf(f0Var) + ", \n googleMultiAssertionExtension=" + String.valueOf(l2Var) + ", \n googleSessionIdExtension=" + String.valueOf(l0Var) + ", \n googleSilentVerificationExtension=" + String.valueOf(n0Var) + ", \n devicePublicKeyExtension=" + String.valueOf(h2Var) + ", \n googleTunnelServerIdExtension=" + String.valueOf(q0Var) + ", \n googleThirdPartyPaymentExtension=" + String.valueOf(sVar) + ", \n prfExtension=" + String.valueOf(u0Var) + ", \n simpleTransactionAuthorizationExtension=" + String.valueOf(f1Var) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 2, R(), i10, false);
        n5.c.C(parcel, 3, this.f113b, i10, false);
        n5.c.C(parcel, 4, S(), i10, false);
        n5.c.C(parcel, 5, this.f115d, i10, false);
        n5.c.C(parcel, 6, this.f116e, i10, false);
        n5.c.C(parcel, 7, this.f117f, i10, false);
        n5.c.C(parcel, 8, this.f118g, i10, false);
        n5.c.C(parcel, 9, this.f119h, i10, false);
        n5.c.C(parcel, 10, this.f120i, i10, false);
        n5.c.C(parcel, 11, this.f121j, i10, false);
        n5.c.C(parcel, 12, this.f122k, i10, false);
        n5.c.C(parcel, 13, this.f123l, i10, false);
        n5.c.b(parcel, iA);
    }
}
