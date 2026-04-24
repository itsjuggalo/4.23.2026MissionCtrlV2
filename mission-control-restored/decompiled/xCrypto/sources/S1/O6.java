package S1;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzis;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class O6 extends F6 {
    public O6(b7 b7Var) {
        super(b7Var);
    }

    private final String k(String str) {
        String strX = this.f3955b.D0().x(str);
        if (TextUtils.isEmpty(strX)) {
            return (String) AbstractC0569f2.f4599r.b(null);
        }
        Uri uri = Uri.parse((String) AbstractC0569f2.f4599r.b(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        String authority = uri.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(strX).length() + 1 + String.valueOf(authority).length());
        sb.append(strX);
        sb.append(".");
        sb.append(authority);
        builderBuildUpon.authority(sb.toString());
        return builderBuildUpon.build().toString();
    }

    public static final boolean l(String str) {
        String str2 = (String) AbstractC0569f2.f4603t.b(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(com.amazon.a.a.o.b.f.f8804a)) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    public final N6 i(String str) {
        J2 j2L0;
        b7 b7Var = this.f3955b;
        J2 j2L02 = b7Var.F0().L0(str);
        N6 n6 = null;
        if (j2L02 == null || !j2L02.V()) {
            return new N6(k(str), Collections.EMPTY_MAP, EnumC0612k5.GOOGLE_ANALYTICS, null);
        }
        zzil zzilVarZzb = zzis.zzb();
        zzilVarZzb.zzb(2);
        zzilVarZzb.zza((zzin) AbstractC0940s.k(zzin.zzb(j2L02.M())));
        String strP0 = j2L02.p0();
        zzgl zzglVarW = b7Var.D0().w(str);
        if (zzglVarW == null || (j2L0 = b7Var.F0().L0(str)) == null || ((!zzglVarW.zzp() || zzglVarW.zzq().zzc() != 100) && !this.f4245a.C().P(str, j2L0.l0()) && (TextUtils.isEmpty(strP0) || Math.abs(strP0.hashCode() % 100) >= zzglVarW.zzq().zzc()))) {
            zzilVarZzb.zzc(3);
            return new N6(k(str), Collections.EMPTY_MAP, EnumC0612k5.GOOGLE_ANALYTICS, (zzis) zzilVarZzb.zzbc());
        }
        String strO0 = j2L02.o0();
        zzilVarZzb.zzb(2);
        zzgl zzglVarW2 = b7Var.D0().w(j2L02.o0());
        if (zzglVarW2 == null || !zzglVarW2.zzp()) {
            this.f4245a.a().w().b("[sgtm] Missing sgtm_setting in remote config. appId", strO0);
            zzilVarZzb.zzc(4);
        } else {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(j2L02.l0())) {
                map.put("x-gtm-server-preview", j2L02.l0());
            }
            String strZzd = zzglVarW2.zzq().zzd();
            zzin zzinVarZzb = zzin.zzb(j2L02.M());
            if (zzinVarZzb != null && zzinVarZzb != zzin.CLIENT_UPLOAD_ELIGIBLE) {
                zzilVarZzb.zza(zzinVarZzb);
            } else if (l(j2L02.o0())) {
                zzilVarZzb.zza(zzin.PINNED_TO_SERVICE_UPLOAD);
            } else if (TextUtils.isEmpty(strZzd)) {
                zzilVarZzb.zza(zzin.MISSING_SGTM_SERVER_URL);
            } else {
                this.f4245a.a().w().b("[sgtm] Eligible for client side upload. appId", strO0);
                zzilVarZzb.zzb(3);
                zzilVarZzb.zza(zzin.CLIENT_UPLOAD_ELIGIBLE);
                n6 = new N6(strZzd, map, EnumC0612k5.SGTM_CLIENT, (zzis) zzilVarZzb.zzbc());
            }
            zzglVarW2.zzq().zza();
            zzglVarW2.zzq().zzb();
            C0658q3 c0658q3 = this.f4245a;
            c0658q3.c();
            if (TextUtils.isEmpty(strZzd)) {
                zzilVarZzb.zzc(6);
                c0658q3.a().w().b("[sgtm] Local service, missing sgtm_server_url", j2L02.o0());
            } else {
                c0658q3.a().w().b("[sgtm] Eligible for local service direct upload. appId", strO0);
                zzilVarZzb.zzb(5);
                zzilVarZzb.zzc(2);
                n6 = new N6(strZzd, map, EnumC0612k5.SGTM, (zzis) zzilVarZzb.zzbc());
            }
        }
        return n6 != null ? n6 : new N6(k(str), Collections.EMPTY_MAP, EnumC0612k5.GOOGLE_ANALYTICS, (zzis) zzilVarZzb.zzbc());
    }

    public final boolean j(String str, zzin zzinVar) {
        zzgl zzglVarW;
        h();
        return (zzinVar != zzin.CLIENT_UPLOAD_ELIGIBLE || l(str) || (zzglVarW = this.f3955b.D0().w(str)) == null || !zzglVarW.zzp() || zzglVarW.zzq().zzd().isEmpty()) ? false : true;
    }
}
