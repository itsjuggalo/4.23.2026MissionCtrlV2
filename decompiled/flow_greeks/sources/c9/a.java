package c9;

import o7.d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3751b;

    public a(Class cls, Object obj) {
        this.f3750a = (Class) d0.b(cls);
        this.f3751b = d0.b(obj);
    }

    public Object a() {
        return this.f3751b;
    }

    public Class b() {
        return this.f3750a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f3750a, this.f3751b);
    }
}
