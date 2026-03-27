package i3;

/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X f6852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0675b f6853b;

    public O(X x6, C0675b c0675b) {
        EnumC0686m enumC0686m = EnumC0686m.f6983b;
        this.f6852a = x6;
        this.f6853b = c0675b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O)) {
            return false;
        }
        O o3 = (O) obj;
        o3.getClass();
        EnumC0686m enumC0686m = EnumC0686m.f6983b;
        return this.f6852a.equals(o3.f6852a) && this.f6853b.equals(o3.f6853b);
    }

    public final int hashCode() {
        return this.f6853b.hashCode() + ((this.f6852a.hashCode() + (EnumC0686m.f6983b.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SessionEvent(eventType=" + EnumC0686m.f6983b + ", sessionData=" + this.f6852a + ", applicationInfo=" + this.f6853b + ')';
    }
}
