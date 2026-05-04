package com.google.android.gms.internal.p002firebaseauthapi;

import a7.g;
import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.b;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import m7.a0;
import m7.c0;
import m7.c1;
import m7.d;
import m7.e;
import m7.h;
import m7.i;
import m7.j;
import m7.o0;
import m7.p0;
import m7.r0;
import m7.u0;
import m7.v0;
import n7.k;
import n7.k1;
import n7.p;
import n7.u1;
import n7.x;
import n7.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzacq extends zzafo {
    public zzacq(g gVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzaeo(gVar, scheduledExecutorService);
        this.zzb = executor;
    }

    public final Task<Void> zza(g gVar, String str, String str2) {
        return zza((zzacp) new zzacp(str, str2).zza(gVar));
    }

    public final Task<d> zzb(g gVar, String str, String str2) {
        return zza((zzacs) new zzacs(str, str2).zza(gVar));
    }

    public final Task<u0> zzc(g gVar, String str, String str2) {
        return zza((zzacw) new zzacw(str, str2).zza(gVar));
    }

    public final Task<Void> zzd(g gVar, a0 a0Var, String str, k1 k1Var) {
        return zza((zzaeg) new zzaeg(str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(g gVar, String str, String str2, String str3) {
        return zza((zzacr) new zzacr(str, str2, str3).zza(gVar));
    }

    public final Task<Void> zzb(g gVar, a0 a0Var, h hVar, String str, k1 k1Var) {
        return zza((zzadg) new zzadg(hVar, str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<i> zzc(g gVar, a0 a0Var, h hVar, String str, k1 k1Var) {
        return zza((zzadf) new zzadf(hVar, str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<i> zza(g gVar, String str, String str2, String str3, String str4, u1 u1Var) {
        return zza((zzacu) new zzacu(str, str2, str3, str4).zza(gVar).zza(u1Var));
    }

    public final Task<String> zzd(g gVar, String str, String str2) {
        return zza((zzaek) new zzaek(str, str2).zza(gVar));
    }

    public final Task<i> zzb(g gVar, a0 a0Var, j jVar, String str, k1 k1Var) {
        return zza((zzadh) new zzadh(jVar, str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zzc(g gVar, a0 a0Var, String str, k1 k1Var) {
        return zza((zzaed) new zzaed(str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(a0 a0Var, y yVar) {
        return zza((zzact) new zzact().zza(a0Var).zza(yVar).zza((x) yVar));
    }

    public final Task<Void> zza(g gVar, p0 p0Var, a0 a0Var, String str, u1 u1Var) {
        zzagb.zza();
        zzacv zzacvVar = new zzacv(p0Var, a0Var.zze(), str, null);
        zzacvVar.zza(gVar).zza(u1Var);
        return zza(zzacvVar);
    }

    public final Task<i> zzb(g gVar, a0 a0Var, String str, String str2, String str3, String str4, k1 k1Var) {
        return zza((zzadj) new zzadj(str, str2, str3, str4).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(g gVar, v0 v0Var, a0 a0Var, String str, String str2, u1 u1Var) {
        zzacv zzacvVar = new zzacv(v0Var, a0Var.zze(), str, str2);
        zzacvVar.zza(gVar).zza(u1Var);
        return zza(zzacvVar);
    }

    public final Task<i> zzb(g gVar, a0 a0Var, o0 o0Var, String str, k1 k1Var) {
        zzagb.zza();
        return zza((zzadl) new zzadl(o0Var, str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<i> zza(g gVar, a0 a0Var, p0 p0Var, String str, u1 u1Var) {
        zzagb.zza();
        zzacy zzacyVar = new zzacy(p0Var, str, null);
        zzacyVar.zza(gVar).zza(u1Var);
        if (a0Var != null) {
            zzacyVar.zza(a0Var);
        }
        return zza(zzacyVar);
    }

    public final Task<Void> zzb(g gVar, String str, e eVar, String str2, String str3) {
        eVar.a0(6);
        return zza((zzadp) new zzadp(str, eVar, str2, str3, "sendSignInLinkToEmail").zza(gVar));
    }

    public final Task<i> zza(g gVar, a0 a0Var, v0 v0Var, String str, String str2, u1 u1Var) {
        zzacy zzacyVar = new zzacy(v0Var, str, str2);
        zzacyVar.zza(gVar).zza(u1Var);
        if (a0Var != null) {
            zzacyVar.zza(a0Var);
        }
        return zza(zzacyVar);
    }

    public final Task<i> zzb(g gVar, String str, String str2, String str3, String str4, u1 u1Var) {
        return zza((zzadw) new zzadw(str, str2, str3, str4).zza(gVar).zza(u1Var));
    }

    public final Task<c0> zza(g gVar, a0 a0Var, String str, k1 k1Var) {
        return zza((zzacx) new zzacx(str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<i> zzb(g gVar, a0 a0Var, String str, k1 k1Var) {
        s.k(gVar);
        s.e(str);
        s.k(a0Var);
        s.k(k1Var);
        List listZzg = a0Var.zzg();
        if ((listZzg != null && !listZzg.contains(str)) || a0Var.X()) {
            return Tasks.forException(zzaen.zza(new Status(17016, str)));
        }
        str.getClass();
        if (!str.equals(Constants.SIGN_IN_METHOD_PASSWORD)) {
            return zza((zzaee) new zzaee(str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
        }
        return zza((zzaeb) new zzaeb().zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<zzahr> zza() {
        return zza(new zzada());
    }

    public final Task<zzahs> zza(String str, String str2) {
        return zza(new zzacz(str, str2));
    }

    public final Task<i> zza(g gVar, a0 a0Var, h hVar, String str, k1 k1Var) {
        s.k(gVar);
        s.k(hVar);
        s.k(a0Var);
        s.k(k1Var);
        List listZzg = a0Var.zzg();
        if (listZzg != null && listZzg.contains(hVar.R())) {
            return Tasks.forException(zzaen.zza(new Status(17015)));
        }
        if (hVar instanceof j) {
            j jVar = (j) hVar;
            if (!jVar.X()) {
                return zza((zzadc) new zzadc(jVar, str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
            }
            return zza((zzadd) new zzadd(jVar).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
        }
        if (hVar instanceof o0) {
            zzagb.zza();
            return zza((zzade) new zzade((o0) hVar).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
        }
        s.k(gVar);
        s.k(hVar);
        s.k(a0Var);
        s.k(k1Var);
        return zza((zzadb) new zzadb(hVar).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(g gVar, a0 a0Var, j jVar, String str, k1 k1Var) {
        return zza((zzadi) new zzadi(jVar, str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(g gVar, a0 a0Var, String str, String str2, String str3, String str4, k1 k1Var) {
        return zza((zzadk) new zzadk(str, str2, str3, str4).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(g gVar, a0 a0Var, o0 o0Var, String str, k1 k1Var) {
        zzagb.zza();
        return zza((zzadm) new zzadm(o0Var, str).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(g gVar, a0 a0Var, k1 k1Var) {
        return zza((zzado) new zzado().zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(String str, String str2, String str3, String str4) {
        return zza(new zzadn(str, str2, str3, str4));
    }

    public final Task<Void> zza(g gVar, e eVar, String str) {
        return zza((zzadq) new zzadq(str, eVar).zza(gVar));
    }

    public final Task<Void> zza(g gVar, String str, e eVar, String str2, String str3) {
        eVar.a0(1);
        return zza((zzadp) new zzadp(str, eVar, str2, str3, "sendPasswordResetEmail").zza(gVar));
    }

    public final Task<Void> zza(String str) {
        return zza(new zzads(str));
    }

    public final Task<i> zza(g gVar, u1 u1Var, String str) {
        return zza((zzadr) new zzadr(str).zza(gVar).zza(u1Var));
    }

    public final Task<i> zza(g gVar, h hVar, String str, u1 u1Var) {
        return zza((zzadu) new zzadu(hVar, str).zza(gVar).zza(u1Var));
    }

    public final Task<i> zza(g gVar, String str, String str2, u1 u1Var) {
        return zza((zzadt) new zzadt(str, str2).zza(gVar).zza(u1Var));
    }

    public final Task<i> zza(g gVar, j jVar, String str, u1 u1Var) {
        return zza((zzadv) new zzadv(jVar, str).zza(gVar).zza(u1Var));
    }

    public final Task<i> zza(g gVar, o0 o0Var, String str, u1 u1Var) {
        zzagb.zza();
        return zza((zzady) new zzady(o0Var, str).zza(gVar).zza(u1Var));
    }

    public final Task<Void> zza(p pVar, String str, String str2, long j10, boolean z10, boolean z11, String str3, String str4, String str5, boolean z12, b.AbstractC0100b abstractC0100b, Executor executor, Activity activity) {
        zzadx zzadxVar = new zzadx(pVar, str, str2, j10, z10, z11, str3, str4, str5, z12);
        zzadxVar.zza(abstractC0100b, activity, executor, str);
        return zza(zzadxVar);
    }

    public final Task<zzair> zza(p pVar, String str) {
        return zza(new zzaea(pVar, str));
    }

    public final Task<Void> zza(p pVar, r0 r0Var, String str, long j10, boolean z10, boolean z11, String str2, String str3, String str4, boolean z12, b.AbstractC0100b abstractC0100b, Executor executor, Activity activity) {
        zzadz zzadzVar = new zzadz(r0Var, s.e(pVar.zzc()), str, j10, z10, z11, str2, str3, str4, z12);
        zzadzVar.zza(abstractC0100b, activity, executor, r0Var.a());
        return zza(zzadzVar);
    }

    public final Task<Void> zza(g gVar, a0 a0Var, String str, String str2, k1 k1Var) {
        return zza((zzaec) new zzaec(a0Var.zze(), str, str2).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(g gVar, a0 a0Var, o0 o0Var, k1 k1Var) {
        zzagb.zza();
        return zza((zzaef) new zzaef(o0Var).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(g gVar, a0 a0Var, c1 c1Var, k1 k1Var) {
        return zza((zzaei) new zzaei(c1Var).zza(gVar).zza(a0Var).zza(k1Var).zza((x) k1Var));
    }

    public final Task<Void> zza(String str, String str2, e eVar) {
        eVar.a0(7);
        return zza(new zzaeh(str, str2, eVar));
    }

    public static n7.i zza(g gVar, zzahk zzahkVar) {
        s.k(gVar);
        s.k(zzahkVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new n7.e(zzahkVar, "firebase"));
        List<zzaib> listZzl = zzahkVar.zzl();
        if (listZzl != null && !listZzl.isEmpty()) {
            for (int i10 = 0; i10 < listZzl.size(); i10++) {
                arrayList.add(new n7.e(listZzl.get(i10)));
            }
        }
        n7.i iVar = new n7.i(gVar, arrayList);
        iVar.w0(new k(zzahkVar.zzb(), zzahkVar.zza()));
        iVar.x0(zzahkVar.zzn());
        iVar.v0(zzahkVar.zze());
        iVar.s0(n7.o0.a(zzahkVar.zzk()));
        iVar.q0(zzahkVar.zzd());
        return iVar;
    }

    public final void zza(g gVar, zzaij zzaijVar, b.AbstractC0100b abstractC0100b, Activity activity, Executor executor) {
        zza((zzaej) new zzaej(zzaijVar).zza(gVar).zza(abstractC0100b, activity, executor, zzaijVar.zzd()));
    }
}
