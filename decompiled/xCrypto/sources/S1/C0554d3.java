package S1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import u.C1853a;
import u.C1857e;

/* JADX INFO: renamed from: S1.d3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0554d3 extends M6 implements InterfaceC0614l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f4441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f4442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f4443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f4444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f4445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C1857e f4446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zzr f4447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f4448l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f4449m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f4450n;

    public C0554d3(b7 b7Var) {
        super(b7Var);
        this.f4440d = new C1853a();
        this.f4441e = new C1853a();
        this.f4442f = new C1853a();
        this.f4443g = new C1853a();
        this.f4444h = new C1853a();
        this.f4448l = new C1853a();
        this.f4449m = new C1853a();
        this.f4450n = new C1853a();
        this.f4445i = new C1853a();
        this.f4446j = new W2(this, 20);
        this.f4447k = new X2(this);
    }

    public static final Map u(zzgl zzglVar) {
        C1853a c1853a = new C1853a();
        if (zzglVar != null) {
            for (zzgt zzgtVar : zzglVar.zze()) {
                c1853a.put(zzgtVar.zza(), zzgtVar.zzb());
            }
        }
        return c1853a;
    }

    public static final Z3 v(int i4) {
        int i5 = i4 - 1;
        if (i5 == 1) {
            return Z3.AD_STORAGE;
        }
        if (i5 == 2) {
            return Z3.ANALYTICS_STORAGE;
        }
        if (i5 == 3) {
            return Z3.AD_USER_DATA;
        }
        if (i5 != 4) {
            return null;
        }
        return Z3.AD_PERSONALIZATION;
    }

    public final void A(String str) {
        h();
        this.f4449m.put(str, null);
    }

    public final void B(String str) {
        h();
        this.f4444h.remove(str);
    }

    public final boolean C(String str, byte[] bArr, String str2, String str3) throws Throwable {
        j();
        h();
        AbstractC0940s.e(str);
        zzgk zzgkVar = (zzgk) t(str, bArr).zzcl();
        r(str, zzgkVar);
        s(str, (zzgl) zzgkVar.zzbc());
        this.f4444h.put(str, (zzgl) zzgkVar.zzbc());
        this.f4448l.put(str, zzgkVar.zzh());
        this.f4449m.put(str, str2);
        this.f4450n.put(str, str3);
        this.f4440d.put(str, u((zzgl) zzgkVar.zzbc()));
        this.f3955b.F0().c0(str, new ArrayList(zzgkVar.zzd()));
        try {
            zzgkVar.zze();
            bArr = ((zzgl) zzgkVar.zzbc()).zzcc();
        } catch (RuntimeException e4) {
            this.f4245a.a().r().c("Unable to serialize reduced-size config. Storing full config instead. appId", C2.x(str), e4);
        }
        C0709x c0709xF0 = this.f3955b.F0();
        AbstractC0940s.e(str);
        c0709xF0.h();
        c0709xF0.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (c0709xF0.w0().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                c0709xF0.f4245a.a().o().b("Failed to update remote config (got 0). appId", C2.x(str));
            }
        } catch (SQLiteException e5) {
            c0709xF0.f4245a.a().o().c("Error storing remote config. appId", C2.x(str), e5);
        }
        zzgkVar.zzf();
        this.f4444h.put(str, (zzgl) zzgkVar.zzbc());
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
        Map map = (Map) this.f4442f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean E(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        q(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = (Map) this.f4443g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final Set F(String str) {
        h();
        q(str);
        return (Set) this.f4441e.get(str);
    }

    public final int G(String str, String str2) throws Throwable {
        Integer num;
        h();
        q(str);
        Map map = (Map) this.f4445i.get(str);
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
        Map map = this.f4441e;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("device_model") || ((Set) map.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean K(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f4441e;
        if (map.get(str) != null) {
            return ((Set) map.get(str)).contains("os_version") || ((Set) map.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean L(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f4441e;
        return map.get(str) != null && ((Set) map.get(str)).contains("user_id");
    }

    public final boolean M(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f4441e;
        return map.get(str) != null && ((Set) map.get(str)).contains("google_signals");
    }

    public final boolean N(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f4441e;
        return map.get(str) != null && ((Set) map.get(str)).contains("app_instance_id");
    }

    public final boolean O(String str) throws Throwable {
        h();
        q(str);
        Map map = this.f4441e;
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

    @Override // S1.InterfaceC0614l
    public final String d(String str, String str2) throws Throwable {
        h();
        q(str);
        Map map = (Map) this.f4440d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // S1.M6
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
        AbstractC0940s.e(str);
        r rVarP0 = this.f3955b.F0().P0(str);
        if (rVarP0 == null) {
            return null;
        }
        this.f4245a.a().w().b("Populate EES config from database on cache miss. appId", str);
        s(str, t(str, rVarP0.f4892a));
        return (zzc) this.f4446j.snapshot().get(str);
    }

    public final /* synthetic */ Map p() {
        return this.f4440d;
    }

    public final void q(String str) throws Throwable {
        j();
        h();
        AbstractC0940s.e(str);
        Map map = this.f4444h;
        if (map.get(str) == null) {
            r rVarP0 = this.f3955b.F0().P0(str);
            if (rVarP0 != null) {
                zzgk zzgkVar = (zzgk) t(str, rVarP0.f4892a).zzcl();
                r(str, zzgkVar);
                this.f4440d.put(str, u((zzgl) zzgkVar.zzbc()));
                map.put(str, (zzgl) zzgkVar.zzbc());
                s(str, (zzgl) zzgkVar.zzbc());
                this.f4448l.put(str, zzgkVar.zzh());
                this.f4449m.put(str, rVarP0.f4893b);
                this.f4450n.put(str, rVarP0.f4894c);
                return;
            }
            this.f4440d.put(str, null);
            this.f4442f.put(str, null);
            this.f4441e.put(str, null);
            this.f4443g.put(str, null);
            map.put(str, null);
            this.f4448l.put(str, null);
            this.f4449m.put(str, null);
            this.f4450n.put(str, null);
            this.f4445i.put(str, null);
        }
    }

    public final void r(String str, zzgk zzgkVar) {
        HashSet hashSet = new HashSet();
        C1853a c1853a = new C1853a();
        C1853a c1853a2 = new C1853a();
        C1853a c1853a3 = new C1853a();
        Iterator it = zzgkVar.zzg().iterator();
        while (it.hasNext()) {
            hashSet.add(((zzgh) it.next()).zza());
        }
        for (int i4 = 0; i4 < zzgkVar.zza(); i4++) {
            zzgi zzgiVar = (zzgi) zzgkVar.zzb(i4).zzcl();
            if (zzgiVar.zza().isEmpty()) {
                this.f4245a.a().r().a("EventConfig contained null event name");
            } else {
                String strZza = zzgiVar.zza();
                String strB = AbstractC0539b4.b(zzgiVar.zza());
                if (!TextUtils.isEmpty(strB)) {
                    zzgiVar.zzb(strB);
                    zzgkVar.zzc(i4, zzgiVar);
                }
                if (zzgiVar.zzc() && zzgiVar.zzd()) {
                    c1853a.put(strZza, Boolean.TRUE);
                }
                if (zzgiVar.zze() && zzgiVar.zzf()) {
                    c1853a2.put(zzgiVar.zza(), Boolean.TRUE);
                }
                if (zzgiVar.zzg()) {
                    if (zzgiVar.zzh() < 2 || zzgiVar.zzh() > 65535) {
                        this.f4245a.a().r().c("Invalid sampling rate. Event name, sample rate", zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    } else {
                        c1853a3.put(zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    }
                }
            }
        }
        this.f4441e.put(str, hashSet);
        this.f4442f.put(str, c1853a);
        this.f4443g.put(str, c1853a2);
        this.f4445i.put(str, c1853a3);
    }

    public final void s(final String str, zzgl zzglVar) {
        if (zzglVar.zzj() == 0) {
            this.f4446j.remove(str);
            return;
        }
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.a().w().b("EES programs found", Integer.valueOf(zzglVar.zzj()));
        zzja zzjaVar = (zzja) zzglVar.zzi().get(0);
        try {
            zzc zzcVar = new zzc();
            zzcVar.zza("internal.remoteConfig", new Callable() { // from class: S1.c3
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new zzn("internal.remoteConfig", new Y2(this.f4425a, str));
                }
            });
            zzcVar.zza("internal.appMetadata", new Callable() { // from class: S1.Z2
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    final C0554d3 c0554d3 = this.f4314a;
                    final String str2 = str;
                    return new zzu("internal.appMetadata", new Callable() { // from class: S1.b3
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            C0554d3 c0554d32 = c0554d3;
                            C0709x c0709xF0 = c0554d32.f3955b.F0();
                            String str3 = str2;
                            J2 j2L0 = c0709xF0.L0(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            c0554d32.f4245a.w().A();
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
            zzcVar.zza("internal.logger", new Callable() { // from class: S1.a3
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new zzt(this.f4334a.f4447k);
                }
            });
            zzcVar.zzf(zzjaVar);
            this.f4446j.put(str, zzcVar);
            c0658q3.a().w().c("EES program loaded for appId, activities", str, Integer.valueOf(zzjaVar.zzb().zzb()));
            Iterator it = zzjaVar.zzb().zza().iterator();
            while (it.hasNext()) {
                c0658q3.a().w().b("EES program activity", ((zziy) it.next()).zza());
            }
        } catch (zzd unused) {
            this.f4245a.a().o().b("Failed to load EES program. appId", str);
        }
    }

    public final zzgl t(String str, byte[] bArr) {
        if (bArr == null) {
            return zzgl.zzs();
        }
        try {
            zzgl zzglVar = (zzgl) ((zzgk) g7.W(zzgl.zzr(), bArr)).zzbc();
            this.f4245a.a().w().c("Parsed config. version, gmp_app_id", zzglVar.zza() ? Long.valueOf(zzglVar.zzb()) : null, zzglVar.zzc() ? zzglVar.zzd() : null);
            return zzglVar;
        } catch (zzmq e4) {
            this.f4245a.a().r().c("Unable to merge remote config. appId", C2.x(str), e4);
            return zzgl.zzs();
        } catch (RuntimeException e5) {
            this.f4245a.a().r().c("Unable to merge remote config. appId", C2.x(str), e5);
            return zzgl.zzs();
        }
    }

    public final zzgl w(String str) {
        j();
        h();
        AbstractC0940s.e(str);
        q(str);
        return (zzgl) this.f4444h.get(str);
    }

    public final String x(String str) {
        h();
        q(str);
        return (String) this.f4448l.get(str);
    }

    public final String y(String str) {
        h();
        return (String) this.f4449m.get(str);
    }

    public final String z(String str) {
        h();
        return (String) this.f4450n.get(str);
    }
}
