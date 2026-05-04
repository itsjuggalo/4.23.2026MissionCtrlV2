package j8;

import o8.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f13944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e8.a f13945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o8.i f13946f;

    /* JADX INFO: renamed from: j8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class C0244a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13947a;

        static {
            int[] iArr = new int[e.a.values().length];
            f13947a = iArr;
            try {
                iArr[e.a.CHILD_ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13947a[e.a.CHILD_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13947a[e.a.CHILD_MOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13947a[e.a.CHILD_REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(n nVar, e8.a aVar, o8.i iVar) {
        this.f13944d = nVar;
        this.f13945e = aVar;
        this.f13946f = iVar;
    }

    @Override // j8.i
    public i a(o8.i iVar) {
        return new a(this.f13944d, this.f13945e, iVar);
    }

    @Override // j8.i
    public o8.d b(o8.c cVar, o8.i iVar) {
        return new o8.d(cVar.j(), this, e8.k.a(e8.k.c(this.f13944d, iVar.e().v(cVar.i())), cVar.k()), cVar.m() != null ? cVar.m().b() : null);
    }

    @Override // j8.i
    public void c(e8.c cVar) {
        this.f13945e.onCancelled(cVar);
    }

    @Override // j8.i
    public void d(o8.d dVar) {
        if (h()) {
            return;
        }
        int i10 = C0244a.f13947a[dVar.b().ordinal()];
        if (i10 == 1) {
            this.f13945e.onChildAdded(dVar.e(), dVar.d());
            return;
        }
        if (i10 == 2) {
            this.f13945e.onChildChanged(dVar.e(), dVar.d());
        } else if (i10 == 3) {
            this.f13945e.onChildMoved(dVar.e(), dVar.d());
        } else {
            if (i10 != 4) {
                return;
            }
            this.f13945e.onChildRemoved(dVar.e());
        }
    }

    @Override // j8.i
    public o8.i e() {
        return this.f13946f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar.f13945e.equals(this.f13945e) && aVar.f13944d.equals(this.f13944d) && aVar.f13946f.equals(this.f13946f);
    }

    @Override // j8.i
    public boolean f(i iVar) {
        return (iVar instanceof a) && ((a) iVar).f13945e.equals(this.f13945e);
    }

    public int hashCode() {
        return (((this.f13945e.hashCode() * 31) + this.f13944d.hashCode()) * 31) + this.f13946f.hashCode();
    }

    @Override // j8.i
    public boolean i(e.a aVar) {
        return aVar != e.a.VALUE;
    }

    public String toString() {
        return "ChildEventRegistration";
    }
}
