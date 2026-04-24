package i2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zziy;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzmq;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import u.C2736a;
import u.C2740e;

/* JADX INFO: renamed from: i2.d3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1794d3 extends M6 implements InterfaceC1854l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f15599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f15600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f15601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f15602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f15603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f15604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C2740e f15605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zzr f15606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f15607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f15608m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f15609n;

    public C1794d3(b7 b7Var) {
        super(b7Var);
        this.f15599d = new C2736a();
        this.f15600e = new C2736a();
        this.f15601f = new C2736a();
        this.f15602g = new C2736a();
        this.f15603h = new C2736a();
        this.f15607l = new C2736a();
        this.f15608m = new C2736a();
        this.f15609n = new C2736a();
        this.f15604i = new C2736a();
        this.f15605j = new W2(this, 20);
        this.f15606k = new X2(this);
    }

    public static final Map u(zzgl zzglVar) {
        C2736a c2736a = new C2736a();
        if (zzglVar != null) {
            for (zzgt zzgtVar : zzglVar.zze()) {
                c2736a.put(zzgtVar.zza(), zzgtVar.zzb());
            }
        }
        return c2736a;
    }

    public static final Z3 v(int i7) {
        int i8 = i7 - 1;
        if (i8 == 1) {
            return Z3.AD_STORAGE;
        }
        if (i8 == 2) {
            return Z3.ANALYTICS_STORAGE;
        }
        if (i8 == 3) {
            return Z3.AD_USER_DATA;
        }
        if (i8 != 4) {
            return null;
        }
        return Z3.AD_PERSONALIZATION;
    }

    public final void A(String str) {
        h();
        this.f15608m.put(str, null);
    }

    public final void B(String str) {
        h();
        this.f15603h.remove(str);
    }

    public final boolean C(String str, byte[] bArr, String str2, String str3) {
        j();
        h();
        AbstractC1207s.e(str);
        zzgk zzgkVar = (zzgk) t(str, bArr).zzcl();
        r(str, zzgkVar);
        s(str, (zzgl) zzgkVar.zzbc());
        this.f15603h.put(str, (zzgl) zzgkVar.zzbc());
        this.f15607l.put(str, zzgkVar.zzh());
        this.f15608m.put(str, str2);
        this.f15609n.put(str, str3);
        this.f15599d.put(str, u((zzgl) zzgkVar.zzbc()));
        this.f15114b.F0().c0(str, new ArrayList(zzgkVar.zzd()));
        try {
            zzgkVar.zze();
            bArr = ((zzgl) zzgkVar.zzbc()).zzcc();
        } catch (RuntimeException e7) {
            this.f15404a.a().r().c("Unable to serialize reduced-size config. Storing full config instead. appId", C2.x(str), e7);
        }
        C1950x c1950xF0 = this.f15114b.F0();
        AbstractC1207s.e(str);
        c1950xF0.h();
        c1950xF0.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (c1950xF0.w0().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                c1950xF0.f15404a.a().o().b("Failed to update remote config (got 0). appId", C2.x(str));
            }
        } catch (SQLiteException e8) {
            c1950xF0.f15404a.a().o().c("Error storing remote config. appId", C2.x(str), e8);
        }
        zzgkVar.zzf();
        this.f15603h.put(str, (zzgl) zzgkVar.zzbc());
        return true;
    }

    public final boolean D(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        q(str);
        if (H(str) && l7.N(str2)) {
            return true;
        }
        if (I(str) && l7.r0(str2)) {
            return true;
        }
        Map map = (Map) this.f15601f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean E(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        q(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f15602g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final Set F(String str) {
        h();
        q(str);
        return (Set) this.f15600e.get(str);
    }

    public final int G(String str, String str2) throws Throwable {
        Integer num;
        h();
        q(str);
        Map map = (Map) this.f15604i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean H(String str) {
        return "1".equals(d(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean I(String str) {
        return "1".equals(d(str, "measurement.upload.blacklist_public"));
    }

    public final boolean J(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f15600e;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("device_model") || ((Set) map.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean K(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f15600e;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("os_version") || ((Set) map.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean L(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f15600e;
        return map.get(str) != null && ((Set) map.get(str)).contains("user_id");
    }

    public final boolean M(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f15600e;
        return map.get(str) != null && ((Set) map.get(str)).contains("google_signals");
    }

    public final boolean N(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f15600e;
        return map.get(str) != null && ((Set) map.get(str)).contains("app_instance_id");
    }

    public final boolean O(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f15600e;
        return map.get(str) != null && ((Set) map.get(str)).contains("enhanced_user_id");
    }

    public final boolean P(String str, Z3 z32) throws Throwable {
        h();
        q(str);
        zzgf zzgfVarR = R(str);
        if (zzgfVarR == null) {
            return false;
        }
        Iterator it = zzgfVarR.zza().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfu zzfuVar = (zzfu) it.next();
            if (z32 == v(zzfuVar.zzb())) {
                if (zzfuVar.zzc() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Z3 Q(String str, Z3 z32) {
        h();
        q(str);
        zzgf zzgfVarR = R(str);
        if (zzgfVarR == null) {
            return null;
        }
        for (zzfw zzfwVar : zzgfVarR.zzb()) {
            if (z32 == v(zzfwVar.zzb())) {
                return v(zzfwVar.zzc());
            }
        }
        return null;
    }

    public final zzgf R(String str) {
        h();
        q(str);
        zzgl zzglVarW = w(str);
        if (zzglVarW == null || !zzglVarW.zzn()) {
            return null;
        }
        return zzglVarW.zzo();
    }

    public final boolean S(String str) {
        h();
        q(str);
        zzgf zzgfVarR = R(str);
        return zzgfVarR == null || !zzgfVarR.zzd() || zzgfVarR.zze();
    }

    public final SortedSet T(String str) {
        h();
        q(str);
        TreeSet treeSet = new TreeSet();
        zzgf zzgfVarR = R(str);
        if (zzgfVarR != null) {
            Iterator it = zzgfVarR.zzc().iterator();
            while (it.hasNext()) {
                treeSet.add(((zzgc) it.next()).zza());
            }
        }
        return treeSet;
    }

    @Override // i2.InterfaceC1854l
    public final String d(String str, String str2) throws Throwable {
        h();
        q(str);
        Map map = (Map) this.f15599d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // i2.M6
    public final boolean l() {
        return false;
    }

    public final X3 m(String str, Z3 z32) {
        h();
        q(str);
        zzgf zzgfVarR = R(str);
        if (zzgfVarR == null) {
            return X3.UNINITIALIZED;
        }
        for (zzfu zzfuVar : zzgfVarR.zzf()) {
            if (v(zzfuVar.zzb()) == z32) {
                int iZzc = zzfuVar.zzc() - 1;
                return iZzc != 1 ? iZzc != 2 ? X3.UNINITIALIZED : X3.DENIED : X3.GRANTED;
            }
        }
        return X3.UNINITIALIZED;
    }

    public final boolean n(String str) throws Throwable {
        h();
        q(str);
        zzgf zzgfVarR = R(str);
        if (zzgfVarR == null) {
            return false;
        }
        for (zzfu zzfuVar : zzgfVarR.zza()) {
            if (zzfuVar.zzb() == 3 && zzfuVar.zzd() == 3) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ zzc o(String str) throws Throwable {
        j();
        AbstractC1207s.e(str);
        C1902r c1902rP0 = this.f15114b.F0().P0(str);
        if (c1902rP0 == null) {
            return null;
        }
        this.f15404a.a().w().b("Populate EES config from database on cache miss. appId", str);
        s(str, t(str, c1902rP0.f16051a));
        return (zzc) this.f15605j.snapshot().get(str);
    }

    public final /* synthetic */ Map p() {
        return this.f15599d;
    }

    public final void q(String str) throws Throwable {
        j();
        h();
        AbstractC1207s.e(str);
        Map map = this.f15603h;
        if (map.get(str) == null) {
            C1902r c1902rP0 = this.f15114b.F0().P0(str);
            if (c1902rP0 != null) {
                zzgk zzgkVar = (zzgk) t(str, c1902rP0.f16051a).zzcl();
                r(str, zzgkVar);
                this.f15599d.put(str, u((zzgl) zzgkVar.zzbc()));
                map.put(str, (zzgl) zzgkVar.zzbc());
                s(str, (zzgl) zzgkVar.zzbc());
                this.f15607l.put(str, zzgkVar.zzh());
                this.f15608m.put(str, c1902rP0.f16052b);
                this.f15609n.put(str, c1902rP0.f16053c);
                return;
            }
            this.f15599d.put(str, null);
            this.f15601f.put(str, null);
            this.f15600e.put(str, null);
            this.f15602g.put(str, null);
            map.put(str, null);
            this.f15607l.put(str, null);
            this.f15608m.put(str, null);
            this.f15609n.put(str, null);
            this.f15604i.put(str, null);
        }
    }

    public final void r(String str, zzgk zzgkVar) {
        HashSet hashSet = new HashSet();
        C2736a c2736a = new C2736a();
        C2736a c2736a2 = new C2736a();
        C2736a c2736a3 = new C2736a();
        Iterator it = zzgkVar.zzg().iterator();
        while (it.hasNext()) {
            hashSet.add(((zzgh) it.next()).zza());
        }
        for (int i7 = 0; i7 < zzgkVar.zza(); i7++) {
            zzgi zzgiVar = (zzgi) zzgkVar.zzb(i7).zzcl();
            if (zzgiVar.zza().isEmpty()) {
                this.f15404a.a().r().a("EventConfig contained null event name");
            } else {
                String strZza = zzgiVar.zza();
                String strB = AbstractC1779b4.b(zzgiVar.zza());
                if (!TextUtils.isEmpty(strB)) {
                    zzgiVar.zzb(strB);
                    zzgkVar.zzc(i7, zzgiVar);
                }
                if (zzgiVar.zzc() && zzgiVar.zzd()) {
                    c2736a.put(strZza, Boolean.TRUE);
                }
                if (zzgiVar.zze() && zzgiVar.zzf()) {
                    c2736a2.put(zzgiVar.zza(), Boolean.TRUE);
                }
                if (zzgiVar.zzg()) {
                    if (zzgiVar.zzh() < 2 || zzgiVar.zzh() > 65535) {
                        this.f15404a.a().r().c("Invalid sampling rate. Event name, sample rate", zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    } else {
                        c2736a3.put(zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    }
                }
            }
        }
        this.f15600e.put(str, hashSet);
        this.f15601f.put(str, c2736a);
        this.f15602g.put(str, c2736a2);
        this.f15604i.put(str, c2736a3);
    }

    public final void s(final String str, zzgl zzglVar) {
        if (zzglVar.zzj() == 0) {
            this.f15605j.remove(str);
            return;
        }
        C1898q3 c1898q3 = this.f15404a;
        c1898q3.a().w().b("EES programs found", Integer.valueOf(zzglVar.zzj()));
        zzja zzjaVar = (zzja) zzglVar.zzi().get(0);
        try {
            zzc zzcVar = new zzc();
            zzcVar.zza("internal.remoteConfig", new Callable() { // from class: i2.c3
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new zzn("internal.remoteConfig", new Y2(this.f15584a, str));
                }
            });
            zzcVar.zza("internal.appMetadata", new Callable() { // from class: i2.Z2
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    final C1794d3 c1794d3 = this.f15473a;
                    final String str2 = str;
                    return new zzu("internal.appMetadata", new Callable() { // from class: i2.b3
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            C1794d3 c1794d32 = c1794d3;
                            C1950x c1950xF0 = c1794d32.f15114b.F0();
                            String str3 = str2;
                            J2 j2L0 = c1950xF0.L0(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            c1794d32.f15404a.w().A();
                            map.put("gmp_version", 130000L);
                            if (j2L0 != null) {
                                String strD0 = j2L0.D0();
                                if (strD0 != null) {
                                    map.put("app_version", strD0);
                                }
                                map.put("app_version_int", Long.valueOf(j2L0.F0()));
                                map.put("dynamite_version", Long.valueOf(j2L0.b()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzcVar.zza("internal.logger", new Callable() { // from class: i2.a3
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new zzt(this.f15493a.f15606k);
                }
            });
            zzcVar.zzf(zzjaVar);
            this.f15605j.put(str, zzcVar);
            c1898q3.a().w().c("EES program loaded for appId, activities", str, Integer.valueOf(zzjaVar.zzb().zzb()));
            Iterator it = zzjaVar.zzb().zza().iterator();
            while (it.hasNext()) {
                c1898q3.a().w().b("EES program activity", ((zziy) it.next()).zza());
            }
        } catch (zzd unused) {
            this.f15404a.a().o().b("Failed to load EES program. appId", str);
        }
    }

    public final zzgl t(String str, byte[] bArr) {
        if (bArr == null) {
            return zzgl.zzs();
        }
        try {
            zzgl zzglVar = (zzgl) ((zzgk) g7.W(zzgl.zzr(), bArr)).zzbc();
            this.f15404a.a().w().c("Parsed config. version, gmp_app_id", zzglVar.zza() ? Long.valueOf(zzglVar.zzb()) : null, zzglVar.zzc() ? zzglVar.zzd() : null);
            return zzglVar;
        } catch (zzmq e7) {
            this.f15404a.a().r().c("Unable to merge remote config. appId", C2.x(str), e7);
            return zzgl.zzs();
        } catch (RuntimeException e8) {
            this.f15404a.a().r().c("Unable to merge remote config. appId", C2.x(str), e8);
            return zzgl.zzs();
        }
    }

    public final zzgl w(String str) {
        j();
        h();
        AbstractC1207s.e(str);
        q(str);
        return (zzgl) this.f15603h.get(str);
    }

    public final String x(String str) {
        h();
        q(str);
        return (String) this.f15607l.get(str);
    }

    public final String y(String str) {
        h();
        return (String) this.f15608m.get(str);
    }

    public final String z(String str) {
        h();
        return (String) this.f15609n.get(str);
    }
}
