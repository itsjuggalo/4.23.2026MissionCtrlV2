package x0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f24132e = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24133d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final c0 a(Bundle data) throws y0.m {
            kotlin.jvm.internal.t.f(data, "data");
            String string = data.getString("androidx.credentials.BUNDLE_KEY_GET_RESTORE_CREDENTIAL_RESPONSE");
            if (string != null) {
                return new c0(string, data, null);
            }
            throw new y0.m("The device does not contain a restore credential.");
        }

        public a() {
        }
    }

    public /* synthetic */ c0(String str, Bundle bundle, kotlin.jvm.internal.k kVar) {
        this(str, bundle);
    }

    public c0(String str, Bundle bundle) {
        super("androidx.credentials.TYPE_RESTORE_CREDENTIAL", bundle);
        this.f24133d = str;
        if (!b1.c.f2919a.a(str)) {
            throw new IllegalArgumentException("authenticationResponseJson must not be empty, and must be a valid JSON");
        }
    }
}
