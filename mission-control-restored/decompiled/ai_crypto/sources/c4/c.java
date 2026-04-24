package c4;

import b4.InterfaceC0994a;

/* JADX INFO: loaded from: classes.dex */
public final class c implements InterfaceC1143b, InterfaceC0994a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f9413b = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9414a;

    public c(Object obj) {
        this.f9414a = obj;
    }

    public static InterfaceC1143b a(Object obj) {
        return new c(d.c(obj, "instance cannot be null"));
    }

    @Override // D5.a
    public Object get() {
        return this.f9414a;
    }
}
