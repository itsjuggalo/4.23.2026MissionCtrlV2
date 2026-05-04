package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.firebase.auth.b;
import java.util.Objects;
import m7.o0;
import n7.s1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends b.AbstractC0100b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f6082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s1 f6083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b.AbstractC0100b f6084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f6085d;

    public g(FirebaseAuth firebaseAuth, a aVar, s1 s1Var, b.AbstractC0100b abstractC0100b) {
        this.f6082a = aVar;
        this.f6083b = s1Var;
        this.f6084c = abstractC0100b;
        Objects.requireNonNull(firebaseAuth);
        this.f6085d = firebaseAuth;
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onCodeAutoRetrievalTimeOut(String str) {
        this.f6084c.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onCodeSent(String str, b.a aVar) {
        this.f6084c.onCodeSent(str, aVar);
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onVerificationCompleted(o0 o0Var) {
        this.f6084c.onVerificationCompleted(o0Var);
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onVerificationFailed(a7.m mVar) {
        if (zzaen.zza(mVar)) {
            this.f6082a.b(true);
            Log.d("FirebaseAuth", "Re-triggering phone verification with Recaptcha flow forced for phone number " + this.f6082a.j());
            FirebaseAuth.i0(this.f6082a);
            return;
        }
        if (TextUtils.isEmpty(this.f6083b.c())) {
            Log.d("FirebaseAuth", "Invoking original failure callbacks after phone verification failure for " + this.f6082a.j() + ", error - " + mVar.getMessage());
            this.f6084c.onVerificationFailed(mVar);
            return;
        }
        if (zzaen.zzb(mVar) && this.f6085d.q0().d("PHONE_PROVIDER") && TextUtils.isEmpty(this.f6083b.b())) {
            this.f6082a.d(true);
            Log.d("FirebaseAuth", "Re-triggering phone verification with non-reCAPTCHA Enterprise flow for phone number " + this.f6082a.j());
            FirebaseAuth.i0(this.f6082a);
            return;
        }
        Log.d("FirebaseAuth", "Invoking original failure callbacks after reCAPTCHA Enterprise + phone verification failure for " + this.f6082a.j() + ", error - " + mVar.getMessage());
        this.f6084c.onVerificationFailed(mVar);
    }
}
