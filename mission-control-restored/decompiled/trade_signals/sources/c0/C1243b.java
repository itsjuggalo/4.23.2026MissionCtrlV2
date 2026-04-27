package c0;

import B5.k;
import b0.C1173d;
import b0.InterfaceC1174e;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;

/* JADX INFO: renamed from: c0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1243b implements InterfaceC1174e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f13328a;

    public C1243b(k produceNewData) {
        AbstractC2304t.f(produceNewData, "produceNewData");
        this.f13328a = produceNewData;
    }

    @Override // b0.InterfaceC1174e
    public Object a(C1173d c1173d, InterfaceC2707e interfaceC2707e) {
        return this.f13328a.invoke(c1173d);
    }
}
