package v2;

/* JADX INFO: renamed from: v2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2835a extends AbstractC2845k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2835a f23745a = new C2835a();

    public static AbstractC2845k e() {
        return f23745a;
    }

    @Override // v2.AbstractC2845k
    public Object b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // v2.AbstractC2845k
    public boolean c() {
        return false;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
