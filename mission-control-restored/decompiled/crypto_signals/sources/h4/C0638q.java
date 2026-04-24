package h4;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: renamed from: h4.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0638q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f6636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0643v f6637c;

    public static C0638q a(ArrayList arrayList) {
        C0638q c0638q = new C0638q();
        String str = (String) arrayList.get(0);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"path\" is null.");
        }
        c0638q.f6635a = str;
        c0638q.f6636b = (Map) arrayList.get(1);
        Object obj = arrayList.get(2);
        C0643v c0643vA = obj == null ? null : C0643v.a((ArrayList) obj);
        if (c0643vA == null) {
            throw new IllegalStateException("Nonnull field \"metadata\" is null.");
        }
        c0638q.f6637c = c0643vA;
        return c0638q;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.f6635a);
        arrayList.add(this.f6636b);
        C0643v c0643v = this.f6637c;
        arrayList.add(c0643v == null ? null : c0643v.b());
        return arrayList;
    }
}
