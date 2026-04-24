package C2;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f908a = -1.0f;

    @Override // C2.d
    public void a(m mVar, float f7, float f8, float f9) {
        mVar.o(0.0f, f9 * f8, 180.0f, 180.0f - f7);
        double d7 = f9;
        double d8 = f8;
        mVar.m((float) (Math.sin(Math.toRadians(f7)) * d7 * d8), (float) (Math.sin(Math.toRadians(90.0f - f7)) * d7 * d8));
    }
}
