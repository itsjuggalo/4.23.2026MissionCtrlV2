package x0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f24127e = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24128d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final b0 a(Bundle data) throws b1.b {
            kotlin.jvm.internal.t.f(data, "data");
            try {
                String string = data.getString("androidx.credentials.BUNDLE_KEY_AUTHENTICATION_RESPONSE_JSON");
                kotlin.jvm.internal.t.c(string);
                return new b0(string, data, null);
            } catch (Exception unused) {
                throw new b1.b();
            }
        }

        public final Bundle b(String authenticationResponseJson) {
            kotlin.jvm.internal.t.f(authenticationResponseJson, "authenticationResponseJson");
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_AUTHENTICATION_RESPONSE_JSON", authenticationResponseJson);
            return bundle;
        }

        public a() {
        }
    }

    public /* synthetic */ b0(String str, Bundle bundle, kotlin.jvm.internal.k kVar) {
        this(str, bundle);
    }

    public b0(String str, Bundle bundle) {
        super("androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL", bundle);
        this.f24128d = str;
        if (!b1.c.f2919a.a(str)) {
            throw new IllegalArgumentException("authenticationResponseJson must not be empty, and must be a valid JSON");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(String authenticationResponseJson) {
        this(authenticationResponseJson, f24127e.b(authenticationResponseJson));
        kotlin.jvm.internal.t.f(authenticationResponseJson, "authenticationResponseJson");
    }
}
