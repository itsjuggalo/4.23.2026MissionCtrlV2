package eg;

import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8881c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f8882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8883b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends dd.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8884c = -1;

        public b() {
        }

        @Override // dd.c
        public void c() {
            do {
                int i10 = this.f8884c + 1;
                this.f8884c = i10;
                if (i10 >= d.this.f8882a.length) {
                    break;
                }
            } while (d.this.f8882a[this.f8884c] == null);
            if (this.f8884c >= d.this.f8882a.length) {
                e();
                return;
            }
            Object obj = d.this.f8882a[this.f8884c];
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
            f(obj);
        }
    }

    public d(Object[] objArr, int i10) {
        super(null);
        this.f8882a = objArr;
        this.f8883b = i10;
    }

    private final void f(int i10) {
        Object[] objArr = this.f8882a;
        if (objArr.length > i10) {
            return;
        }
        int length = objArr.length;
        do {
            length *= 2;
        } while (length <= i10);
        Object[] objArrCopyOf = Arrays.copyOf(this.f8882a, length);
        kotlin.jvm.internal.t.e(objArrCopyOf, "copyOf(...)");
        this.f8882a = objArrCopyOf;
    }

    @Override // eg.c
    public int a() {
        return this.f8883b;
    }

    @Override // eg.c
    public void c(int i10, Object value) {
        kotlin.jvm.internal.t.f(value, "value");
        f(i10);
        if (this.f8882a[i10] == null) {
            this.f8883b = a() + 1;
        }
        this.f8882a[i10] = value;
    }

    @Override // eg.c
    public Object get(int i10) {
        return dd.n.I(this.f8882a, i10);
    }

    @Override // eg.c, java.lang.Iterable
    public Iterator iterator() {
        return new b();
    }

    public d() {
        this(new Object[20], 0);
    }
}
