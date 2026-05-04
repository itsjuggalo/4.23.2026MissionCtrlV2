package b7;

import android.content.Context;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.b f3004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f3006c = null;

    public c(Context context, fa.b bVar, String str) {
        this.f3004a = bVar;
        this.f3005b = str;
    }

    public static List c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(b.b((Map) it.next()));
        }
        return arrayList;
    }

    public final void a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        ((AnalyticsConnector) this.f3004a.get()).setConditionalUserProperty(conditionalUserProperty);
    }

    public final void b(List list) {
        ArrayDeque arrayDeque = new ArrayDeque(f());
        int i10 = i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            while (arrayDeque.size() >= i10) {
                k(((AnalyticsConnector.ConditionalUserProperty) arrayDeque.pollFirst()).name);
            }
            AnalyticsConnector.ConditionalUserProperty conditionalUserPropertyF = bVar.f(this.f3005b);
            a(conditionalUserPropertyF);
            arrayDeque.offer(conditionalUserPropertyF);
        }
    }

    public final boolean d(List list, b bVar) {
        String strC = bVar.c();
        String strE = bVar.e();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.c().equals(strC) && bVar2.e().equals(strE)) {
                return true;
            }
        }
        return false;
    }

    public List e() throws a {
        p();
        List listF = f();
        ArrayList arrayList = new ArrayList();
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            arrayList.add(b.a((AnalyticsConnector.ConditionalUserProperty) it.next()));
        }
        return arrayList;
    }

    public final List f() {
        return ((AnalyticsConnector) this.f3004a.get()).getConditionalUserProperties(this.f3005b, "");
    }

    public final ArrayList g(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (!d(list2, bVar)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public final ArrayList h(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (!d(list2, bVar)) {
                arrayList.add(bVar.f(this.f3005b));
            }
        }
        return arrayList;
    }

    public final int i() {
        if (this.f3006c == null) {
            this.f3006c = Integer.valueOf(((AnalyticsConnector) this.f3004a.get()).getMaxUserProperties(this.f3005b));
        }
        return this.f3006c.intValue();
    }

    public void j() throws a {
        p();
        l(f());
    }

    public final void k(String str) {
        ((AnalyticsConnector) this.f3004a.get()).clearConditionalUserProperty(str, null, null);
    }

    public final void l(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            k(((AnalyticsConnector.ConditionalUserProperty) it.next()).name);
        }
    }

    public void m(List list) throws a {
        p();
        if (list == null) {
            throw new IllegalArgumentException("The replacementExperiments list is null.");
        }
        n(c(list));
    }

    public final void n(List list) throws a {
        if (list.isEmpty()) {
            j();
            return;
        }
        List listE = e();
        l(h(listE, list));
        b(g(list, listE));
    }

    public void o(b bVar) throws a {
        p();
        b.h(bVar);
        ArrayList arrayList = new ArrayList();
        Map mapG = bVar.g();
        mapG.remove("triggerEvent");
        arrayList.add(b.b(mapG));
        b(arrayList);
    }

    public final void p() throws a {
        if (this.f3004a.get() == null) {
            throw new a("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }
}
