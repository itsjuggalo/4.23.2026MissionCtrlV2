package i1;

import android.content.Intent;
import android.credentials.Credential;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialResponse;
import android.os.Build;
import android.os.Bundle;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import x0.c;
import x0.x;
import y0.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11525a = new c(null);

    /* JADX INFO: renamed from: i1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0216a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0217a f11526a = new C0217a(null);

        /* JADX INFO: renamed from: i1.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0217a {
            public /* synthetic */ C0217a(k kVar) {
                this();
            }

            public final h a(Intent intent) {
                t.f(intent, "intent");
                h.a aVar = h.f25156c;
                Bundle bundleExtra = intent.getBundleExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION");
                if (bundleExtra == null) {
                    return null;
                }
                return aVar.a(bundleExtra);
            }

            public final x b(Intent intent) {
                t.f(intent, "intent");
                x.a aVar = x.f24171b;
                Bundle bundleExtra = intent.getBundleExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE");
                if (bundleExtra == null) {
                    return null;
                }
                return aVar.a(bundleExtra);
            }

            public C0217a() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0218a f11527a = new C0218a(null);

        /* JADX INFO: renamed from: i1.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0218a {
            public /* synthetic */ C0218a(k kVar) {
                this();
            }

            public final h a(Intent intent) {
                t.f(intent, "intent");
                GetCredentialException getCredentialException = (GetCredentialException) intent.getSerializableExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", GetCredentialException.class);
                if (getCredentialException == null) {
                    return null;
                }
                String type = getCredentialException.getType();
                t.e(type, "ex.type");
                return b1.a.a(type, getCredentialException.getMessage());
            }

            public final x b(Intent intent) {
                t.f(intent, "intent");
                GetCredentialResponse getCredentialResponse = (GetCredentialResponse) intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", GetCredentialResponse.class);
                if (getCredentialResponse == null) {
                    return null;
                }
                c.a aVar = x0.c.f24129c;
                Credential credential = getCredentialResponse.getCredential();
                t.e(credential, "response.credential");
                return new x(aVar.a(credential));
            }

            public C0218a() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {
        public /* synthetic */ c(k kVar) {
            this();
        }

        public final h a(Intent intent) {
            t.f(intent, "intent");
            return Build.VERSION.SDK_INT >= 34 ? b.f11527a.a(intent) : C0216a.f11526a.a(intent);
        }

        public final x b(Intent intent) {
            t.f(intent, "intent");
            return Build.VERSION.SDK_INT >= 34 ? b.f11527a.b(intent) : C0216a.f11526a.b(intent);
        }

        public c() {
        }
    }
}
