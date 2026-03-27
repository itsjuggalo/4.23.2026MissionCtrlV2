package S1;

/* JADX INFO: loaded from: classes.dex */
public enum X3 {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4286a;

    X3(String str) {
        this.f4286a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4286a;
    }
}
