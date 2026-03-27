package w4;

import java.util.ArrayList;

/* JADX INFO: renamed from: w4.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1341i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11285b;

    public C1341i0(int i) {
        this.f11284a = i;
        switch (i) {
            case 1:
                this.f11285b = new ArrayList(20);
                break;
            default:
                this.f11285b = new ArrayList();
                break;
        }
    }

    public void a(Object obj, String str) {
        this.f11285b.add(str + "=" + obj);
    }

    public String toString() {
        switch (this.f11284a) {
            case 0:
                return this.f11285b.toString();
            default:
                return super.toString();
        }
    }
}
