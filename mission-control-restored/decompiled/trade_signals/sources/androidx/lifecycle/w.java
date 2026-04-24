package androidx.lifecycle;

import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.C1150b;

/* JADX INFO: loaded from: classes.dex */
public class w implements InterfaceC1159k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1150b.a f12020b;

    public w(Object obj) {
        this.f12019a = obj;
        this.f12020b = C1150b.f11957c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC1159k
    public void b(InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar) {
        this.f12020b.a(interfaceC1161m, aVar, this.f12019a);
    }
}
