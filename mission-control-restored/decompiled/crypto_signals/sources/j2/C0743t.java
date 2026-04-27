package j2;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.GenericIdpActivity;
import com.google.firebase.auth.internal.RecaptchaActivity;
import f2.C0596b;

/* JADX INFO: renamed from: j2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0743t implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Uri f7733b;

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        switch (this.f7732a) {
            case 0:
                G g2 = GenericIdpActivity.f5473D;
                Uri.Builder builderBuildUpon = this.f7733b.buildUpon();
                if (task.isSuccessful()) {
                    C0596b c0596b = (C0596b) task.getResult();
                    Z1.k kVar = c0596b.f6424b;
                    if (kVar != null) {
                        Log.w("GenericIdpActivity", "Error getting App Check token; using placeholder token instead. Error: ".concat(String.valueOf(kVar)));
                    }
                    builderBuildUpon.fragment("fac=" + c0596b.f6423a);
                } else {
                    a3.d.s("Unexpected error getting App Check token: ", task.getException().getMessage(), "GenericIdpActivity");
                }
                return builderBuildUpon.build();
            default:
                G g5 = RecaptchaActivity.f5476D;
                Uri.Builder builderBuildUpon2 = this.f7733b.buildUpon();
                if (task.isSuccessful()) {
                    C0596b c0596b2 = (C0596b) task.getResult();
                    Z1.k kVar2 = c0596b2.f6424b;
                    if (kVar2 != null) {
                        Log.w("RecaptchaActivity", "Error getting App Check token; using placeholder token instead. Error: ".concat(String.valueOf(kVar2)));
                    }
                    builderBuildUpon2.fragment("fac=" + c0596b2.f6423a);
                } else {
                    a3.d.s("Unexpected error getting App Check token: ", task.getException().getMessage(), "RecaptchaActivity");
                }
                return builderBuildUpon2.build();
        }
    }
}
