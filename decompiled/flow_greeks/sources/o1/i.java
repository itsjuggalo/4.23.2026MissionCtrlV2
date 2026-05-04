package o1;

import android.content.Context;
import cd.h0;
import cd.s;
import id.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import p1.f;
import pd.o;
import pd.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f17461a = new LinkedHashSet();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends m implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f17463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f17464c;

        public a(gd.e eVar) {
            super(3, eVar);
        }

        @Override // pd.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n1.c cVar, p1.f fVar, gd.e eVar) {
            a aVar = new a(eVar);
            aVar.f17463b = cVar;
            aVar.f17464c = fVar;
            return aVar.invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f17462a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s.b(obj);
            n1.c cVar = (n1.c) this.f17463b;
            p1.f fVar = (p1.f) this.f17464c;
            Set setKeySet = fVar.a().keySet();
            ArrayList arrayList = new ArrayList(dd.s.u(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(((f.a) it.next()).a());
            }
            Map mapA = cVar.a();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapA.entrySet()) {
                if (!arrayList.contains((String) entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            p1.c cVarC = fVar.c();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                String str = (String) entry2.getKey();
                Object value = entry2.getValue();
                if (value instanceof Boolean) {
                    cVarC.j(p1.i.a(str), value);
                } else if (value instanceof Float) {
                    cVarC.j(p1.i.d(str), value);
                } else if (value instanceof Integer) {
                    cVarC.j(p1.i.e(str), value);
                } else if (value instanceof Long) {
                    cVarC.j(p1.i.f(str), value);
                } else if (value instanceof String) {
                    cVarC.j(p1.i.g(str), value);
                } else if (value instanceof Set) {
                    f.a aVarH = p1.i.h(str);
                    t.d(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                    cVarC.j(aVarH, (Set) value);
                }
            }
            return cVarC.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f17466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Set f17467c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Set set, gd.e eVar) {
            super(2, eVar);
            this.f17467c = set;
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(p1.f fVar, gd.e eVar) {
            return ((b) create(fVar, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            b bVar = new b(this.f17467c, eVar);
            bVar.f17466b = obj;
            return bVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f17465a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s.b(obj);
            Set setKeySet = ((p1.f) this.f17466b).a().keySet();
            ArrayList arrayList = new ArrayList(dd.s.u(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(((f.a) it.next()).a());
            }
            boolean z10 = true;
            if (this.f17467c != i.c()) {
                Set set = this.f17467c;
                if (set == null || !set.isEmpty()) {
                    Iterator it2 = set.iterator();
                    while (it2.hasNext()) {
                        if (!arrayList.contains((String) it2.next())) {
                            break;
                        }
                    }
                    z10 = false;
                } else {
                    z10 = false;
                }
            }
            return id.b.a(z10);
        }
    }

    public static final n1.a a(Context context, String sharedPreferencesName, Set keysToMigrate) {
        t.f(context, "context");
        t.f(sharedPreferencesName, "sharedPreferencesName");
        t.f(keysToMigrate, "keysToMigrate");
        return keysToMigrate == f17461a ? new n1.a(context, sharedPreferencesName, null, e(keysToMigrate), d(), 4, null) : new n1.a(context, sharedPreferencesName, keysToMigrate, e(keysToMigrate), d());
    }

    public static /* synthetic */ n1.a b(Context context, String str, Set set, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            set = f17461a;
        }
        return a(context, str, set);
    }

    public static final Set c() {
        return f17461a;
    }

    public static final p d() {
        return new a(null);
    }

    public static final o e(Set set) {
        return new b(set, null);
    }
}
