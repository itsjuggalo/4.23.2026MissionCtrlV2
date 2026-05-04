package we;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f23962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f23963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f1 f23965d;

    public f1(q1 q1Var, List parametersInfo, String str) {
        kotlin.jvm.internal.t.f(parametersInfo, "parametersInfo");
        this.f23962a = q1Var;
        this.f23963b = parametersInfo;
        this.f23964c = str;
        f1 f1Var = null;
        if (str != null) {
            q1 q1VarA = q1Var != null ? q1Var.a() : null;
            ArrayList arrayList = new ArrayList(dd.s.u(parametersInfo, 10));
            Iterator it = parametersInfo.iterator();
            while (it.hasNext()) {
                q1 q1Var2 = (q1) it.next();
                arrayList.add(q1Var2 != null ? q1Var2.a() : null);
            }
            f1Var = new f1(q1VarA, arrayList, null);
        }
        this.f23965d = f1Var;
    }

    public final String a() {
        return this.f23964c;
    }

    public final List b() {
        return this.f23963b;
    }

    public final q1 c() {
        return this.f23962a;
    }

    public final f1 d() {
        return this.f23965d;
    }
}
