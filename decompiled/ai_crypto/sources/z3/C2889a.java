package z3;

import b3.AbstractC0981D;

/* JADX INFO: renamed from: z3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2889a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f26057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f26058b;

    public C2889a(Class cls, Object obj) {
        this.f26057a = (Class) AbstractC0981D.b(cls);
        this.f26058b = AbstractC0981D.b(obj);
    }

    public Object a() {
        return this.f26058b;
    }

    public Class b() {
        return this.f26057a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f26057a, this.f26058b);
    }
}
