package x0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f24173f = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24175e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final z a(Bundle data) throws b1.b {
            kotlin.jvm.internal.t.f(data, "data");
            try {
                String string = data.getString("androidx.credentials.BUNDLE_KEY_ID");
                String string2 = data.getString("androidx.credentials.BUNDLE_KEY_PASSWORD");
                kotlin.jvm.internal.t.c(string);
                kotlin.jvm.internal.t.c(string2);
                return new z(string, string2, data, null);
            } catch (Exception unused) {
                throw new b1.b();
            }
        }

        public final Bundle b(String id2, String password) {
            kotlin.jvm.internal.t.f(id2, "id");
            kotlin.jvm.internal.t.f(password, "password");
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_ID", id2);
            bundle.putString("androidx.credentials.BUNDLE_KEY_PASSWORD", password);
            return bundle;
        }

        public a() {
        }
    }

    public /* synthetic */ z(String str, String str2, Bundle bundle, kotlin.jvm.internal.k kVar) {
        this(str, str2, bundle);
    }

    public z(String str, String str2, Bundle bundle) {
        super("android.credentials.TYPE_PASSWORD_CREDENTIAL", bundle);
        this.f24174d = str;
        this.f24175e = str2;
        if (str2.length() <= 0) {
            throw new IllegalArgumentException("password should not be empty");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z(String id2, String password) {
        this(id2, password, f24173f.b(id2, password));
        kotlin.jvm.internal.t.f(id2, "id");
        kotlin.jvm.internal.t.f(password, "password");
    }
}
