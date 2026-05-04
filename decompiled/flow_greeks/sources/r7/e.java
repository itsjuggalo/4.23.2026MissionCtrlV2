package r7;

import dd.s;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.t;
import w7.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ta.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f19372a;

    public e(o userMetadata) {
        t.f(userMetadata, "userMetadata");
        this.f19372a = userMetadata;
    }

    @Override // ta.f
    public void a(ta.e rolloutsState) {
        t.f(rolloutsState, "rolloutsState");
        o oVar = this.f19372a;
        Set<ta.d> setB = rolloutsState.b();
        t.e(setB, "getRolloutAssignments(...)");
        ArrayList arrayList = new ArrayList(s.u(setB, 10));
        for (ta.d dVar : setB) {
            arrayList.add(w7.j.b(dVar.d(), dVar.b(), dVar.c(), dVar.f(), dVar.e()));
        }
        oVar.n(arrayList);
        g.f().b("Updated Crashlytics Rollout State");
    }
}
