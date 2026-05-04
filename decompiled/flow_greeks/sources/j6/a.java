package j6;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import x0.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends y {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f13907p = new b(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f13908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f13909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f13910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f13911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f13912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f13913n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f13914o;

    /* JADX INFO: renamed from: j6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0242a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13917c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f13919e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f13920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f13921g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13915a = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13918d = true;

        public final a a() {
            return new a(this.f13915a, this.f13917c, this.f13918d, this.f13916b, this.f13921g, this.f13919e, this.f13920f);
        }

        public final C0242a b(boolean z10) {
            this.f13920f = z10;
            return this;
        }

        public final C0242a c(boolean z10) {
            this.f13918d = z10;
            return this;
        }

        public final C0242a d(String str) {
            this.f13917c = str;
            return this;
        }

        public final C0242a e(String serverClientId) {
            t.f(serverClientId, "serverClientId");
            if (serverClientId.length() <= 0) {
                throw new IllegalArgumentException("serverClientId should not be empty");
            }
            this.f13915a = serverClientId;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(k kVar) {
        }

        public static final Bundle a(String serverClientId, String str, boolean z10, String str2, List list, boolean z11, boolean z12) {
            t.f(serverClientId, "serverClientId");
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_SERVER_CLIENT_ID", serverClientId);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_NONCE", str);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS", z10);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_LINKED_SERVICE_ID", str2);
            bundle.putStringArrayList("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES", list == null ? null : new ArrayList<>(list));
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER", z11);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_AUTO_SELECT_ENABLED", z12);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String serverClientId, String str, boolean z10, String str2, List list, boolean z11, boolean z12) {
        super("com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL", b.a(serverClientId, str, z10, str2, list, z11, z12), b.a(serverClientId, str, z10, str2, list, z11, z12), true, z12, (Set) null, 500, 32, (k) null);
        t.f(serverClientId, "serverClientId");
        this.f13908i = serverClientId;
        this.f13909j = str;
        this.f13910k = z10;
        this.f13911l = str2;
        this.f13912m = list;
        this.f13913n = z11;
        this.f13914o = z12;
        if (serverClientId.length() <= 0) {
            throw new IllegalArgumentException("serverClientId should not be empty");
        }
        if (z10 && z11) {
            throw new IllegalArgumentException("filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true;  the Verified Phone Number feature only works in sign-ups.");
        }
    }

    public final boolean f() {
        return this.f13914o;
    }

    public final boolean g() {
        return this.f13910k;
    }

    public final List h() {
        return this.f13912m;
    }

    public final String i() {
        return this.f13911l;
    }

    public final String j() {
        return this.f13909j;
    }

    public final boolean k() {
        return this.f13913n;
    }

    public final String l() {
        return this.f13908i;
    }
}
