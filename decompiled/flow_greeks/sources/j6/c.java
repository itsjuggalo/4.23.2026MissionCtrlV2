package j6;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import x0.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f13929k = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f13933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Uri f13935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f13936j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13937a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13938b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f13940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f13941e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Uri f13942f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f13943g;

        public final c a() {
            return new c(this.f13937a, this.f13938b, this.f13939c, this.f13940d, this.f13941e, this.f13942f, this.f13943g);
        }

        public final a b(String str) {
            this.f13939c = str;
            return this;
        }

        public final a c(String str) {
            this.f13940d = str;
            return this;
        }

        public final a d(String str) {
            this.f13941e = str;
            return this;
        }

        public final a e(String id2) {
            t.f(id2, "id");
            this.f13937a = id2;
            return this;
        }

        public final a f(String idToken) {
            t.f(idToken, "idToken");
            this.f13938b = idToken;
            return this;
        }

        public final a g(String str) {
            this.f13943g = str;
            return this;
        }

        public final a h(Uri uri) {
            this.f13942f = uri;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(k kVar) {
        }

        public final c a(Bundle data) throws d {
            t.f(data, "data");
            try {
                String string = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID");
                String string2 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN");
                String string3 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_DISPLAY_NAME");
                String string4 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FAMILY_NAME");
                String string5 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_GIVEN_NAME");
                Uri uri = Build.VERSION.SDK_INT >= 33 ? (Uri) data.getParcelable("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI", Uri.class) : (Uri) data.getParcelable("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI");
                String string6 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PHONE_NUMBER");
                t.c(string);
                t.c(string2);
                return new c(string, string2, string3, string4, string5, uri, string6);
            } catch (Exception e10) {
                throw new d(e10);
            }
        }
    }

    public c(String id2, String idToken, String str, String str2, String str3, Uri uri, String str4) {
        t.f(id2, "id");
        t.f(idToken, "idToken");
        t.f(id2, "id");
        t.f(idToken, "idToken");
        Bundle bundle = new Bundle();
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID", id2);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN", idToken);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_DISPLAY_NAME", str);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FAMILY_NAME", str2);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_GIVEN_NAME", str3);
        bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PHONE_NUMBER", str4);
        bundle.putParcelable("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI", uri);
        super("com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL", bundle);
        this.f13930d = id2;
        this.f13931e = idToken;
        this.f13932f = str;
        this.f13933g = str2;
        this.f13934h = str3;
        this.f13935i = uri;
        this.f13936j = str4;
        if (id2.length() <= 0) {
            throw new IllegalArgumentException("id should not be empty");
        }
        if (idToken.length() <= 0) {
            throw new IllegalArgumentException("idToken should not be empty");
        }
    }

    public static final c c(Bundle bundle) {
        return f13929k.a(bundle);
    }

    public final String d() {
        return this.f13932f;
    }

    public final String e() {
        return this.f13933g;
    }

    public final String f() {
        return this.f13934h;
    }

    public final String g() {
        return this.f13930d;
    }

    public final String h() {
        return this.f13931e;
    }

    public final Uri i() {
        return this.f13935i;
    }
}
