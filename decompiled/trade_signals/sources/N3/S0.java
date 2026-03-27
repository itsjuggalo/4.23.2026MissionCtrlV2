package N3;

import Q1.C0796h;
import Q1.C0797i;
import android.app.Application;
import h2.AbstractC1856a;

/* JADX INFO: loaded from: classes.dex */
public class S0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f5630a;

    public S0(Application application) {
        this.f5630a = application;
    }

    public void a() {
        try {
            AbstractC1856a.a(this.f5630a);
        } catch (C0796h | C0797i e8) {
            e8.printStackTrace();
        }
    }
}
