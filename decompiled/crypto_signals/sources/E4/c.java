package E4;

import F1.d;
import F1.e;
import N1.E;
import N1.InterfaceC0137v;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.internal.measurement.zzqa;
import com.google.android.gms.internal.measurement.zzqm;
import com.google.android.gms.internal.measurement.zzrk;
import java.util.List;
import s3.B0;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e, InterfaceC0137v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f467b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f486a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ c f468c = new c(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ c f469d = new c(5);
    public static final /* synthetic */ c e = new c(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ c f470f = new c(7);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ c f471k = new c(8);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ c f472l = new c(9);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ c f473m = new c(10);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ c f474n = new c(11);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ c f475o = new c(12);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ c f476p = new c(13);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ c f477q = new c(14);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ c f478r = new c(15);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ c f479s = new c(16);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ c f480t = new c(17);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ c f481u = new c(18);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ c f482v = new c(19);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ c f483w = new c(20);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ c f484x = new c(21);
    public static final /* synthetic */ c y = new c(22);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ c f485z = new c(23);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final /* synthetic */ c f461A = new c(24);

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final /* synthetic */ c f462B = new c(25);

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final /* synthetic */ c f463C = new c(26);

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final /* synthetic */ c f464D = new c(27);

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final /* synthetic */ c f465E = new c(28);

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final /* synthetic */ c f466F = new c(29);

    public /* synthetic */ c(int i) {
        this.f486a = i;
    }

    public static final boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // F1.e
    public d b(Context context, String str, F1.c cVar) {
        d dVar = new d();
        int iA = cVar.a(context, str);
        dVar.f488a = iA;
        if (iA != 0) {
            dVar.f490c = -1;
            return dVar;
        }
        int iC = cVar.c(context, str, true);
        dVar.f489b = iC;
        if (iC != 0) {
            dVar.f490c = 1;
        }
        return dVar;
    }

    @Override // N1.InterfaceC0137v
    public /* synthetic */ Object zza() {
        switch (this.f486a) {
            case 4:
                return new Boolean(zzpi.zzb());
            case 5:
                return new Boolean(zzqa.zza());
            case 6:
                List list = E.f1180a;
                return Boolean.valueOf(zzrk.zza());
            case 7:
                List list2 = E.f1180a;
                return zzpc.zzl();
            case 8:
                List list3 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzao());
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                List list4 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzr());
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                List list5 = E.f1180a;
                return zzpc.zzM();
            case 11:
                List list6 = E.f1180a;
                return Long.valueOf(zzpc.zzA());
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                List list7 = E.f1180a;
                return Long.valueOf(zzpc.zzL());
            case 13:
                List list8 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzO());
            case 14:
                List list9 = E.f1180a;
                return Long.valueOf(zzpc.zzQ());
            case 15:
                List list10 = E.f1180a;
                return Long.valueOf(zzpc.zzaf());
            case 16:
                List list11 = E.f1180a;
                return Long.valueOf(zzpc.zzE());
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                List list12 = E.f1180a;
                return Long.valueOf(zzpc.zzy());
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                List list13 = E.f1180a;
                return Long.valueOf(zzpc.zzag());
            case 19:
                List list14 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzas());
            case 20:
                List list15 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzo());
            case 21:
                List list16 = E.f1180a;
                return Long.valueOf(zzpc.zzH());
            case 22:
                List list17 = E.f1180a;
                return zzpc.zzg();
            case 23:
                List list18 = E.f1180a;
                return Integer.valueOf((int) zzqm.zzd());
            case 24:
                List list19 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzu());
            case 25:
                List list20 = E.f1180a;
                return Long.valueOf(zzpc.zzad());
            case 26:
                List list21 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzx());
            case 27:
                List list22 = E.f1180a;
                return zzpc.zzY();
            case 28:
                List list23 = E.f1180a;
                return zzpc.zzD();
            default:
                List list24 = E.f1180a;
                return zzpc.zzab();
        }
    }
}
