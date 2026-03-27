package O;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n0 implements a5.M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2263c;

    public /* synthetic */ n0(int i, Object obj, Object obj2) {
        this.f2261a = i;
        this.f2262b = obj;
        this.f2263c = obj2;
    }

    @Override // a5.M
    public final void a() {
        switch (this.f2261a) {
            case 0:
                String str = (String) this.f2262b;
                o0 o0Var = (o0) this.f2263c;
                synchronized (q0.f2276b) {
                    LinkedHashMap linkedHashMap = q0.f2277c;
                    q0 q0Var = (q0) linkedHashMap.get(str);
                    if (q0Var != null) {
                        q0Var.f2278a.remove(o0Var);
                        if (q0Var.f2278a.isEmpty()) {
                            linkedHashMap.remove(str);
                            q0Var.stopWatching();
                        }
                    }
                    break;
                }
                return;
            default:
                ((b5.c) this.f2262b).f4894c.removeCallbacks((a5.z0) this.f2263c);
                return;
        }
    }
}
