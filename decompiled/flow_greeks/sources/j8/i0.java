package j8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i0 implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static i0 f14011b = new i0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f14012a = new HashMap();

    public static i0 b() {
        return f14011b;
    }

    @Override // j8.j
    public void a(i iVar) {
        d(iVar);
    }

    public void c(i iVar) {
        synchronized (this.f14012a) {
            try {
                List arrayList = (List) this.f14012a.get(iVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f14012a.put(iVar, arrayList);
                }
                arrayList.add(iVar);
                if (!iVar.e().f()) {
                    i iVarA = iVar.a(o8.i.a(iVar.e().e()));
                    List arrayList2 = (List) this.f14012a.get(iVarA);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        this.f14012a.put(iVarA, arrayList2);
                    }
                    arrayList2.add(iVar);
                }
                iVar.j(true);
                iVar.k(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(i iVar) {
        synchronized (this.f14012a) {
            try {
                List list = (List) this.f14012a.get(iVar);
                boolean z10 = true;
                int i10 = 0;
                int i11 = 0;
                if (list != null) {
                    while (true) {
                        if (i11 >= list.size()) {
                            i11 = 0;
                            break;
                        } else {
                            if (list.get(i11) == iVar) {
                                list.remove(i11);
                                i11 = 1;
                                break;
                            }
                            i11++;
                        }
                    }
                    if (list.isEmpty()) {
                        this.f14012a.remove(iVar);
                    }
                }
                if (i11 == 0 && iVar.g()) {
                    z10 = false;
                }
                m8.m.f(z10);
                if (!iVar.e().f()) {
                    i iVarA = iVar.a(o8.i.a(iVar.e().e()));
                    List list2 = (List) this.f14012a.get(iVarA);
                    if (list2 != null) {
                        while (true) {
                            if (i10 >= list2.size()) {
                                break;
                            }
                            if (list2.get(i10) == iVar) {
                                list2.remove(i10);
                                break;
                            }
                            i10++;
                        }
                        if (list2.isEmpty()) {
                            this.f14012a.remove(iVarA);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(i iVar) {
        synchronized (this.f14012a) {
            try {
                List list = (List) this.f14012a.get(iVar);
                if (list != null && !list.isEmpty()) {
                    if (iVar.e().f()) {
                        HashSet hashSet = new HashSet();
                        for (int size = list.size() - 1; size >= 0; size--) {
                            i iVar2 = (i) list.get(size);
                            if (!hashSet.contains(iVar2.e())) {
                                hashSet.add(iVar2.e());
                                iVar2.l();
                            }
                        }
                    } else {
                        ((i) list.get(0)).l();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
