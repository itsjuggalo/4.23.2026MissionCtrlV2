package U5;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class C implements B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f8190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f8192d;

    public C(List allDependencies, Set modulesWhoseInternalsAreVisible, List directExpectedByDependencies, Set allExpectedByDependencies) {
        AbstractC2304t.f(allDependencies, "allDependencies");
        AbstractC2304t.f(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        AbstractC2304t.f(directExpectedByDependencies, "directExpectedByDependencies");
        AbstractC2304t.f(allExpectedByDependencies, "allExpectedByDependencies");
        this.f8189a = allDependencies;
        this.f8190b = modulesWhoseInternalsAreVisible;
        this.f8191c = directExpectedByDependencies;
        this.f8192d = allExpectedByDependencies;
    }

    @Override // U5.B
    public List a() {
        return this.f8189a;
    }

    @Override // U5.B
    public Set b() {
        return this.f8190b;
    }

    @Override // U5.B
    public List c() {
        return this.f8191c;
    }
}
