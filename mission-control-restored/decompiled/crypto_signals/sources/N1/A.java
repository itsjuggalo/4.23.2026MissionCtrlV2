package N1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpl;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.internal.measurement.zzqj;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzqs;
import com.google.android.gms.internal.measurement.zzrb;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar;
import com.google.firebase.auth.FirebaseAuth;
import f2.C0596b;
import h1.InterfaceC0618a;
import h2.InterfaceC0619a;
import i2.AbstractC0669o;
import i2.C0664j;
import j2.C0723C;
import j2.C0730f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k2.C0771q;
import k2.InterfaceC0757c;
import s1.C0994k;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class A implements InterfaceC0137v, androidx.lifecycle.W, InterfaceC0757c, InterfaceC0619a, InterfaceC0618a, Continuation, n0.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ A f1091b = new A(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ A f1092c = new A(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ A f1093d = new A(2);
    public static final /* synthetic */ A e = new A(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ A f1094f = new A(4);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ A f1095k = new A(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ A f1096l = new A(6);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ A f1097m = new A(7);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ A f1098n = new A(8);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ A f1099o = new A(9);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ A f1100p = new A(10);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ A f1101q = new A(11);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ A f1102r = new A(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1103a;

    public /* synthetic */ A(int i) {
        this.f1103a = i;
    }

    public static void j(Z3.f fVar, final A a6) {
        Object obj = null;
        int i = 13;
        e3.w wVar = new e3.w(i, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.generateQrCodeUrl", fVar, new Z3.v(), obj);
        if (a6 != null) {
            final int i6 = 0;
            wVar.L(new Z3.b(a6) { // from class: e4.y

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ N1.A f6346b;

                {
                    this.f6346b = a6;
                }

                @Override // Z3.b
                public final void d(Object obj2, Y3.d dVar) {
                    switch (i6) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) obj2;
                            String str = (String) arrayList2.get(0);
                            String str2 = (String) arrayList2.get(1);
                            String str3 = (String) arrayList2.get(2);
                            this.f6346b.getClass();
                            C0723C c0723c = (C0723C) C0574m.f6323a.get(str);
                            if (str2 == null || str3 == null) {
                                FirebaseAuth firebaseAuth = c0723c.f7635g;
                                AbstractC0669o abstractC0669o = firebaseAuth.f5453f;
                                com.google.android.gms.common.internal.I.h(abstractC0669o, "Current user cannot be null, since user is required to be logged in to enroll for TOTP MFA.");
                                String str4 = ((C0730f) abstractC0669o).f7688b.f7683f;
                                com.google.android.gms.common.internal.I.e(str4, "Email cannot be empty, since verified email is required to use MFA.");
                                Z1.h hVar = firebaseAuth.f5449a;
                                hVar.a();
                                arrayList.add(0, c0723c.a(str4, hVar.f3963b));
                                dVar.f(arrayList);
                            } else {
                                arrayList.add(0, c0723c.a(str2, str3));
                                dVar.f(arrayList);
                            }
                            break;
                        default:
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = (ArrayList) obj2;
                            String str5 = (String) arrayList4.get(0);
                            String str6 = (String) arrayList4.get(1);
                            this.f6346b.getClass();
                            C0723C c0723c2 = (C0723C) C0574m.f6323a.get(str5);
                            c0723c2.getClass();
                            com.google.android.gms.common.internal.I.e(str6, "qrCodeUrl cannot be empty.");
                            try {
                                Z1.h hVar2 = c0723c2.f7635g.f5449a;
                                hVar2.a();
                                hVar2.f3962a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str6)).addFlags(268435456));
                            } catch (ActivityNotFoundException unused) {
                                Z1.h hVar3 = c0723c2.f7635g.f5449a;
                                hVar3.a();
                                hVar3.f3962a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=otpauth&c=apps")).addFlags(268435456));
                            }
                            arrayList3.add(0, null);
                            dVar.f(arrayList3);
                            break;
                    }
                }
            });
        } else {
            wVar.L(null);
        }
        int i7 = 13;
        e3.w wVar2 = new e3.w(i7, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.openInOtpApp", fVar, new Z3.v(), obj);
        if (a6 == null) {
            wVar2.L(null);
        } else {
            final int i8 = 1;
            wVar2.L(new Z3.b(a6) { // from class: e4.y

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ N1.A f6346b;

                {
                    this.f6346b = a6;
                }

                @Override // Z3.b
                public final void d(Object obj2, Y3.d dVar) {
                    switch (i8) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = (ArrayList) obj2;
                            String str = (String) arrayList2.get(0);
                            String str2 = (String) arrayList2.get(1);
                            String str3 = (String) arrayList2.get(2);
                            this.f6346b.getClass();
                            C0723C c0723c = (C0723C) C0574m.f6323a.get(str);
                            if (str2 == null || str3 == null) {
                                FirebaseAuth firebaseAuth = c0723c.f7635g;
                                AbstractC0669o abstractC0669o = firebaseAuth.f5453f;
                                com.google.android.gms.common.internal.I.h(abstractC0669o, "Current user cannot be null, since user is required to be logged in to enroll for TOTP MFA.");
                                String str4 = ((C0730f) abstractC0669o).f7688b.f7683f;
                                com.google.android.gms.common.internal.I.e(str4, "Email cannot be empty, since verified email is required to use MFA.");
                                Z1.h hVar = firebaseAuth.f5449a;
                                hVar.a();
                                arrayList.add(0, c0723c.a(str4, hVar.f3963b));
                                dVar.f(arrayList);
                            } else {
                                arrayList.add(0, c0723c.a(str2, str3));
                                dVar.f(arrayList);
                            }
                            break;
                        default:
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = (ArrayList) obj2;
                            String str5 = (String) arrayList4.get(0);
                            String str6 = (String) arrayList4.get(1);
                            this.f6346b.getClass();
                            C0723C c0723c2 = (C0723C) C0574m.f6323a.get(str5);
                            c0723c2.getClass();
                            com.google.android.gms.common.internal.I.e(str6, "qrCodeUrl cannot be empty.");
                            try {
                                Z1.h hVar2 = c0723c2.f7635g.f5449a;
                                hVar2.a();
                                hVar2.f3962a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str6)).addFlags(268435456));
                            } catch (ActivityNotFoundException unused) {
                                Z1.h hVar3 = c0723c2.f7635g.f5449a;
                                hVar3.a();
                                hVar3.f3962a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=otpauth&c=apps")).addFlags(268435456));
                            }
                            arrayList3.add(0, null);
                            dVar.f(arrayList3);
                            break;
                    }
                }
            });
        }
    }

    @Override // androidx.lifecycle.W
    public androidx.lifecycle.T a(Class cls) {
        return new Z.S(true);
    }

    @Override // k2.InterfaceC0757c
    public /* synthetic */ Object c(C0771q c0771q) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(c0771q);
    }

    @Override // h1.InterfaceC0618a
    public long d() {
        return System.currentTimeMillis();
    }

    public Signature[] g(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public boolean i(CharSequence charSequence) {
        return charSequence instanceof B.e;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* synthetic */ Object then(Task task) {
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        Exception exception = task.getException();
        return Tasks.forException(new C0664j("INTERNAL_ERROR", zzac.zzb(exception != null ? exception.getMessage() : "")));
    }

    @Override // N1.InterfaceC0137v
    public /* synthetic */ Object zza() {
        switch (this.f1103a) {
            case 0:
                List list = E.f1180a;
                return Integer.valueOf((int) zzpc.zzw());
            case 1:
                List list2 = E.f1180a;
                return Boolean.valueOf(zzpc.zzC());
            case 2:
                List list3 = E.f1180a;
                return Boolean.valueOf(zzpu.zzb());
            case 3:
                List list4 = E.f1180a;
                return Boolean.valueOf(zzqj.zza());
            case 4:
                List list5 = E.f1180a;
                return Integer.valueOf((int) zzpf.zza());
            case 5:
                List list6 = E.f1180a;
                return Boolean.valueOf(zzrb.zzb());
            case 6:
                List list7 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzam());
            case 7:
                List list8 = E.f1180a;
                return Boolean.valueOf(zzqp.zzh());
            case 8:
                List list9 = E.f1180a;
                return Boolean.valueOf(zzpl.zzb());
            case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                List list10 = E.f1180a;
                return Boolean.valueOf(zzqp.zze());
            case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                List list11 = E.f1180a;
                return Long.valueOf(zzpc.zza());
            default:
                return new Boolean(zzqs.zza());
        }
    }

    public A(R3.b bVar) {
        this.f1103a = 18;
        new Z3.q(bVar, "flutter/deferredcomponent", Z3.w.f4022b, null).b(new Q3.h(this, 23));
        C0994k.O().getClass();
        new HashMap();
    }

    @Override // n0.c
    public void h() {
    }

    @Override // h2.InterfaceC0619a
    public void e(C0596b c0596b) {
    }

    @Override // n0.c
    public void b(int i, Serializable serializable) {
    }
}
