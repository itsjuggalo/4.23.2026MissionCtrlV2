package i2;

import x1.C1402a;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {
    private static final C1402a zza = new C1402a("PhoneAuthProvider", new String[0]);

    public abstract void onCodeAutoRetrievalTimeOut(String str);

    public abstract void onCodeSent(String str, w wVar);

    public abstract void onVerificationCompleted(u uVar);

    public abstract void onVerificationFailed(Z1.k kVar);
}
