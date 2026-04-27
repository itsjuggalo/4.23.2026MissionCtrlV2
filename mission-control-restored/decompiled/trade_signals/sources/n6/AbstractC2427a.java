package n6;

import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;
import p5.AbstractC2592n;
import p5.AbstractC2595q;
import p5.z;

/* JADX INFO: renamed from: n6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2427a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0360a f21620f = new C0360a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f21621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f21625e;

    /* JADX INFO: renamed from: n6.a$a, reason: collision with other inner class name */
    public static final class C0360a {
        public C0360a() {
        }

        public /* synthetic */ C0360a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public AbstractC2427a(int... numbers) {
        List listI;
        AbstractC2304t.f(numbers, "numbers");
        this.f21621a = numbers;
        Integer numH = AbstractC2592n.H(numbers, 0);
        this.f21622b = numH != null ? numH.intValue() : -1;
        Integer numH2 = AbstractC2592n.H(numbers, 1);
        this.f21623c = numH2 != null ? numH2.intValue() : -1;
        Integer numH3 = AbstractC2592n.H(numbers, 2);
        this.f21624d = numH3 != null ? numH3.intValue() : -1;
        if (numbers.length <= 3) {
            listI = AbstractC2595q.i();
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + com.amazon.a.a.o.c.a.b.f14112a);
            }
            listI = z.G0(AbstractC2590l.c(numbers).subList(3, numbers.length));
        }
        this.f21625e = listI;
    }

    public final int a() {
        return this.f21622b;
    }

    public final int b() {
        return this.f21623c;
    }

    public final boolean c(int i8, int i9, int i10) {
        int i11 = this.f21622b;
        if (i11 > i8) {
            return true;
        }
        if (i11 < i8) {
            return false;
        }
        int i12 = this.f21623c;
        if (i12 > i9) {
            return true;
        }
        return i12 >= i9 && this.f21624d >= i10;
    }

    public final boolean d(AbstractC2427a version) {
        AbstractC2304t.f(version, "version");
        return c(version.f21622b, version.f21623c, version.f21624d);
    }

    public final boolean e(int i8, int i9, int i10) {
        int i11 = this.f21622b;
        if (i11 < i8) {
            return true;
        }
        if (i11 > i8) {
            return false;
        }
        int i12 = this.f21623c;
        if (i12 < i9) {
            return true;
        }
        return i12 <= i9 && this.f21624d <= i10;
    }

    public boolean equals(Object obj) {
        if (obj != null && AbstractC2304t.b(getClass(), obj.getClass())) {
            AbstractC2427a abstractC2427a = (AbstractC2427a) obj;
            if (this.f21622b == abstractC2427a.f21622b && this.f21623c == abstractC2427a.f21623c && this.f21624d == abstractC2427a.f21624d && AbstractC2304t.b(this.f21625e, abstractC2427a.f21625e)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(AbstractC2427a ourVersion) {
        AbstractC2304t.f(ourVersion, "ourVersion");
        int i8 = this.f21622b;
        if (i8 == 0) {
            if (ourVersion.f21622b != 0 || this.f21623c != ourVersion.f21623c) {
                return false;
            }
        } else if (i8 != ourVersion.f21622b || this.f21623c > ourVersion.f21623c) {
            return false;
        }
        return true;
    }

    public final int[] g() {
        return this.f21621a;
    }

    public int hashCode() {
        int i8 = this.f21622b;
        int i9 = i8 + (i8 * 31) + this.f21623c;
        int i10 = i9 + (i9 * 31) + this.f21624d;
        return i10 + (i10 * 31) + this.f21625e.hashCode();
    }

    public String toString() {
        int[] iArrG = g();
        ArrayList arrayList = new ArrayList();
        for (int i8 : iArrG) {
            if (i8 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i8));
        }
        return arrayList.isEmpty() ? FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE : z.h0(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
