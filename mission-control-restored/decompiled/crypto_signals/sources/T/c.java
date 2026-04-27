package T;

import G4.l;
import K4.j;
import R4.p;
import a.AbstractC0284a;

/* JADX INFO: loaded from: classes.dex */
public final class c extends j implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f2889c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar, I4.d dVar) {
        super(2, dVar);
        this.f2889c = (j) pVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [K4.j, R4.p] */
    @Override // K4.a
    public final I4.d create(Object obj, I4.d dVar) {
        c cVar = new c(this.f2889c, dVar);
        cVar.f2888b = obj;
        return cVar;
    }

    @Override // R4.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((b) obj, (I4.d) obj2)).invokeSuspend(l.f540a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [K4.j, R4.p] */
    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        J4.a aVar = J4.a.f791a;
        int i = this.f2887a;
        if (i == 0) {
            AbstractC0284a.E(obj);
            b bVar = (b) this.f2888b;
            this.f2887a = 1;
            obj = this.f2889c.invoke(bVar, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC0284a.E(obj);
        }
        b bVar2 = (b) obj;
        kotlin.jvm.internal.j.c(bVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
        bVar2.f2886b.f2609a.set(true);
        return bVar2;
    }
}
