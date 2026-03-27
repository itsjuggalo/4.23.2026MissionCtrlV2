package androidx.lifecycle;

import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.C0956b;

/* JADX INFO: loaded from: classes.dex */
public class w implements InterfaceC0965k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0956b.a f7833b;

    public w(Object obj) {
        this.f7832a = obj;
        this.f7833b = C0956b.f7759c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0965k
    public void a(InterfaceC0967m interfaceC0967m, AbstractC0963i.a aVar) {
        this.f7833b.a(interfaceC0967m, aVar, this.f7832a);
    }
}
