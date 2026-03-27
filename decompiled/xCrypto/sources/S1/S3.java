package S1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzmq;
import com.google.firebase.messaging.Constants;
import io.flutter.plugins.firebase.analytics.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import z1.AbstractC1993k;
import z1.C1994l;

/* JADX INFO: loaded from: classes.dex */
public final class S3 extends AbstractBinderC0585h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7 f4233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f4234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4235c;

    public S3(b7 b7Var, String str) {
        AbstractC0940s.k(b7Var);
        this.f4233a = b7Var;
        this.f4235c = null;
    }

    @Override // S1.InterfaceC0601j2
    public final List C(String str, String str2, n7 n7Var) {
        g0(n7Var, false);
        String str3 = n7Var.f4788a;
        AbstractC0940s.k(str3);
        try {
            return (List) this.f4233a.b().r(new CallableC0729z3(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e4) {
            this.f4233a.a().o().b("Failed to get conditional user properties", e4);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // S1.InterfaceC0601j2
    public final void D(n7 n7Var) {
        AbstractC0940s.e(n7Var.f4788a);
        AbstractC0940s.k(n7Var.f4806s);
        b(new D3(this, n7Var));
    }

    @Override // S1.InterfaceC0601j2
    public final void E(h7 h7Var, n7 n7Var) {
        AbstractC0940s.k(h7Var);
        g0(n7Var, false);
        k0(new I3(this, h7Var, n7Var));
    }

    @Override // S1.InterfaceC0601j2
    public final void G(C0590i c0590i, n7 n7Var) {
        AbstractC0940s.k(c0590i);
        AbstractC0940s.k(c0590i.f4669c);
        g0(n7Var, false);
        C0590i c0590i2 = new C0590i(c0590i);
        c0590i2.f4667a = n7Var.f4788a;
        k0(new RunnableC0697v3(this, c0590i2, n7Var));
    }

    @Override // S1.InterfaceC0601j2
    public final void I(final n7 n7Var, final C0574g c0574g) {
        g0(n7Var, false);
        k0(new Runnable() { // from class: S1.O3
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4146a.c0(n7Var, c0574g);
            }
        });
    }

    @Override // S1.InterfaceC0601j2
    public final void L(C0590i c0590i) {
        AbstractC0940s.k(c0590i);
        AbstractC0940s.k(c0590i.f4669c);
        AbstractC0940s.e(c0590i.f4667a);
        h0(c0590i.f4667a, true);
        k0(new RunnableC0705w3(this, new C0590i(c0590i)));
    }

    @Override // S1.InterfaceC0601j2
    public final void M(final n7 n7Var) {
        AbstractC0940s.e(n7Var.f4788a);
        AbstractC0940s.k(n7Var.f4806s);
        b(new Runnable() { // from class: S1.R3
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4221a.c(n7Var);
            }
        });
    }

    @Override // S1.InterfaceC0601j2
    public final List P(String str, String str2, boolean z4, n7 n7Var) {
        g0(n7Var, false);
        String str3 = n7Var.f4788a;
        AbstractC0940s.k(str3);
        try {
            List<j7> list = (List) this.f4233a.b().r(new CallableC0713x3(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (j7 j7Var : list) {
                if (z4 || !l7.N(j7Var.f4708c)) {
                    arrayList.add(new h7(j7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e4) {
            e = e4;
            this.f4233a.a().o().c("Failed to query user properties. appId", C2.x(n7Var.f4788a), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e5) {
            e = e5;
            this.f4233a.a().o().c("Failed to query user properties. appId", C2.x(n7Var.f4788a), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // S1.InterfaceC0601j2
    public final void Q(n7 n7Var) {
        g0(n7Var, false);
        k0(new RunnableC0673s3(this, n7Var));
    }

    @Override // S1.InterfaceC0601j2
    public final void S(J j4, String str, String str2) {
        AbstractC0940s.k(j4);
        AbstractC0940s.e(str);
        h0(str, true);
        k0(new G3(this, j4, str));
    }

    @Override // S1.InterfaceC0601j2
    public final List T(n7 n7Var, Bundle bundle) {
        g0(n7Var, false);
        AbstractC0940s.k(n7Var.f4788a);
        b7 b7Var = this.f4233a;
        if (!b7Var.B0().H(null, AbstractC0569f2.f4553Z0)) {
            try {
                return (List) this.f4233a.b().r(new K3(this, n7Var, bundle)).get();
            } catch (InterruptedException | ExecutionException e4) {
                this.f4233a.a().o().c("Failed to get trigger URIs. appId", C2.x(n7Var.f4788a), e4);
                return Collections.EMPTY_LIST;
            }
        }
        try {
            return (List) b7Var.b().s(new J3(this, n7Var, bundle)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            this.f4233a.a().o().c("Failed to get trigger URIs. appId", C2.x(n7Var.f4788a), e5);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // S1.InterfaceC0601j2
    public final void W(final n7 n7Var) {
        AbstractC0940s.e(n7Var.f4788a);
        AbstractC0940s.k(n7Var.f4806s);
        b(new Runnable() { // from class: S1.L3
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4088a.f(n7Var);
            }
        });
    }

    @Override // S1.InterfaceC0601j2
    public final void X(n7 n7Var) {
        g0(n7Var, false);
        k0(new B3(this, n7Var));
    }

    @Override // S1.InterfaceC0601j2
    public final void Y(n7 n7Var, final I6 i6, final InterfaceC0649p2 interfaceC0649p2) {
        g0(n7Var, false);
        final String str = (String) AbstractC0940s.k(n7Var.f4788a);
        this.f4233a.b().t(new Runnable() { // from class: S1.N3
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4124a.b0(str, i6, interfaceC0649p2);
            }
        });
    }

    public final /* synthetic */ void a0(n7 n7Var, Bundle bundle, InterfaceC0625m2 interfaceC0625m2, String str) {
        b7 b7Var = this.f4233a;
        b7Var.D();
        try {
            interfaceC0625m2.zze(b7Var.p0(n7Var, bundle));
        } catch (RemoteException e4) {
            this.f4233a.a().o().c("Failed to return trigger URIs for app", str, e4);
        }
    }

    public final void b(Runnable runnable) {
        AbstractC0940s.k(runnable);
        b7 b7Var = this.f4233a;
        if (b7Var.b().p()) {
            runnable.run();
        } else {
            b7Var.b().v(runnable);
        }
    }

    public final /* synthetic */ void b0(String str, I6 i6, InterfaceC0649p2 interfaceC0649p2) {
        b7 b7Var = this.f4233a;
        b7Var.D();
        b7Var.b().h();
        b7Var.O0();
        List<e7> listO = b7Var.F0().o(str, i6, ((Integer) AbstractC0569f2.f4504B.b(null)).intValue());
        ArrayList arrayList = new ArrayList();
        for (e7 e7Var : listO) {
            if (b7Var.t(str, e7Var.e())) {
                int i4 = e7Var.i();
                if (i4 > 0) {
                    if (i4 <= ((Integer) AbstractC0569f2.f4615z.b(null)).intValue()) {
                        if (b7Var.f().currentTimeMillis() >= e7Var.h() + Math.min(((Long) AbstractC0569f2.f4611x.b(null)).longValue() * (1 << (i4 - 1)), ((Long) AbstractC0569f2.f4613y.b(null)).longValue())) {
                        }
                    }
                    b7Var.a().w().d("[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis", str, Long.valueOf(e7Var.c()), Long.valueOf(e7Var.h()));
                }
                G6 g6B = e7Var.b();
                try {
                    zzhz zzhzVar = (zzhz) g7.W(zzib.zzh(), g6B.f3977b);
                    for (int i5 = 0; i5 < zzhzVar.zzb(); i5++) {
                        zzic zzicVar = (zzic) zzhzVar.zzc(i5).zzcl();
                        zzicVar.zzs(b7Var.f().currentTimeMillis());
                        zzhzVar.zzd(i5, zzicVar);
                    }
                    g6B.f3977b = ((zzib) zzhzVar.zzbc()).zzcc();
                    if (Log.isLoggable(b7Var.a().z(), 2)) {
                        g6B.f3982g = b7Var.K0().K((zzib) zzhzVar.zzbc());
                    }
                    arrayList.add(g6B);
                } catch (zzmq unused) {
                    b7Var.a().r().b("Failed to parse queued batch. appId", str);
                }
            } else {
                b7Var.a().w().d("[sgtm] batch skipped due to destination in backoff. appId, rowId, url", str, Long.valueOf(e7Var.c()), e7Var.e());
            }
        }
        K6 k6 = new K6(arrayList);
        try {
            interfaceC0649p2.v(k6);
            this.f4233a.a().w().c("[sgtm] Sending queued upload batches to client. appId, count", str, Integer.valueOf(k6.f4079a.size()));
        } catch (RemoteException e4) {
            this.f4233a.a().o().c("[sgtm] Failed to return upload batches for app", str, e4);
        }
    }

    public final /* synthetic */ void c(n7 n7Var) {
        b7 b7Var = this.f4233a;
        b7Var.D();
        b7Var.P0(n7Var);
    }

    public final /* synthetic */ void c0(n7 n7Var, C0574g c0574g) {
        b7 b7Var = this.f4233a;
        b7Var.D();
        b7Var.q0((String) AbstractC0940s.k(n7Var.f4788a), c0574g);
    }

    @Override // S1.InterfaceC0601j2
    public final List d(String str, String str2, String str3, boolean z4) {
        h0(str, true);
        try {
            List<j7> list = (List) this.f4233a.b().r(new CallableC0721y3(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (j7 j7Var : list) {
                if (z4 || !l7.N(j7Var.f4708c)) {
                    arrayList.add(new h7(j7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e4) {
            e = e4;
            this.f4233a.a().o().c("Failed to get user properties as. appId", C2.x(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e5) {
            e = e5;
            this.f4233a.a().o().c("Failed to get user properties as. appId", C2.x(str), e);
            return Collections.EMPTY_LIST;
        }
    }

    public final /* synthetic */ void d0(Bundle bundle, String str, n7 n7Var) {
        b7 b7Var = this.f4233a;
        boolean zH = b7Var.B0().H(null, AbstractC0569f2.f4547W0);
        if (bundle.isEmpty() && zH) {
            C0709x c0709xF0 = this.f4233a.F0();
            c0709xF0.h();
            c0709xF0.j();
            try {
                c0709xF0.w0().execSQL("delete from default_event_params where app_id=?", new String[]{str});
                return;
            } catch (SQLiteException e4) {
                c0709xF0.f4245a.a().o().b("Error clearing default event params", e4);
                return;
            }
        }
        C0709x c0709xF02 = b7Var.F0();
        c0709xF02.h();
        c0709xF02.j();
        byte[] bArrZzcc = c0709xF02.f3955b.K0().J(new E(c0709xF02.f4245a, "", str, "dep", 0L, 0L, bundle)).zzcc();
        C0658q3 c0658q3 = c0709xF02.f4245a;
        c0658q3.a().w().c("Saving default event parameters, appId, data size", str, Integer.valueOf(bArrZzcc.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(Constants.PARAMETERS, bArrZzcc);
        try {
            if (c0709xF02.w0().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                c0658q3.a().o().b("Failed to insert default event parameters (got -1). appId", C2.x(str));
            }
        } catch (SQLiteException e5) {
            c0709xF02.f4245a.a().o().c("Error storing default event parameters. appId", C2.x(str), e5);
        }
        b7 b7Var2 = this.f4233a;
        C0709x c0709xF03 = b7Var2.F0();
        long j4 = n7Var.f4786D;
        if (c0709xF03.J(str, j4)) {
            b7Var2.F0().K(str, Long.valueOf(j4), null, bundle);
        }
    }

    public final /* synthetic */ b7 e0() {
        return this.f4233a;
    }

    public final /* synthetic */ void f(n7 n7Var) {
        b7 b7Var = this.f4233a;
        b7Var.D();
        b7Var.Q0(n7Var);
    }

    public final void f0(J j4, n7 n7Var) {
        b7 b7Var = this.f4233a;
        b7Var.D();
        b7Var.k(j4, n7Var);
    }

    @Override // S1.InterfaceC0601j2
    public final String g(n7 n7Var) {
        g0(n7Var, false);
        return this.f4233a.o0(n7Var);
    }

    public final void g0(n7 n7Var, boolean z4) {
        AbstractC0940s.k(n7Var);
        String str = n7Var.f4788a;
        AbstractC0940s.e(str);
        h0(str, false);
        this.f4233a.N0().o(n7Var.f4789b);
    }

    public final void h0(String str, boolean z4) {
        if (TextUtils.isEmpty(str)) {
            this.f4233a.a().o().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z4) {
            try {
                if (this.f4234b == null) {
                    boolean z5 = true;
                    if (!"com.google.android.gms".equals(this.f4235c)) {
                        b7 b7Var = this.f4233a;
                        if (!G1.r.a(b7Var.e(), Binder.getCallingUid()) && !C1994l.a(b7Var.e()).c(Binder.getCallingUid())) {
                            z5 = false;
                        }
                    }
                    this.f4234b = Boolean.valueOf(z5);
                }
                if (this.f4234b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e4) {
                this.f4233a.a().o().b("Measurement Service called with invalid calling package. appId", C2.x(str));
                throw e4;
            }
        }
        if (this.f4235c == null && AbstractC1993k.k(this.f4233a.e(), Binder.getCallingUid(), str)) {
            this.f4235c = str;
        }
        if (str.equals(this.f4235c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // S1.InterfaceC0601j2
    public final List i(n7 n7Var, boolean z4) {
        g0(n7Var, false);
        String str = n7Var.f4788a;
        AbstractC0940s.k(str);
        try {
            List<j7> list = (List) this.f4233a.b().r(new CallableC0665r3(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (j7 j7Var : list) {
                if (z4 || !l7.N(j7Var.f4708c)) {
                    arrayList.add(new h7(j7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e4) {
            e = e4;
            this.f4233a.a().o().c("Failed to get user properties. appId", C2.x(n7Var.f4788a), e);
            return null;
        } catch (ExecutionException e5) {
            e = e5;
            this.f4233a.a().o().c("Failed to get user properties. appId", C2.x(n7Var.f4788a), e);
            return null;
        }
    }

    public final void i0(J j4, n7 n7Var) {
        b7 b7Var = this.f4233a;
        C0554d3 c0554d3D0 = b7Var.D0();
        String str = n7Var.f4788a;
        zzc zzcVar = TextUtils.isEmpty(str) ? null : (zzc) c0554d3D0.f4446j.get(str);
        if (zzcVar == null) {
            this.f4233a.a().w().b("EES not loaded for", n7Var.f4788a);
            f0(j4, n7Var);
            return;
        }
        try {
            Map mapZ = b7Var.K0().Z(j4.f4006b.o(), true);
            String str2 = j4.f4005a;
            String strA = AbstractC0539b4.a(str2);
            if (strA != null) {
                str2 = strA;
            }
            if (zzcVar.zzb(new zzaa(str2, j4.f4008d, mapZ))) {
                if (zzcVar.zzc()) {
                    b7 b7Var2 = this.f4233a;
                    b7Var2.a().w().b("EES edited event", j4.f4005a);
                    f0(b7Var2.K0().m(zzcVar.zze().zzc()), n7Var);
                } else {
                    f0(j4, n7Var);
                }
                if (zzcVar.zzd()) {
                    for (zzaa zzaaVar : zzcVar.zze().zzf()) {
                        b7 b7Var3 = this.f4233a;
                        b7Var3.a().w().b("EES logging created event", zzaaVar.zzb());
                        f0(b7Var3.K0().m(zzaaVar), n7Var);
                    }
                    return;
                }
                return;
            }
        } catch (zzd unused) {
            this.f4233a.a().o().c("EES error. appId, eventName", n7Var.f4789b, j4.f4005a);
        }
        this.f4233a.a().w().b("EES was not applied to event", j4.f4005a);
        f0(j4, n7Var);
    }

    public final J j0(J j4, n7 n7Var) {
        H h4;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(j4.f4005a) && (h4 = j4.f4006b) != null && h4.n() != 0) {
            String strM = h4.m("_cis");
            if ("referrer broadcast".equals(strM) || "referrer API".equals(strM)) {
                this.f4233a.a().u().b("Event has been filtered ", j4.toString());
                return new J("_cmpx", h4, j4.f4007c, j4.f4008d);
            }
        }
        return j4;
    }

    @Override // S1.InterfaceC0601j2
    public final void k(n7 n7Var) {
        g0(n7Var, false);
        k0(new RunnableC0681t3(this, n7Var));
    }

    public final void k0(Runnable runnable) {
        AbstractC0940s.k(runnable);
        b7 b7Var = this.f4233a;
        if (b7Var.b().p()) {
            runnable.run();
        } else {
            b7Var.b().t(runnable);
        }
    }

    @Override // S1.InterfaceC0601j2
    public final void l(long j4, String str, String str2, String str3) {
        k0(new RunnableC0689u3(this, str2, str3, str, j4));
    }

    @Override // S1.InterfaceC0601j2
    public final byte[] o(J j4, String str) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(j4);
        h0(str, true);
        b7 b7Var = this.f4233a;
        A2 a2V = b7Var.a().v();
        C0696v2 c0696v2M0 = b7Var.M0();
        String str2 = j4.f4005a;
        a2V.b("Log and bundle. event", c0696v2M0.a(str2));
        long jB = b7Var.f().b() / 1000000;
        try {
            byte[] bArr = (byte[]) b7Var.b().s(new H3(this, j4, str)).get();
            if (bArr == null) {
                b7Var.a().o().b("Log and bundle returned null. appId", C2.x(str));
                bArr = new byte[0];
            }
            b7Var.a().v().d("Log and bundle processed. event, size, time_ms", b7Var.M0().a(str2), Integer.valueOf(bArr.length), Long.valueOf((b7Var.f().b() / 1000000) - jB));
            return bArr;
        } catch (InterruptedException e4) {
            e = e4;
            b7 b7Var2 = this.f4233a;
            b7Var2.a().o().d("Failed to log and bundle. appId, event, error", C2.x(str), b7Var2.M0().a(j4.f4005a), e);
            return null;
        } catch (ExecutionException e5) {
            e = e5;
            b7 b7Var22 = this.f4233a;
            b7Var22.a().o().d("Failed to log and bundle. appId, event, error", C2.x(str), b7Var22.M0().a(j4.f4005a), e);
            return null;
        }
    }

    @Override // S1.InterfaceC0601j2
    public final void p(final n7 n7Var, final Bundle bundle, final InterfaceC0625m2 interfaceC0625m2) {
        g0(n7Var, false);
        final String str = (String) AbstractC0940s.k(n7Var.f4788a);
        this.f4233a.b().t(new Runnable() { // from class: S1.M3
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4101a.a0(n7Var, bundle, interfaceC0625m2, str);
            }
        });
    }

    @Override // S1.InterfaceC0601j2
    public final void r(n7 n7Var) {
        String str = n7Var.f4788a;
        AbstractC0940s.e(str);
        h0(str, false);
        k0(new C3(this, n7Var));
    }

    @Override // S1.InterfaceC0601j2
    public final void s(J j4, n7 n7Var) {
        AbstractC0940s.k(j4);
        g0(n7Var, false);
        k0(new F3(this, j4, n7Var));
    }

    @Override // S1.InterfaceC0601j2
    public final void t(final Bundle bundle, final n7 n7Var) {
        g0(n7Var, false);
        final String str = n7Var.f4788a;
        AbstractC0940s.k(str);
        k0(new Runnable() { // from class: S1.Q3
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4205a.d0(bundle, str, n7Var);
            }
        });
    }

    @Override // S1.InterfaceC0601j2
    public final List u(String str, String str2, String str3) {
        h0(str, true);
        try {
            return (List) this.f4233a.b().r(new A3(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e4) {
            this.f4233a.a().o().b("Failed to get conditional user properties as", e4);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // S1.InterfaceC0601j2
    public final C0646p x(n7 n7Var) {
        g0(n7Var, false);
        AbstractC0940s.e(n7Var.f4788a);
        try {
            return (C0646p) this.f4233a.b().s(new E3(this, n7Var)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e4) {
            this.f4233a.a().o().c("Failed to get consent. appId", C2.x(n7Var.f4788a), e4);
            return new C0646p(null);
        }
    }
}
