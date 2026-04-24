package S1;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: renamed from: S1.x4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0714x4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f5045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f5046b;

    public RunnableC0714x4(C0540b5 c0540b5, Bundle bundle) {
        this.f5045a = bundle;
        Objects.requireNonNull(c0540b5);
        this.f5046b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0540b5 c0540b5 = this.f5046b;
        c0540b5.h();
        c0540b5.j();
        Bundle bundle = this.f5045a;
        AbstractC0940s.k(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString(FirebaseAnalytics.Param.ORIGIN);
        AbstractC0940s.e(string);
        AbstractC0940s.e(string2);
        AbstractC0940s.k(bundle.get("value"));
        if (!c0540b5.f4245a.g()) {
            c0540b5.f4245a.a().w().a("Conditional property not set since app measurement is disabled");
            return;
        }
        h7 h7Var = new h7(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            C0658q3 c0658q3 = c0540b5.f4245a;
            J jR = c0658q3.C().R(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            c0540b5.f4245a.J().d0(new C0590i(bundle.getString("app_id"), string2, h7Var, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), c0658q3.C().R(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), jR, bundle.getLong("time_to_live"), c0658q3.C().R(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
