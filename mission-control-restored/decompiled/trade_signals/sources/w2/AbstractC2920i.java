package w2;

/* JADX INFO: renamed from: w2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2920i {
    public static int a(int i8) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i8) * (-862048943)), 15)) * 461845907);
    }

    public static int b(Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
