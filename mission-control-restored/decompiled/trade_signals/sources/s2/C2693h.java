package s2;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2329m;

/* JADX INFO: renamed from: s2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2693h implements InterfaceC2688c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2698m f23071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f23072b = new Handler(Looper.getMainLooper());

    public C2693h(C2698m c2698m) {
        this.f23071a = c2698m;
    }

    @Override // s2.InterfaceC2688c
    public final AbstractC2328l a(Activity activity, AbstractC2687b abstractC2687b) {
        if (abstractC2687b.b()) {
            return AbstractC2331o.e(null);
        }
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", abstractC2687b.a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        C2329m c2329m = new C2329m();
        intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, new ResultReceiverC2692g(this, this.f23072b, c2329m));
        activity.startActivity(intent);
        return c2329m.a();
    }

    @Override // s2.InterfaceC2688c
    public final AbstractC2328l b() {
        return this.f23071a.a();
    }
}
