package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.b;
import java.util.Objects;
import m7.r0;
import n7.d0;
import n7.p;
import n7.s1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f6079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f6081c;

    public f(FirebaseAuth firebaseAuth, a aVar, String str) {
        this.f6079a = aVar;
        this.f6080b = str;
        Objects.requireNonNull(firebaseAuth);
        this.f6081c = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        String strD;
        String strB;
        String strC;
        if (task.isSuccessful()) {
            strD = ((s1) task.getResult()).d();
            strB = ((s1) task.getResult()).b();
            strC = ((s1) task.getResult()).c();
        } else {
            Exception exception = task.getException();
            String str = "Error while validating application identity: ";
            if (exception != null) {
                str = "Error while validating application identity: " + exception.getMessage();
            }
            Log.e("FirebaseAuth", str);
            if (exception != null && d0.i(exception)) {
                FirebaseAuth.f0((a7.m) exception, this.f6079a, this.f6080b);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            strC = null;
            strD = null;
            strB = null;
        }
        long jLongValue = this.f6079a.i().longValue();
        b.AbstractC0100b abstractC0100bE0 = this.f6081c.e0(this.f6079a.j(), this.f6079a.g());
        if (TextUtils.isEmpty(strD)) {
            abstractC0100bE0 = this.f6081c.d0(this.f6079a, abstractC0100bE0, (s1) task.getResult());
        }
        b.AbstractC0100b abstractC0100b = abstractC0100bE0;
        p pVar = (p) s.k(this.f6079a.e());
        if (zzac.zzc(strC) && this.f6081c.q0() != null && this.f6081c.q0().d("PHONE_PROVIDER")) {
            strC = "NO_RECAPTCHA";
        }
        String str2 = strC;
        if (pVar.V()) {
            this.f6081c.f6027e.zza(pVar, (String) s.k(this.f6079a.j()), this.f6081c.f6031i, jLongValue, this.f6079a.f() != null, this.f6079a.m(), strD, strB, str2, this.f6081c.F0(), abstractC0100b, this.f6079a.k(), this.f6079a.a());
        } else {
            this.f6081c.f6027e.zza(pVar, (r0) s.k(this.f6079a.h()), this.f6081c.f6031i, jLongValue, this.f6079a.f() != null, this.f6079a.m(), strD, strB, str2, this.f6081c.F0(), abstractC0100b, this.f6079a.k(), this.f6079a.a());
        }
    }
}
