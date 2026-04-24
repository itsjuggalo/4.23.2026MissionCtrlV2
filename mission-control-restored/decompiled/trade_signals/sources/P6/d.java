package P6;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2581c;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6487c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f6488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6489b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b extends AbstractC2581c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6490c = -1;

        public b() {
        }

        @Override // p5.AbstractC2581c
        public void c() {
            do {
                int i8 = this.f6490c + 1;
                this.f6490c = i8;
                if (i8 >= d.this.f6488a.length) {
                    break;
                }
            } while (d.this.f6488a[this.f6490c] == null);
            if (this.f6490c >= d.this.f6488a.length) {
                d();
                return;
            }
            Object obj = d.this.f6488a[this.f6490c];
            AbstractC2304t.d(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
            e(obj);
        }
    }

    public d() {
        this(new Object[20], 0);
    }

    private final void f(int i8) {
        Object[] objArr = this.f6488a;
        if (objArr.length > i8) {
            return;
        }
        int length = objArr.length;
        do {
            length *= 2;
        } while (length <= i8);
        Object[] objArrCopyOf = Arrays.copyOf(this.f6488a, length);
        AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
        this.f6488a = objArrCopyOf;
    }

    @Override // P6.c
    public int a() {
        return this.f6489b;
    }

    @Override // P6.c
    public void d(int i8, Object value) {
        AbstractC2304t.f(value, "value");
        f(i8);
        if (this.f6488a[i8] == null) {
            this.f6489b = a() + 1;
        }
        this.f6488a[i8] = value;
    }

    @Override // P6.c
    public Object get(int i8) {
        return AbstractC2592n.I(this.f6488a, i8);
    }

    @Override // P6.c, java.lang.Iterable
    public Iterator iterator() {
        return new b();
    }

    public d(Object[] objArr, int i8) {
        super(null);
        this.f6488a = objArr;
        this.f6489b = i8;
    }
}
