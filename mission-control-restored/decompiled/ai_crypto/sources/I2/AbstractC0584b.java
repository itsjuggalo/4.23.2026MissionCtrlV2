package I2;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: I2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0584b extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0030b f2947a = EnumC0030b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2948b;

    /* JADX INFO: renamed from: I2.b$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2949a;

        static {
            int[] iArr = new int[EnumC0030b.values().length];
            f2949a = iArr;
            try {
                iArr[EnumC0030b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2949a[EnumC0030b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: I2.b$b, reason: collision with other inner class name */
    public enum EnumC0030b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object b();

    public final Object c() {
        this.f2947a = EnumC0030b.DONE;
        return null;
    }

    public final boolean d() {
        this.f2947a = EnumC0030b.FAILED;
        this.f2948b = b();
        if (this.f2947a == EnumC0030b.DONE) {
            return false;
        }
        this.f2947a = EnumC0030b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        H2.m.t(this.f2947a != EnumC0030b.FAILED);
        int i7 = a.f2949a[this.f2947a.ordinal()];
        if (i7 == 1) {
            return false;
        }
        if (i7 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f2947a = EnumC0030b.NOT_READY;
        Object objA = r.a(this.f2948b);
        this.f2948b = null;
        return objA;
    }
}
