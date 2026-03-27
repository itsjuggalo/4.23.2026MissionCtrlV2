package S1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class M4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f4107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ N4 f4110e;

    public M4(N4 n4, boolean z4, Uri uri, String str, String str2) {
        this.f4106a = z4;
        this.f4107b = uri;
        this.f4108c = str;
        this.f4109d = str2;
        Objects.requireNonNull(n4);
        this.f4110e = n4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleS0;
        Bundle bundleS02;
        N4 n4 = this.f4110e;
        C0540b5 c0540b5 = n4.f4128a;
        c0540b5.h();
        String str = this.f4109d;
        Uri uri = this.f4107b;
        try {
            C0658q3 c0658q3 = c0540b5.f4245a;
            l7 l7VarC = c0658q3.C();
            if (TextUtils.isEmpty(str)) {
                bundleS0 = null;
            } else if (str.contains("gclid") || str.contains("gbraid") || str.contains("utm_campaign") || str.contains("utm_source") || str.contains("utm_medium") || str.contains("utm_id") || str.contains("dclid") || str.contains("srsltid") || str.contains("sfmc_id")) {
                bundleS0 = l7VarC.s0(Uri.parse("https://google.com/search?".concat(str)));
                if (bundleS0 != null) {
                    bundleS0.putString("_cis", "referrer");
                }
            } else {
                l7VarC.f4245a.a().v().a("Activity created with data 'referrer' without required params");
                bundleS0 = null;
            }
            String str2 = this.f4108c;
            if (this.f4106a && (bundleS02 = c0658q3.C().s0(uri)) != null) {
                bundleS02.putString("_cis", "intent");
                if (!bundleS02.containsKey("gclid") && bundleS0 != null && bundleS0.containsKey("gclid")) {
                    bundleS02.putString("_cer", String.format("gclid=%s", bundleS0.getString("gclid")));
                }
                c0540b5.t(str2, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleS02);
                c0540b5.f4369r.b(str2, bundleS02);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c0658q3.a().v().b("Activity created with referrer", str);
            if (c0658q3.w().H(null, AbstractC0569f2.f4517H0)) {
                if (bundleS0 != null) {
                    c0540b5.t(str2, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleS0);
                    c0540b5.f4369r.b(str2, bundleS0);
                } else {
                    c0658q3.a().v().b("Referrer does not contain valid parameters", str);
                }
                c0540b5.y("auto", "_ldl", null, true);
                return;
            }
            if (!str.contains("gclid") || (!str.contains("utm_campaign") && !str.contains("utm_source") && !str.contains("utm_medium") && !str.contains("utm_term") && !str.contains("utm_content"))) {
                c0658q3.a().v().a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                c0540b5.y("auto", "_ldl", str, true);
            }
        } catch (RuntimeException e4) {
            n4.f4128a.f4245a.a().o().b("Throwable caught in handleReferrerForOnActivityCreated", e4);
        }
    }
}
