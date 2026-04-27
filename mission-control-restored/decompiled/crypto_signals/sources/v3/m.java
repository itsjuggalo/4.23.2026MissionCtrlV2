package v3;

import N1.Z0;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class m extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Z0 f10635m = new Z0(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f10636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f10638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10639d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f10640f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public k f10641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k f10642l;

    public m(boolean z6) {
        Z0 z02 = f10635m;
        this.f10639d = 0;
        this.e = 0;
        this.f10636a = z02;
        this.f10637b = z6;
        this.f10640f = new l(z6);
    }

    public final l a(Object obj, boolean z6) {
        int iCompareTo;
        l lVar;
        l lVar2 = this.f10638c;
        Z0 z02 = f10635m;
        Comparator comparator = this.f10636a;
        if (lVar2 != null) {
            Comparable comparable = comparator == z02 ? (Comparable) obj : null;
            while (true) {
                Object obj2 = lVar2.f10631f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return lVar2;
                }
                l lVar3 = iCompareTo < 0 ? lVar2.f10628b : lVar2.f10629c;
                if (lVar3 == null) {
                    break;
                }
                lVar2 = lVar3;
            }
        } else {
            iCompareTo = 0;
        }
        l lVar4 = lVar2;
        if (!z6) {
            return null;
        }
        l lVar5 = this.f10640f;
        if (lVar4 != null) {
            lVar = new l(this.f10637b, lVar4, obj, lVar5, lVar5.e);
            if (iCompareTo < 0) {
                lVar4.f10628b = lVar;
            } else {
                lVar4.f10629c = lVar;
            }
            c(lVar4, true);
        } else {
            if (comparator == z02 && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            lVar = new l(this.f10637b, lVar4, obj, lVar5, lVar5.e);
            this.f10638c = lVar;
        }
        this.f10639d++;
        this.e++;
        return lVar;
    }

    public final void c(l lVar, boolean z6) {
        while (lVar != null) {
            l lVar2 = lVar.f10628b;
            l lVar3 = lVar.f10629c;
            int i = lVar2 != null ? lVar2.f10634m : 0;
            int i6 = lVar3 != null ? lVar3.f10634m : 0;
            int i7 = i - i6;
            if (i7 == -2) {
                l lVar4 = lVar3.f10628b;
                l lVar5 = lVar3.f10629c;
                int i8 = (lVar4 != null ? lVar4.f10634m : 0) - (lVar5 != null ? lVar5.f10634m : 0);
                if (i8 == -1 || (i8 == 0 && !z6)) {
                    f(lVar);
                } else {
                    g(lVar3);
                    f(lVar);
                }
                if (z6) {
                    return;
                }
            } else if (i7 == 2) {
                l lVar6 = lVar2.f10628b;
                l lVar7 = lVar2.f10629c;
                int i9 = (lVar6 != null ? lVar6.f10634m : 0) - (lVar7 != null ? lVar7.f10634m : 0);
                if (i9 == 1 || (i9 == 0 && !z6)) {
                    g(lVar);
                } else {
                    f(lVar2);
                    g(lVar);
                }
                if (z6) {
                    return;
                }
            } else if (i7 == 0) {
                lVar.f10634m = i + 1;
                if (z6) {
                    return;
                }
            } else {
                lVar.f10634m = Math.max(i, i6) + 1;
                if (!z6) {
                    return;
                }
            }
            lVar = lVar.f10627a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f10638c = null;
        this.f10639d = 0;
        this.e++;
        l lVar = this.f10640f;
        lVar.e = lVar;
        lVar.f10630d = lVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        l lVarA = null;
        if (obj != null) {
            try {
                lVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return lVarA != null;
    }

    public final void d(l lVar, boolean z6) {
        l lVar2;
        l lVar3;
        int i;
        if (z6) {
            l lVar4 = lVar.e;
            lVar4.f10630d = lVar.f10630d;
            lVar.f10630d.e = lVar4;
        }
        l lVar5 = lVar.f10628b;
        l lVar6 = lVar.f10629c;
        l lVar7 = lVar.f10627a;
        int i6 = 0;
        if (lVar5 == null || lVar6 == null) {
            if (lVar5 != null) {
                e(lVar, lVar5);
                lVar.f10628b = null;
            } else if (lVar6 != null) {
                e(lVar, lVar6);
                lVar.f10629c = null;
            } else {
                e(lVar, null);
            }
            c(lVar7, false);
            this.f10639d--;
            this.e++;
            return;
        }
        if (lVar5.f10634m > lVar6.f10634m) {
            l lVar8 = lVar5.f10629c;
            while (true) {
                l lVar9 = lVar8;
                lVar3 = lVar5;
                lVar5 = lVar9;
                if (lVar5 == null) {
                    break;
                } else {
                    lVar8 = lVar5.f10629c;
                }
            }
        } else {
            l lVar10 = lVar6.f10628b;
            while (true) {
                lVar2 = lVar6;
                lVar6 = lVar10;
                if (lVar6 == null) {
                    break;
                } else {
                    lVar10 = lVar6.f10628b;
                }
            }
            lVar3 = lVar2;
        }
        d(lVar3, false);
        l lVar11 = lVar.f10628b;
        if (lVar11 != null) {
            i = lVar11.f10634m;
            lVar3.f10628b = lVar11;
            lVar11.f10627a = lVar3;
            lVar.f10628b = null;
        } else {
            i = 0;
        }
        l lVar12 = lVar.f10629c;
        if (lVar12 != null) {
            i6 = lVar12.f10634m;
            lVar3.f10629c = lVar12;
            lVar12.f10627a = lVar3;
            lVar.f10629c = null;
        }
        lVar3.f10634m = Math.max(i, i6) + 1;
        e(lVar, lVar3);
    }

    public final void e(l lVar, l lVar2) {
        l lVar3 = lVar.f10627a;
        lVar.f10627a = null;
        if (lVar2 != null) {
            lVar2.f10627a = lVar3;
        }
        if (lVar3 == null) {
            this.f10638c = lVar2;
        } else if (lVar3.f10628b == lVar) {
            lVar3.f10628b = lVar2;
        } else {
            lVar3.f10629c = lVar2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        k kVar = this.f10641k;
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(this, 0);
        this.f10641k = kVar2;
        return kVar2;
    }

    public final void f(l lVar) {
        l lVar2 = lVar.f10628b;
        l lVar3 = lVar.f10629c;
        l lVar4 = lVar3.f10628b;
        l lVar5 = lVar3.f10629c;
        lVar.f10629c = lVar4;
        if (lVar4 != null) {
            lVar4.f10627a = lVar;
        }
        e(lVar, lVar3);
        lVar3.f10628b = lVar;
        lVar.f10627a = lVar3;
        int iMax = Math.max(lVar2 != null ? lVar2.f10634m : 0, lVar4 != null ? lVar4.f10634m : 0) + 1;
        lVar.f10634m = iMax;
        lVar3.f10634m = Math.max(iMax, lVar5 != null ? lVar5.f10634m : 0) + 1;
    }

    public final void g(l lVar) {
        l lVar2 = lVar.f10628b;
        l lVar3 = lVar.f10629c;
        l lVar4 = lVar2.f10628b;
        l lVar5 = lVar2.f10629c;
        lVar.f10628b = lVar5;
        if (lVar5 != null) {
            lVar5.f10627a = lVar;
        }
        e(lVar, lVar2);
        lVar2.f10629c = lVar;
        lVar.f10627a = lVar2;
        int iMax = Math.max(lVar3 != null ? lVar3.f10634m : 0, lVar5 != null ? lVar5.f10634m : 0) + 1;
        lVar.f10634m = iMax;
        lVar2.f10634m = Math.max(iMax, lVar4 != null ? lVar4.f10634m : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        l lVarA;
        if (obj != null) {
            try {
                lVarA = a(obj, false);
            } catch (ClassCastException unused) {
                lVarA = null;
            }
        } else {
            lVarA = null;
        }
        if (lVarA != null) {
            return lVarA.f10633l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        k kVar = this.f10642l;
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(this, 1);
        this.f10642l = kVar2;
        return kVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f10637b) {
            throw new NullPointerException("value == null");
        }
        l lVarA = a(obj, true);
        Object obj3 = lVarA.f10633l;
        lVarA.f10633l = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        l lVarA;
        if (obj != null) {
            try {
                lVarA = a(obj, false);
            } catch (ClassCastException unused) {
                lVarA = null;
            }
        } else {
            lVarA = null;
        }
        if (lVarA != null) {
            d(lVarA, true);
        }
        if (lVarA != null) {
            return lVarA.f10633l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f10639d;
    }
}
