package a1;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0000a f7g = new C0000a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z0.e f8f;

    /* JADX INFO: renamed from: a1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0000a {
        public /* synthetic */ C0000a(k kVar) {
            this();
        }

        public C0000a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(z0.e domError, CharSequence charSequence) {
        super("androidx.credentials.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + domError.a(), charSequence);
        t.f(domError, "domError");
        this.f8f = domError;
    }
}
