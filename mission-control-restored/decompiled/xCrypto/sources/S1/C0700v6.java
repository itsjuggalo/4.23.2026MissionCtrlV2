package S1;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: renamed from: S1.v6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0700v6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0708w6 f5007a;

    public C0700v6(C0708w6 c0708w6) {
        Objects.requireNonNull(c0708w6);
        this.f5007a = c0708w6;
    }

    public final void a() {
        C0708w6 c0708w6 = this.f5007a;
        c0708w6.h();
        C0658q3 c0658q3 = c0708w6.f4245a;
        if (c0658q3.x().A(c0658q3.f().currentTimeMillis())) {
            c0658q3.x().f4191m.b(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                c0658q3.a().w().a("Detected application was in foreground");
                c(c0658q3.f().currentTimeMillis(), false);
            }
        }
    }

    public final void b(long j4, boolean z4) {
        C0708w6 c0708w6 = this.f5007a;
        c0708w6.h();
        c0708w6.q();
        C0658q3 c0658q3 = c0708w6.f4245a;
        if (c0658q3.x().A(j4)) {
            c0658q3.x().f4191m.b(true);
            c0708w6.f4245a.L().p();
        }
        c0658q3.x().f4195q.b(j4);
        if (c0658q3.x().f4191m.a()) {
            c(j4, z4);
        }
    }

    public final void c(long j4, boolean z4) {
        C0708w6 c0708w6 = this.f5007a;
        c0708w6.h();
        if (c0708w6.f4245a.g()) {
            C0658q3 c0658q3 = c0708w6.f4245a;
            c0658q3.x().f4195q.b(j4);
            c0658q3.a().w().b("Session started, time", Long.valueOf(c0658q3.f().a()));
            long j5 = j4 / 1000;
            C0658q3 c0658q32 = c0708w6.f4245a;
            c0658q32.B().B("auto", "_sid", Long.valueOf(j5), j4);
            c0658q3.x().f4196r.b(j5);
            c0658q3.x().f4191m.b(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j5);
            c0658q32.B().u("auto", "_s", j4, bundle);
            String strA = c0658q3.x().f4201w.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strA);
            c0658q32.B().u("auto", "_ssr", j4, bundle2);
        }
    }
}
