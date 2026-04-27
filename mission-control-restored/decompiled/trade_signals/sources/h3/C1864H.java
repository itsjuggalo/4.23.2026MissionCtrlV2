package h3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import k3.AbstractC2279m;

/* JADX INFO: renamed from: h3.H, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1864H implements InterfaceC1873i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C1864H f18413b = new C1864H();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f18414a = new HashMap();

    public static C1864H b() {
        return f18413b;
    }

    @Override // h3.InterfaceC1873i
    public void a(AbstractC1872h abstractC1872h) {
        d(abstractC1872h);
    }

    public void c(AbstractC1872h abstractC1872h) {
        synchronized (this.f18414a) {
            try {
                List arrayList = (List) this.f18414a.get(abstractC1872h);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f18414a.put(abstractC1872h, arrayList);
                }
                arrayList.add(abstractC1872h);
                if (!abstractC1872h.e().f()) {
                    AbstractC1872h abstractC1872hA = abstractC1872h.a(m3.i.a(abstractC1872h.e().e()));
                    List arrayList2 = (List) this.f18414a.get(abstractC1872hA);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        this.f18414a.put(abstractC1872hA, arrayList2);
                    }
                    arrayList2.add(abstractC1872h);
                }
                abstractC1872h.j(true);
                abstractC1872h.k(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(AbstractC1872h abstractC1872h) {
        synchronized (this.f18414a) {
            try {
                List list = (List) this.f18414a.get(abstractC1872h);
                boolean z7 = true;
                int i8 = 0;
                int i9 = 0;
                if (list != null) {
                    while (true) {
                        if (i9 >= list.size()) {
                            i9 = 0;
                            break;
                        } else {
                            if (list.get(i9) == abstractC1872h) {
                                list.remove(i9);
                                i9 = 1;
                                break;
                            }
                            i9++;
                        }
                    }
                    if (list.isEmpty()) {
                        this.f18414a.remove(abstractC1872h);
                    }
                }
                if (i9 == 0 && abstractC1872h.g()) {
                    z7 = false;
                }
                AbstractC2279m.f(z7);
                if (!abstractC1872h.e().f()) {
                    AbstractC1872h abstractC1872hA = abstractC1872h.a(m3.i.a(abstractC1872h.e().e()));
                    List list2 = (List) this.f18414a.get(abstractC1872hA);
                    if (list2 != null) {
                        while (true) {
                            if (i8 >= list2.size()) {
                                break;
                            }
                            if (list2.get(i8) == abstractC1872h) {
                                list2.remove(i8);
                                break;
                            }
                            i8++;
                        }
                        if (list2.isEmpty()) {
                            this.f18414a.remove(abstractC1872hA);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(AbstractC1872h abstractC1872h) {
        synchronized (this.f18414a) {
            try {
                List list = (List) this.f18414a.get(abstractC1872h);
                if (list != null && !list.isEmpty()) {
                    if (abstractC1872h.e().f()) {
                        HashSet hashSet = new HashSet();
                        for (int size = list.size() - 1; size >= 0; size--) {
                            AbstractC1872h abstractC1872h2 = (AbstractC1872h) list.get(size);
                            if (!hashSet.contains(abstractC1872h2.e())) {
                                hashSet.add(abstractC1872h2.e());
                                abstractC1872h2.l();
                            }
                        }
                    } else {
                        ((AbstractC1872h) list.get(0)).l();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
