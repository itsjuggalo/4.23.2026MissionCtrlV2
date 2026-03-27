package com.google.firebase.auth;

import A1.a;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiFactorResolver extends a {
    public abstract FirebaseAuth getFirebaseAuth();

    public abstract List<MultiFactorInfo> getHints();

    public abstract MultiFactorSession getSession();

    public abstract Task<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion);
}
