package N1;

/* JADX INFO: loaded from: classes.dex */
public enum G0 {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1250a;

    G0(String str) {
        this.f1250a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f1250a;
    }
}
