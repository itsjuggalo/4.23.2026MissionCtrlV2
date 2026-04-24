package A3;

import M2.D;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f86a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f87b;

    public a(Class cls, Object obj) {
        this.f86a = (Class) D.b(cls);
        this.f87b = D.b(obj);
    }

    public Object a() {
        return this.f87b;
    }

    public Class b() {
        return this.f86a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f86a, this.f87b);
    }
}
