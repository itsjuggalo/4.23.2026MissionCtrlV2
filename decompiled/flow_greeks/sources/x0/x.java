package x0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24171b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f24172a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final x a(Bundle bundle) {
            Bundle bundle2;
            kotlin.jvm.internal.t.f(bundle, "bundle");
            String string = bundle.getString("androidx.credentials.provider.extra.EXTRA_CREDENTIAL_TYPE");
            if (string == null || (bundle2 = bundle.getBundle("androidx.credentials.provider.extra.EXTRA_CREDENTIAL_DATA")) == null) {
                return null;
            }
            return new x(c.f24129c.b(string, bundle2));
        }

        public a() {
        }
    }

    public x(c credential) {
        kotlin.jvm.internal.t.f(credential, "credential");
        this.f24172a = credential;
    }

    public final c a() {
        return this.f24172a;
    }
}
