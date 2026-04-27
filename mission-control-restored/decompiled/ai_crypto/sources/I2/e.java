package I2;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static StringBuilder a(int i7) {
        d.b(i7, "size");
        return new StringBuilder((int) Math.min(((long) i7) * 8, 1073741824L));
    }
}
