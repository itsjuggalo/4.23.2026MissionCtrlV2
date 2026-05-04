package bf;

import dd.a0;
import dd.l;
import dd.n;
import dd.r;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0060a f3309f = new C0060a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f3310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3314e;

    /* JADX INFO: renamed from: bf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0060a {
        public /* synthetic */ C0060a(k kVar) {
            this();
        }

        public C0060a() {
        }
    }

    public a(int... numbers) {
        List listK;
        t.f(numbers, "numbers");
        this.f3310a = numbers;
        Integer numH = n.H(numbers, 0);
        this.f3311b = numH != null ? numH.intValue() : -1;
        Integer numH2 = n.H(numbers, 1);
        this.f3312c = numH2 != null ? numH2.intValue() : -1;
        Integer numH3 = n.H(numbers, 2);
        this.f3313d = numH3 != null ? numH3.intValue() : -1;
        if (numbers.length <= 3) {
            listK = r.k();
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + com.amazon.a.a.o.c.a.b.f4610a);
            }
            listK = a0.I0(l.c(numbers).subList(3, numbers.length));
        }
        this.f3314e = listK;
    }

    public final int a() {
        return this.f3311b;
    }

    public final int b() {
        return this.f3312c;
    }

    public final boolean c(int i10, int i11, int i12) {
        int i13 = this.f3311b;
        if (i13 > i10) {
            return true;
        }
        if (i13 < i10) {
            return false;
        }
        int i14 = this.f3312c;
        if (i14 > i11) {
            return true;
        }
        return i14 >= i11 && this.f3313d >= i12;
    }

    public final boolean d(a version) {
        t.f(version, "version");
        return c(version.f3311b, version.f3312c, version.f3313d);
    }

    public final boolean e(int i10, int i11, int i12) {
        int i13 = this.f3311b;
        if (i13 < i10) {
            return true;
        }
        if (i13 > i10) {
            return false;
        }
        int i14 = this.f3312c;
        if (i14 < i11) {
            return true;
        }
        return i14 <= i11 && this.f3313d <= i12;
    }

    public boolean equals(Object obj) {
        if (obj == null || !t.b(getClass(), obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3311b == aVar.f3311b && this.f3312c == aVar.f3312c && this.f3313d == aVar.f3313d && t.b(this.f3314e, aVar.f3314e);
    }

    public final boolean f(a ourVersion) {
        t.f(ourVersion, "ourVersion");
        int i10 = this.f3311b;
        return i10 == 0 ? ourVersion.f3311b == 0 && this.f3312c == ourVersion.f3312c : i10 == ourVersion.f3311b && this.f3312c <= ourVersion.f3312c;
    }

    public final int[] g() {
        return this.f3310a;
    }

    public int hashCode() {
        int i10 = this.f3311b;
        int i11 = i10 + (i10 * 31) + this.f3312c;
        int i12 = i11 + (i11 * 31) + this.f3313d;
        return i12 + (i12 * 31) + this.f3314e.hashCode();
    }

    public String toString() {
        int[] iArrG = g();
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArrG) {
            if (i10 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList.isEmpty() ? FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE : a0.i0(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
