package S1;

import N1.C0094g0;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.GenericIdpActivity;
import com.google.firebase.auth.internal.RecaptchaActivity;
import j2.G;
import java.util.List;
import u.AbstractC1193h;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2848c;

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.f2846a) {
            case 0:
                C0236e c0236e = (C0236e) this.f2847b;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f2848c;
                synchronized (c0236e.f2864f) {
                    c0236e.e.remove(taskCompletionSource);
                    break;
                }
                return;
            case 1:
                G g2 = GenericIdpActivity.f5473D;
                Intent intent = new Intent("android.intent.action.VIEW");
                GenericIdpActivity genericIdpActivity = (GenericIdpActivity) this.f2847b;
                ResolveInfo resolveInfoResolveActivity = genericIdpActivity.getPackageManager().resolveActivity(intent, 0);
                String str = (String) this.f2848c;
                if (resolveInfoResolveActivity == null) {
                    Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
                    zzaer.zzb(genericIdpActivity, str);
                    return;
                }
                List<ResolveInfo> listQueryIntentServices = genericIdpActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
                if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
                    intent2.putExtra("com.android.browser.application_id", str);
                    Log.i("GenericIdpActivity", "Opening IDP Sign In link in a browser window.");
                    intent2.addFlags(1073741824);
                    intent2.addFlags(268435456);
                    genericIdpActivity.startActivity(intent2);
                    return;
                }
                io.flutter.plugin.platform.p pVarE = new C0094g0().e();
                Log.i("GenericIdpActivity", "Opening IDP Sign In link in a custom chrome tab.");
                Uri uri = (Uri) task.getResult();
                Intent intent3 = (Intent) pVarE.f7201b;
                intent3.setData(uri);
                AbstractC1193h.startActivity(genericIdpActivity, intent3, (Bundle) pVarE.f7202c);
                return;
            default:
                G g5 = RecaptchaActivity.f5476D;
                Intent intent4 = new Intent("android.intent.action.VIEW");
                RecaptchaActivity recaptchaActivity = (RecaptchaActivity) this.f2847b;
                ResolveInfo resolveInfoResolveActivity2 = recaptchaActivity.getPackageManager().resolveActivity(intent4, 0);
                String str2 = (String) this.f2848c;
                if (resolveInfoResolveActivity2 == null) {
                    Log.e("RecaptchaActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
                    zzaer.zzb(recaptchaActivity, str2);
                    return;
                }
                List<ResolveInfo> listQueryIntentServices2 = recaptchaActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
                if (listQueryIntentServices2 == null || listQueryIntentServices2.isEmpty()) {
                    Intent intent5 = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
                    intent5.putExtra("com.android.browser.application_id", str2);
                    intent5.addFlags(1073741824);
                    intent5.addFlags(268435456);
                    recaptchaActivity.startActivity(intent5);
                    return;
                }
                io.flutter.plugin.platform.p pVarE2 = new C0094g0().e();
                Intent intent6 = (Intent) pVarE2.f7201b;
                intent6.addFlags(1073741824);
                intent6.addFlags(268435456);
                intent6.setData((Uri) task.getResult());
                AbstractC1193h.startActivity(recaptchaActivity, intent6, (Bundle) pVarE2.f7202c);
                return;
        }
    }

    public /* synthetic */ C(C0236e c0236e, TaskCompletionSource taskCompletionSource) {
        this.f2846a = 0;
        this.f2847b = c0236e;
        this.f2848c = taskCompletionSource;
    }
}
