package I6;

import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I0 f4340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f4341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC0613d0 f4342c;

    public G(I0 howThisTypeIsUsed, Set set, AbstractC0613d0 abstractC0613d0) {
        AbstractC2304t.f(howThisTypeIsUsed, "howThisTypeIsUsed");
        this.f4340a = howThisTypeIsUsed;
        this.f4341b = set;
        this.f4342c = abstractC0613d0;
    }

    public abstract AbstractC0613d0 a();

    public abstract I0 b();

    public abstract Set c();

    public abstract G d(R5.m0 m0Var);

    public abstract int hashCode();
}
