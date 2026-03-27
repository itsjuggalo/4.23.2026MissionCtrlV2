package V2;

import N1.E;
import N1.InterfaceC0137v;
import android.content.Context;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.internal.measurement.zzpx;
import com.google.android.gms.internal.measurement.zzqm;
import com.google.android.gms.internal.measurement.zzqp;
import java.util.List;
import s3.B0;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public final class f implements F1.c, F1.e, InterfaceC0137v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ f f3254b = new f(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ f f3255c = new f(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ f f3256d = new f(5);
    public static final /* synthetic */ f e = new f(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ f f3257f = new f(7);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ f f3258k = new f(8);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ f f3259l = new f(9);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ f f3260m = new f(10);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ f f3261n = new f(11);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ f f3262o = new f(12);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ f f3263p = new f(13);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ f f3264q = new f(14);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ f f3265r = new f(15);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ f f3266s = new f(16);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ f f3267t = new f(17);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ f f3268u = new f(18);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ f f3269v = new f(19);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ f f3270w = new f(20);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ f f3271x = new f(21);
    public static final /* synthetic */ f y = new f(22);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ f f3272z = new f(23);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final /* synthetic */ f f3248A = new f(24);

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final /* synthetic */ f f3249B = new f(25);

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final /* synthetic */ f f3250C = new f(26);

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final /* synthetic */ f f3251D = new f(27);

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final /* synthetic */ f f3252E = new f(28);

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final /* synthetic */ f f3253F = new f(29);

    public /* synthetic */ f(int i) {
        this.f3273a = i;
    }

    @Override // F1.c
    public int a(Context context, String str) {
        return F1.f.a(context, str);
    }

    @Override // F1.e
    public F1.d b(Context context, String str, F1.c cVar) {
        int iC;
        F1.d dVar = new F1.d();
        int iA = cVar.a(context, str);
        dVar.f488a = iA;
        int i = 1;
        int i6 = 0;
        if (iA != 0) {
            iC = cVar.c(context, str, false);
            dVar.f489b = iC;
        } else {
            iC = cVar.c(context, str, true);
            dVar.f489b = iC;
        }
        int i7 = dVar.f488a;
        if (i7 == 0) {
            if (iC == 0) {
                i = 0;
            }
            dVar.f490c = i;
            return dVar;
        }
        i6 = i7;
        if (i6 >= iC) {
            i = -1;
        }
        dVar.f490c = i;
        return dVar;
    }

    @Override // F1.c
    public int c(Context context, String str, boolean z6) {
        return F1.f.d(context, str, z6);
    }

    @Override // N1.InterfaceC0137v
    public /* synthetic */ Object zza() {
        switch (this.f3273a) {
            case 3:
                return new Boolean(zzpi.zza());
            case 4:
                return new Boolean(zzpx.zza());
            case 5:
                List list = E.f1180a;
                return Boolean.valueOf(zzqp.zzd());
            case 6:
                List list2 = E.f1180a;
                return zzpc.zze();
            case 7:
                List list3 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzal());
            case 8:
                List list4 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzaq());
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                List list5 = E.f1180a;
                return zzpc.zzn();
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                List list6 = E.f1180a;
                return Long.valueOf(zzpc.zzT());
            case 11:
                List list7 = E.f1180a;
                return Long.valueOf(zzpc.zzJ());
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                List list8 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzP());
            case 13:
                List list9 = E.f1180a;
                return Long.valueOf(zzpc.zzR());
            case 14:
                List list10 = E.f1180a;
                return Long.valueOf(zzpc.zzf());
            case 15:
                List list11 = E.f1180a;
                return Long.valueOf(zzpc.zzah());
            case 16:
                List list12 = E.f1180a;
                return Long.valueOf(zzpc.zzz());
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                List list13 = E.f1180a;
                return Long.valueOf(zzpc.zzF());
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                List list14 = E.f1180a;
                return Long.valueOf(zzpc.zzat());
            case 19:
                List list15 = E.f1180a;
                return Long.valueOf(zzpc.zzm());
            case 20:
                List list16 = E.f1180a;
                return Long.valueOf(zzpc.zzG());
            case 21:
                List list17 = E.f1180a;
                return zzqm.zzf();
            case 22:
                List list18 = E.f1180a;
                return Long.valueOf(zzqm.zzb());
            case 23:
                List list19 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzs());
            case 24:
                List list20 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzd());
            case 25:
                List list21 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzaj());
            case 26:
                List list22 = E.f1180a;
                return zzpc.zzac();
            case 27:
                List list23 = E.f1180a;
                return Long.valueOf(zzpc.zzj());
            case 28:
                List list24 = E.f1180a;
                return zzpc.zzk();
            default:
                List list25 = E.f1180a;
                return Long.valueOf(zzpc.zzZ());
        }
    }
}
