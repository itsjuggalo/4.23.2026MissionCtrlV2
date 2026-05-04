package q6;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0322b f18795a = EnumC0322b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18796b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18797a;

        static {
            int[] iArr = new int[EnumC0322b.values().length];
            f18797a = iArr;
            try {
                iArr[EnumC0322b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18797a[EnumC0322b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: q6.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0322b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object b();

    public final Object c() {
        this.f18795a = EnumC0322b.DONE;
        return null;
    }

    public final boolean d() {
        this.f18795a = EnumC0322b.FAILED;
        this.f18796b = b();
        if (this.f18795a == EnumC0322b.DONE) {
            return false;
        }
        this.f18795a = EnumC0322b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        p6.n.t(this.f18795a != EnumC0322b.FAILED);
        int i10 = a.f18797a[this.f18795a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f18795a = EnumC0322b.NOT_READY;
        Object objA = r.a(this.f18796b);
        this.f18796b = null;
        return objA;
    }
}
