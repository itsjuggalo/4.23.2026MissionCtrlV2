package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfr;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: renamed from: S1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0542c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f4418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f4419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f4420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f4421f;

    public AbstractC0542c(String str, int i4) {
        this.f4416a = str;
        this.f4417b = i4;
    }

    public static Boolean d(String str, int i4, boolean z4, String str2, List list, String str3, C2 c22) {
        if (i4 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z4 && i4 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i4 - 1) {
            case 1:
                if (str3 != null) {
                    try {
                    } catch (PatternSyntaxException unused) {
                        if (c22 != null) {
                            c22.r().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                        }
                        return null;
                    }
                    break;
                }
                break;
            case 6:
                if (list != null) {
                    break;
                }
                break;
        }
        return null;
    }

    public static Boolean e(Boolean bool, boolean z4) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z4);
    }

    public static Boolean f(String str, zzfr zzfrVar, C2 c22) {
        List list;
        AbstractC0940s.k(zzfrVar);
        if (str == null || !zzfrVar.zza() || zzfrVar.zzj() == 1 || (zzfrVar.zzj() != 7 ? !zzfrVar.zzb() : zzfrVar.zzg() == 0)) {
            return null;
        }
        int iZzj = zzfrVar.zzj();
        boolean zZze = zzfrVar.zze();
        String strZzc = (zZze || iZzj == 2 || iZzj == 7) ? zzfrVar.zzc() : zzfrVar.zzc().toUpperCase(Locale.ENGLISH);
        if (zzfrVar.zzg() == 0) {
            list = null;
        } else {
            List listZzf = zzfrVar.zzf();
            if (!zZze) {
                ArrayList arrayList = new ArrayList(listZzf.size());
                Iterator it = listZzf.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                listZzf = Collections.unmodifiableList(arrayList);
            }
            list = listZzf;
        }
        return d(str, iZzj, zZze, strZzc, list, iZzj == 2 ? strZzc : null, c22);
    }

    public static Boolean g(long j4, zzfl zzflVar) {
        try {
            return j(new BigDecimal(j4), zzflVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean h(double d4, zzfl zzflVar) {
        try {
            return j(new BigDecimal(d4), zzflVar, Math.ulp(d4));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean i(String str, zzfl zzflVar) {
        if (!g7.O(str)) {
            return null;
        }
        try {
            return j(new BigDecimal(str), zzflVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean j(BigDecimal bigDecimal, zzfl zzflVar, double d4) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        AbstractC0940s.k(zzflVar);
        if (zzflVar.zza()) {
            if (zzflVar.zzm() != 1) {
                if (zzflVar.zzm() == 5) {
                    if (!zzflVar.zzf() || !zzflVar.zzh()) {
                        return null;
                    }
                } else if (!zzflVar.zzd()) {
                    return null;
                }
                int iZzm = zzflVar.zzm();
                if (zzflVar.zzm() == 5) {
                    if (g7.O(zzflVar.zzg()) && g7.O(zzflVar.zzi())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzflVar.zzg());
                            bigDecimal4 = new BigDecimal(zzflVar.zzi());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!g7.O(zzflVar.zze())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(zzflVar.zze());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (iZzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i4 = iZzm - 1;
                if (i4 == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                }
                if (i4 == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
                if (i4 != 3) {
                    if (i4 == 4 && bigDecimal3 != null) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                    }
                    return null;
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (d4 != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d4).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d4).multiply(new BigDecimal(2)))) < 0);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
        }
        return null;
    }

    public abstract int a();

    public abstract boolean b();

    public abstract boolean c();
}
