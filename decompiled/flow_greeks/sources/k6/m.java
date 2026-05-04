package k6;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import l6.t;
import l6.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l6.i f14742c = new l6.i("ReviewService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f14743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14744b;

    /* JADX WARN: Type inference failed for: r7v0, types: [k6.i] */
    public m(Context context) {
        this.f14744b = context.getPackageName();
        if (w.a(context)) {
            this.f14743a = new t(context, f14742c, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), new Object() { // from class: k6.i
            }, null);
        }
    }

    public final Task a() {
        String str = this.f14744b;
        l6.i iVar = f14742c;
        iVar.c("requestInAppReview (%s)", str);
        if (this.f14743a == null) {
            iVar.a("Play Store app is either not installed or not the official version", new Object[0]);
            return Tasks.forException(new a(-1));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f14743a.s(new j(this, taskCompletionSource, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
