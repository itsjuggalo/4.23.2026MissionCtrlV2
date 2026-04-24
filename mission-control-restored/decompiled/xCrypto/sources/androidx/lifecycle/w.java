package androidx.lifecycle;

import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.C0839b;

/* JADX INFO: loaded from: classes.dex */
public class w implements InterfaceC0848k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0839b.a f7724b;

    public w(Object obj) {
        this.f7723a = obj;
        this.f7724b = C0839b.f7661c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0848k
    public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
        this.f7724b.a(interfaceC0850m, aVar, this.f7723a);
    }
}
