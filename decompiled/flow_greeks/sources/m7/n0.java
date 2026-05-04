package m7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.p002firebaseauthapi.zzafc;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.GenericIdpActivity;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n0 extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f16039a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FirebaseAuth f16040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f16041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f16042c;

        public a a(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                this.f16042c.putString((String) entry.getKey(), (String) entry.getValue());
            }
            return this;
        }

        public n0 b() {
            return new n0(this.f16041b);
        }

        public a c(List list) {
            this.f16041b.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList<>(list));
            return this;
        }

        public a(String str, FirebaseAuth firebaseAuth) {
            Bundle bundle = new Bundle();
            this.f16041b = bundle;
            Bundle bundle2 = new Bundle();
            this.f16042c = bundle2;
            this.f16040a = firebaseAuth;
            bundle.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.l().r().b());
            bundle.putString("com.google.firebase.auth.KEY_PROVIDER_ID", str);
            bundle.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle2);
            bundle.putString("com.google.firebase.auth.internal.CLIENT_VERSION", zzafc.zza().zzb());
            bundle.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.q());
            bundle.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", firebaseAuth.l().q());
            bundle.putString("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN", firebaseAuth.n());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f16046d;

        public h a() {
            return z1.Z(this.f16043a, this.f16044b, this.f16045c, this.f16046d);
        }

        public b b(String str) {
            this.f16045c = str;
            return this;
        }

        public b c(String str) {
            this.f16044b = str;
            return this;
        }

        public b d(String str, String str2) {
            this.f16044b = str;
            this.f16046d = str2;
            return this;
        }

        public b(String str) {
            this.f16043a = str;
        }
    }

    public static a d(String str) {
        return e(str, FirebaseAuth.getInstance());
    }

    public static a e(String str, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.s.e(str);
        com.google.android.gms.common.internal.s.k(firebaseAuth);
        if (!Constants.SIGN_IN_METHOD_FACEBOOK.equals(str) || zzagl.zza(firebaseAuth.l())) {
            return new a(str, firebaseAuth);
        }
        throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
    }

    public static b f(String str) {
        return new b(com.google.android.gms.common.internal.s.e(str));
    }

    @Override // m7.n
    public final void a(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f16039a);
        activity.startActivity(intent);
    }

    @Override // m7.n
    public final void b(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f16039a);
        activity.startActivity(intent);
    }

    @Override // m7.n
    public final void c(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.f16039a);
        activity.startActivity(intent);
    }

    public n0(Bundle bundle) {
        this.f16039a = bundle;
    }
}
