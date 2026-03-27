package com.google.firebase.auth;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public final class TotpMultiFactorGenerator {
    public static final String FACTOR_ID = "totp";

    private TotpMultiFactorGenerator() {
    }

    public static Task<TotpSecret> generateSecret(MultiFactorSession multiFactorSession) {
        AbstractC0940s.k(multiFactorSession);
        com.google.firebase.auth.internal.zzam zzamVar = (com.google.firebase.auth.internal.zzam) multiFactorSession;
        return FirebaseAuth.getInstance(zzamVar.zza().zza()).zza(zzamVar);
    }

    public static TotpMultiFactorAssertion getAssertionForEnrollment(TotpSecret totpSecret, String str) {
        return new TotpMultiFactorAssertion((String) AbstractC0940s.k(str), (TotpSecret) AbstractC0940s.k(totpSecret), null);
    }

    public static TotpMultiFactorAssertion getAssertionForSignIn(String str, String str2) {
        return new TotpMultiFactorAssertion((String) AbstractC0940s.k(str2), null, (String) AbstractC0940s.k(str));
    }
}
