package N1;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import p0.C0902n;

/* JADX INFO: loaded from: classes.dex */
public abstract class D0 implements F0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1130a;

    public D0(C0138v0 c0138v0) {
        com.google.android.gms.common.internal.I.g(c0138v0);
        this.f1130a = c0138v0;
    }

    public static D0 g(p0.u uVar, int i) {
        if (i == 0) {
            return new C0902n(uVar, 0);
        }
        if (i == 1) {
            return new C0902n(uVar, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    @Override // N1.F0
    public W b() {
        throw null;
    }

    @Override // N1.F0
    public C0126r0 c() {
        throw null;
    }

    @Override // N1.F0
    public Context d() {
        throw null;
    }

    @Override // N1.F0
    public B1.a e() {
        throw null;
    }

    @Override // N1.F0
    public E4.c f() {
        throw null;
    }

    public abstract int h(View view);

    public abstract int i(View view);

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract void m();

    public abstract void n();

    public void o(Object obj, boolean z6) {
        Set set = (Set) this.f1130a;
        int size = set.size();
        if (z6) {
            set.add(obj);
            if (size == 0) {
                m();
                return;
            }
            return;
        }
        if (set.remove(obj) && size == 1) {
            n();
        }
    }

    public void p() {
        C0126r0 c0126r0 = ((C0138v0) this.f1130a).f1815k;
        C0138v0.l(c0126r0);
        c0126r0.p();
    }

    public D0(int i) {
        switch (i) {
            case 3:
                this.f1130a = Collections.newSetFromMap(new IdentityHashMap());
                break;
            default:
                this.f1130a = new LinkedHashMap();
                break;
        }
    }

    public D0(p0.u uVar) {
        new Rect();
        this.f1130a = uVar;
    }
}
