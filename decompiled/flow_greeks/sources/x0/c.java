package x0;

import android.credentials.Credential;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f24129c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f24131b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final c a(Credential credential) {
            kotlin.jvm.internal.t.f(credential, "credential");
            String type = credential.getType();
            kotlin.jvm.internal.t.e(type, "credential.type");
            Bundle data = credential.getData();
            kotlin.jvm.internal.t.e(data, "credential.data");
            return b(type, data);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final c b(String type, Bundle data) {
            kotlin.jvm.internal.t.f(type, "type");
            kotlin.jvm.internal.t.f(data, "data");
            try {
                switch (type.hashCode()) {
                    case -1678407252:
                        if (type.equals("androidx.credentials.TYPE_DIGITAL_CREDENTIAL")) {
                            return v.f24158e.a(data);
                        }
                        break;
                    case -1072734346:
                        if (type.equals("androidx.credentials.TYPE_RESTORE_CREDENTIAL")) {
                            return c0.f24132e.a(data);
                        }
                        break;
                    case -543568185:
                        if (type.equals("android.credentials.TYPE_PASSWORD_CREDENTIAL")) {
                            return z.f24173f.a(data);
                        }
                        break;
                    case -95037569:
                        if (type.equals("androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL")) {
                            return b0.f24127e.a(data);
                        }
                        break;
                }
                throw new b1.b();
            } catch (b1.b unused) {
                return new u(type, data);
            }
        }

        public a() {
        }
    }

    public c(String type, Bundle data) {
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(data, "data");
        this.f24130a = type;
        this.f24131b = data;
    }

    public final Bundle a() {
        return this.f24131b;
    }

    public final String b() {
        return this.f24130a;
    }
}
