package g5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p5.a f10066a = new p5.a("GoogleSignInCommon", new String[0]);

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f10066a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static com.google.android.gms.common.api.h b(com.google.android.gms.common.api.g gVar, Context context, boolean z10) {
        f10066a.a("Signing out", new Object[0]);
        d(context);
        return z10 ? com.google.android.gms.common.api.i.b(Status.f5455f, gVar) : gVar.b(new k(gVar));
    }

    public static com.google.android.gms.common.api.h c(com.google.android.gms.common.api.g gVar, Context context, boolean z10) {
        f10066a.a("Revoking access", new Object[0]);
        String strE = c.b(context).e();
        d(context);
        return z10 ? f.a(strE) : gVar.b(new m(gVar));
    }

    public static void d(Context context) {
        p.a(context).b();
        Iterator it = com.google.android.gms.common.api.g.c().iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.g) it.next()).h();
        }
        com.google.android.gms.common.api.internal.g.a();
    }
}
