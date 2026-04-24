package S1;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class R2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbq f4218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f4219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S2 f4220c;

    public R2(S2 s22, zzbq zzbqVar, ServiceConnection serviceConnection) {
        this.f4218a = zzbqVar;
        this.f4219b = serviceConnection;
        Objects.requireNonNull(s22);
        this.f4220c = s22;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleZze;
        S2 s22 = this.f4220c;
        T2 t22 = s22.f4232b;
        C0658q3 c0658q3 = t22.f4244a;
        c0658q3.b().h();
        Bundle bundle = new Bundle();
        String strA = s22.a();
        bundle.putString("package_name", strA);
        try {
            bundleZze = this.f4218a.zze(bundle);
        } catch (Exception e4) {
            t22.f4244a.a().o().b("Exception occurred while retrieving the Install Referrer", e4.getMessage());
        }
        if (bundleZze == null) {
            c0658q3.a().o().a("Install Referrer Service returned a null response");
            bundleZze = null;
        }
        C0658q3 c0658q32 = t22.f4244a;
        c0658q32.b().h();
        C0658q3.q();
        if (bundleZze != null) {
            long j4 = bundleZze.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j4 == 0) {
                c0658q32.a().r().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleZze.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    c0658q32.a().o().a("No referrer defined in Install Referrer response");
                } else {
                    c0658q32.a().w().b("InstallReferrer API result", string);
                    Bundle bundleS0 = c0658q32.C().s0(Uri.parse("?".concat(string)));
                    if (bundleS0 == null) {
                        c0658q32.a().o().a("No campaign params defined in Install Referrer result");
                    } else {
                        List listAsList = Arrays.asList(((String) AbstractC0569f2.f4580i1.b(null)).split(com.amazon.a.a.o.b.f.f8804a));
                        Iterator<String> it = bundleS0.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (listAsList.contains(it.next())) {
                                long j5 = bundleZze.getLong("referrer_click_timestamp_server_seconds", 0L) * 1000;
                                if (j5 > 0) {
                                    bundleS0.putLong("click_timestamp", j5);
                                }
                            }
                        }
                        if (j4 == c0658q32.x().f4185g.a()) {
                            c0658q32.a().w().a("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (c0658q32.g()) {
                            c0658q32.x().f4185g.b(j4);
                            c0658q32.a().w().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            bundleS0.putString("_cis", "referrer API v2");
                            c0658q32.B().w("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleS0, strA);
                        }
                    }
                }
            }
        }
        F1.b.b().c(c0658q32.e(), this.f4219b);
    }
}
