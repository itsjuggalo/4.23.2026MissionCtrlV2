package W5;

import F5.E;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Iterable, R5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5449d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5452c;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final e a(int i7, int i8, int i9) {
            return new e(i7, i8, i9);
        }

        public a() {
        }
    }

    public e(int i7, int i8, int i9) {
        if (i9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i9 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f5450a = i7;
        this.f5451b = L5.c.c(i7, i8, i9);
        this.f5452c = i9;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            if (!isEmpty() || !((e) obj).isEmpty()) {
                e eVar = (e) obj;
                if (this.f5450a != eVar.f5450a || this.f5451b != eVar.f5451b || this.f5452c != eVar.f5452c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f5450a;
    }

    public final int h() {
        return this.f5451b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f5450a * 31) + this.f5451b) * 31) + this.f5452c;
    }

    public boolean isEmpty() {
        if (this.f5452c > 0) {
            if (this.f5450a <= this.f5451b) {
                return false;
            }
        } else if (this.f5450a >= this.f5451b) {
            return false;
        }
        return true;
    }

    public final int j() {
        return this.f5452c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public E iterator() {
        return new f(this.f5450a, this.f5451b, this.f5452c);
    }

    public String toString() {
        StringBuilder sb;
        int i7;
        if (this.f5452c > 0) {
            sb = new StringBuilder();
            sb.append(this.f5450a);
            sb.append("..");
            sb.append(this.f5451b);
            sb.append(" step ");
            i7 = this.f5452c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f5450a);
            sb.append(" downTo ");
            sb.append(this.f5451b);
            sb.append(" step ");
            i7 = -this.f5452c;
        }
        sb.append(i7);
        return sb.toString();
    }
}
