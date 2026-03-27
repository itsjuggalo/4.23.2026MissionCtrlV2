package S1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.messaging.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0658q3 f4957a;

    public t7(C0658q3 c0658q3) {
        this.f4957a = c0658q3;
    }

    public final void a() {
        C0658q3 c0658q3 = this.f4957a;
        c0658q3.b().h();
        if (e()) {
            if (d()) {
                c0658q3.x().f4202x.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                c0658q3.B().t("auto", "_cmpx", bundle);
            } else {
                String strA = c0658q3.x().f4202x.a();
                if (TextUtils.isEmpty(strA)) {
                    c0658q3.a().p().a("Cache still valid but referrer not found");
                } else {
                    long jA = c0658q3.x().f4203y.a() / 3600000;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", (jA - 1) * 3600000);
                    Object obj = pair.first;
                    c0658q3.B().t(obj == null ? "app" : (String) obj, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                c0658q3.x().f4202x.b(null);
            }
            c0658q3.x().f4203y.b(0L);
        }
    }

    public final void b(String str, Bundle bundle) {
        String string;
        C0658q3 c0658q3 = this.f4957a;
        c0658q3.b().h();
        if (c0658q3.g()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        c0658q3.x().f4202x.b(string);
        c0658q3.x().f4203y.b(c0658q3.f().currentTimeMillis());
    }

    public final void c() {
        if (e() && d()) {
            this.f4957a.x().f4202x.b(null);
        }
    }

    public final boolean d() {
        if (!e()) {
            return false;
        }
        C0658q3 c0658q3 = this.f4957a;
        return c0658q3.f().currentTimeMillis() - c0658q3.x().f4203y.a() > c0658q3.w().D(null, AbstractC0569f2.f4585k0);
    }

    public final boolean e() {
        return this.f4957a.x().f4203y.a() > 0;
    }
}
