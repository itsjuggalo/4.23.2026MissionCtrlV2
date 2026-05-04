package x0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0421a f24124c = new C0421a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f24126b;

    /* JADX INFO: renamed from: x0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0421a {
        public /* synthetic */ C0421a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public C0421a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Bundle a() {
        return this.f24126b;
    }

    public final String b() {
        return this.f24125a;
    }

    public a(String requestType) {
        kotlin.jvm.internal.t.f(requestType, "requestType");
        this.f24125a = requestType;
        Bundle bundle = new Bundle();
        this.f24126b = bundle;
        if (kotlin.jvm.internal.t.b(requestType, "androidx.credentials.TYPE_CLEAR_CREDENTIAL_STATE") || kotlin.jvm.internal.t.b(requestType, "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL")) {
            if (kotlin.jvm.internal.t.b(requestType, "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL")) {
                bundle.putBoolean("androidx.credentials.BUNDLE_KEY_CLEAR_RESTORE_CREDENTIAL_REQUEST", true);
            }
        } else {
            throw new IllegalArgumentException("The request type " + requestType + " is not supported.");
        }
    }

    public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? "androidx.credentials.TYPE_CLEAR_CREDENTIAL_STATE" : str);
    }
}
