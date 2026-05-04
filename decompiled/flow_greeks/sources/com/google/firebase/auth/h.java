package com.google.firebase.auth;

import com.google.android.gms.common.internal.s;
import com.google.firebase.auth.b;
import java.util.Objects;
import m7.o0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends b.AbstractC0100b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.AbstractC0100b f6086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f6087b;

    public h(FirebaseAuth firebaseAuth, b.AbstractC0100b abstractC0100b) {
        this.f6086a = abstractC0100b;
        Objects.requireNonNull(firebaseAuth);
        this.f6087b = firebaseAuth;
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onCodeSent(String str, b.a aVar) {
        this.f6086a.onVerificationCompleted(b.a(str, (String) s.k(this.f6087b.f6029g.e())));
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onVerificationCompleted(o0 o0Var) {
        this.f6086a.onVerificationCompleted(o0Var);
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onVerificationFailed(a7.m mVar) {
        this.f6086a.onVerificationFailed(mVar);
    }

    @Override // com.google.firebase.auth.b.AbstractC0100b
    public final void onCodeAutoRetrievalTimeOut(String str) {
    }
}
