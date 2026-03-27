package a2;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: a2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0783b extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0086b f6118a = EnumC0086b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f6119b;

    /* JADX INFO: renamed from: a2.b$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6120a;

        static {
            int[] iArr = new int[EnumC0086b.values().length];
            f6120a = iArr;
            try {
                iArr[EnumC0086b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6120a[EnumC0086b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: a2.b$b, reason: collision with other inner class name */
    public enum EnumC0086b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object b();

    public final Object c() {
        this.f6118a = EnumC0086b.DONE;
        return null;
    }

    public final boolean d() {
        this.f6118a = EnumC0086b.FAILED;
        this.f6119b = b();
        if (this.f6118a == EnumC0086b.DONE) {
            return false;
        }
        this.f6118a = EnumC0086b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Z1.m.t(this.f6118a != EnumC0086b.FAILED);
        int i4 = a.f6120a[this.f6118a.ordinal()];
        if (i4 == 1) {
            return false;
        }
        if (i4 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6118a = EnumC0086b.NOT_READY;
        Object objA = r.a(this.f6119b);
        this.f6119b = null;
        return objA;
    }
}
