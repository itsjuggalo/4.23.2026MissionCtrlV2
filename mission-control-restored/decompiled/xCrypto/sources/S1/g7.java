package S1;

import A1.b;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzis;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzlq;
import com.google.android.gms.internal.measurement.zznk;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqu;
import com.revenuecat.purchases.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class g7 extends M6 {
    public g7(b7 b7Var) {
        super(b7Var);
    }

    public static final String A(boolean z4, boolean z5, boolean z6) {
        StringBuilder sb = new StringBuilder();
        if (z4) {
            sb.append("Dynamic ");
        }
        if (z5) {
            sb.append("Sequence ");
        }
        if (z6) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public static final Object B(zzhw zzhwVar) {
        if (zzhwVar.zzc()) {
            return zzhwVar.zzd();
        }
        if (zzhwVar.zze()) {
            return Long.valueOf(zzhwVar.zzf());
        }
        if (zzhwVar.zzi()) {
            return Double.valueOf(zzhwVar.zzj());
        }
        if (zzhwVar.zzm() > 0) {
            return Y(zzhwVar.zzk());
        }
        return null;
    }

    public static final void C(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(com.amazon.a.a.o.b.f.f8804a);
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                z(builder, str3, string, set);
            }
        }
    }

    public static final void D(StringBuilder sb, int i4, String str, zzii zziiVar) {
        if (zziiVar == null) {
            return;
        }
        y(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zziiVar.zzd() != 0) {
            y(sb, 4);
            sb.append("results: ");
            int i5 = 0;
            for (Long l4 : zziiVar.zzc()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(l4);
                i5 = i6;
            }
            sb.append('\n');
        }
        if (zziiVar.zzb() != 0) {
            y(sb, 4);
            sb.append("status: ");
            int i7 = 0;
            for (Long l5 : zziiVar.zza()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(l5);
                i7 = i8;
            }
            sb.append('\n');
        }
        if (zziiVar.zzf() != 0) {
            y(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i9 = 0;
            for (zzhq zzhqVar : zziiVar.zze()) {
                int i10 = i9 + 1;
                if (i9 != 0) {
                    sb.append(", ");
                }
                sb.append(zzhqVar.zza() ? Integer.valueOf(zzhqVar.zzb()) : null);
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(zzhqVar.zzc() ? Long.valueOf(zzhqVar.zzd()) : null);
                i9 = i10;
            }
            sb.append("}\n");
        }
        if (zziiVar.zzh() != 0) {
            y(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i11 = 0;
            for (zzik zzikVar : zziiVar.zzg()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb.append(", ");
                }
                sb.append(zzikVar.zza() ? Integer.valueOf(zzikVar.zzb()) : null);
                sb.append(": [");
                Iterator it = zzikVar.zzc().iterator();
                int i13 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i14 = i13 + 1;
                    if (i13 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i13 = i14;
                }
                sb.append("]");
                i11 = i12;
            }
            sb.append("}\n");
        }
        y(sb, 3);
        sb.append("}\n");
    }

    public static final void E(StringBuilder sb, int i4, String str, Object obj) {
        if (obj == null) {
            return;
        }
        y(sb, i4 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static final void F(StringBuilder sb, int i4, String str, zzfl zzflVar) {
        if (zzflVar == null) {
            return;
        }
        y(sb, i4);
        sb.append(str);
        sb.append(" {\n");
        if (zzflVar.zza()) {
            int iZzm = zzflVar.zzm();
            E(sb, i4, "comparison_type", iZzm != 1 ? iZzm != 2 ? iZzm != 3 ? iZzm != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (zzflVar.zzb()) {
            E(sb, i4, "match_as_float", Boolean.valueOf(zzflVar.zzc()));
        }
        if (zzflVar.zzd()) {
            E(sb, i4, "comparison_value", zzflVar.zze());
        }
        if (zzflVar.zzf()) {
            E(sb, i4, "min_comparison_value", zzflVar.zzg());
        }
        if (zzflVar.zzh()) {
            E(sb, i4, "max_comparison_value", zzflVar.zzi());
        }
        y(sb, i4);
        sb.append("}\n");
    }

    public static boolean O(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean P(List list, int i4) {
        if (i4 < list.size() * 64) {
            return ((1 << (i4 % 64)) & ((Long) list.get(i4 / 64)).longValue()) != 0;
        }
        return false;
    }

    public static List Q(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            long j4 = 0;
            for (int i5 = 0; i5 < 64; i5++) {
                int i6 = (i4 * 64) + i5;
                if (i6 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i6)) {
                    j4 |= 1 << i5;
                }
            }
            arrayList.add(Long.valueOf(j4));
        }
        return arrayList;
    }

    public static zznk W(zznk zznkVar, byte[] bArr) {
        zzlq zzlqVarZza = zzlq.zza();
        return zzlqVarZza != null ? zznkVar.zzaV(bArr, zzlqVarZza) : zznkVar.zzaW(bArr);
    }

    public static int X(zzic zzicVar, String str) {
        for (int i4 = 0; i4 < zzicVar.zzl(); i4++) {
            if (str.equals(zzicVar.zzm(i4).zzc())) {
                return i4;
            }
        }
        return -1;
    }

    public static Bundle[] Y(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzhw zzhwVar = (zzhw) it.next();
            if (zzhwVar != null) {
                Bundle bundle = new Bundle();
                for (zzhw zzhwVar2 : zzhwVar.zzk()) {
                    if (zzhwVar2.zzc()) {
                        bundle.putString(zzhwVar2.zzb(), zzhwVar2.zzd());
                    } else if (zzhwVar2.zze()) {
                        bundle.putLong(zzhwVar2.zzb(), zzhwVar2.zzf());
                    } else if (zzhwVar2.zzi()) {
                        bundle.putDouble(zzhwVar2.zzb(), zzhwVar2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static final void o(zzhr zzhrVar, String str, Object obj) {
        List listZza = zzhrVar.zza();
        int i4 = 0;
        while (true) {
            if (i4 >= listZza.size()) {
                i4 = -1;
                break;
            } else if (str.equals(((zzhw) listZza.get(i4)).zzb())) {
                break;
            } else {
                i4++;
            }
        }
        zzhv zzhvVarZzn = zzhw.zzn();
        zzhvVarZzn.zzb(str);
        zzhvVarZzn.zzf(((Long) obj).longValue());
        if (i4 >= 0) {
            zzhrVar.zze(i4, zzhvVarZzn);
        } else {
            zzhrVar.zzg(zzhvVarZzn);
        }
    }

    public static final boolean p(J j4, n7 n7Var) {
        AbstractC0940s.k(j4);
        AbstractC0940s.k(n7Var);
        return !TextUtils.isEmpty(n7Var.f4789b);
    }

    public static final Bundle q(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzhw zzhwVar = (zzhw) it.next();
            String strZzb = zzhwVar.zzb();
            if (zzhwVar.zzi()) {
                bundle.putDouble(strZzb, zzhwVar.zzj());
            } else if (zzhwVar.zzg()) {
                bundle.putFloat(strZzb, zzhwVar.zzh());
            } else if (zzhwVar.zzc()) {
                bundle.putString(strZzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putLong(strZzb, zzhwVar.zzf());
            }
        }
        return bundle;
    }

    public static final zzhw r(zzhs zzhsVar, String str) {
        for (zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().equals(str)) {
                return zzhwVar;
            }
        }
        return null;
    }

    public static final Map s(zzhs zzhsVar, String... strArr) {
        Object objB;
        HashMap map = new HashMap();
        for (zzhw zzhwVar : zzhsVar.zza()) {
            if (Arrays.asList(strArr).contains(zzhwVar.zzb()) && (objB = B(zzhwVar)) != null) {
                map.put(zzhwVar.zzb(), objB);
            }
        }
        return map;
    }

    public static final Map t(zzhs zzhsVar, String str) {
        Object objB;
        HashMap map = new HashMap();
        for (zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().startsWith("gad_") && (objB = B(zzhwVar)) != null) {
                map.put(zzhwVar.zzb(), objB);
            }
        }
        return map;
    }

    public static final Object u(zzhs zzhsVar, String str) {
        zzhw zzhwVarR = r(zzhsVar, str);
        if (zzhwVarR == null) {
            return null;
        }
        return B(zzhwVarR);
    }

    public static final Object v(zzhs zzhsVar, String str, Object obj) {
        Object objU = u(zzhsVar, str);
        return objU == null ? obj : objU;
    }

    public static final void y(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append("  ");
        }
    }

    public static final void z(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public final void G(zzit zzitVar, Object obj) {
        AbstractC0940s.k(obj);
        zzitVar.zzd();
        zzitVar.zzf();
        zzitVar.zzh();
        if (obj instanceof String) {
            zzitVar.zzc((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzitVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzitVar.zzg(((Double) obj).doubleValue());
        } else {
            this.f4245a.a().o().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void H(zzhv zzhvVar, Object obj) {
        AbstractC0940s.k(obj);
        zzhvVar.zze();
        zzhvVar.zzg();
        zzhvVar.zzi();
        zzhvVar.zzm();
        if (obj instanceof String) {
            zzhvVar.zzd((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzhvVar.zzf(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzhvVar.zzh(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            this.f4245a.a().o().b("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                zzhv zzhvVarZzn = zzhw.zzn();
                for (String str : bundle.keySet()) {
                    zzhv zzhvVarZzn2 = zzhw.zzn();
                    zzhvVarZzn2.zzb(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzhvVarZzn2.zzf(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzhvVarZzn2.zzd((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zzhvVarZzn2.zzh(((Double) obj2).doubleValue());
                    }
                    zzhvVarZzn.zzk(zzhvVarZzn2);
                }
                if (zzhvVarZzn.zzj() > 0) {
                    arrayList.add((zzhw) zzhvVarZzn.zzbc());
                }
            }
        }
        zzhvVar.zzl(arrayList);
    }

    public final B6 I(String str, zzic zzicVar, zzhr zzhrVar, String str2) {
        int iIndexOf;
        zzql.zza();
        C0658q3 c0658q3 = this.f4245a;
        if (!c0658q3.w().H(str, AbstractC0569f2.f4535Q0)) {
            return null;
        }
        long jCurrentTimeMillis = c0658q3.f().currentTimeMillis();
        Set setA = f7.a(c0658q3.w().C(str, AbstractC0569f2.f4608v0).split(com.amazon.a.a.o.b.f.f8804a));
        b7 b7Var = this.f3955b;
        O6 o6C0 = b7Var.C0();
        String strX = o6C0.f3955b.D0().x(str);
        Uri.Builder builder = new Uri.Builder();
        C0658q3 c0658q32 = o6C0.f4245a;
        builder.scheme(c0658q32.w().C(str, AbstractC0569f2.f4594o0));
        if (TextUtils.isEmpty(strX)) {
            builder.authority(c0658q32.w().C(str, AbstractC0569f2.f4596p0));
        } else {
            String strC = c0658q32.w().C(str, AbstractC0569f2.f4596p0);
            StringBuilder sb = new StringBuilder(String.valueOf(strX).length() + 1 + String.valueOf(strC).length());
            sb.append(strX);
            sb.append(".");
            sb.append(strC);
            builder.authority(sb.toString());
        }
        builder.path(c0658q32.w().C(str, AbstractC0569f2.f4598q0));
        z(builder, "gmp_app_id", zzicVar.zzac(), setA);
        c0658q3.w().A();
        z(builder, "gmp_version", String.valueOf(130000L), setA);
        String strZzV = zzicVar.zzV();
        C0622m c0622mW = c0658q3.w();
        C0561e2 c0561e2 = AbstractC0569f2.f4541T0;
        if (c0622mW.H(str, c0561e2) && b7Var.D0().N(str)) {
            strZzV = "";
        }
        z(builder, "app_instance_id", strZzV, setA);
        z(builder, "rdid", zzicVar.zzP(), setA);
        z(builder, "bundle_id", zzicVar.zzK(), setA);
        String strZzk = zzhrVar.zzk();
        String strA = AbstractC0539b4.a(strZzk);
        if (true != TextUtils.isEmpty(strA)) {
            strZzk = strA;
        }
        z(builder, "app_event_name", strZzk, setA);
        z(builder, "app_version", String.valueOf(zzicVar.zzai()), setA);
        String strZzD = zzicVar.zzD();
        if (c0658q3.w().H(str, c0561e2) && b7Var.D0().K(str) && !TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
            strZzD = strZzD.substring(0, iIndexOf);
        }
        z(builder, "os_version", strZzD, setA);
        z(builder, "timestamp", String.valueOf(zzhrVar.zzn()), setA);
        if (zzicVar.zzS()) {
            z(builder, "lat", "1", setA);
        }
        z(builder, "privacy_sandbox_version", String.valueOf(zzicVar.zzaG()), setA);
        z(builder, "trigger_uri_source", "1", setA);
        z(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setA);
        z(builder, "request_uuid", str2, setA);
        List<zzhw> listZza = zzhrVar.zza();
        Bundle bundle = new Bundle();
        for (zzhw zzhwVar : listZza) {
            String strZzb = zzhwVar.zzb();
            if (zzhwVar.zzi()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzj()));
            } else if (zzhwVar.zzg()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzh()));
            } else if (zzhwVar.zzc()) {
                bundle.putString(strZzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putString(strZzb, String.valueOf(zzhwVar.zzf()));
            }
        }
        C(builder, c0658q3.w().C(str, AbstractC0569f2.f4606u0).split("\\|"), bundle, setA);
        List<zziu> listZzk = zzicVar.zzk();
        Bundle bundle2 = new Bundle();
        for (zziu zziuVar : listZzk) {
            String strZzc = zziuVar.zzc();
            if (zziuVar.zzj()) {
                bundle2.putString(strZzc, String.valueOf(zziuVar.zzk()));
            } else if (zziuVar.zzh()) {
                bundle2.putString(strZzc, String.valueOf(zziuVar.zzi()));
            } else if (zziuVar.zzd()) {
                bundle2.putString(strZzc, zziuVar.zze());
            } else if (zziuVar.zzf()) {
                bundle2.putString(strZzc, String.valueOf(zziuVar.zzg()));
            }
        }
        C(builder, c0658q3.w().C(str, AbstractC0569f2.f4604t0).split("\\|"), bundle2, setA);
        z(builder, "dma", true != zzicVar.zzaC() ? "0" : "1", setA);
        if (!zzicVar.zzaE().isEmpty()) {
            z(builder, "dma_cps", zzicVar.zzaE(), setA);
        }
        if (zzicVar.zzaK()) {
            zzha zzhaVarZzaL = zzicVar.zzaL();
            if (!zzhaVarZzaL.zzb().isEmpty()) {
                z(builder, "dl_gclid", zzhaVarZzaL.zzb(), setA);
            }
            if (!zzhaVarZzaL.zzd().isEmpty()) {
                z(builder, "dl_gbraid", zzhaVarZzaL.zzd(), setA);
            }
            if (!zzhaVarZzaL.zzf().isEmpty()) {
                z(builder, "dl_gs", zzhaVarZzaL.zzf(), setA);
            }
            if (zzhaVarZzaL.zzh() > 0) {
                z(builder, "dl_ss_ts", String.valueOf(zzhaVarZzaL.zzh()), setA);
            }
            if (!zzhaVarZzaL.zzj().isEmpty()) {
                z(builder, "mr_gclid", zzhaVarZzaL.zzj(), setA);
            }
            if (!zzhaVarZzaL.zzm().isEmpty()) {
                z(builder, "mr_gbraid", zzhaVarZzaL.zzm(), setA);
            }
            if (!zzhaVarZzaL.zzo().isEmpty()) {
                z(builder, "mr_gs", zzhaVarZzaL.zzo(), setA);
            }
            if (zzhaVarZzaL.zzq() > 0) {
                z(builder, "mr_click_ts", String.valueOf(zzhaVarZzaL.zzq()), setA);
            }
        }
        return new B6(builder.build().toString(), jCurrentTimeMillis, 1);
    }

    public final zzhs J(E e4) {
        zzhr zzhrVarZzk = zzhs.zzk();
        zzhrVarZzk.zzq(e4.f3915e);
        H h4 = e4.f3916f;
        G g4 = new G(h4);
        while (g4.hasNext()) {
            String next = g4.next();
            zzhv zzhvVarZzn = zzhw.zzn();
            zzhvVarZzn.zzb(next);
            Object objI = h4.i(next);
            AbstractC0940s.k(objI);
            H(zzhvVarZzn, objI);
            zzhrVarZzk.zzg(zzhvVarZzn);
        }
        String str = e4.f3913c;
        if (!TextUtils.isEmpty(str) && h4.i("_o") == null) {
            zzhv zzhvVarZzn2 = zzhw.zzn();
            zzhvVarZzn2.zzb("_o");
            zzhvVarZzn2.zzd(str);
            zzhrVarZzk.zzf((zzhw) zzhvVarZzn2.zzbc());
        }
        return (zzhs) zzhrVarZzk.zzbc();
    }

    public final String K(zzib zzibVar) {
        zzhe zzheVarZzat;
        if (zzibVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzibVar.zzf()) {
            E(sb, 0, "upload_subdomain", zzibVar.zzg());
        }
        if (zzibVar.zzd()) {
            E(sb, 0, "sgtm_join_id", zzibVar.zze());
        }
        for (zzid zzidVar : zzibVar.zza()) {
            if (zzidVar != null) {
                y(sb, 1);
                sb.append("bundle {\n");
                if (zzidVar.zza()) {
                    E(sb, 1, "protocol_version", Integer.valueOf(zzidVar.zzb()));
                }
                zzqu.zza();
                C0658q3 c0658q3 = this.f4245a;
                if (c0658q3.w().H(zzidVar.zzA(), AbstractC0569f2.f4529N0) && zzidVar.zzag()) {
                    E(sb, 1, "session_stitching_token", zzidVar.zzah());
                }
                E(sb, 1, "platform", zzidVar.zzt());
                if (zzidVar.zzC()) {
                    E(sb, 1, "gmp_version", Long.valueOf(zzidVar.zzD()));
                }
                if (zzidVar.zzE()) {
                    E(sb, 1, "uploading_gmp_version", Long.valueOf(zzidVar.zzF()));
                }
                if (zzidVar.zzac()) {
                    E(sb, 1, "dynamite_version", Long.valueOf(zzidVar.zzad()));
                }
                if (zzidVar.zzW()) {
                    E(sb, 1, "config_version", Long.valueOf(zzidVar.zzX()));
                }
                E(sb, 1, "gmp_app_id", zzidVar.zzP());
                E(sb, 1, "app_id", zzidVar.zzA());
                E(sb, 1, "app_version", zzidVar.zzB());
                if (zzidVar.zzU()) {
                    E(sb, 1, "app_version_major", Integer.valueOf(zzidVar.zzV()));
                }
                E(sb, 1, "firebase_instance_id", zzidVar.zzT());
                if (zzidVar.zzK()) {
                    E(sb, 1, "dev_cert_hash", Long.valueOf(zzidVar.zzL()));
                }
                E(sb, 1, "app_store", zzidVar.zzz());
                if (zzidVar.zzi()) {
                    E(sb, 1, "upload_timestamp_millis", Long.valueOf(zzidVar.zzj()));
                }
                if (zzidVar.zzk()) {
                    E(sb, 1, "start_timestamp_millis", Long.valueOf(zzidVar.zzm()));
                }
                if (zzidVar.zzn()) {
                    E(sb, 1, "end_timestamp_millis", Long.valueOf(zzidVar.zzo()));
                }
                if (zzidVar.zzp()) {
                    E(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzidVar.zzq()));
                }
                if (zzidVar.zzr()) {
                    E(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzidVar.zzs()));
                }
                E(sb, 1, "app_instance_id", zzidVar.zzJ());
                E(sb, 1, "resettable_device_id", zzidVar.zzG());
                E(sb, 1, "ds_id", zzidVar.zzZ());
                if (zzidVar.zzH()) {
                    E(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzidVar.zzI()));
                }
                E(sb, 1, "os_version", zzidVar.zzu());
                E(sb, 1, "device_model", zzidVar.zzv());
                E(sb, 1, "user_default_language", zzidVar.zzw());
                if (zzidVar.zzx()) {
                    E(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzidVar.zzy()));
                }
                if (zzidVar.zzM()) {
                    E(sb, 1, "bundle_sequential_index", Integer.valueOf(zzidVar.zzN()));
                }
                if (zzidVar.zzau()) {
                    E(sb, 1, "delivery_index", Integer.valueOf(zzidVar.zzav()));
                }
                if (zzidVar.zzQ()) {
                    E(sb, 1, "service_upload", Boolean.valueOf(zzidVar.zzR()));
                }
                E(sb, 1, "health_monitor", zzidVar.zzO());
                if (zzidVar.zzaa()) {
                    E(sb, 1, "retry_counter", Integer.valueOf(zzidVar.zzab()));
                }
                if (zzidVar.zzae()) {
                    E(sb, 1, "consent_signals", zzidVar.zzaf());
                }
                if (zzidVar.zzan()) {
                    E(sb, 1, "is_dma_region", Boolean.valueOf(zzidVar.zzao()));
                }
                if (zzidVar.zzap()) {
                    E(sb, 1, "core_platform_services", zzidVar.zzaq());
                }
                if (zzidVar.zzal()) {
                    E(sb, 1, "consent_diagnostics", zzidVar.zzam());
                }
                if (zzidVar.zzai()) {
                    E(sb, 1, "target_os_version", Long.valueOf(zzidVar.zzaj()));
                }
                zzql.zza();
                if (c0658q3.w().H(zzidVar.zzA(), AbstractC0569f2.f4535Q0)) {
                    E(sb, 1, "ad_services_version", Integer.valueOf(zzidVar.zzar()));
                    if (zzidVar.zzas() && (zzheVarZzat = zzidVar.zzat()) != null) {
                        y(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        E(sb, 2, "eligible", Boolean.valueOf(zzheVarZzat.zza()));
                        E(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzheVarZzat.zzb()));
                        E(sb, 2, "pre_r", Boolean.valueOf(zzheVarZzat.zzc()));
                        E(sb, 2, "r_extensions_too_old", Boolean.valueOf(zzheVarZzat.zzd()));
                        E(sb, 2, "adservices_extension_too_old", Boolean.valueOf(zzheVarZzat.zze()));
                        E(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(zzheVarZzat.zzf()));
                        E(sb, 2, "measurement_manager_disabled", Boolean.valueOf(zzheVarZzat.zzg()));
                        y(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (zzidVar.zzaw()) {
                    zzha zzhaVarZzax = zzidVar.zzax();
                    y(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (zzhaVarZzax.zza()) {
                        E(sb, 2, "deep_link_gclid", zzhaVarZzax.zzb());
                    }
                    if (zzhaVarZzax.zzc()) {
                        E(sb, 2, "deep_link_gbraid", zzhaVarZzax.zzd());
                    }
                    if (zzhaVarZzax.zze()) {
                        E(sb, 2, "deep_link_gad_source", zzhaVarZzax.zzf());
                    }
                    if (zzhaVarZzax.zzg()) {
                        E(sb, 2, "deep_link_session_millis", Long.valueOf(zzhaVarZzax.zzh()));
                    }
                    if (zzhaVarZzax.zzi()) {
                        E(sb, 2, "market_referrer_gclid", zzhaVarZzax.zzj());
                    }
                    if (zzhaVarZzax.zzk()) {
                        E(sb, 2, "market_referrer_gbraid", zzhaVarZzax.zzm());
                    }
                    if (zzhaVarZzax.zzn()) {
                        E(sb, 2, "market_referrer_gad_source", zzhaVarZzax.zzo());
                    }
                    if (zzhaVarZzax.zzp()) {
                        E(sb, 2, "market_referrer_click_millis", Long.valueOf(zzhaVarZzax.zzq()));
                    }
                    y(sb, 2);
                    sb.append("}\n");
                }
                if (zzidVar.zzaA()) {
                    E(sb, 1, "batching_timestamp_millis", Long.valueOf(zzidVar.zzaB()));
                }
                if (zzidVar.zzay()) {
                    zzis zzisVarZzaz = zzidVar.zzaz();
                    y(sb, 2);
                    sb.append("sgtm_diagnostics {\n");
                    int iZzf = zzisVarZzaz.zzf();
                    E(sb, 2, "upload_type", iZzf != 1 ? iZzf != 2 ? iZzf != 3 ? iZzf != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    E(sb, 2, "client_upload_eligibility", zzisVarZzaz.zza().name());
                    int iZzg = zzisVarZzaz.zzg();
                    E(sb, 2, "service_upload_eligibility", iZzg != 1 ? iZzg != 2 ? iZzg != 3 ? iZzg != 4 ? iZzg != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    y(sb, 2);
                    sb.append("}\n");
                }
                if (zzidVar.zzaC()) {
                    zzho zzhoVarZzaD = zzidVar.zzaD();
                    y(sb, 2);
                    sb.append("consent_info_extra {\n");
                    for (zzhl zzhlVar : zzhoVarZzaD.zza()) {
                        y(sb, 3);
                        sb.append("limited_data_modes {\n");
                        int iZzc = zzhlVar.zzc();
                        E(sb, 3, "type", iZzc != 1 ? iZzc != 2 ? iZzc != 3 ? iZzc != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int iZzd = zzhlVar.zzd();
                        E(sb, 3, "mode", iZzd != 1 ? iZzd != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        y(sb, 3);
                        sb.append("}\n");
                    }
                    y(sb, 2);
                    sb.append("}\n");
                }
                List<zziu> listZzf = zzidVar.zzf();
                if (listZzf != null) {
                    for (zziu zziuVar : listZzf) {
                        if (zziuVar != null) {
                            y(sb, 2);
                            sb.append("user_property {\n");
                            E(sb, 2, "set_timestamp_millis", zziuVar.zza() ? Long.valueOf(zziuVar.zzb()) : null);
                            E(sb, 2, "name", c0658q3.D().c(zziuVar.zzc()));
                            E(sb, 2, "string_value", zziuVar.zze());
                            E(sb, 2, "int_value", zziuVar.zzf() ? Long.valueOf(zziuVar.zzg()) : null);
                            E(sb, 2, "double_value", zziuVar.zzj() ? Double.valueOf(zziuVar.zzk()) : null);
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzhg> listZzS = zzidVar.zzS();
                if (listZzS != null) {
                    for (zzhg zzhgVar : listZzS) {
                        if (zzhgVar != null) {
                            y(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzhgVar.zza()) {
                                E(sb, 2, "audience_id", Integer.valueOf(zzhgVar.zzb()));
                            }
                            if (zzhgVar.zzf()) {
                                E(sb, 2, "new_audience", Boolean.valueOf(zzhgVar.zzg()));
                            }
                            D(sb, 2, "current_data", zzhgVar.zzc());
                            if (zzhgVar.zzd()) {
                                D(sb, 2, "previous_data", zzhgVar.zze());
                            }
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzhs> listZzc = zzidVar.zzc();
                if (listZzc != null) {
                    for (zzhs zzhsVar : listZzc) {
                        if (zzhsVar != null) {
                            y(sb, 2);
                            sb.append("event {\n");
                            E(sb, 2, "name", c0658q3.D().a(zzhsVar.zzd()));
                            if (zzhsVar.zze()) {
                                E(sb, 2, "timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                            }
                            if (zzhsVar.zzg()) {
                                E(sb, 2, "previous_timestamp_millis", Long.valueOf(zzhsVar.zzh()));
                            }
                            if (zzhsVar.zzi()) {
                                E(sb, 2, "count", Integer.valueOf(zzhsVar.zzj()));
                            }
                            if (zzhsVar.zzb() != 0) {
                                w(sb, 2, zzhsVar.zza());
                            }
                            y(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                y(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    public final String L(zzff zzffVar) {
        if (zzffVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzffVar.zza()) {
            E(sb, 0, "filter_id", Integer.valueOf(zzffVar.zzb()));
        }
        E(sb, 0, "event_name", this.f4245a.D().a(zzffVar.zzc()));
        String strA = A(zzffVar.zzi(), zzffVar.zzj(), zzffVar.zzm());
        if (!strA.isEmpty()) {
            E(sb, 0, "filter_type", strA);
        }
        if (zzffVar.zzg()) {
            F(sb, 1, "event_count_filter", zzffVar.zzh());
        }
        if (zzffVar.zze() > 0) {
            sb.append("  filters {\n");
            Iterator it = zzffVar.zzd().iterator();
            while (it.hasNext()) {
                x(sb, 2, (zzfh) it.next());
            }
        }
        y(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    public final String M(zzfn zzfnVar) {
        if (zzfnVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzfnVar.zza()) {
            E(sb, 0, "filter_id", Integer.valueOf(zzfnVar.zzb()));
        }
        E(sb, 0, "property_name", this.f4245a.D().c(zzfnVar.zzc()));
        String strA = A(zzfnVar.zze(), zzfnVar.zzf(), zzfnVar.zzh());
        if (!strA.isEmpty()) {
            E(sb, 0, "filter_type", strA);
        }
        x(sb, 1, zzfnVar.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    public final Parcelable N(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (b.a unused) {
                this.f4245a.a().o().a("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final List R(List list, List list2) {
        int i4;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.f4245a.a().r().b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    this.f4245a.a().r().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i5 = size2;
            i4 = size;
            size = i5;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i4);
    }

    public final boolean S(long j4, long j5) {
        return j4 == 0 || j5 <= 0 || Math.abs(this.f4245a.f().currentTimeMillis() - j4) > j5;
    }

    public final long T(byte[] bArr) {
        AbstractC0940s.k(bArr);
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.C().h();
        MessageDigest messageDigestC = l7.C();
        if (messageDigestC != null) {
            return l7.D(messageDigestC.digest(bArr));
        }
        c0658q3.a().o().a("Failed to get MD5");
        return 0L;
    }

    public final long U(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return T(str.getBytes(Charset.forName("UTF-8")));
    }

    public final byte[] V(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e4) {
            this.f4245a.a().o().b("Failed to gzip content", e4);
            throw e4;
        }
    }

    public final Map Z(Bundle bundle, boolean z4) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z5 = obj instanceof Parcelable[];
            if (z5 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z4) {
                    ArrayList arrayList = new ArrayList();
                    if (z5) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(Z((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            Object obj2 = arrayList2.get(i4);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(Z((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(Z((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    @Override // S1.M6
    public final boolean l() {
        return false;
    }

    public final J m(zzaa zzaaVar) {
        Object obj;
        Bundle bundleN = n(zzaaVar.zzf(), true);
        String string = (!bundleN.containsKey("_o") || (obj = bundleN.get("_o")) == null) ? "app" : obj.toString();
        String strB = AbstractC0539b4.b(zzaaVar.zzb());
        if (strB == null) {
            strB = zzaaVar.zzb();
        }
        return new J(strB, new H(bundleN), string, zzaaVar.zza());
    }

    public final Bundle n(Map map, boolean z4) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z4) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList2.add(n((Map) arrayList.get(i4), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public final void w(StringBuilder sb, int i4, List list) {
        if (list == null) {
            return;
        }
        int i5 = i4 + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzhw zzhwVar = (zzhw) it.next();
            if (zzhwVar != null) {
                y(sb, i5);
                sb.append("param {\n");
                E(sb, i5, "name", zzhwVar.zza() ? this.f4245a.D().b(zzhwVar.zzb()) : null);
                E(sb, i5, "string_value", zzhwVar.zzc() ? zzhwVar.zzd() : null);
                E(sb, i5, "int_value", zzhwVar.zze() ? Long.valueOf(zzhwVar.zzf()) : null);
                E(sb, i5, "double_value", zzhwVar.zzi() ? Double.valueOf(zzhwVar.zzj()) : null);
                if (zzhwVar.zzm() > 0) {
                    w(sb, i5, zzhwVar.zzk());
                }
                y(sb, i5);
                sb.append("}\n");
            }
        }
    }

    public final void x(StringBuilder sb, int i4, zzfh zzfhVar) {
        String str;
        if (zzfhVar == null) {
            return;
        }
        y(sb, i4);
        sb.append("filter {\n");
        if (zzfhVar.zze()) {
            E(sb, i4, "complement", Boolean.valueOf(zzfhVar.zzf()));
        }
        if (zzfhVar.zzg()) {
            E(sb, i4, "param_name", this.f4245a.D().b(zzfhVar.zzh()));
        }
        if (zzfhVar.zza()) {
            int i5 = i4 + 1;
            zzfr zzfrVarZzb = zzfhVar.zzb();
            if (zzfrVarZzb != null) {
                y(sb, i5);
                sb.append("string_filter {\n");
                if (zzfrVarZzb.zza()) {
                    switch (zzfrVarZzb.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    E(sb, i5, "match_type", str);
                }
                if (zzfrVarZzb.zzb()) {
                    E(sb, i5, "expression", zzfrVarZzb.zzc());
                }
                if (zzfrVarZzb.zzd()) {
                    E(sb, i5, "case_sensitive", Boolean.valueOf(zzfrVarZzb.zze()));
                }
                if (zzfrVarZzb.zzg() > 0) {
                    y(sb, i4 + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : zzfrVarZzb.zzf()) {
                        y(sb, i4 + 3);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                y(sb, i5);
                sb.append("}\n");
            }
        }
        if (zzfhVar.zzc()) {
            F(sb, i4 + 1, "number_filter", zzfhVar.zzd());
        }
        y(sb, i4);
        sb.append("}\n");
    }
}
