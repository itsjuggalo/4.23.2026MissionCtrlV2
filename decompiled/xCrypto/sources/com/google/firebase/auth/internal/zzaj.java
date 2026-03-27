package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaj extends MultiFactor {
    private final zzaf zza;

    public zzaj(zzaf zzafVar) {
        AbstractC0940s.k(zzafVar);
        this.zza = zzafVar;
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> enroll(MultiFactorAssertion multiFactorAssertion, String str) {
        AbstractC0940s.k(multiFactorAssertion);
        zzaf zzafVar = this.zza;
        return FirebaseAuth.getInstance(zzafVar.zza()).zza(zzafVar, multiFactorAssertion, str);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.zza.zzi();
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<MultiFactorSession> getSession() {
        return this.zza.getIdToken(false).continueWithTask(new zzai(this));
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> unenroll(MultiFactorInfo multiFactorInfo) {
        AbstractC0940s.k(multiFactorInfo);
        return unenroll(multiFactorInfo.getUid());
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> unenroll(String str) {
        AbstractC0940s.e(str);
        zzaf zzafVar = this.zza;
        return FirebaseAuth.getInstance(zzafVar.zza()).zza(zzafVar, str);
    }
}
