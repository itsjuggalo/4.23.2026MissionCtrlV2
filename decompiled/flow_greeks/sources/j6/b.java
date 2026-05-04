package j6;

import android.os.Bundle;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import x0.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends y {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0243b f13922l = new C0243b(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f13923i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f13924j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f13925k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13928c;

        public a(String serverClientId) {
            t.f(serverClientId, "serverClientId");
            this.f13926a = serverClientId;
        }

        public final b a() {
            return new b(this.f13926a, this.f13927b, this.f13928c);
        }

        public final a b(String hostedDomainFilter) {
            t.f(hostedDomainFilter, "hostedDomainFilter");
            this.f13927b = hostedDomainFilter;
            return this;
        }

        public final a c(String str) {
            this.f13928c = str;
            return this;
        }
    }

    /* JADX INFO: renamed from: j6.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0243b {
        public /* synthetic */ C0243b(k kVar) {
        }

        public static final Bundle a(String serverClientId, String str, String str2, boolean z10) {
            t.f(serverClientId, "serverClientId");
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_SERVER_CLIENT_ID", serverClientId);
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_NONCE", str2);
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_HOSTED_DOMAIN_FILTER", str);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_AUTO_SELECT_ENABLED", true);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_GOOGLE_ID_TOKEN_SUBTYPE", "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_SIWG_CREDENTIAL");
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String serverClientId, String str, String str2) {
        super("com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL", C0243b.a(serverClientId, str, str2, true), C0243b.a(serverClientId, str, str2, true), true, true, null, 32, null);
        t.f(serverClientId, "serverClientId");
        this.f13923i = serverClientId;
        this.f13924j = str;
        this.f13925k = str2;
        if (serverClientId.length() <= 0) {
            throw new IllegalArgumentException("serverClientId should not be empty");
        }
    }

    public final String f() {
        return this.f13924j;
    }

    public final String g() {
        return this.f13925k;
    }

    public final String h() {
        return this.f13923i;
    }
}
