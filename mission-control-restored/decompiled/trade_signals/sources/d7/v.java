package d7;

import Y6.InterfaceC1015l;
import Y6.S;
import Y6.V;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends Y6.I implements V {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ V f17078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Y6.I f17079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17080e;

    /* JADX WARN: Multi-variable type inference failed */
    public v(Y6.I i8, String str) {
        V v8 = i8 instanceof V ? (V) i8 : null;
        this.f17078c = v8 == null ? S.a() : v8;
        this.f17079d = i8;
        this.f17080e = str;
    }

    @Override // Y6.V
    public void U(long j8, InterfaceC1015l interfaceC1015l) {
        this.f17078c.U(j8, interfaceC1015l);
    }

    @Override // Y6.I
    public String toString() {
        return this.f17080e;
    }

    @Override // Y6.I
    public void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        this.f17079d.v0(interfaceC2711i, runnable);
    }

    @Override // Y6.I
    public boolean w0(InterfaceC2711i interfaceC2711i) {
        return this.f17079d.w0(interfaceC2711i);
    }
}
