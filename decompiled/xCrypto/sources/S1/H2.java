package S1;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzib;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class H2 extends M6 {
    public H2(b7 b7Var) {
        super(b7Var);
    }

    @Override // S1.M6
    public final boolean l() {
        return false;
    }

    public final boolean m() {
        j();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f4245a.e().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void n(String str, N6 n6, zzib zzibVar, E2 e22) {
        H2 h22;
        String str2;
        URL url;
        byte[] bArrZzcc;
        h();
        j();
        try {
            url = new URI(n6.a()).toURL();
            this.f3955b.K0();
            bArrZzcc = zzibVar.zzcc();
            h22 = this;
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            h22 = this;
            str2 = str;
        }
        try {
            this.f4245a.b().w(new G2(h22, str2, url, bArrZzcc, n6.b(), e22));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            h22.f4245a.a().o().c("Failed to parse URL. Not uploading MeasurementBatch. appId", C2.x(str2), n6.a());
        }
    }

    public final void o(J2 j22, Map map, E2 e22) {
        H2 h22;
        URL url;
        h();
        j();
        AbstractC0940s.k(j22);
        AbstractC0940s.k(e22);
        O6 o6C0 = this.f3955b.C0();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) AbstractC0569f2.f4569f.b(null)).encodedAuthority((String) AbstractC0569f2.f4572g.b(null)).path("config/app/".concat(String.valueOf(j22.r0()))).appendQueryParameter("platform", "android");
        o6C0.f4245a.w().A();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(130000L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            url = new URI(string).toURL();
            h22 = this;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            h22 = this;
        }
        try {
            this.f4245a.b().w(new G2(h22, j22.o0(), url, null, map, e22));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            h22.f4245a.a().o().c("Failed to parse config URL. Not fetching. appId", C2.x(j22.o0()), string);
        }
    }
}
