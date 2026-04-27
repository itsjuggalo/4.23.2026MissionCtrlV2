package e4;

import com.google.firebase.auth.FirebaseAuth;
import e3.C0536F;
import i2.C0648B;
import j2.C0723C;
import j2.C0734j;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface x {
    static void a(Z3.f fVar, final x xVar) {
        r rVar = r.f6334h;
        Object obj = null;
        e3.w wVar = new e3.w(13, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.generateSecret", fVar, rVar, obj);
        if (xVar != null) {
            final int i = 0;
            wVar.L(new Z3.b(xVar) { // from class: e4.v

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ x f6341b;

                {
                    this.f6341b = xVar;
                }

                @Override // Z3.b
                public final void d(Object obj2, Y3.d dVar) {
                    switch (i) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            String str = (String) ((ArrayList) obj2).get(0);
                            w wVar2 = new w(arrayList, dVar, 0);
                            ((C0574m) this.f6341b).getClass();
                            C0734j c0734j = (C0734j) C0573l.f6320b.get(str);
                            com.google.android.gms.common.internal.I.g(c0734j);
                            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(Z1.h.f(c0734j.e.f7689c));
                            firebaseAuth.getClass();
                            firebaseAuth.e.zza(c0734j, firebaseAuth.f5457k).continueWithTask(new Z.B(firebaseAuth, 7)).addOnCompleteListener(new C0536F(wVar2, 28));
                            break;
                        case 1:
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj2;
                            String str2 = (String) arrayList3.get(0);
                            String str3 = (String) arrayList3.get(1);
                            ((C0574m) this.f6341b).getClass();
                            C0723C c0723c = (C0723C) C0574m.f6323a.get(str2);
                            com.google.android.gms.common.internal.I.g(str3);
                            com.google.android.gms.common.internal.I.g(c0723c);
                            C0648B c0648b = new C0648B(str3, c0723c, null);
                            String string = UUID.randomUUID().toString();
                            C0573l.f6322d.put(string, c0648b);
                            arrayList2.add(0, string);
                            dVar.f(arrayList2);
                            break;
                        default:
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj2;
                            String str4 = (String) arrayList5.get(0);
                            String str5 = (String) arrayList5.get(1);
                            ((C0574m) this.f6341b).getClass();
                            com.google.android.gms.common.internal.I.g(str5);
                            com.google.android.gms.common.internal.I.g(str4);
                            C0648B c0648b2 = new C0648B(str5, null, str4);
                            String string2 = UUID.randomUUID().toString();
                            C0573l.f6322d.put(string2, c0648b2);
                            arrayList4.add(0, string2);
                            dVar.f(arrayList4);
                            break;
                    }
                }
            });
        } else {
            wVar.L(null);
        }
        e3.w wVar2 = new e3.w(13, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForEnrollment", fVar, rVar, obj);
        if (xVar != null) {
            final int i6 = 1;
            wVar2.L(new Z3.b(xVar) { // from class: e4.v

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ x f6341b;

                {
                    this.f6341b = xVar;
                }

                @Override // Z3.b
                public final void d(Object obj2, Y3.d dVar) {
                    switch (i6) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            String str = (String) ((ArrayList) obj2).get(0);
                            w wVar22 = new w(arrayList, dVar, 0);
                            ((C0574m) this.f6341b).getClass();
                            C0734j c0734j = (C0734j) C0573l.f6320b.get(str);
                            com.google.android.gms.common.internal.I.g(c0734j);
                            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(Z1.h.f(c0734j.e.f7689c));
                            firebaseAuth.getClass();
                            firebaseAuth.e.zza(c0734j, firebaseAuth.f5457k).continueWithTask(new Z.B(firebaseAuth, 7)).addOnCompleteListener(new C0536F(wVar22, 28));
                            break;
                        case 1:
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj2;
                            String str2 = (String) arrayList3.get(0);
                            String str3 = (String) arrayList3.get(1);
                            ((C0574m) this.f6341b).getClass();
                            C0723C c0723c = (C0723C) C0574m.f6323a.get(str2);
                            com.google.android.gms.common.internal.I.g(str3);
                            com.google.android.gms.common.internal.I.g(c0723c);
                            C0648B c0648b = new C0648B(str3, c0723c, null);
                            String string = UUID.randomUUID().toString();
                            C0573l.f6322d.put(string, c0648b);
                            arrayList2.add(0, string);
                            dVar.f(arrayList2);
                            break;
                        default:
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj2;
                            String str4 = (String) arrayList5.get(0);
                            String str5 = (String) arrayList5.get(1);
                            ((C0574m) this.f6341b).getClass();
                            com.google.android.gms.common.internal.I.g(str5);
                            com.google.android.gms.common.internal.I.g(str4);
                            C0648B c0648b2 = new C0648B(str5, null, str4);
                            String string2 = UUID.randomUUID().toString();
                            C0573l.f6322d.put(string2, c0648b2);
                            arrayList4.add(0, string2);
                            dVar.f(arrayList4);
                            break;
                    }
                }
            });
        } else {
            wVar2.L(null);
        }
        e3.w wVar3 = new e3.w(13, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForSignIn", fVar, rVar, obj);
        if (xVar == null) {
            wVar3.L(null);
        } else {
            final int i7 = 2;
            wVar3.L(new Z3.b(xVar) { // from class: e4.v

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ x f6341b;

                {
                    this.f6341b = xVar;
                }

                @Override // Z3.b
                public final void d(Object obj2, Y3.d dVar) {
                    switch (i7) {
                        case 0:
                            ArrayList arrayList = new ArrayList();
                            String str = (String) ((ArrayList) obj2).get(0);
                            w wVar22 = new w(arrayList, dVar, 0);
                            ((C0574m) this.f6341b).getClass();
                            C0734j c0734j = (C0734j) C0573l.f6320b.get(str);
                            com.google.android.gms.common.internal.I.g(c0734j);
                            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(Z1.h.f(c0734j.e.f7689c));
                            firebaseAuth.getClass();
                            firebaseAuth.e.zza(c0734j, firebaseAuth.f5457k).continueWithTask(new Z.B(firebaseAuth, 7)).addOnCompleteListener(new C0536F(wVar22, 28));
                            break;
                        case 1:
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj2;
                            String str2 = (String) arrayList3.get(0);
                            String str3 = (String) arrayList3.get(1);
                            ((C0574m) this.f6341b).getClass();
                            C0723C c0723c = (C0723C) C0574m.f6323a.get(str2);
                            com.google.android.gms.common.internal.I.g(str3);
                            com.google.android.gms.common.internal.I.g(c0723c);
                            C0648B c0648b = new C0648B(str3, c0723c, null);
                            String string = UUID.randomUUID().toString();
                            C0573l.f6322d.put(string, c0648b);
                            arrayList2.add(0, string);
                            dVar.f(arrayList2);
                            break;
                        default:
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj2;
                            String str4 = (String) arrayList5.get(0);
                            String str5 = (String) arrayList5.get(1);
                            ((C0574m) this.f6341b).getClass();
                            com.google.android.gms.common.internal.I.g(str5);
                            com.google.android.gms.common.internal.I.g(str4);
                            C0648B c0648b2 = new C0648B(str5, null, str4);
                            String string2 = UUID.randomUUID().toString();
                            C0573l.f6322d.put(string2, c0648b2);
                            arrayList4.add(0, string2);
                            dVar.f(arrayList4);
                            break;
                    }
                }
            });
        }
    }
}
