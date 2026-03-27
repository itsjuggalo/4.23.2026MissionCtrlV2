package o5;

import java.io.Serializable;

/* JADX INFO: renamed from: o5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2479g implements InterfaceC2483k, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21965a;

    public C2479g(Object obj) {
        this.f21965a = obj;
    }

    @Override // o5.InterfaceC2483k
    public boolean e() {
        return true;
    }

    @Override // o5.InterfaceC2483k
    public Object getValue() {
        return this.f21965a;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
