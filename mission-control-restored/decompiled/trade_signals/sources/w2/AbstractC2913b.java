package w2;

import java.util.NoSuchElementException;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: w2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2913b extends AbstractC2910B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0420b f23995a = EnumC0420b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f23996b;

    /* JADX INFO: renamed from: w2.b$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23997a;

        static {
            int[] iArr = new int[EnumC0420b.values().length];
            f23997a = iArr;
            try {
                iArr[EnumC0420b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23997a[EnumC0420b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: w2.b$b, reason: collision with other inner class name */
    public enum EnumC0420b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object b();

    public final Object c() {
        this.f23995a = EnumC0420b.DONE;
        return null;
    }

    public final boolean d() {
        this.f23995a = EnumC0420b.FAILED;
        this.f23996b = b();
        if (this.f23995a == EnumC0420b.DONE) {
            return false;
        }
        this.f23995a = EnumC0420b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        AbstractC2848n.t(this.f23995a != EnumC0420b.FAILED);
        int i8 = a.f23997a[this.f23995a.ordinal()];
        if (i8 == 1) {
            return false;
        }
        if (i8 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f23995a = EnumC0420b.NOT_READY;
        Object objA = r.a(this.f23996b);
        this.f23996b = null;
        return objA;
    }
}
