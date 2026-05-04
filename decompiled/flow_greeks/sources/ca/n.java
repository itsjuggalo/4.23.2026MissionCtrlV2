package ca;

import android.app.Application;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f3790a;

    public n(Application application) {
        this.f3790a = application;
    }

    public aa.o a(Executor executor) {
        return new aa.o(executor);
    }

    public Application b() {
        return this.f3790a;
    }
}
