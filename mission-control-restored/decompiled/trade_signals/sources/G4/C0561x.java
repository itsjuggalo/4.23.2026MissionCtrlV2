package G4;

import F4.EnumC0502p;
import java.util.ArrayList;
import java.util.Iterator;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0561x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f3242a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile EnumC0502p f3243b = EnumC0502p.IDLE;

    public void a(EnumC0502p enumC0502p) {
        AbstractC2848n.o(enumC0502p, "newState");
        if (this.f3243b == enumC0502p || this.f3243b == EnumC0502p.SHUTDOWN) {
            return;
        }
        this.f3243b = enumC0502p;
        if (this.f3242a.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.f3242a;
        this.f3242a = new ArrayList();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }
}
