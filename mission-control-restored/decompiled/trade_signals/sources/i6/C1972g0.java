package i6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: i6.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1972g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1994r0 f18877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f18878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1972g0 f18880d;

    public C1972g0(C1994r0 c1994r0, List parametersInfo, String str) {
        AbstractC2304t.f(parametersInfo, "parametersInfo");
        this.f18877a = c1994r0;
        this.f18878b = parametersInfo;
        this.f18879c = str;
        C1972g0 c1972g0 = null;
        if (str != null) {
            C1994r0 c1994r0A = c1994r0 != null ? c1994r0.a() : null;
            ArrayList arrayList = new ArrayList(p5.r.s(parametersInfo, 10));
            Iterator it = parametersInfo.iterator();
            while (it.hasNext()) {
                C1994r0 c1994r02 = (C1994r0) it.next();
                arrayList.add(c1994r02 != null ? c1994r02.a() : null);
            }
            c1972g0 = new C1972g0(c1994r0A, arrayList, null);
        }
        this.f18880d = c1972g0;
    }

    public final String a() {
        return this.f18879c;
    }

    public final List b() {
        return this.f18878b;
    }

    public final C1994r0 c() {
        return this.f18877a;
    }

    public final C1972g0 d() {
        return this.f18880d;
    }
}
