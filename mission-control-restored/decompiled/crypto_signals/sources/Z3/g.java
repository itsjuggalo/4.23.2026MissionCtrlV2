package Z3;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import s1.C0994k;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f4004a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0994k f4005b;

    public g(C0994k c0994k) {
        this.f4005b = c0994k;
    }

    public final void a() {
        if (this.f4004a.getAndSet(true)) {
            return;
        }
        C0994k c0994k = this.f4005b;
        if (((AtomicReference) c0994k.f9531c).get() != this) {
            return;
        }
        i iVar = (i) c0994k.f9532d;
        iVar.f4006a.f(iVar.f4007b, null);
    }

    public final void b(String str, HashMap map) {
        if (this.f4004a.get()) {
            return;
        }
        C0994k c0994k = this.f4005b;
        if (((AtomicReference) c0994k.f9531c).get() != this) {
            return;
        }
        i iVar = (i) c0994k.f9532d;
        iVar.f4006a.f(iVar.f4007b, iVar.f4008c.c(map, "firebase_firestore", str));
    }

    public final void c(Object obj) {
        if (this.f4004a.get()) {
            return;
        }
        C0994k c0994k = this.f4005b;
        if (((AtomicReference) c0994k.f9531c).get() != this) {
            return;
        }
        i iVar = (i) c0994k.f9532d;
        iVar.f4006a.f(iVar.f4007b, iVar.f4008c.a(obj));
    }
}
