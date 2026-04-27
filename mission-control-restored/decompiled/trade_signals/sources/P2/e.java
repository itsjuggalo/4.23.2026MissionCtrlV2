package P2;

import U2.o;
import f4.AbstractC1755d;
import f4.AbstractC1756e;
import f4.InterfaceC1757f;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.r;

/* JADX INFO: loaded from: classes.dex */
public final class e implements InterfaceC1757f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f6354a;

    public e(o userMetadata) {
        AbstractC2304t.f(userMetadata, "userMetadata");
        this.f6354a = userMetadata;
    }

    @Override // f4.InterfaceC1757f
    public void a(AbstractC1756e rolloutsState) {
        AbstractC2304t.f(rolloutsState, "rolloutsState");
        o oVar = this.f6354a;
        Set<AbstractC1755d> setB = rolloutsState.b();
        AbstractC2304t.e(setB, "getRolloutAssignments(...)");
        ArrayList arrayList = new ArrayList(r.s(setB, 10));
        for (AbstractC1755d abstractC1755d : setB) {
            arrayList.add(U2.j.b(abstractC1755d.d(), abstractC1755d.b(), abstractC1755d.c(), abstractC1755d.f(), abstractC1755d.e()));
        }
        oVar.p(arrayList);
        g.f().b("Updated Crashlytics Rollout State");
    }
}
