package S1;

import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: renamed from: S1.y4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0722y4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f5060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f5061b;

    public RunnableC0722y4(C0540b5 c0540b5, Bundle bundle) {
        this.f5060a = bundle;
        Objects.requireNonNull(c0540b5);
        this.f5061b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0540b5 c0540b5 = this.f5061b;
        c0540b5.h();
        c0540b5.j();
        Bundle bundle = this.f5060a;
        AbstractC0940s.k(bundle);
        String strE = AbstractC0940s.e(bundle.getString("name"));
        if (!c0540b5.f4245a.g()) {
            c0540b5.f4245a.a().w().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            c0540b5.f4245a.J().d0(new C0590i(bundle.getString("app_id"), "", new h7(strE, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), c0540b5.f4245a.C().R(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
