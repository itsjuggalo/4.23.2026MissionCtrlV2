package w2;

/* JADX INFO: renamed from: w2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2916e {
    public static StringBuilder a(int i8) {
        AbstractC2915d.b(i8, "size");
        return new StringBuilder((int) Math.min(((long) i8) * 8, 1073741824L));
    }
}
