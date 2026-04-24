package g4;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.I, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1794I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1821j f18032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1801P f18033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1813b f18034c;

    public C1794I(EnumC1821j eventType, C1801P sessionData, C1813b applicationInfo) {
        AbstractC2304t.f(eventType, "eventType");
        AbstractC2304t.f(sessionData, "sessionData");
        AbstractC2304t.f(applicationInfo, "applicationInfo");
        this.f18032a = eventType;
        this.f18033b = sessionData;
        this.f18034c = applicationInfo;
    }

    public final C1813b a() {
        return this.f18034c;
    }

    public final EnumC1821j b() {
        return this.f18032a;
    }

    public final C1801P c() {
        return this.f18033b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1794I)) {
            return false;
        }
        C1794I c1794i = (C1794I) obj;
        return this.f18032a == c1794i.f18032a && AbstractC2304t.b(this.f18033b, c1794i.f18033b) && AbstractC2304t.b(this.f18034c, c1794i.f18034c);
    }

    public int hashCode() {
        return (((this.f18032a.hashCode() * 31) + this.f18033b.hashCode()) * 31) + this.f18034c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.f18032a + ", sessionData=" + this.f18033b + ", applicationInfo=" + this.f18034c + ')';
    }
}
