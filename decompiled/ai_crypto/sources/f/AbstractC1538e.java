package f;

import Y5.k;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.InterfaceC0965k;
import androidx.lifecycle.InterfaceC0967m;
import g.AbstractC1624a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: renamed from: f.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1538e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f13995h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f13996a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f13997b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f13998c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f13999d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Map f14000e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f14001f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f14002g = new Bundle();

    /* JADX INFO: renamed from: f.e$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1535b f14003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC1624a f14004b;

        public a(InterfaceC1535b callback, AbstractC1624a contract) {
            r.f(callback, "callback");
            r.f(contract, "contract");
            this.f14003a = callback;
            this.f14004b = contract;
        }

        public final InterfaceC1535b a() {
            return this.f14003a;
        }

        public final AbstractC1624a b() {
            return this.f14004b;
        }
    }

    /* JADX INFO: renamed from: f.e$b */
    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: f.e$c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0963i f14005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f14006b;

        public c(AbstractC0963i lifecycle) {
            r.f(lifecycle, "lifecycle");
            this.f14005a = lifecycle;
            this.f14006b = new ArrayList();
        }

        public final void a(InterfaceC0965k observer) {
            r.f(observer, "observer");
            this.f14005a.a(observer);
            this.f14006b.add(observer);
        }

        public final void b() {
            Iterator it = this.f14006b.iterator();
            while (it.hasNext()) {
                this.f14005a.c((InterfaceC0965k) it.next());
            }
            this.f14006b.clear();
        }
    }

    /* JADX INFO: renamed from: f.e$d */
    public static final class d extends s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14007a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(U5.c.f5206a.d(2147418112) + 65536);
        }
    }

    /* JADX INFO: renamed from: f.e$e, reason: collision with other inner class name */
    public static final class C0241e extends AbstractC1536c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1624a f14010c;

        public C0241e(String str, AbstractC1624a abstractC1624a) {
            this.f14009b = str;
            this.f14010c = abstractC1624a;
        }

        @Override // f.AbstractC1536c
        public void b(Object obj, F.b bVar) throws Exception {
            Object obj2 = AbstractC1538e.this.f13997b.get(this.f14009b);
            AbstractC1624a abstractC1624a = this.f14010c;
            if (obj2 != null) {
                int iIntValue = ((Number) obj2).intValue();
                AbstractC1538e.this.f13999d.add(this.f14009b);
                try {
                    AbstractC1538e.this.i(iIntValue, this.f14010c, obj, bVar);
                    return;
                } catch (Exception e7) {
                    AbstractC1538e.this.f13999d.remove(this.f14009b);
                    throw e7;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC1624a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // f.AbstractC1536c
        public void c() {
            AbstractC1538e.this.p(this.f14009b);
        }
    }

    /* JADX INFO: renamed from: f.e$f */
    public static final class f extends AbstractC1536c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1624a f14013c;

        public f(String str, AbstractC1624a abstractC1624a) {
            this.f14012b = str;
            this.f14013c = abstractC1624a;
        }

        @Override // f.AbstractC1536c
        public void b(Object obj, F.b bVar) throws Exception {
            Object obj2 = AbstractC1538e.this.f13997b.get(this.f14012b);
            AbstractC1624a abstractC1624a = this.f14013c;
            if (obj2 != null) {
                int iIntValue = ((Number) obj2).intValue();
                AbstractC1538e.this.f13999d.add(this.f14012b);
                try {
                    AbstractC1538e.this.i(iIntValue, this.f14013c, obj, bVar);
                    return;
                } catch (Exception e7) {
                    AbstractC1538e.this.f13999d.remove(this.f14012b);
                    throw e7;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC1624a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // f.AbstractC1536c
        public void c() {
            AbstractC1538e.this.p(this.f14012b);
        }
    }

    public static final void n(AbstractC1538e this$0, String key, InterfaceC1535b callback, AbstractC1624a contract, InterfaceC0967m interfaceC0967m, AbstractC0963i.a event) {
        r.f(this$0, "this$0");
        r.f(key, "$key");
        r.f(callback, "$callback");
        r.f(contract, "$contract");
        r.f(interfaceC0967m, "<anonymous parameter 0>");
        r.f(event, "event");
        if (AbstractC0963i.a.ON_START != event) {
            if (AbstractC0963i.a.ON_STOP == event) {
                this$0.f14000e.remove(key);
                return;
            } else {
                if (AbstractC0963i.a.ON_DESTROY == event) {
                    this$0.p(key);
                    return;
                }
                return;
            }
        }
        this$0.f14000e.put(key, new a(callback, contract));
        if (this$0.f14001f.containsKey(key)) {
            Object obj = this$0.f14001f.get(key);
            this$0.f14001f.remove(key);
            callback.a(obj);
        }
        C1534a c1534a = (C1534a) M.c.a(this$0.f14002g, key, C1534a.class);
        if (c1534a != null) {
            this$0.f14002g.remove(key);
            callback.a(contract.c(c1534a.c(), c1534a.a()));
        }
    }

    public final void d(int i7, String str) {
        this.f13996a.put(Integer.valueOf(i7), str);
        this.f13997b.put(str, Integer.valueOf(i7));
    }

    public final boolean e(int i7, int i8, Intent intent) {
        String str = (String) this.f13996a.get(Integer.valueOf(i7));
        if (str == null) {
            return false;
        }
        g(str, i8, intent, (a) this.f14000e.get(str));
        return true;
    }

    public final boolean f(int i7, Object obj) {
        String str = (String) this.f13996a.get(Integer.valueOf(i7));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.f14000e.get(str);
        if ((aVar != null ? aVar.a() : null) == null) {
            this.f14002g.remove(str);
            this.f14001f.put(str, obj);
            return true;
        }
        InterfaceC1535b interfaceC1535bA = aVar.a();
        r.d(interfaceC1535bA, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.f13999d.remove(str)) {
            return true;
        }
        interfaceC1535bA.a(obj);
        return true;
    }

    public final void g(String str, int i7, Intent intent, a aVar) {
        if ((aVar != null ? aVar.a() : null) == null || !this.f13999d.contains(str)) {
            this.f14001f.remove(str);
            this.f14002g.putParcelable(str, new C1534a(i7, intent));
        } else {
            aVar.a().a(aVar.b().c(i7, intent));
            this.f13999d.remove(str);
        }
    }

    public final int h() {
        for (Number number : k.f(d.f14007a)) {
            if (!this.f13996a.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public abstract void i(int i7, AbstractC1624a abstractC1624a, Object obj, F.b bVar);

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        if (stringArrayList2 != null) {
            this.f13999d.addAll(stringArrayList2);
        }
        Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        if (bundle2 != null) {
            this.f14002g.putAll(bundle2);
        }
        int size = stringArrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            String str = stringArrayList.get(i7);
            if (this.f13997b.containsKey(str)) {
                Integer num = (Integer) this.f13997b.remove(str);
                if (!this.f14002g.containsKey(str)) {
                    L.a(this.f13996a).remove(num);
                }
            }
            Integer num2 = integerArrayList.get(i7);
            r.e(num2, "rcs[i]");
            int iIntValue = num2.intValue();
            String str2 = stringArrayList.get(i7);
            r.e(str2, "keys[i]");
            d(iIntValue, str2);
        }
    }

    public final void k(Bundle outState) {
        r.f(outState, "outState");
        outState.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f13997b.values()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f13997b.keySet()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f13999d));
        outState.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.f14002g));
    }

    public final AbstractC1536c l(final String key, InterfaceC0967m lifecycleOwner, final AbstractC1624a contract, final InterfaceC1535b callback) {
        r.f(key, "key");
        r.f(lifecycleOwner, "lifecycleOwner");
        r.f(contract, "contract");
        r.f(callback, "callback");
        AbstractC0963i abstractC0963iA = lifecycleOwner.a();
        if (abstractC0963iA.b().b(AbstractC0963i.b.STARTED)) {
            throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + abstractC0963iA.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        o(key);
        c cVar = (c) this.f13998c.get(key);
        if (cVar == null) {
            cVar = new c(abstractC0963iA);
        }
        cVar.a(new InterfaceC0965k() { // from class: f.d
            @Override // androidx.lifecycle.InterfaceC0965k
            public final void a(InterfaceC0967m interfaceC0967m, AbstractC0963i.a aVar) {
                AbstractC1538e.n(this.f13991a, key, callback, contract, interfaceC0967m, aVar);
            }
        });
        this.f13998c.put(key, cVar);
        return new C0241e(key, contract);
    }

    public final AbstractC1536c m(String key, AbstractC1624a contract, InterfaceC1535b callback) {
        r.f(key, "key");
        r.f(contract, "contract");
        r.f(callback, "callback");
        o(key);
        this.f14000e.put(key, new a(callback, contract));
        if (this.f14001f.containsKey(key)) {
            Object obj = this.f14001f.get(key);
            this.f14001f.remove(key);
            callback.a(obj);
        }
        C1534a c1534a = (C1534a) M.c.a(this.f14002g, key, C1534a.class);
        if (c1534a != null) {
            this.f14002g.remove(key);
            callback.a(contract.c(c1534a.c(), c1534a.a()));
        }
        return new f(key, contract);
    }

    public final void o(String str) {
        if (((Integer) this.f13997b.get(str)) != null) {
            return;
        }
        d(h(), str);
    }

    public final void p(String key) {
        Integer num;
        r.f(key, "key");
        if (!this.f13999d.contains(key) && (num = (Integer) this.f13997b.remove(key)) != null) {
            this.f13996a.remove(num);
        }
        this.f14000e.remove(key);
        if (this.f14001f.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + this.f14001f.get(key));
            this.f14001f.remove(key);
        }
        if (this.f14002g.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((C1534a) M.c.a(this.f14002g, key, C1534a.class)));
            this.f14002g.remove(key);
        }
        c cVar = (c) this.f13998c.get(key);
        if (cVar != null) {
            cVar.b();
            this.f13998c.remove(key);
        }
    }
}
