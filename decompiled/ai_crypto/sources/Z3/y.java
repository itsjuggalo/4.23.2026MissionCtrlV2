package Z3;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0790j f6009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D f6010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0782b f6011c;

    public y(EnumC0790j eventType, D sessionData, C0782b applicationInfo) {
        kotlin.jvm.internal.r.f(eventType, "eventType");
        kotlin.jvm.internal.r.f(sessionData, "sessionData");
        kotlin.jvm.internal.r.f(applicationInfo, "applicationInfo");
        this.f6009a = eventType;
        this.f6010b = sessionData;
        this.f6011c = applicationInfo;
    }

    public final C0782b a() {
        return this.f6011c;
    }

    public final EnumC0790j b() {
        return this.f6009a;
    }

    public final D c() {
        return this.f6010b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f6009a == yVar.f6009a && kotlin.jvm.internal.r.b(this.f6010b, yVar.f6010b) && kotlin.jvm.internal.r.b(this.f6011c, yVar.f6011c);
    }

    public int hashCode() {
        return (((this.f6009a.hashCode() * 31) + this.f6010b.hashCode()) * 31) + this.f6011c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.f6009a + ", sessionData=" + this.f6010b + ", applicationInfo=" + this.f6011c + ')';
    }
}
