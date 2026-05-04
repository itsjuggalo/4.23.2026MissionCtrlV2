package x0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f24158e = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24159d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final v a(Bundle data) throws b1.b {
            kotlin.jvm.internal.t.f(data, "data");
            try {
                String string = data.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                kotlin.jvm.internal.t.c(string);
                return new v(string, data, null);
            } catch (Exception unused) {
                throw new b1.b();
            }
        }

        public a() {
        }
    }

    public /* synthetic */ v(String str, Bundle bundle, kotlin.jvm.internal.k kVar) {
        this(str, bundle);
    }

    public v(String str, Bundle bundle) {
        super("androidx.credentials.TYPE_DIGITAL_CREDENTIAL", bundle);
        this.f24159d = str;
        if (!b1.c.f2919a.a(str)) {
            throw new IllegalArgumentException("credentialJson must not be empty, and must be a valid JSON");
        }
    }
}
