package f1;

import a6.g;
import a6.i;
import a6.j;
import a6.q;
import android.util.Log;
import cd.w;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import dd.o0;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.LinkedHashMap;
import kg.c0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.json.JSONObject;
import y0.h;
import z0.b;
import z0.b0;
import z0.d;
import z0.e;
import z0.f;
import z0.l;
import z0.n;
import z0.p;
import z0.r;
import z0.s;
import z0.x;
import z0.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0171a f9275a = new C0171a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9276b = "clientDataJSON";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9277c = "attestationObject";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9278d = "authenticatorData";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9279e = "signature";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9280f = "userHandle";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9281g = "response";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9282h = DiagnosticsEntry.ID_KEY;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9283i = "rawId";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9284j = "type";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9285k = "rpId";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9286l = "challenge";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9287m = "appid";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9288n = "thirdPartyPayment";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9289o = "authenticatorSelection";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f9290p = "requireResidentKey";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9291q = "residentKey";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f9292r = "authenticatorAttachment";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f9293s = "timeout";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f9294t = "excludeCredentials";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f9295u = "transports";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f9296v = "rp";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f9297w = "name";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f9298x = "icon";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f9299y = "alg";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f9300z = Constants.USER;
    public static final String A = "displayName";
    public static final String B = "userVerificationMethod";
    public static final String C = "keyProtectionType";
    public static final String D = "matcherProtectionType";
    public static final String E = "extensions";
    public static final String F = "attestation";
    public static final String G = "pubKeyCredParams";
    public static final String H = "clientExtensionResults";
    public static final String I = "rk";
    public static final String J = "credProps";
    public static final LinkedHashMap K = o0.k(w.a(q.UNKNOWN_ERR, new b0()), w.a(q.ABORT_ERR, new z0.a()), w.a(q.ATTESTATION_NOT_PRIVATE_ERR, new r()), w.a(q.CONSTRAINT_ERR, new b()), w.a(q.DATA_ERR, new d()), w.a(q.INVALID_STATE_ERR, new l()), w.a(q.ENCODING_ERR, new f()), w.a(q.NETWORK_ERR, new n()), w.a(q.NOT_ALLOWED_ERR, new p()), w.a(q.NOT_SUPPORTED_ERR, new s()), w.a(q.SECURITY_ERR, new x()), w.a(q.TIMEOUT_ERR, new z()));

    /* JADX INFO: renamed from: f1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0171a {
        public /* synthetic */ C0171a(k kVar) {
            this();
        }

        public final h a(q code, String str) {
            t.f(code, "code");
            e eVar = (e) b().get(code);
            if (eVar != null) {
                return (code == q.NOT_ALLOWED_ERR && str != null && c0.P(str, "Unable to get sync account", false, 2, null)) ? new y0.f("Passkey retrieval was cancelled by the user.") : new a1.d(eVar, str);
            }
            return new a1.d(new b0(), "unknown fido gms exception - " + str);
        }

        public final LinkedHashMap b() {
            return a.K;
        }

        public final String c(c5.n cred) throws h {
            t.f(cred, "cred");
            JSONObject jSONObject = new JSONObject();
            a6.t tVarX = cred.X();
            j jVarV = tVarX != null ? tVarX.V() : null;
            t.c(jVarV);
            if (jVarV instanceof i) {
                i iVar = (i) jVarV;
                q qVarR = iVar.R();
                t.e(qVarR, "getErrorCode(...)");
                throw a(qVarR, iVar.T());
            }
            if (!(jVarV instanceof g)) {
                Log.e("PublicKeyUtility", "AuthenticatorResponse expected assertion response but got: " + jVarV.getClass().getName());
                String string = jSONObject.toString();
                t.e(string, "toString(...)");
                return string;
            }
            try {
                String strX = tVarX.X();
                t.e(strX, "toJson(...)");
                return strX;
            } catch (Throwable th) {
                throw new y0.k("The PublicKeyCredential response json had an unexpected exception when parsing: " + th.getMessage());
            }
        }

        public C0171a() {
        }
    }
}
