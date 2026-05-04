package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f22588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f22589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f22590c;

    public i0(j eventType, p0 sessionData, b applicationInfo) {
        kotlin.jvm.internal.t.f(eventType, "eventType");
        kotlin.jvm.internal.t.f(sessionData, "sessionData");
        kotlin.jvm.internal.t.f(applicationInfo, "applicationInfo");
        this.f22588a = eventType;
        this.f22589b = sessionData;
        this.f22590c = applicationInfo;
    }

    public final b a() {
        return this.f22590c;
    }

    public final j b() {
        return this.f22588a;
    }

    public final p0 c() {
        return this.f22589b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f22588a == i0Var.f22588a && kotlin.jvm.internal.t.b(this.f22589b, i0Var.f22589b) && kotlin.jvm.internal.t.b(this.f22590c, i0Var.f22590c);
    }

    public int hashCode() {
        return (((this.f22588a.hashCode() * 31) + this.f22589b.hashCode()) * 31) + this.f22590c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.f22588a + ", sessionData=" + this.f22589b + ", applicationInfo=" + this.f22590c + ')';
    }
}
